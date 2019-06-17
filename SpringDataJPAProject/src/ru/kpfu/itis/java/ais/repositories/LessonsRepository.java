package ru.kpfu.itis.java.ais.repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.java.ais.entities.LessonEntity;
import ru.kpfu.itis.java.ais.util.HibernateUtil;

import java.sql.SQLException;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Repository
public class LessonsRepository {

    public LessonEntity getLessonByID (Long id) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(LessonEntity.class);
        LessonEntity lesson = (LessonEntity) criteria.add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return lesson;
    }

    public void addNewLesson(int id, String title, int max_students){
        LessonEntity lesson = new LessonEntity();
        lesson.setId(id);
        lesson.setMaxStudents(max_students);
        lesson.setTitle(title);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(lesson);
    }
}
