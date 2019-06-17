import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Student {
    private String name;
    private static int n = 0;
    private Institute institute;
    private List<Lesson> lessons;

    public void goToLessons() {
        for (Lesson l : lessons) {
            System.out.println("Goes to lesson " + l.getName() + "; " + "\n");
        }
    }

    public Student(String name, Institute institute) {
        this.name = name;
        this.institute = institute;
    }

    public Student() {
        n++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        Student.n = n;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", institute='" + institute + '\'' +
                '}';
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}