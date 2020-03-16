package com.mukflix.backend.apiserver.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USR_MEAL_INFO")
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;

    private Long userId;

    private Date feedDatetime;

    private String placeCode;

    private Long restaurantId;

    private Long meneId;

}

/** 실제 테이블 생성 쿼리문
 * CREATE TABLE USR_MEAL_INFO(
 *     MEAL_INFO_SQ   VARCHAR(10)   NOT NULL
 *   , USR_SQ     VARCHAR(40)   NOT NULL
 *   , MEAL_DDTM   VARCHAR(14)   NOT NULL
 *   , PLACE_CD     VARCHAR(2)     DEFAULT '01'
 *   , RESTAURANT_SQ VARCHAR(10)
 *   , MENU_SQ     VARCHAR(10)
 *   , PRIMARY KEY(MEAL_INFO_SQ)
 */
