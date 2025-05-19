package elion.rexhepi.enterprise_applications_opdracht.model.DAO;
import elion.rexhepi.enterprise_applications_opdracht.model.Event;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface EventDAO extends CrudRepository<Event, Integer> {

    //om de events op de index pagina te kunnen weergeven
    List<Event> findTop10ByOrderByTijdstipDesc();
}
