package pers.darren.dao.user;

import org.apache.ibatis.annotations.*;
import pers.darren.dao.user.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("""
            select
                id,
                username,
                realname,
                gender,
                age,
                created_by,
                created_time,
                modified_by,
                modified_time
            from
                user
            where
                id = #{id,jdbcType=VARCHAR}
            """)
    @ResultMap("User")
    User getUserById(String id);

    @Select("""
            select
                id,
                username,
                realname,
                gender,
                age,
                created_by,
                created_time,
                modified_by,
                modified_time
            from
                user
            """)
    @ResultMap("User")
    List<User> listAllUser();

    @Insert("""
            insert into user
               (id,
                username,
                realname,
                gender,
                age,
                created_by,
                created_time)
            values
               (#{id,jdbcType=VARCHAR},
                #{username,jdbcType=VARCHAR},
                #{realname,jdbcType=VARCHAR},
                #{gender,jdbcType=VARCHAR},
                #{age,jdbcType=INTEGER},
                #{createdBy,jdbcType=VARCHAR},
                #{createdTime,jdbcType=TIMESTAMP})
            """)
    int addUser(User user);

    @Update("""
            update
                user
            set
                realname = #{realname,jdbcType=VARCHAR},
                gender = #{gender,jdbcType=VARCHAR},
                age = #{age,jdbcType=INTEGER},
                modified_by = #{modifiedBy,jdbcType=VARCHAR},
                modified_time = #{modifiedTime,jdbcType=TIMESTAMP}
            where
                id = #{id,jdbcType=VARCHAR}
            """)
    int modifyUserById(User user);
}
