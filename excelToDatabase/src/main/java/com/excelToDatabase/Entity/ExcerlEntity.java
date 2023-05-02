package com.excelToDatabase.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name = "students")
public class ExcerlEntity {
    @Id
    private int studentid;
    private String firstname;
    private String lastname;
    private String address;
    private Long phone;
    private String email;
}
