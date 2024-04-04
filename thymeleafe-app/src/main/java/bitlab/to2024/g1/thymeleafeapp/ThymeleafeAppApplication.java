package bitlab.to2024.g1.thymeleafeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ThymeleafeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafeAppApplication.class, args);
	}

}
