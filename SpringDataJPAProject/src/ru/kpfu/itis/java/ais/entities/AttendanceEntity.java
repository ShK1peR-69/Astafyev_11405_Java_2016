package ru.kpfu.itis.java.ais.entities;

import javax.persistence.*;

/**
 * @author Astafyev Igor
 *         11-405
 */
@Entity
@Table(name = "attendance", schema = "public", catalog = "DBforSpring")
public class AttendanceEntity {
    private String id;
    private int year;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 30)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "year", nullable = false, insertable = true, updatable = true)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceEntity that = (AttendanceEntity) o;

        if (year != that.year) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + year;
        return result;
    }
}
