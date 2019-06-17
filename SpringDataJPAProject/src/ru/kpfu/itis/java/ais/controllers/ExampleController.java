package ru.kpfu.itis.java.ais.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kpfu.itis.java.ais.entities.LessonEntity;
import ru.kpfu.itis.java.ais.services.LessonService;

import java.sql.SQLException;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Controller
public class ExampleController {

    @Autowired
    static LessonService lessonService;

    public static void getLesson() throws SQLException {
        LessonEntity lesson = lessonService.getLessonByID(1);
        String lessonName = lesson.getTitle();
        System.out.println(lessonName);
    }

    public static void main(String[] args) throws SQLException {
        lessonService.addNewLesson(1, "Math", 10);
        getLesson();
    }

}
