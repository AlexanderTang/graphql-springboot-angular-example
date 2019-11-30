package alexandertang.playground.graphql;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GraphQLSpringBootApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GraphQLSpringBootApplication.class)
                .build()
                .run(args);
    }
}
