package com.web.spring.databind;

import com.web.spring.databind.domain.ResponseError;
import com.web.spring.databind.domain.SimpleUser;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2017/7/9.
 */
@Controller
@RequestMapping(value = "/validate")
public class ValidateData {
    /**
     * TODO http://localhost:18080/validate/user?name=sun&age=27
     * 使用注解校验返回客户端错误信息
     */
    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity getSimpleObject(@Valid SimpleUser user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(getFieldErrors(result), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

//    @ExceptionHandler( value = {MethodArgumentNotValidException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public String validationError(MethodArgumentNotValidException ex) {
//        BindingResult result = ex.getBindingResult();
//        final List<FieldError> fieldErrors = result.getFieldErrors();
//        StringBuilder builder = new StringBuilder(256);
//        for (FieldError fieldError : fieldErrors) {
//            builder.append("value:")
//                    .append(fieldError.getField())
//                    .append(" msg:")
//                    .append(fieldError.getDefaultMessage())
//                    .append(" ");
//        }
//        return builder.toString();
//    }

    private String getFieldErrors(BindingResult result) {
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder(256);
        if (result.hasFieldErrors()) {
            builder.append("Field error:");
            for (FieldError fieldError : fieldErrors) {
                builder.append("value:")
                        .append(fieldError.getField())
                        .append(" msg:")
                        .append(fieldError.getDefaultMessage())
                        .append(" ");
            }
            builder.append('\n');
        }
        if (result.hasGlobalErrors()) {
            builder.append("Global error:");
            for (ObjectError objectError : result.getGlobalErrors()) {
                builder.append("errorCode:")
                        .append(objectError.getCode())
                        .append("msg:")
                        .append(objectError.getDefaultMessage())
                        .append(" ");
            }
        }
        return builder.toString();
    }
}
