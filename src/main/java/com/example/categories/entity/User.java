package com.example.categories.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    // Первинний ключ таблиці users
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ім'я користувача
    @Column(nullable = false)
    private String username;

    // Email користувача (унікальний)
    @Column(nullable = false, unique = true)
    private String email;

    // Пароль користувача (зберігається у зашифрованому вигляді)
    @Column(nullable = false)
    private String password;

    // Токен для відновлення паролю
    // Використовується одноразово
    @Column(name = "reset_token")
    private String resetToken;

    public User() {
    }

    // ===== getters / setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }
}