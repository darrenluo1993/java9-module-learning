package pers.darren.dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pers.darren.dao.user.model.User;

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
}
