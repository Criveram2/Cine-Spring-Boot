package co.com.crivera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CineRestServiceApplication {

	public static void main(String[] args) {
	    System.setProperty("server.servlet.context-path", "/cineweb");
		SpringApplication.run(CineRestServiceApplication.class, args);
	}

}
