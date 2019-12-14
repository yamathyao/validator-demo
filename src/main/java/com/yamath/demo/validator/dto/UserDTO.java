package com.yamath.demo.validator.dto;

import com.yamath.demo.validator.annotation.IdCard;
import com.yamath.demo.validator.annotation.MobileNo;
import com.yamath.demo.validator.groups.Create;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yao
 * @date 2019/12/14
 */
@Data
public class UserDTO {

    @NotBlank(message = "用户名不能为空", groups = Create.class)
    @NotNull(message = "用户名不能为空", groups = Create.class)
    private String userName;

    @NotBlank(message = "手机号不能为空", groups = Create.class)
    @NotNull(message = "手机号不能为空", groups = Create.class)
    @MobileNo(message = "手机格式不正确", groups = Create.class)
    private String mobileNo;

    @NotBlank(message = "身份证号不能为空", groups = Create.class)
    @NotNull(message = "身份证号不能为空", groups = Create.class)
    @IdCard(message = "身份证号不合法", groups = Create.class)
    private String idCard;

    @Email(message = "邮箱格式不正确", groups = Create.class)
    private String email;

    private Integer age;

    private String sex;
}
