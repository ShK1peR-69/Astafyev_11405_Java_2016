package ru.kpfu.itis.java2k.ais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component // ��� � ���� ���������� bean
public class ITStudent implements Student {
    @Value("Adel") // �������� �� ���������
    private String name;

    @Autowired // JavaConfig ��� ���� ������ bean ��� ����� autowired(� ������ ������ bean-��������)
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