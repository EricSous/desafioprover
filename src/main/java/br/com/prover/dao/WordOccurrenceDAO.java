package br.com.prover.dao;

import br.com.prover.model.WordOccurrence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class WordOccurrenceDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(WordOccurrence occurrence) {
        em.persist(occurrence);
    }

    public List<WordOccurrence> findAll() {
        return em.createQuery("FROM WordOccurrence", WordOccurrence.class).getResultList();
    }
}
