package kevat25.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kevat25.bookstore.domain.Book;
import kevat25.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    private BookRepository bookRepository;

    // Constructor injection
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // RESTful service to get all books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // RESTful service to get book by id
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    // RESTful service to save new book
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public List<Book> newBook(@RequestBody Book newBook) {
        bookRepository.save(newBook);
        return (List<Book>) bookRepository.findAll();
    }

    // RESTful service to delete book by id
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public List<Book> deleteBookRest(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return (List<Book>) bookRepository.findAll();
    }

    // RESTful service to edit book
    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    Book editBook(@RequestBody Book editedBook, @PathVariable("id") Long bookId) {
        editedBook.setId(bookId);
        return bookRepository.save(editedBook);
    }

}
