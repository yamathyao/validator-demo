package com.yamath.demo.validator.vo;

import com.yamath.demo.validator.constants.Const;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yao
 * @date 2019/12/14
 */
public class ResultVO<T> {

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private T data;

    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultVO<T> success(String message, T data) {
        return new ResultVO<T>(Const.VALIDATE_SUCCESS_CODE, message, data);
    }

    public static <T> ResultVO<T> success(String message) {
        return new ResultVO<T>(Const.VALIDATE_SUCCESS_CODE, message);
    }

    public static <T> ResultVO<T> fail(String message) {
        return new ResultVO<>(Const.VALIDATE_FAIL_CODE, message);
    }

    public static <T> ResultVO<T> error(String message) {
        return new ResultVO<>(Const.ERROR_CODE, message);
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
