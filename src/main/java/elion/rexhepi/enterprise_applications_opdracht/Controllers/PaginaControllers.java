package elion.rexhepi.enterprise_applications_opdracht.Controllers.htmlController;


import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaControllers {

    @GetMapping("/index")
    public String indexTonen(Model model) {
        return "index";
    }

    @GetMapping("/about")
    public String aboutTonen() {
        return "about";
    }

    @GetMapping("/detail")
    public String detailTonen() {
        return "detail";
    }

    @GetMapping("/EvenementenToevoegen")
    public String evenementToevoegPagina() {
        return "EvenementenToevoegen";
    }


}
