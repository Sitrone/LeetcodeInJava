package com.web.spring.databind.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Administrator on 2017/7/9.
 */
public class MyDateConverter implements Converter<String, Date> {
    private static final String pattern = "yyyy-MM-dd";

    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
