package by.itacademy.javaenterprise.lepnikau.app.dao.impl;

import by.itacademy.javaenterprise.lepnikau.app.dao.PersonDAO;
import by.itacademy.javaenterprise.lepnikau.app.entity.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;

public class PersonDAOImpl implements PersonDAO {

    private static final Logger logger = LogManager.getLogger(PersonDAOImpl.class);

    private EntityManager eManager;

    public PersonDAOImpl(EntityManager eManager) {
        this.eManager = eManager;
    }

    @Override
    public Person save(Person person) {
        try {
            eManager.getTransaction().begin();
            eManager.persist(person);
            eManager.getTransaction().commit();
            return person;
        } catch (Exception e) {
            logger.error(e.getMessage());
            eManager.getTransaction().rollback();
        } finally {
            eManager.close();
        }
        return null;
    }

    @Override
    public Person find(Long id) {
        Person person = null;

        try {
            eManager.getTransaction().begin();
            person = eManager.find(Person.class, id);
            eManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error(e.getMessage());
            eManager.getTransaction().rollback();
        } finally {
            eManager.close();
        }
        return person;
    }
}
