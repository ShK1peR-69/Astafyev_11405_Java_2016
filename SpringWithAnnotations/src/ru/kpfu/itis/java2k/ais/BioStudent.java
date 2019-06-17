package ru.kpfu.itis.java2k.ais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
public class BioStudent implements Student {
    @Value("Damir") // �������� �� ���������
    private String name;

    @Autowired // JavaConfig ��� ���� ������ bean ��� ����� autowired(� ������ ������ bean-��������)
    @Qualifier("bio")
    private BioInstitute institute;

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
        return "BioStudent{" +
                "name='" + name + '\'' +
                ", institute=" + institute +
                '}';
    }
}