package com.springboot.java_jangan.data.entity;

import com.springboot.java_jangan.authentication.domain.oauth.OAuthProvider;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor

public class Sns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private OAuthProvider oAuthProvider;

    @Builder
    public Sns( String email,String nickname, OAuthProvider oAuthProvider) {


        this.nickname = nickname;
        this.oAuthProvider = oAuthProvider;
    }


}
