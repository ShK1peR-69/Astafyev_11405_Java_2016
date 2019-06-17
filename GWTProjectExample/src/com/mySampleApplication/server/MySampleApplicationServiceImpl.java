package com.mySampleApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.MySampleApplicationService;

import java.util.Random;

public class MySampleApplicationServiceImpl extends RemoteServiceServlet implements MySampleApplicationService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        Random ran = new Random();
        if(ran.nextInt(10)>5){
            return "Да, Ваш день счастливый:)";
        }
        else{
            return "К сожалению, сегодня не Ваш день..:(";
        }
    }
}