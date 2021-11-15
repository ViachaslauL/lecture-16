package by.itacademy.javaenterprise.lepnikau.app.dao.impl;

import by.itacademy.javaenterprise.lepnikau.app.dao.AddressDAO;
import by.itacademy.javaenterprise.lepnikau.app.entity.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;

public class AddressDAOImpl implements AddressDAO {

    private static final Logger logger = LogManager.getLogger(AddressDAOImpl.class);

    private EntityManager eManager;

    public AddressDAOImpl(EntityManager eManager) {
        this.eManager = eManager;
    }

    @Override
    public Address save(Address address) {
        try {
            eManager.getTransaction().begin();
            eManager.persist(address);
            eManager.getTransaction().commit();
            return address;
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            eManager.close();
        }
        return null;
    }

    @Override
    public Address find(Long id) {
        Address address = null;

        try {
            eManager.getTransaction().begin();
            address = eManager.find(Address.class, id);
            eManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            eManager.close();
        }
        return address;
    }
}
