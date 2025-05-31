package elion.rexhepi.enterprise_applications_opdracht.model.DAO;
import elion.rexhepi.enterprise_applications_opdracht.model.EntiteitenKlasse.Event;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface EventDAO extends CrudRepository<Event, Integer> {


    //je kan de 10 veranderen om meer data te tonen
    List<Event> findTop10ByOrderByTijdstipDesc();

}
