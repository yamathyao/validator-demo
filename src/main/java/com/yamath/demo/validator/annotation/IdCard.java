package com.yamath.demo.validator.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author yao
 * @date 2019/12/14
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = IdCardValidator.class)
public @interface IdCard {

    String message() default "身份证号不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
