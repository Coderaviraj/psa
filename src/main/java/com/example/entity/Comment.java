package com.example.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "content", length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}