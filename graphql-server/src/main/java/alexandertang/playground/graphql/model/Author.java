package alexandertang.playground.graphql.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
public class Author implements Serializable {

    private static final long serialVersionUID = 5256068897209356092L;

    @Id
    private String id;
    private String name;
    private String thumbnail;
    private List<Post> posts = new ArrayList<>();

    public Author(){}

    public Author(String id, String name, String thumbnail, List<Post> posts){
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        if(posts != null){
            this.posts = posts;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}