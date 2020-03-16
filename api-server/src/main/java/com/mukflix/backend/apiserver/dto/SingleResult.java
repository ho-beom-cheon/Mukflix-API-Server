package com.mukflix.backend.apiserver.dto;


import lombok.Getter;
import lombok.Setter;


//결과가 단일 건인 api를 담는 모델

@Getter
@Setter
public class SingleResult<T> extends CommonResult {
    private T data;
}
