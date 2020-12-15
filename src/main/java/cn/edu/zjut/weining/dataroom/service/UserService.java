package cn.edu.zjut.weining.dataroom.service;

import cn.edu.zjut.weining.dataroom.bean.Result;
import cn.edu.zjut.weining.dataroom.bean.User;
import cn.edu.zjut.weining.dataroom.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author panda421
 * @date 2020-12-15 20:30
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    public Result regist(User user) {
        Result result = new Result();
        result.setCode(200);
        result.setData(null);
        try {
            User existUser = userMapper.findUserByName(user.getUsername());
            if(existUser != null){
                //如果用户名已存在
                result.setMassage("username exist");

            }else{
                userMapper.regist(user);
                result.setMassage("success");
                result.setData(user);
            }
        } catch (Exception e) {
            result.setMassage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(User user) {
        Result result = new Result();
        result.setCode(200);
        result.setData(null);
        try {
            Long userId= userMapper.login(user);
            if(userId == null){
                result.setMassage("wrong username or password");
            }else{
                result.setMassage("success");
                user.setId(userId);
                result.setData(user);
            }
        } catch (Exception e) {
            result.setMassage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
