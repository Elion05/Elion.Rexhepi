package elion.rexhepi.enterprise_applications_opdracht.Controllers;
import elion.rexhepi.enterprise_applications_opdracht.model.DAO.EventDAO;
import elion.rexhepi.enterprise_applications_opdracht.model.DAO.LocatieDAO;
import elion.rexhepi.enterprise_applications_opdracht.model.EntiteitenKlasse.Event;
import elion.rexhepi.enterprise_applications_opdracht.model.EntiteitenKlasse.Locatie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

//eventcontroller voor de database te vullen met informatie, data beheren
@RequestMapping("/event")
@RestController
public class EventController {

    private EventDAO eventDAO;

    private LocatieDAO locatieDAO;

    @Autowired
    public EventController(EventDAO eventDAO, LocatieDAO locatieDAO) {
        this.eventDAO = eventDAO;
        this.locatieDAO = locatieDAO;
    }

    //table maken in databases
    @PostMapping("/locatie")
    public void addLocatie(@RequestParam int id, @RequestParam String naam,
                           @RequestParam String adres, @RequestParam double capaciteit) {
        Locatie locatie = new Locatie(id, naam, adres, capaciteit);
        locatieDAO.save(locatie);
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestParam LocalDate tijdstip, @RequestParam String titel, @RequestParam
                                                String omschrijving, @RequestParam String organisatie, @RequestParam String email, @RequestParam int locatie_id){
        if (locatieDAO.existsById(locatie_id)){
            Locatie foundLocatie = locatieDAO.findById(locatie_id).get();

            Event event = new Event(tijdstip, titel, omschrijving, organisatie, email, foundLocatie);
            eventDAO.save(event);
            return new ResponseEntity<>(event, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public Iterable<Event> getAlleEvenementen() {
        return eventDAO.findAll();
    }
}
