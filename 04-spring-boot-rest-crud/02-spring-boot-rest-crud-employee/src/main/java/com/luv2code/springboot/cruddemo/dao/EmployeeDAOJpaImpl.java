package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // Define field for EntityManager
    private EntityManager entityManager;

    // Set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // Execute the query and get the result list
        List<Employee> employees = theQuery.getResultList();

        // Return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // Get the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // Return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // Save the employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // Return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // Find employee by ID
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // Remove the employee
        entityManager.remove(theEmployee);
    }

}
