package com.myApplicationForSemWork.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myApplicationForSemWork.client.MyApplicationForSemWorkService;

public class MyApplicationForSemWorkServiceImpl extends RemoteServiceServlet implements MyApplicationForSemWorkService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}