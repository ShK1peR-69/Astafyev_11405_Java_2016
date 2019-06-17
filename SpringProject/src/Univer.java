/**
 * @author Astafyev Igor
 *         11-405
 */

public class Univer {
    private String name;
    private static Univer univer = new Univer();

    public static Univer getUniver() {
        return univer;
    }

    public static void setUniver(Univer univer) {
        Univer.univer = univer;
    }

    public Univer() {
    }
}
