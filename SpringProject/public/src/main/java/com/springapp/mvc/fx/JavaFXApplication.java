package com.springapp.mvc.fx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class JavaFXApplication extends Application {

    private static String[] savedArgs;
    protected ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(getClass(), savedArgs);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

    protected static void launchApp(Class<? extends JavaFXApplication> clazz, String[] args) {
        JavaFXApplication.savedArgs = args;
        Application.launch(clazz, args);
    }
}