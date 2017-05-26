package com.example.demo.mapper;

import com.example.demo.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by roc on 2017/5/25.
 */
@Mapper
public interface UserMapper {
//    @Select("select * from users where user_id = #{userId}")
    @Select("select * from users where user_id = #{userId}")
    User findUserByUserId(@Param("userId") String userId);
    @Insert("insert into users (user_id, user_name, user_pwd) values (#{userId}, #{userName}, #{pwd})")
    boolean insertUsers (@Param("userId") String userId, @Param("userName") String userName, @Param("pwd") String pwd);
}
