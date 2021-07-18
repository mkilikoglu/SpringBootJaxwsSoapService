package com.springbootjaxwssoapservice.service;

import com.springbootjaxwssoapservice.input.ToplaInput;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
@Component
@WebService(endpointInterface = "com.springbootjaxwssoapservice.service.ICalculator")
    public class Calculator implements ICalculator {

    @WebMethod(operationName = "servisTest")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public String serviceTest(@WebParam(name = "testMesaj") String testMesaj){

        return testMesaj;
    }

    @WebMethod(operationName = "topla")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public int topla(@WebParam(name = "toplanacakSayilar") ToplaInput input) {
        return input.getA()+input.getB();
    }


    @WebMethod(operationName = "cikar")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    public int cikar(@WebParam(name = "a") int a ,
                     @WebParam(name = "b") int b) {
        return a-b;
    }
}
