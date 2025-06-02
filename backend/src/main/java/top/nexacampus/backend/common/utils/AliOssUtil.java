package top.nexacampus.backend.common.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

/**
 * Nexa Campus
 * top.nexacampus.backend.configuration <br>
 * 阿里云OSS工具类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 15:07
 **/
@Data
@AllArgsConstructor
@Slf4j
public class AliOssUtil {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String folderName;

    /**
     * 文件上传
     *
     * @param bytes 文件字节数组
     * @param objectName 文件名
     * @return 文件访问路径
     */
    public String upload(byte[] bytes, String objectName) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 将存入的文件存储到不同的时间文件夹
            // 例如：nexa-campus/2021/07/01/xxx.jpg
            String date = LocalDate.now().toString().replace("-", "/");

            if (!folderName.isEmpty()) {
                objectName = folderName + "/" + date + "/" + objectName;
            } else {
                objectName = date + "/" + objectName;
            }

            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(bytes));
        } catch (OSSException oe) { // OSSException表示请求已发送到OSS，但由于某种原因被拒绝。
            System.out.println("捕获到OSSException，这意味着您的请求已发送到OSS。"
                                +"但由于某种原因，它以错误响应被拒绝。");
            System.out.println("错误消息：" + oe.getErrorMessage());
            System.out.println("错误代码：" + oe.getErrorCode());
            System.out.println("请求ID:" + oe.getRequestId());
            System.out.println("主机ID:" + oe.getHostId());
        } catch (ClientException ce) { // ClientException表示客户端在尝试与OSS通信时遇到了严重的内部问题。
            System.out.println("捕获ClientException，这意味着客户端在尝试与OSS通信时遇到了严重的内部问题，例如无法访问网络。");
            System.out.println("错误消息：" + ce.getMessage());
        } finally { // 关闭OSSClient。
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        //文件访问路径规则 https://BucketName.Endpoint/ObjectName
        StringBuilder stringBuilder = new StringBuilder("https://");
        stringBuilder
                .append(bucketName)
                .append(".")
                .append(endpoint)
                .append("/")
                .append(objectName);

        log.info("文件上传到:{}", stringBuilder.toString());

        // 返回文件访问路径
        return stringBuilder.toString();
    }
}
