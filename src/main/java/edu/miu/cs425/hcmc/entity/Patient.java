package edu.miu.cs425.hcmc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "patient_number")
    private String patientNumber;
    @Column(name = "is_an_out_patient")
    private Boolean isAnOutPatient;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

}
