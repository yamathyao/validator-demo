package com.yamath.demo.validator.controller;

import com.yamath.demo.validator.dto.UserDTO;
import com.yamath.demo.validator.groups.Create;
import com.yamath.demo.validator.service.IUserService;
import com.yamath.demo.validator.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author yao
 * @date 2019/12/14
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/registry")
    public ResultVO<UserDTO> userRegistry(@Validated(Create.class) UserDTO user) {
//        IUserService userService = (IUserService) SpringContextUtil.getBean("userService");
        return userService.userRegistry(user);
    }

    @GetMapping("/find/name")
    public ResultVO<List<UserDTO>> userFindByName(@RequestParam("userName") @NotBlank(message = "用户名不能为空") String userName) {
//        IUserService userService = (IUserService) SpringContextUtil.getBean("userService");
        return userService.userFindByName(userName);
    }
}
