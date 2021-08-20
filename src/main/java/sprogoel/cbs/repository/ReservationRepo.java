package sprogoel.cbs.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sprogoel.cbs.application.reservation.ReservationException;
import sprogoel.cbs.model.Reservation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class ReservationRepo {

    private static final Logger logger = LoggerFactory.getLogger(ReservationRepo.class);

    @Inject
    EntityManager em;


    @Transactional
    public Reservation save(Reservation reservation) {
        logger.debug("Saving reservation to DB: {}", reservation);
        em.persist(reservation);
        return reservation;
    }


    @Transactional
    public void delete(Long id) throws ReservationException {
        Reservation reservation = em.find(Reservation.class, id);
        if (reservation != null) {
            delete(reservation);
        } else {
            logger.warn("Tried to delete reservation with ID: [{}], but could not find any with that ID.", id);
            throw ReservationException.createNoReservationFoundException();
        }
    }

    @Transactional
    public void delete(Reservation reservation) {
        em.remove(reservation);
    }


}
