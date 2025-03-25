package ma.enset.hospitalmvc.web;


import lombok.AllArgsConstructor;
import ma.enset.hospitalmvc.entities.Patient;
import ma.enset.hospitalmvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping("/index")
public  String index(Model model,
                     @RequestParam( name = "page",defaultValue = "0") int page ,
                     @RequestParam(name = "siize", defaultValue = "5") int size )
    {
        Page<Patient> pagePatient=patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("ListPatient",pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "patients";
    }
}
