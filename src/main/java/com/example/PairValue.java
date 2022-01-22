package com.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PairValue {

    private Integer value;
    private Integer nextGreaterValue;

}
