package alexandertang.playground.graphql.repository;

import alexandertang.playground.graphql.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Optional<Author> getById(String id);
}
