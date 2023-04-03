package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    // Implement the Update method
    @Transactional
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    // Implement the Delete method
    @Transactional
    @Override
    public void delete(Integer id) {
        // Retrieve the Student
        Student theStudent = entityManager.find(Student.class, id);

        // Delete the Student
        entityManager.remove(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // Return Query Results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);

        // Set Query Parameters
        theQuery.setParameter("theData", theLastName);

        // Return Query Results
        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery(
                "DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }

}
