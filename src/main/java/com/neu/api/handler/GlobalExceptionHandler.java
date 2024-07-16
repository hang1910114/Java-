package com.neu.api.handler;

import com.neu.api.exception.BusException;
import com.neu.api.exception.ParamException;
import com.neu.api.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ParamException.class)
    public Result handleParamException(ParamException paramException){

        logger.error(paramException.getMessage()); //参数异常
        return Result.failure(paramException.getMessage());

    }


    @ExceptionHandler(BusException.class)
    public Result handleBusException(BusException busException){
        logger.error(busException.getMessage());

        return Result.failure(busException.getSimpleMsg());
    }
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception exception){
        logger.error(exception.getMessage());
        return Result.failure("请检查网络");
    }
}
