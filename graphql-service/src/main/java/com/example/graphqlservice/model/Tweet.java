package com.example.graphqlservice.model;

import com.example.graphqlservice.scalar.GraphQLDateType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by scottmcallister on 2018-02-16.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User author;
    private String text;
    private int likes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

//    public boolean isRetweet() {
//        return retweet;
//    }
//
//    public void setRetweet(boolean retweet) {
//        this.retweet = retweet;
//    }
//
//    public Tweet getParent() {
//        return parent;
//    }
//
//    public void setParent(Tweet parent) {
//        this.parent = parent;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        return id.equals(tweet.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", author=" + author +
                ", text='" + text + '\'' +
                ", likes=" + likes +
                '}';
    }
}
