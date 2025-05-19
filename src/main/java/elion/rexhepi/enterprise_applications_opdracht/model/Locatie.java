package elion.rexhepi.enterprise_applications_opdracht.model;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Locatie {
    @Id
    private int id;

    @NotBlank
    @Size(min=1, max=50)
    private String naam;

    @NotBlank
    @Size(min=1, max=50)
    private String adres;

    @NotBlank
    @Size(min=1, max=50000)
    private double capaciteit;

    @OneToMany(mappedBy = "locatie")
    private List<Event> events;


    public Locatie(int id,String naam, String adres, double capaciteit) {
        this.naam = naam;
        this.id = id;
        this.adres = adres;
        this.capaciteit = capaciteit;
    }

    public Locatie() {
    }

    public double getCapaciteit() {
        return capaciteit;
    }
    public void setCapaciteit(double capaciteit) {
        this.capaciteit = capaciteit;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }
    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
