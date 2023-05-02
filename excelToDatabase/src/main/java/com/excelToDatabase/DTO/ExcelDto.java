package com.excelToDatabase.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExcelDto {
    private int studentid;
    private String firstname;
    private String lastname;
    private String address;
    private Long phone;
    private String email;
}
