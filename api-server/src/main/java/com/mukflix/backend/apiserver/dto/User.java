package com.mukflix.backend.apiserver.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USR_INFO")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_SQ")
    private Long userSequence ;

    @Email(message = "메일의 양식에 맞게 입력해주세요")
    @Column(name = "USR_EMAIL", nullable = false, unique = true, length = 50)
    private String userEmail;

    @Column(name = "USR_NM")
    private String userName;

    @Column(name = "GEND")
    private String userGender;


    @Column(name = "BIRTH")
    private String userBirth;

    @Column(name = "JOIN_DD")
    private String userJoin_dd;

    @Column(name = "LST_CHG_DD")
    private String userChg_dd;

    @Column(length = 100)
    private String provider;

    /**
     *   Join(조인)
     *     비밀번호 정보를 다른 뱡향으로 활용하기 위해
     *     회원정보와 비밀번호 정보를 다른 테이블로 관리
     */

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="USR_SQ")
    private PasswordChangeRecord passwordChangeRecord;



    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getPassword() {
        return this.passwordChangeRecord.getPassword();
    }


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return this.userEmail;
    }


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }


}