package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            // createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            // queryForStudents(studentDAO);
            queryForStudentsByLastName(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // Create the Student Object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

        // Save the Student Object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // Display the ID of the Saved Student
        System.out.println("Saved student.  Generated ID: " + tempStudent.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // Create Multiple Students
        System.out.println("Creating three new student objects...");
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

        // Save the Student Objects
        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void readStudent(StudentDAO studentDAO) {
        // Create a Student Object
        System.out.println("Creating a new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

        // Save the Student
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // Display the Student's ID
        int theId = tempStudent.getId();
        System.out.println("Saved Student. Generated ID: " + theId);

        // Retrieve the Student Based on the ID (Primary Key)
        System.out.println("Retrieving the Student with ID: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // Display the Student
        System.out.println("Found the student: " + myStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // Get the List of Students
        List<Student> theStudents = studentDAO.findAll();

        // Display the List of Students
        for (Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // Get the List of Students
        List<Student> theStudents = studentDAO.findByLastName("Doe");

        // Display the List of Students
        for (Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }
    }

}
