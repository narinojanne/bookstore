package kevat25.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat25.bookstore.domain.Book;
import kevat25.bookstore.domain.BookRepository;
import kevat25.bookstore.domain.Category;
import kevat25.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {

			Category category1 = new Category("Scifi");
			Category category2 = new Category("Children");
			Category category3 = new Category("History");

			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			brepository.save(new Book("Aku", "Johnson", "123456789", 2025, 15.50, category1));
			brepository.save(new Book("Ankka", "Kateson", "987654321", 2020, 20.15, category2));	
			
			brepository.save(new Book("Musta", "Naamio", "963258741", 1995, 15.25, category3));
			
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
