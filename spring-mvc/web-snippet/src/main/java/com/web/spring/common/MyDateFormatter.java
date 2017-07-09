package com.web.spring.databind.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 * 相对于Converter，source默认为String，converter接口中的Source可以为任意类型，更加灵活
 * Created by Administrator on 2017/7/9.
 */
public class MyDateFormatter implements Formatter<Date>{
    private static final String pattern = "yyyy-MM-dd";

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return null;
    }
}
