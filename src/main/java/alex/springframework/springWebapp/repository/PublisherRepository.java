package alex.springframework.springWebapp.repository;

import alex.springframework.springWebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
