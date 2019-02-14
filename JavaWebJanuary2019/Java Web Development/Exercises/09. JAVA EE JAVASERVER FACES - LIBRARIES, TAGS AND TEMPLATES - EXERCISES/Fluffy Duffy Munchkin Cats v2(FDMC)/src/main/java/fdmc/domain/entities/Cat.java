package fdmc.domain.entities;


import jdk.jfr.BooleanFlag;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Nino Bonev - 14.2.2019 г., 0:10
 */

/*
•	name – a String, must contain at least 2 characters, shouldn’t be longer than 10.
•	breed – a String, must contain at least 5 characters, shouldn’t be longer than 20.
•	color – a String.
•	age – an Integer, must be between 1 and 31.
•	gender – a String.
•	price – a decimal value, must be at least 0.01.
•	addedOn – a date without time.
•	hasPassport – a boolean value.

 */

@Entity
@Table(name = "fdmc")
public class Cat extends BaseEntity {

    private String name;
    private String breed;
    private String color;
    private Integer age;
    private String gender;
    private Double price;
    private Date addedOn;
    private boolean hasPassport;

    @Column(name = "cat_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "breed")
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    @Column(name = "hasPassport")
    public boolean isHasPassport() {
        return hasPassport;
    }

    public void setHasPassport(boolean hasPassport) {
        this.hasPassport = hasPassport;
    }
}
