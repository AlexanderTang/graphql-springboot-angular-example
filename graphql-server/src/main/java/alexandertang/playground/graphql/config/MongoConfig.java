package alexandertang.playground.graphql.config;

import alexandertang.playground.graphql.model.Author;
import alexandertang.playground.graphql.model.Post;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Configuration
@AllArgsConstructor
public class MongoConfig {

    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initRepositories() {
        clearRepositories();

        List<Post> posts = persistInitialPosts();
        persistInitialAuthors(posts);
    }

    private void clearRepositories() {
        mongoTemplate.dropCollection("post");
        mongoTemplate.dropCollection("author");
        mongoTemplate.dropCollection("reference");
    }

    private List<Post> persistInitialPosts() {
        List<Post> posts = asList(
                new Post(UUID.randomUUID().toString(), 20L, "Example 1", "example content", "cat1", "Stephen"),
                new Post(UUID.randomUUID().toString(), 40L, "Example 2", "more content", "cat2", "Stephen"),
                new Post(UUID.randomUUID().toString(), 60L, "Example 3", "some MORE content", "cat3", "Alfred"),
                new Post(UUID.randomUUID().toString(), 80L, "Example 4", "so much content", "cat4", "Bob"),
                new Post(UUID.randomUUID().toString(), 100L, "Example 5", "content overflow", "cat5", "Stephen")
        );
        for (Post post : posts) {
            mongoTemplate.save(post);
        }
        return posts;
    }

    private void persistInitialAuthors(List<Post> posts){
        String authorStephen = "Stephen";
        String authorAlfred = "Alfred";
        String authorBob = "Bob";
        List<Author> authors = asList(
                new Author(UUID.randomUUID().toString(), authorStephen, "thumbnail1",
                        posts.stream()
                                .filter(post -> authorStephen.equals(post.getAuthorId()))
                                .collect(Collectors.toList())),
                new Author(UUID.randomUUID().toString(), authorAlfred, "thumbnail2",
                        posts.stream()
                                .filter(post -> authorAlfred.equals(post.getAuthorId()))
                                .collect(Collectors.toList())),
                new Author(UUID.randomUUID().toString(), authorBob, "thumbnail3",
                        posts.stream()
                                .filter(post -> authorBob.equals(post.getAuthorId()))
                                .collect(Collectors.toList()))
        );
        for (Author author : authors) {
            mongoTemplate.save(author);
        }
    }
}
