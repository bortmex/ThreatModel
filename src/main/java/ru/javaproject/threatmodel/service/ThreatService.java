package ru.javaproject.threatmodel.service;

import ru.javaproject.threatmodel.model.Threat;
import ru.javaproject.threatmodel.util.exception.NotFoundException;

import java.util.List;

public interface ThreatService {

    //Threat save(Threat user);

    //void delete(int id) throws NotFoundException;

    Threat get(int id) throws NotFoundException;

    List<Threat> getAll();

    //void update(Threat user);
}
