package by.itacademy.javaenterprise.lepnikau.app.dao;

import by.itacademy.javaenterprise.lepnikau.app.entity.Person;

public interface PersonDAO {

    Person save(Person person);

    Person find(Long id);
}
