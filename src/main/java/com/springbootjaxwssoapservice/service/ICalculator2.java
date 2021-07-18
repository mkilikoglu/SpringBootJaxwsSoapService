package com.springbootjaxwssoapservice.service;

import com.springbootjaxwssoapservice.input.ToplaInput;

import javax.jws.WebService;

@WebService
public interface ICalculator2 {
    public String serviceTest(String msg);
    public int topla(ToplaInput input);
    public int  cikar(int a ,int b);
}
