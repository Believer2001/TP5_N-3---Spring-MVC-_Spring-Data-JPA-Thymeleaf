package ma.enset.hospitalmvc.web;


import lombok.AllArgsConstructor;
import ma.enset.hospitalmvc.entities.Patient;
import ma.enset.hospitalmvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping("/index")

public  String index(Model model){
        List<Patient> patientList=patientRepository.findAll();
        model.addAttribute("ListPatient",patientList);
        return "patients";
    }
}
