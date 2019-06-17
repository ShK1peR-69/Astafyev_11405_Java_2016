/**
 * @author Astafyev Igor
 *         11-405
 */

public class Lesson {
    private String name;

    public Lesson() {
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                '}';
    }

    public Lesson(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
