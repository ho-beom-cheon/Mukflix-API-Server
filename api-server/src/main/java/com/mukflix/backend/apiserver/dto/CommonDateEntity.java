package com.mukflix.backend.apiserver.dto;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 *  날짜 자동 셋팅을 위한 추상 클래스
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class CommonDateEntity {
    @CreatedDate // Entity 생성시 자동으로 날짜세팅
    private LocalDateTime createdAt;
    @LastModifiedDate // Entity 수정시 자동으로 날짜세팅
    private LocalDateTime modifiedAt;
}

