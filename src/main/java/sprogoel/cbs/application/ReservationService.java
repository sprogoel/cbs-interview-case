package sprogoel.cbs.application;

import sprogoel.cbs.model.MovieShowing;
import sprogoel.cbs.model.Reservation;
import sprogoel.cbs.repository.MovieShowingsRepo;

public class ReservationService {

    public static boolean validateReservation(Long movieId, int seatCount) {
        MovieShowing movie = MovieShowingsRepo.getById(movieId);
        if (movie == null) {
            return false;
        }

        return movie.calcRemainingSeats() >= seatCount;
    }

}
