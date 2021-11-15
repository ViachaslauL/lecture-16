package by.itacademy.javaenterprise.lepnikau.app.dao.impl;

import by.itacademy.javaenterprise.lepnikau.app.dao.PersonDAO;
import by.itacademy.javaenterprise.lepnikau.app.entity.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonDAOImplTest {

    @Mock
    private static EntityTransaction entityTransactionMock;

    @Mock
    private EntityManager entityManagerMock;
    private PersonDAO personDAO;

    @BeforeAll
    static void beforeAll() {
        entityTransactionMock = mock(EntityTransaction.class);

    }

    @BeforeEach
    void beforeEach() {
        entityManagerMock = mock(EntityManager.class);
        personDAO = new PersonDAOImpl(entityManagerMock);
    }

    @Test
    void saveTest() {
        Person person = new Person();

        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);

        Person actual = personDAO.save(person);

        assertNotNull(actual);
    }

    @Test
    void saveTestWithEntityEqualToNull() {

        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);

        Person actual = personDAO.save(null);

        assertNull(actual);
    }

    @Test
    void findTest() {
        Person person = new Person();
        person.setPersonId(5L);

        Long queryId = 5L;

        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        when(entityManagerMock.find(Mockito.<Class<Person>>any(), Mockito.eq(queryId)))
                .thenReturn(person);

        assertEquals(queryId, personDAO.find(queryId).getPersonId());
    }

    @Test
    void findTestWithWrongId() {
        Long queryId = -1L;

        assertNull(personDAO.find(queryId));
    }
}