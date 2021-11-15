package by.itacademy.javaenterprise.lepnikau.app.dao.impl;

import by.itacademy.javaenterprise.lepnikau.app.dao.AddressDAO;
import by.itacademy.javaenterprise.lepnikau.app.entity.Address;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressDAOImplTest {

    private static EntityTransaction entityTransactionMock;

    private EntityManager entityManagerMock;
    private AddressDAO addressDAO;

    @BeforeAll
    static void beforeAll() {
        entityTransactionMock = mock(EntityTransaction.class);

    }

    @BeforeEach
    void beforeEach() {
        entityManagerMock = mock(EntityManager.class);

        addressDAO = new AddressDAOImpl(entityManagerMock);
    }

    @Test
    void saveTest() {
        Address address = new Address();

        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);

        Address actual = addressDAO.save(address);

        assertNotNull(actual);
    }

    @Test
    void saveTestWithEntityNull() {
        assertNull(addressDAO.save(null));

        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);

        assertDoesNotThrow(() -> addressDAO.save(null));
    }

    @Test
    void findTest() {
        Address address = new Address();
        address.setAddressId(1L);

        Long queryId = 1L;

        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        when(entityManagerMock.find(Mockito.<Class<Address>>any(), Mockito.eq(queryId)))
                .thenReturn(address);

        assertEquals(queryId, addressDAO.find(queryId).getAddressId());
    }

    @Test
    void findTestWithWrongId() {
        Long queryId = -1L;

        assertNull(addressDAO.find(queryId));
    }
}