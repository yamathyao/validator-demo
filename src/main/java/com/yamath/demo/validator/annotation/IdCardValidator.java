package com.yamath.demo.validator.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yao
 * @date 2019/12/14
 */
public class IdCardValidator implements ConstraintValidator<IdCard, Object> {

    public static final Pattern ID_CARD_PATTERN = Pattern.compile("^(\\d{6})(19|20)(\\d{2})(1[0-2]|0[1-9])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$");

    private static final int ID_CARD_18_BYTE = 18;

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return IdCardValidator.is18ByteIdCardComplex(String.valueOf(o));
    }

    @Override
    public void initialize(IdCard constraintAnnotation) {

    }

    public static boolean is18ByteIdCardComplex(String idCard) {
        Matcher matcher = ID_CARD_PATTERN.matcher(idCard);
        int[] prefix = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        int[] suffix = new int[]{1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        if (matcher.matches()) {
            // 用来保存前17位各自乘以加权因子后的总和
            int idCardWiSum = 0;
            for (int i = 0; i < ID_CARD_18_BYTE - 1; i++) {
                idCardWiSum += Integer.parseInt(idCard.substring(i, i + 1)) * prefix[i];
            }
            //
            int idCardMod = idCardWiSum % 11;
            //
            String idCardLast = idCard.substring(ID_CARD_18_BYTE - 1);
            //
            if (idCardMod == 2) {
                return "x".equalsIgnoreCase(idCardLast);
            } else {
                return idCardLast.equals(suffix[idCardMod] + "");
            }
        }
        return false;
    }
}
