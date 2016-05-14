package com.myApplicationForSemWork.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MyApplicationForSemWorkService")
public interface MyApplicationForSemWorkService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use MyApplicationForSemWorkService.App.getInstance() to access static instance of MyApplicationForSemWorkServiceAsync
     */
    public static class App {
        private static MyApplicationForSemWorkServiceAsync ourInstance = GWT.create(MyApplicationForSemWorkService.class);

        public static synchronized MyApplicationForSemWorkServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
