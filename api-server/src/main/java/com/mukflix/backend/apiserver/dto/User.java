package com.mukflix.backend.apiserver.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;





@Builder // builder를 사용할 수 있게 합니다.
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@Table(name = "USR_INFO") // 'USR_INFO' 테이블과 매핑됨을 명시
public class User extends CommonDateEntity implements UserDetails{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "USR_SQ")
    private Long userSequence ;

    @Column(name = "USR_EMAIL", nullable = false, unique = true, length = 50)
    private String userEmail;

    @Column(name = "USR_NM")
    private String userName;

    @Column(name = "GEND")
    private String userGender;


    @Column(name = "BIRTH")
    private String userBirth;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(length = 100)
    private String provider;

    /**
     *   Join(조인) 사용 이유 ?
     *     비밀번호 정보를 다른 뱡향으로 활용하기 위해
     *     회원정보와 비밀번호 정보를 다른 테이블로 관리
     */

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="USR_SQ")
    private PasswordChangeRecord passwordChangeRecord;


    /**
     * [ @ElementCollection ]
     *
     * entity 객체가 아니 값타입의 객체 컴포넌트를
     * 컬렉션으로 사용하려 할 때 사용
     *
     * [ @Builder.Default ]
     *
     * 상황에 따라 잠시 특정 값으로 초기화해놓고 특정 경우마다
     * 다른 값으로 초기화 하고 싶을 경우 사용.
     * 고정의 의미가 아니므로 final을 붙일 수 없는 경우 사용.
     */

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    //권한은 회원마다 여러 개가 세팅 될 수 있기때문에 Collection으로 선언
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    //계정이 만료가 되지 않았는지 여부
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠기지 않았는지 여부
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //계정 패스워드가 만료 되었는지 여부
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 사용 가능한지 여부
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }


}