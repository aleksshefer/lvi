package ru.shefer.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "topic_name")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    @Column(name = "creation_date", updatable = false)
    @CreationTimestamp
    private Date creationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic", fetch = FetchType.LAZY)
    private Set<Post> posts;

    public Topic() {
    }

    public String customToString() {
        return "Название темы: " + name +
                ", автор: " + author.getName() + author.getSurname() +
                ", дата создания: " + new SimpleDateFormat("dd.MM.yyyy").format(creationDate);
    }
}