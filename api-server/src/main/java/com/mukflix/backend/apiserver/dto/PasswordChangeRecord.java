package com.mukflix.backend.apiserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PW_CHG_HIST")
public class PasswordChangeRecord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_SQ")
    private Long userSequence ;

    @Column(name = "PW")
    private String password;

    //비밀번호 수정 날짜는 마지막 변경 시간을 자동으로 등록할 예정임
    //Date 개발 전까진 비활성화
//    @Column(name = "MOD_DDTM")
//    private String mod_ddtm;


}
