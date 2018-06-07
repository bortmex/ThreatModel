package ru.javaproject.threatmodel.web.threat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javaproject.threatmodel.model.Threat;
import ru.javaproject.threatmodel.service.ThreatService;

import java.util.List;

public abstract class AbstractThreatController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private ThreatService service;

    public Threat get(int id) {
        LOG.info("get meal {} for User {}", id);
        return service.get(id);
    }

    public List<Threat> getAll() {
        LOG.info("getAll ");
        return service.getAll();
    }
}
