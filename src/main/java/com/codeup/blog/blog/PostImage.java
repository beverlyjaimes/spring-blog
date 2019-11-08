package com.codeup.blog.blog;
//. In the relationship-practice branch of your Spring Blog's, add an entity of PostImage with the following fields:
//        id (typical primary key annotations)
//        image_title VARCHAR(100) NOT NULL
//        url VARCHAR(1000) NOT NULL - the url is for simple hot linking of images for now
//        post_id (a FK that will be created with the proper One-To-Many mapping)



import javax.persistence.*;

@Entity
@Table(name = "images")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String image_title;

    @Column(length = 1000, nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public PostImage(){
    }

//    public PostImage(String image_title, String url, Post post) {
//        this.image_title = image_title;
//        this.url = url;
//        this.post = post;
//    }

    public PostImage(String image_title, String url) {
        this.image_title = image_title;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
