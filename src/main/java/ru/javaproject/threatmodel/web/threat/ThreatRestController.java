package ru.javaproject.threatmodel.web.threat;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javaproject.threatmodel.model.QuestionPOJO;
import ru.javaproject.threatmodel.model.Threat;
import ru.javaproject.threatmodel.util.Qwerasdf;

import java.util.List;

@RestController
@RequestMapping(ThreatRestController.REST_URL)
public class ThreatRestController extends AbstractThreatController {
    static final String REST_URL = "/rest/threat";

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Threat> getAllThreat() {
        return super.getAll();
    }
}
