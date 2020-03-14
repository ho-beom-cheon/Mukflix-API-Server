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
public class PassWord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_SQ")
    private Long sq;

//    @Column(name = "PW_SQ")
//    private Long pw_sq;


    @Column(name = "PW")
    private String pw;
//
//    @Column(name = "MOD_DDTM")
//    private String mod_ddtm;


}
