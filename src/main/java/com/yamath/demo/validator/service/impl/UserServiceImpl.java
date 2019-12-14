package com.yamath.demo.validator.service.impl;

import com.yamath.demo.validator.dto.UserDTO;
import com.yamath.demo.validator.service.IUserService;
import com.yamath.demo.validator.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yao
 * @date 2019/12/14
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Override
    public ResultVO<UserDTO> userRegistry(UserDTO userDTO) {
        try {
            log.info("用户注册成功, {}", userDTO);
            return ResultVO.success("用户注册成功", userDTO);
        } catch (Exception ex) {
            log.error("用户注册失败。{}", ex.getMessage(), ex);
            return ResultVO.error("用户注册失败");
        }

    }

    @Override
    public ResultVO<List<UserDTO>> userFindByName(String userName) {
        List<UserDTO> userList = new ArrayList<>();
        UserDTO user = new UserDTO();
        user.setUserName(userName);
        user.setIdCard("310115***********3");
        user.setMobileNo("15*****8362");
        user.setAge(18);
        user.setSex("male");
        user.setEmail("yaoyamath@gmail.com");
        userList.add(user);
        return ResultVO.success("查询成功", userList);
    }
}
