package edu.miu.cs425.hcmc.dao;

import edu.miu.cs425.hcmc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAllByOrderFullNameAsc();
}
