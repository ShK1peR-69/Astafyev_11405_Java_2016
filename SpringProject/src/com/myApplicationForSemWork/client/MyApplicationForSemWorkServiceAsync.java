package com.myApplicationForSemWork.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MyApplicationForSemWorkServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
