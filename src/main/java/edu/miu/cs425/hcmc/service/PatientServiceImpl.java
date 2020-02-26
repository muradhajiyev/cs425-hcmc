package edu.miu.cs425.hcmc.service;

import edu.miu.cs425.hcmc.dao.PatientRepository;
import edu.miu.cs425.hcmc.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAllByOrderByFullNameAsc() {
        return this.patientRepository.findAllByOrderByFullNameAsc();
    }

    @Override
    public List<Patient> findAllElderPatients() {
        return this.patientRepository.findAllElderPatients();
    }

    @Override
    public void save(Patient patient) {
        this.patientRepository.save(patient);
    }
}
