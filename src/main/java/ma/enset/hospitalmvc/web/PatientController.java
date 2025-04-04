package ma.enset.hospitalmvc.web;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.hospitalmvc.entities.Patient;
import ma.enset.hospitalmvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping("/index")
    public  String index(Model model,
                     @RequestParam( name = "page",defaultValue = "0") int page ,
                     @RequestParam(name = "size", defaultValue = "5") int size ,
                     @RequestParam(name = "keyword", defaultValue = "") String kw )

    {
        Page<Patient> pagePatient=patientRepository.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("ListPatient",pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        return "patients";
    }



    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page)
    {
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword  ;
    }

    @GetMapping("/")
    public String home(){return "redirect:/index";}


    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> lisPatients(){
        return  patientRepository.findAll();
    }

   @GetMapping("/formPatients")
    public String formPatients(Model model )
    {
        model.addAttribute("patient",new Patient());

       return "formPatients";
    }


    @PostMapping(path = "/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult)
        {
            if(bindingResult.hasErrors()) return "formpatients";
            patientRepository.save(patient);
            return "redirect:/formPatients";


    }

    @PostMapping(path = "/saveUpdate")
    public String saveUpdate(Model model, String  keyword,int page, @Valid Patient patient, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()) return "formPatients";
        patientRepository.save(patient);
        return "redirect:/index?page="+page+"&keyword="+keyword;


    }

    @GetMapping("/editPatient")
    public String formPatients(Model model,Long id, String keyword,int page )
    {
        Patient patient=patientRepository.findById(id).orElse(null);
        if (patient==null) throw  new RuntimeException("Patient not found");
        model.addAttribute("patient",patient);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);
        return "editPatient";

    }
}
