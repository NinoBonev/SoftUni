package p01_DefineAClassPerson;

import p01_DefineAClassPerson.Person;

import java.lang.reflect.Field;

/**
 * Created by Nino Bonev - 15.6.2018 г., 23:44
 */
public class Main {
    public static void main(String[] args) {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
