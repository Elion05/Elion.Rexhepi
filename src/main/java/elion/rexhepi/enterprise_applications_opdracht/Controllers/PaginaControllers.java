package elion.rexhepi.enterprise_applications_opdracht.Controllers;

import elion.rexhepi.enterprise_applications_opdracht.model.DAO.EventDAO;
import elion.rexhepi.enterprise_applications_opdracht.model.DAO.LocatieDAO;
import elion.rexhepi.enterprise_applications_opdracht.model.Event;
import elion.rexhepi.enterprise_applications_opdracht.model.Locatie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



//controller voor alle paginas
@Controller
public class PaginaControllers {

    @Autowired
    private EventDAO eventDAOs;
    @Autowired
    private LocatieDAO locatieDAO;



    //hier voeg ik 3 info dingen voor de bij de index pagina
    @GetMapping({"/index", "", "/"})
    public String index(Model index) {
        List<Event> laatsteEvents = eventDAOs.findTop10ByOrderByTijdstipDesc();
        index.addAttribute("events", laatsteEvents);
        return "index";
    }

    //gwne getmapping voor pagina
    @GetMapping("/about")
    public String aboutTonen() {
        return "about";
    }




    //hier hetzelfde als bij de index pagina maar gewoon meer informatie + query parameter zie EventDAO
    @GetMapping("/detail")
    public String detailTonen(@RequestParam("id")int id, Model detailsmodel) {
        Event event = eventDAOs.findById(id).orElse(null);
        detailsmodel.addAttribute("event", event);
        return "detail";
    }


    @GetMapping("/new")
    public String newHTMLtonen(Model newmodel) {
        newmodel.addAttribute("event", new Event());
        newmodel.addAttribute("locaties", locatieDAO.findAll());
        return "new";
    }
    @PostMapping("/new")
    public String eventToevoegen(@ModelAttribute("event") @Valid Event event,
                                 BindingResult result,
                                 @RequestParam("locatie.id") int locatieId,
                                 Model model) {

        if (result.hasErrors()) {
            model.addAttribute("locaties", locatieDAO.findAll());
            return "new";
        }

        Locatie locatie = locatieDAO.findById(locatieId).orElse(null);
        if (locatie == null) {
            result.rejectValue("locatie", null, "Ongeldige locatie");
            model.addAttribute("locaties", locatieDAO.findAll());
            return "new";
        }

        event.setLocatie(locatie);
        eventDAOs.save(event);
        return "redirect:/index";
    }
    
}

