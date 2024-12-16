package me.byungju.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "email", nullable = false, unique = true)
    private String password;

    @Builder
    public User(String email, String password, String auth){
        this.email = email;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("user"));
    }
    //사용자의 id를 반환(고유한 값)
    @Override
    public String getUsername(){
        return email;
    }

    //사용자의 password를 반환
    @Override
    public String getPassword(){
        return password;
    }

    //계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired(){
        //만료되었는지 확인하는 로직

        return true; //true -> 만료되지 않았음
    }

    //계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked(){
        //계정 잠금되었는지 확인하는 로직
        return true; //true -> 잠금되지 않음
    }


    // 패스워드 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired(){
        // 패스워드가 만료되었는지 확인하는 로직
        return true; //true -> 만료되지 않음
    }

    //계정 사용가능여부 반환
    @Override
    public boolean isEnabled(){
        //계정 사용가능한지 확인하는 로직

        return true; //true -> 사용가능
    }

}
