package ru.javaproject.threatmodel.repository;

import ru.javaproject.threatmodel.model.Threat;

import java.util.List;

public interface ThreatRepository {
    Threat save(Threat user);

    boolean delete(int id);

    Threat get(int id);

    List<Threat> getAll();
}
