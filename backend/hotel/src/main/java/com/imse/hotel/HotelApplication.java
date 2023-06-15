package com.imse.hotel;

import com.imse.hotel.fillingdatabase.DataBaseFillingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HotelApplication implements CommandLineRunner{  // methode um run zu einschalten
	@Autowired
	DataBaseFillingController databasefillingcontroller;

	public static void main(String[] args) {

		SpringApplication.run(HotelApplication.class, args);

	}

	@Override
	public void run(String... args) {
		databasefillingcontroller.deleteDataBase();
	}
}

/*
package com.imse.hotel;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

}
*/