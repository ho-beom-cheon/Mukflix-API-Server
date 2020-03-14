package com.mukflix.backend.apiserver.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Long USR_SQ;



    @Column(name = "USR_EMAIL")
    private String email;

    @Column(name = "USR_NM")
    private String name;

    @Column(name = "GEND")
    private String gend;

    @Column(name = "BIRTH")
    private String birth;

    @Column(name = "JOIN_DD")
    private String join_dd;

    @Column(name = "LST_CHG_DD")
    private String chg_dd;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="USR_SQ")
    private PassWord passWord;



}



// DTO : 데이터를 주고받을 포맷


// [ @Getter ] : Getter 메소드를 생성해준다
// [ @Setter ] : Setter 메소드를 생성해준다
// [ @ToString ] : toString 메소드를 클래스 필드 확인 후 만들어 준다. exclude속성 사용 시 제외가능 (exclude = "password)
// [ @NoArgsConstructor ] : 파라미터가 없는 기본 생성자를 생성
// [ @AllArgsConstructor ] : 모든 필드 값을 파라미터로 받는 생성자를 생성
// [ @RequiredArgsConstructor ] : final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 생성
/*
   [ @EqualsAndHashCode ]
* equlas와 hashcode 메소드를 만들어 준다
* callSuper 속성을 통해 자동 생성 시 부모 클래스의 필드까지 감안할지 안 할지 설정 가능
* true이면 부모 클래스 필드 값들도 동일한지 체크, false이면(default) 자신 클래스의 필드 값들만 고려
* */
//@Getter
//@Setter
//@EqualsAndHashCode(of = "uid")
//@ToString
//@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
/*
   [ @Data ]
* @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode를 한번에 설정해줌
* */
//@Entity
//@Data
///*
//    Serializable을 설정하는 이유?
//    데이터 전송 시 조각단위로 보내는 것이 아닌 하나의 객체로 보낼 수 있게 해주므로 더 효율적이다.
//*/
//public class User implements Serializable {
//
//    @Id //기본키(PK) 지정
//    @GeneratedValue //키를 직접할당하는것이 아닌 자동생성
//    private String usr_sq;
//
//    @Column(nullable = false, unique = true, length = 40)
//    String usr_nm;
//
//    @Column(nullable = false, unique = true, length = 40)
//    String gend;
//    @Column(nullable = false, unique = true, length = 40)
//    String usr_email;
//    @Column(nullable = false, unique = true, length = 40)
//    String birth;
//}
