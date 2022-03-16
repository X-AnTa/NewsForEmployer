package com.anta.news.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_name")
    private String name;

    @Column(name = "type_color")
    private String type_color;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "news_types",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "news_id")

    )
    private Set<Type> news;

    public Type() {
    }

    public Type(String type_name, String type_color) {
        this.name = type_name;
        this.type_color = type_color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_name() {
        return name;
    }

    public void setType_name(String type_name) {
        this.name = type_name;
    }

    public String getType_color() {
        return type_color;
    }

    public void setType_color(String type_color) {
        this.type_color = type_color;
    }

    public void setNews(Set<Type> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type_name='" + name + '\'' +
                ", type_color='" + type_color + '\'' +
                '}';
    }
}
