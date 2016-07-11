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
    String comicName;

    @Column
    String comment;

    @Column
    String filename;

    @Column
    int likes;

    @ManyToOne
    User user;

    public ComicBook() {
    }

    public ComicBook(String comicName, String comment, String filename, User user) {
        this.comicName = comicName;
        this.comment = comment;
        this.filename = filename;
        this.user = user;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
