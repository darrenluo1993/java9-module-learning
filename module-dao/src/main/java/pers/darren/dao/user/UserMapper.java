package pers.darren.dao.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
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
                created_time,
                modified_by,
                modified_time)
            values
               (#{id,jdbcType=VARCHAR},
                #{username,jdbcType=VARCHAR},
                #{realname,jdbcType=VARCHAR},
                #{gender,jdbcType=VARCHAR},
                #{age,jdbcType=INTEGER},
                #{createdBy,jdbcType=VARCHAR},
                #{createdTime,jdbcType=TIMESTAMP},
                #{modifiedBy,jdbcType=VARCHAR},
                #{modifiedTime,jdbcType=TIMESTAMP})
            """)
    int addUser(User user);
}
