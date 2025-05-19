package elion.rexhepi.enterprise_applications_opdracht.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Evenementen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate tijdstip;
    private String titel;
    private String omschrijving;
    private String organisatie;
    private String email;

    @ManyToOne
    @JoinColumn(name = "locatie_id")
    private Locatie locatie;



    public Evenementen(String titel, String omschrijving, String organisatie, String email) {
        this.titel = titel;
        this.omschrijving = omschrijving;
        this.organisatie = organisatie;
        this.email = email;
        this.tijdstip = LocalDate.now();
    }

    public Evenementen() {
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
}
