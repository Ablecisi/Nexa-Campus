package top.nexacampus.backend.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.mapper <br>
 *
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 21:35
 **/
@Mapper
public interface RoleUserMapper {
    /**
     * 根据用户ID获取角色ID
     *
     * @param userId 用户ID
     * @return Long 角色ID
     */
    Long getRoleIdByUserId(Long userId);
}
