package com.mukflix.backend.apiserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/**
 * [ @EqualsAndHashCode(callSuper=false) ]
 *
 * callSuper 속성을 통해 eqauls와 hashCode 메소드 자동 생성 시 부모 클래스의
 * 필드까지 감안할지의 여부를 설정할 수 있다.
 * '@EqualsAndHashCode(callSuper = true)'로 설정시 부모 클래스 필드 값들도 동일한지 체크하며,
 * false(기본값)일 경우 자신 클래스의 필드 값만 고려한다
 */


@Data // Lombok
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@Entity  // TODO 설명 쓰기
@EqualsAndHashCode(callSuper=false)
@Table(name = "GUIDE")
public class Guide {

    /**
     * [ @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) ]
     *
     * 해당 필드는 오직 쓰려는 경우에만 접근이 허용
     * 사용자를 생성하기 위한 요청 본문을 처리할때는 사용
     * 응답결과를 생성할 때는 해당 필드는 제외되서 응답 본문에 표시되지 않음
     * -> 대략 json에서 안보인다는 뜻!
     *
     * [ @Id ]
     * 엔티티의 기본키를 직접할당
     *
     * [ @GeneratedValue ]
     * 선택 전략에 따라 기본 키를 자동 할당
     */

    @Id // PrimaryKey
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


}
