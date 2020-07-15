package com.gyb.ustils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author gb
 * @Date 2020/7/8 17:06
 * @Version 1.0
 * description:字符串转日期
 */

public class StringToDateConverter implements Converter<String, Date> {


    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/8 17:08
     *
     * @param source 传入进来的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
//        判断是否为空
        if (source == null) {
            throw new RuntimeException("日期有误");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
//把字符串转成日期
            return dateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换错误");
        }

    }
}
