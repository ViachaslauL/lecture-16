package by.itacademy.javaenterprise.lepnikau.app.dao;

import by.itacademy.javaenterprise.lepnikau.app.entity.Address;

public interface AddressDAO {

    Address save(Address address);

    Address find(Long id);
}
