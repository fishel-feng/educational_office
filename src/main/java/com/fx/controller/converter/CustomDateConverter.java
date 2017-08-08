package com.fx.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class CustomDateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        return null;
    }
}
