package ru.kpfu.itis.java.ais.entities;

import javax.persistence.*;

/**
 * @author Astafyev Igor
 *         11-405
 */
@Entity
@Table(name = "lesson", schema = "public", catalog = "DBforSpring")
public class LessonEntity {
    private int id;
    private String title;
    private int maxStudents;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "max_students", nullable = false, insertable = true, updatable = true)
    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonEntity that = (LessonEntity) o;

        if (id != that.id) return false;
        if (maxStudents != that.maxStudents) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + maxStudents;
        return result;
    }
}
