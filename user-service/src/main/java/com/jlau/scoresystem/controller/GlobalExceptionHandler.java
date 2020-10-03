package com.jlau.scoresystem.controller;

import com.jlau.scoresystem.vo.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/20.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    public ResultModel exceptionHandler(Exception e){
        logger.error(e.getMessage()+e.getClass());
        return ResultModel.fail(e.getMessage()+e.getClass());
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultModel exceptionArgumentValidException(MethodArgumentNotValidException argsException){
        BindingResult bindingResult = argsException.getBindingResult();
        List<ObjectError> errors = bindingResult.getAllErrors();
        for (ObjectError error:errors){
            logger.error(error.getDefaultMessage().toString());
        }
        return ResultModel.fail(errors.get(0).getDefaultMessage().toString());
    }
}
