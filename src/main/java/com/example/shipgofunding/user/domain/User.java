package com.example.shipgofunding.user.domain;

import com.example.shipgofunding.config.utils.MetaData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@SQLRestriction("deleted_at IS NULL")
@SQLDelete(sql = "UPDATE users SET deleted_at = CURRENT_TIMESTAMP, is_deleted = TRUE where id = ?")
@Entity
@Table(name = "users")
public class User extends MetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "image")
    private String image;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name="role")
    private RoleEnum role;

    @Builder
    public User(String email, String password, String nickname, RoleEnum role) {
        this.role = role;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

}