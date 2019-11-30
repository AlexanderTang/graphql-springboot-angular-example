package alexandertang.playground.graphql.controller;

import alexandertang.playground.graphql.repository.PostRepository;
import alexandertang.playground.graphql.model.Post;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class PostController {

    private PostRepository postRepository;

    @GetMapping(value = "/all-posts")
    public List<Post> getAllPosts () {
        return postRepository.findAll();
    }

    @GetMapping(value = "/posts-by-author")
    public List<Post> getAllPosts (@RequestParam String authorId) {
        return postRepository.getAllByAuthorId(authorId);
    }
}
