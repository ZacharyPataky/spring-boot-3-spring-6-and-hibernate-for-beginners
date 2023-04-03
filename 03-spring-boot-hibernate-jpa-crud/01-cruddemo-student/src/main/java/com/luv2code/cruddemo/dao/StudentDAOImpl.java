package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements  StudentDAO {

    // Define Field for Entity Manager
    private EntityManager entityManager;

    // Inject Entity Manager Using Constructor Injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement the Save method
    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

}
