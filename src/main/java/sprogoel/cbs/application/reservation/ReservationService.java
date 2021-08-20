package sprogoel.cbs.application.reservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sprogoel.cbs.model.MovieShowing;
import sprogoel.cbs.model.Reservation;
import sprogoel.cbs.model.dto.ReservationRequest;
import sprogoel.cbs.repository.MovieShowingsRepo;
import sprogoel.cbs.repository.ReservationRepo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Date;

@RequestScoped
public class ReservationService {
    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    @Inject
    MovieShowingsRepo movieShowingsRepo;

    @Inject
    ReservationRepo reservationRepo;

    public Reservation createReservation(ReservationRequest request) throws ReservationException {
        MovieShowing movie = movieShowingsRepo.getById(request.getShowingId());
        if (movie == null) {
            throw ReservationException.createMovieNotFoundException();
        }

        if (movie.calcRemainingSeats() < request.getSeatCount()) {
            throw ReservationException.createNotEnoughSeatsException();
        }

        Reservation reservation = reservationRepo.save(new Reservation(movie, new Date(), request.getSeatCount()));

        logger.info("Created new reservation. {}", reservation);

        return reservation;
    }

    public void deleteReservation(Long id) throws ReservationException {
        reservationRepo.delete(id);
    }


}
