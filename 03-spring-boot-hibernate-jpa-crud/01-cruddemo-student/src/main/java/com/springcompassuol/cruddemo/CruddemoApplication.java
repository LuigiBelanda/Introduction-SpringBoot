package com.springcompassuol.cruddemo;

import com.springcompassuol.cruddemo.dao.StudentDAO;
import com.springcompassuol.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent2 = new Student("Sarra", "Doe", "sarra@gmail.com");
		Student tempStudent3 = new Student("Jessica", "Doe", "Jessica@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved Student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved Student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved Student. Generated id: " + tempStudent3.getId());
	}

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
}
