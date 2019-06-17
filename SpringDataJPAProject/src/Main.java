import org.hibernate.Session;
import ru.kpfu.itis.java.ais.entities.LessonEntity;
import ru.kpfu.itis.java.ais.util.HibernateUtil;

import javax.transaction.Transaction;

/**
 * @author Astafyev Igor
 *         11-405
 */
public class Main {
    private static final Session session  = HibernateUtil.getSession();

    public static void main(final String[] args) throws Exception {
        org.hibernate.Query q = session.createQuery("from LessonEntity ");
        for(Object l: q.list()){
            System.out.println(l);
        }

        Transaction t = (Transaction) session.beginTransaction();
        LessonEntity le = new LessonEntity();
        le.setTitle("Proga");
        session.save(le);
        t.commit();
    }
}
