package com.gankki.controller.excel;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestClass1 {

    public String str;

    public Date date;

    public Double dou;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDou() {
        return dou;
    }

    public void setDou(Double dou) {
        this.dou = dou;
    }

    public static void main(String[] args) throws Exception{
        DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter1.parse("2021-01-01 00:00:00"));
        System.out.println(Double.valueOf("1.11c"));
    }


}
