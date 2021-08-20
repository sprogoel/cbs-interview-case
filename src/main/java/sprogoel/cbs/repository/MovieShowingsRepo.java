package sprogoel.cbs.repository;


import sprogoel.cbs.model.MovieShowing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MovieShowingsRepo {

    @Inject
    EntityManager em;


    @Transactional
    public MovieShowing getById(Long id) {
        return em.find(MovieShowing.class, id);
    }

    @Transactional
    public List<MovieShowing> getAll() {
        return em.createQuery("FROM MovieShowing", MovieShowing.class).getResultList();
    }


}
