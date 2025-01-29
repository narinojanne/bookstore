package kevat25.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat25.bookstore.domain.Book;
import kevat25.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo() {
		return (args) -> {
			repository.save(new Book("Aku", "Johnson", "123456789", 2025, 15.50));
			repository.save(new Book("Ankka", "Kateson", "987654321", 2020, 20.15));	
			
			repository.save(new Book("Musta", "Naamio", "963258741", 1995, 15.25));
			
			for (Book book : repository.findAll()) {
			}
		};
	}

}
