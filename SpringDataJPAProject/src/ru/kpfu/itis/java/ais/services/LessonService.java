package ru.kpfu.itis.java.ais.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.java.ais.entities.LessonEntity;
import ru.kpfu.itis.java.ais.repositories.LessonsRepository;

import java.sql.SQLException;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Service
public class LessonService {

    @Autowired
    LessonsRepository lessonsRepository;

    public LessonEntity getLessonByID(long id) throws SQLException {
        return lessonsRepository.getLessonByID(id);
    }

    public void addNewLesson(int id, String title, int max_students) {
        lessonsRepository.addNewLesson(id, title, max_students);
    }

}
