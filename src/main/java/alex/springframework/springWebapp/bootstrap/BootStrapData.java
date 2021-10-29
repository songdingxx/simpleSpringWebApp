package alex.springframework.springWebapp.bootstrap;

import alex.springframework.springWebapp.domain.Author;
import alex.springframework.springWebapp.domain.Book;
import alex.springframework.springWebapp.domain.Publisher;
import alex.springframework.springWebapp.repository.AuthorRepository;
import alex.springframework.springWebapp.repository.BookRepository;
import alex.springframework.springWebapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Test Publisher");
        publisher.setCity("test city");
        publisher.setState("CA");

        publisherRepository.save(publisher);
        System.out.println("Publisher repository count: " + publisherRepository.count());

        Author eric = new Author("Eric", "None");
        Book book1 = new Book("Design", "1234");

        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "None");
        Book book2 = new Book("Domain", "134125");

        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        authorRepository.save(rod);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap...");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Books: " + authorRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
