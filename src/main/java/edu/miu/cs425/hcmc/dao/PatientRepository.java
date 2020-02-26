package edu.miu.cs425.hcmc.dao;

import edu.miu.cs425.hcmc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAllByOrderByFullNameAsc();
    @Query(value = "SELECT p.* FROM patient p WHERE FLOOR(DATEDIFF(NOW(), p.date_of_birth)/365.25) >= 65 ORDER BY p.date_of_birth DESC", nativeQuery = true)
    List<Patient> findAllElderPatients();
}
