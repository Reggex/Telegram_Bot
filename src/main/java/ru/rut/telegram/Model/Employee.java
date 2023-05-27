package ru.rut.telegram.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "CHAT_ID")
    private String chatId;

    @Column(name = "IS_ADMIN")
    private boolean isAdmin = true;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Work> workList;

    public Employee() {
    }

    public Employee(String login, String chatId, boolean isAdmin) {
        this.login = login;
        this.chatId = chatId;
        this.isAdmin = isAdmin;
    }

}
