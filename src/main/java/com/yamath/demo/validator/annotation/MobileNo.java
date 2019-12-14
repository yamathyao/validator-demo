package com.yamath.demo.validator.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author yao
 * @date 2019/12/14
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileNoValidator.class)
public @interface MobileNo {

    String message() default "手机号不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
