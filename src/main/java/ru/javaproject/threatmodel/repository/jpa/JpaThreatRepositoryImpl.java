package ru.javaproject.threatmodel.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javaproject.threatmodel.model.Threat;
import ru.javaproject.threatmodel.repository.ThreatRepository;
import ru.javaproject.threatmodel.util.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaThreatRepositoryImpl implements ThreatRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Threat save(Threat user) {
        throw new NotFoundException("not implementation");
    }

    @Override
    public boolean delete(int id) {
        throw new NotFoundException("not implementation");
    }

    @Override
    public Threat get(int id) {
        return em.find(Threat.class, id);
    }

    @Override
    public List<Threat> getAll() {
        return em.createNamedQuery(Threat.ALL_SORTED, Threat.class).getResultList();
    }
}
