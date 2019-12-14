package com.yamath.demo.validator.service;

import com.yamath.demo.validator.dto.UserDTO;
import com.yamath.demo.validator.vo.ResultVO;

import java.util.List;

/**
 * @author yao
 * @date 2019/12/14
 */
public interface IUserService {

    /**
     * 用户注册
     *
     * @param userDTO
     * @return
     */
    ResultVO<UserDTO> userRegistry(UserDTO userDTO);

    /**
     * 用户名查找用户信息
     *
     * @param userName
     * @return
     */
    ResultVO<List<UserDTO>> userFindByName(String userName);
}
