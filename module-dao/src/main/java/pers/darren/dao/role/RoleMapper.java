package pers.darren.dao.role;

import org.apache.ibatis.annotations.*;
import pers.darren.dao.role.model.Role;

@Mapper
public interface RoleMapper {
    @Select("""
            select
                id,
                role_name,
                role_desc,
                created_by,
                created_time,
                modified_by,
                modified_time
            from
                role
            where
                id = #{id,jdbcType=VARCHAR}
            """)
    @ResultMap("Role")
    Role getRoleById(String id);

    @Insert("""
            insert into role
               (id,
                role_name,
                role_desc,
                created_by,
                created_time)
            values
               (#{id,jdbcType=VARCHAR},
                #{roleName,jdbcType=VARCHAR},
                #{roleDesc,jdbcType=VARCHAR},
                #{createdBy,jdbcType=VARCHAR},
                #{createdTime,jdbcType=TIMESTAMP})
            """)
    int addRole(Role role);

    @Update("""
            update
                role
            set
                role_name = #{roleName,jdbcType=VARCHAR},
                role_desc = #{roleDesc,jdbcType=VARCHAR},
                modified_by = #{modifiedBy,jdbcType=VARCHAR},
                modified_time = #{modifiedTime,jdbcType=TIMESTAMP}
            where
                id = #{id,jdbcType=VARCHAR}
            """)
    int modifyRoleById(Role role);

    int modifyRoleSelectiveById(Role role);
}
