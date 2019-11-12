package com.FoodGramServer.FoodGramServer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_message;


    @OneToMany
    //@JsonManagedReference
    @JoinColumn(name="user_id")
    private User user1;


    @OneToMany
    //@JsonManagedReference
    @JoinColumn(name="user_id")
    private User user2;


    @Column(name = "message")
    @NotNull
    private String message;

    @Column(name = "timestamp")
    @NotNull
    private LocalDateTime timestamp;
}
