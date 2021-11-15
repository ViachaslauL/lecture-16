package by.itacademy.javaenterprise.lepnikau.app.dao.impl;

import by.itacademy.javaenterprise.lepnikau.app.dao.AddressDAO;
import by.itacademy.javaenterprise.lepnikau.app.entity.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressDAOImplTest {

    @Mock
    private EntityTransaction entityTransactionMock;
    @Mock
    private EntityManager entityManagerMock;
    private AddressDAO addressDAO;

    @BeforeEach
    void beforeEach() {
        entityTransactionMock = mock(EntityTransaction.class);
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

        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);

        assertNull(addressDAO.save(null));
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

        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);

        assertNull(addressDAO.find(queryId));
    }
}