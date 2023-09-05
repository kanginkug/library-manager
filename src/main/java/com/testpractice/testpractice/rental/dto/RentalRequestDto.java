package com.testpractice.testpractice.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@AllArgsConstructor
public class RentalRequestDto {

    private String author;
    private Date rentalDate;
    private Date receiveDate;
}
