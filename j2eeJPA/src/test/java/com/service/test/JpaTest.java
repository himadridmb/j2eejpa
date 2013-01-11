package com.service.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.service.domain.Employee;

public class JpaTest {

  private static final String PERSISTENCE_UNIT_NAME = "j2eeJPA";
  private EntityManagerFactory factory;

  @Before
  public void setUp() throws Exception {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();

    // Begin a new local transaction so that we can persist a new entity
    em.getTransaction().begin();

    // Read the existing entries
    Query q = em.createQuery("select m from Employee m");
    // Persons should be empty

    // Do we have entries?
    boolean createNewEntries = (q.getResultList().size() == 0);

    // No, so lets create new entries
    if (createNewEntries) {
      assertTrue(q.getResultList().size() == 0);
 
      for (int i = 0; i < 40; i++) {
    	  Employee employee = new Employee();
          employee.setFirstName("UNOapp"+i);
          employee.setSurname("WEBtool"+i);
          employee.setSalary(10000+i);
       
          em.persist(employee);
        
      }
    }

    // Commit the transaction, which will cause the entity to
    // be stored in the database
    em.getTransaction().commit();

    // It is always good practice to close the EntityManager so that
    // resources are conserved.
    em.close();

  }

  @Test
  public void checkAvailablePeople() {

    // Now lets check the database and see if the created entries are there
    // Create a fresh, new EntityManager
    EntityManager em = factory.createEntityManager();

    // Perform a simple query for all the Message entities
    Query q = em.createQuery("select m from Employee m");

    // We should have 40 Persons in the database
    assertTrue(q.getResultList().size() == 40);

    em.close();
  }

  @Test
  public void ListAllEmployees()
  {
	  EntityManager em = factory.createEntityManager();
	  TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
	  List<Employee> emps = query.getResultList();
	  assertTrue(emps != null);
	  
	  for (Employee e : emps)
	  {
	      System.out.println("Found employee: " + e);
	  }
	  em.close();
  }
 
} 
