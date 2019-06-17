package ru.kpfu.itis.java2k.ais;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Component
@Qualifier("it")
public class ITInstitute implements Institute{
    @Value("ITIS")
    private String name;

    public ITInstitute(){
    }

    public ITInstitute(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name + '\'' +
                '}';
    }
}
