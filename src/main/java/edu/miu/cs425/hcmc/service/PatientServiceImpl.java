package edu.miu.cs425.hcmc.service;

import edu.miu.cs425.hcmc.dao.PatientRepository;
import edu.miu.cs425.hcmc.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAllByOrderFullNameAsc() {
        return this.patientRepository.findAllByOrderFullNameAsc();
    }

    @Override
    public void save(Patient thePatient) {
        this.patientRepository.save(thePatient);
    }
}
