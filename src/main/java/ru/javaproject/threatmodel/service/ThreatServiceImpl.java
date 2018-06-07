package ru.javaproject.threatmodel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javaproject.threatmodel.model.Threat;
import ru.javaproject.threatmodel.repository.ThreatRepository;
import ru.javaproject.threatmodel.util.exception.NotFoundException;

import java.util.List;

import static ru.javaproject.threatmodel.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ThreatServiceImpl implements ThreatService{

    @Autowired
    private ThreatRepository repository;

    @Override
    public Threat get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Threat> getAll() {
        return repository.getAll();
    }
}
