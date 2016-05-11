package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

public class AddressInformationFormBean {

    @Pattern(regexp = "\\d{6}", message = "Некорректно введён индех")
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String index;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String area;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String city;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String street;

    @Pattern(regexp = "\\d{1,10}", message = "Некорректно введён номер дома")
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String house;

    @Pattern(regexp = "\\d{0,10}", message = "Некорректно введён номер квартиры")
    private String flat;

    public AddressInformationFormBean() {
    }

    public AddressInformationFormBean(String index, String area, String city, String street, String house, String flat) {
        this.index = index;
        this.area = area;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}
