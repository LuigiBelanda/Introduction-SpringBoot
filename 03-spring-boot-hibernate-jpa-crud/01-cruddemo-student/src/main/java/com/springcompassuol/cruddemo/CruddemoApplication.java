package com.springcompassuol.cruddemo;

import com.springcompassuol.cruddemo.dao.StudentDAO;
import com.springcompassuol.cruddemo.entity.Student;
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

	// New Bean
	// Será executado depois que os Spring Beans forem carregados
	// E irá fazer o que quisermos
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		// Assim que os Beans forem carregados nosso código irá executar os comandos abaixo
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	/*
	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id: PK
		int studentId = 1;
		System.out.println("getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		// Update the Student
		studentDAO.update(myStudent);

		// Display the updated student
		System.out.println("Update student: " + myStudent);
	}
	*/

	/*
	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// Get a list of students
		// Aqui chamamos nosso método findByLastName e passamos como param o lastName que queremos pesquisar
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		// Display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
	*/

	/*
	private void queryForStudents(StudentDAO studentDAO) {
		// Get list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
	*/

	/*
	private void readStudent(StudentDAO studentDAO) {
		// Create a student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffyduck@gmail.com");

		// Save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// Display id
		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated id: " + theId);

		// Return student based on the id: PK
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// Display student
		System.out.println("Found the student: " + myStudent);
	}
	*/

	/*
	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent2 = new Student("Sarra", "Doe", "sarra@gmail.com");
		Student tempStudent3 = new Student("Jessica", "Doe", "jessica@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved Student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved Student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved Student. Generated id: " + tempStudent3.getId());
	}
	*/

	/*
	// Aqui é onde iremos salvar / criar nosso Student
	private void createStudent(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");



		// Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);



		// Display id of the saved student
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}
	*/
}
