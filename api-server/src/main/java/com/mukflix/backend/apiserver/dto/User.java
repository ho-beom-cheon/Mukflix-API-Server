package com.mukflix.backend.apiserver.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USR_INFO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_SQ")
    private Long userSequence ;



    @Column(name = "USR_EMAIL")
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

    /**
     *   Join(조인)
     *     비밀번호 정보를 다른 뱡향으로 활용하기 위해
     *     회원정보와 비밀번호 정보를 다른 테이블로 관리
     */

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="USR_SQ")
    private PasswordChangeRecord passWordRecord;



}