package com.app.slackdame.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameChannel;

    public Channel() {
    }

    public Channel(String nameChannel) {
        this.nameChannel = nameChannel;
    }

    @OneToMany(mappedBy ="channel" ,cascade = CascadeType.ALL)
    private List<Post> posts;

    @ManyToOne
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameChannel() {
        return nameChannel;
    }

    public void setNameChannel(String nameChannel) {
        this.nameChannel = nameChannel;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", nameChannel='" + nameChannel + '\'' +
                '}';
    }
}
