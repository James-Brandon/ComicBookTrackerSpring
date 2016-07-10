package com.james.entities;

import javax.persistence.*;

/**
 * Created by jamesyburr on 7/10/16.
 */
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue
    int id;

    @Column
    boolean liked;

    @Transient
    int comicBookId;

    public Like() {
    }

    public Like(boolean liked, int comicBookId) {
        this.liked = liked;
        this.comicBookId = comicBookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getComicBookId() {
        return comicBookId;
    }

    public void setComicBookId(int comicBookId) {
        this.comicBookId = comicBookId;
    }
}
