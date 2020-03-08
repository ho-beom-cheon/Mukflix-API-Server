package com.mukflix.backend.apiserver.dto;

import lombok.Data;

import javax.persistence.*;

@Data // Lombok
@Entity  // TODO 설명 쓰기
@Table(name = "GUIDE")
public class Guide {
    @Id // PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
