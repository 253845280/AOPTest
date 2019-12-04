package com.example.aop.springboot.test;

import com.example.aop.springboot.vail.ParamCheck;
import com.example.aop.springboot.vail.VailData;

import java.util.Date;
import java.util.List;

@VailData
public class TestClass<E> {
    @ParamCheck(Length = 100)
    private String str;
    private Integer add;
    private Date time;
    private Double aDouble;
    private List<E> list;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getAdd() {
        return add;
    }

    public void setAdd(Integer add) {
        this.add = add;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public void setaDouble(Double aDouble) {
        this.aDouble = aDouble;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
