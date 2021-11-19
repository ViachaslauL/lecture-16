package by.itacademy.javaenterprise.lepnikau;

import by.itacademy.javaenterprise.lepnikau.dao.AddressDAO;
import by.itacademy.javaenterprise.lepnikau.dao.impl.AddressDAOImpl;
import by.itacademy.javaenterprise.lepnikau.entity.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("by.it");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AddressDAO addressDAO = new AddressDAOImpl(entityManager);

        Address address = addressDAO.find(1L);
        LOG.info(address.toString());
    }
}
