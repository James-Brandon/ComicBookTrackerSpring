package com.james.entities;

import javax.persistence.*;

/**
 * Created by jamesyburr on 7/10/16.
 */
@Entity
@Table(name = "comic_books")
public class ComicBook {

    @Id
    @GeneratedValue
    int id;

    @Column
    String filename;

    @Column
    int likes;

    @ManyToOne
    User user;

    public ComicBook() {
    }

    public ComicBook(String filename, int likes, User user) {
        this.filename = filename;
        this.likes = likes;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
