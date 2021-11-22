package com.amiriskhakov.alphabank_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrDTO {

    Double todayCourse;
    Double tomorrowCourse;


}
