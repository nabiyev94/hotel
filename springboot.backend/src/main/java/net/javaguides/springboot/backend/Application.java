package net.javaguides.springboot.backend;

import net.javaguides.springboot.backend.model.Administrator;
import net.javaguides.springboot.backend.model.Book;
import net.javaguides.springboot.backend.model.Customer;
import net.javaguides.springboot.backend.model.Room;
import net.javaguides.springboot.backend.repository.AdministratorRepository;
import net.javaguides.springboot.backend.repository.CustomerRepository;
import net.javaguides.springboot.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner { // this interface will provide the run method

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {





	}
}
