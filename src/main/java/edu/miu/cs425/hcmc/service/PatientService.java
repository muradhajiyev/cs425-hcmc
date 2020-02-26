package edu.miu.cs425.hcmc.service;

import edu.miu.cs425.hcmc.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAllByOrderByFullNameAsc();
    List<Patient> findAllElderPatients();
    void save(Patient thePatient);
}
