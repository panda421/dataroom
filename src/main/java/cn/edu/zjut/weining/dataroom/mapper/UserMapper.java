package cn.edu.zjut.weining.dataroom.mapper;

import cn.edu.zjut.weining.dataroom.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author panda421
 * @date 2020-12-15 20:31
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     * @param username 用户名
     * @return null
     */
    @Select(value = "select u.username,u.password from user u where u.username=#{username}")
    @Results
            ({@Result(property = "username",column = "username"),
                    @Result(property = "password",column = "password")})
    User findUserByName(@Param("username") String username);

    /**
     * 注册  插入一条user记录
     * @param user 用户记录
     * @return null
     */
    @Insert("insert into user values(#{id},#{username},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void regist(User user);

    /**
     * 登录
     * @param user 用户记录
     * @return null
     */
    @Select("select u.id from user u where u.username = #{username} and password = #{password}")
    Long login(User user);
}
