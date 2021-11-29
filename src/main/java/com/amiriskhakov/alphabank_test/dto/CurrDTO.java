package com.amiriskhakov.alphabank_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrDTO {

    Double todayCourse;
    Double yesterdayCourse;

}
