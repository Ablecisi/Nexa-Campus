package top.nexacampus.backend.common.context;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.common.context <br>
 * 用于存储当前线程的用户id<br>
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 15:53
 **/
public class BaseContext {
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }
}
