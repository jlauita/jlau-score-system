package com.jlau.scoresystem.controller;

import com.jlau.scoresystem.vo.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/18.
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionAdvice.class);
    @ExceptionHandler(value = Exception.class)
    public Object handler(Exception e){
        logger.error(e.getMessage());
        System.out.println(e.getMessage());
        return ResultModel.fail(e.getMessage());
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object handlerNotValidArgument(MethodArgumentNotValidException e){
        if(e.getBindingResult().hasErrors()){
            List<ObjectError> errors = e.getBindingResult().getAllErrors();
            if(!errors.isEmpty()){
                FieldError error = (FieldError) errors.get(0);//只获取第一个参数验证错误
                String errMessage = error.getDefaultMessage();
                logger.error(errMessage);
                System.out.println(errMessage);
                return ResultModel.fail(errMessage);
            }
        }
        return ResultModel.fail(e.getMessage());
    }
}
