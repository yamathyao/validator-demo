package com.yamath.demo.validator;

import com.yamath.demo.validator.utils.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author yao
 * @date 2019.12.14
 */
@SpringBootApplication
public class ValidatorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorDemoApplication.class, args);
    }

}
