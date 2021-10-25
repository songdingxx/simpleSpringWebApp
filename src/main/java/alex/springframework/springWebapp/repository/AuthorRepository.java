package alex.springframework.springWebapp.repository;

import alex.springframework.springWebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
