package ru.kpfu.itis.java2k.ais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component // Это и есть собственно bean
public class ITStudent implements Student {
    @Value("Adel") // Значение по умлочанию
    private String name;

    @Autowired // JavaConfig сам ищет нужный bean для этого autowired(в данном случае bean-интситут)
    @Qualifier("it")
    private ITInstitute institute;

    public ITStudent() {
    }

    @Override
    public void wakeUp() {

    }

    @Override
    public void study() {

    }

    @Override
    public void goToSleep() {

    }

    @Override
    public String toString() {
        return "ITStudent{" +
                "name='" + name + '\'' +
                ", institute=" + institute +
                '}';
    }
}