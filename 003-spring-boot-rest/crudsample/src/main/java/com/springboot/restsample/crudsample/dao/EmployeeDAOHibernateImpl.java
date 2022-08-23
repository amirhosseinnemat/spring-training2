package com.springboot.restsample.crudsample.dao;

import com.springboot.restsample.crudsample.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@EnableAutoConfiguration // for autowired problem by intellij
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // set-up constructor injection

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);


        // create a query
        Query<Employee> theQuery = currentSession.createQuery("FROM Employee ", Employee.class);
        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }
}
