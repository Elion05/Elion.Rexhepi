package elion.rexhepi.enterprise_applications_opdracht.model.EntiteitenKlasse;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Niet nulllllllllll alstublieft danku")
    @Future(message = "Kies een geldige datum, in de toekomst liefst")
    private LocalDate tijdstip;

    @NotBlank(message = "Vul een titel in (dat is toch logisch dacht ik)")
    @Size(min = 1, max = 50)
    private String titel;

    @NotBlank(message = "NOT BLANK AAAH")
    @Size(min = 1, max = 200)
    private String omschrijving;

    @NotBlank(message = "Not blank")
    @Size(min = 1, max = 50)
    private String organisatie;

    @NotBlank(message = "Email adres mag niet leeg zijn")
    @Email(message = "geef een geldige email adres... of anders...")
    private String email;


    //keys maken met de 2 klasses locatie_id
    @ManyToOne //meerdere eventen kunnen 1 locatie hebben
    @JoinColumn(name = "locatie_id")
    private Locatie locatie;



    public Event(int id, LocalDate tijdstip, String titel, String omschrijving, String organisatie, String email, Locatie foundLocatie) {
        this.titel = titel;
        this.id = id;
        this.omschrijving = omschrijving;
        this.organisatie = organisatie;
        this.email = email;
        this.tijdstip = tijdstip;
        this.locatie = foundLocatie;
    }

    public Event(LocalDate tijdstip, String titel, String omschrijving, String organisatie, String email, Locatie foundLocatie) {
        this.titel = titel;
        this.omschrijving = omschrijving;
        this.organisatie = organisatie;
        this.email = email;
        this.tijdstip = tijdstip;
        this.locatie = foundLocatie;
    }
    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(LocalDate tijdstip) {
        this.tijdstip = tijdstip;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getOrganisatie() {
        return organisatie;
    }

    public void setOrganisatie(String organisatie) {
        this.organisatie = organisatie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

}
