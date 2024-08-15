package br.com.gdam.fipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gdam.fipe.main.Main;

@SpringBootApplication
public class FipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.Menu();
	}

}
