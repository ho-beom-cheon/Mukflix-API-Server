package com.mukflix.backend.apiserver.dto;

//결과가 여러 건인 api를 담는 모델

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResult<T> extends CommonResult {
    private List<T> list;
}
