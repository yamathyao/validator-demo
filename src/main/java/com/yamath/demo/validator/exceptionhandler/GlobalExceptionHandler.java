package com.yamath.demo.validator.exceptionhandler;

import com.yamath.demo.validator.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


/**
 * @author yao
 * @date 2019/12/14
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return ResultVO.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(BindException.class)
    public ResultVO<?> handleBindException(BindException e) {
        log.error(e.getMessage(), e);
        return ResultVO.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO<?> handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
        if (e.getConstraintViolations().iterator().hasNext()) {
            return ResultVO.error(e.getConstraintViolations().iterator().next().getMessage());
        }
        return ResultVO.error(e.getMessage());
    }

}
