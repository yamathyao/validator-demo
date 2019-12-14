package com.yamath.demo.validator.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yao
 * @date 2019/12/14
 */
public class MobileNoValidator implements ConstraintValidator<MobileNo, Object> {

    public static final Pattern MOBILE_NO_PATTERN = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$");

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return MobileNoValidator.isMobileNo(o.toString());
    }

    @Override
    public void initialize(MobileNo constraintAnnotation) {

    }

    public static boolean isMobileNo(String mobileNo) {
        Matcher matcher = MOBILE_NO_PATTERN.matcher(mobileNo);
        return matcher.matches();
    }
}
