package edu.miu.cs425.hcmc.controller;

import edu.miu.cs425.hcmc.entity.Patient;
import edu.miu.cs425.hcmc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("/list")
    public String listPatients(Model theModel){
        List<Patient> patients = this.patientService.findAllByOrderByFullNameAsc();

        theModel.addAttribute("patients", patients);
        theModel.addAttribute("title", "List of All Registered Patients");

        return "/patient/list-patients";
    }

    @GetMapping("/elder/list")
    public String listElderPatients(Model theModel){
        List<Patient> patients = this.patientService.findAllElderPatients();

        theModel.addAttribute("patients", patients);
        theModel.addAttribute("title", "List of Elder Patients");

        return "/patient/list-patients";
    }

    @GetMapping("/register")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Patient theEmployee = new Patient();

        theModel.addAttribute("patient", theEmployee);

        return "/patient/create-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("patient") Patient patient) {
        // hardcode date of birth to not spend a lot of time with datetimepicker.
        patient.setDateOfBirth(new GregorianCalendar(1945, Calendar.FEBRUARY, 11).getTime());
        this.patientService.save(patient);

        return "redirect:/patient/list";
    }
}
