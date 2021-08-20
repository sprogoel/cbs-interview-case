package sprogoel.cbs.application.reservation;

public class ReservationException extends RuntimeException {

    public static final String MOVIE_NOT_FOUND = "Unable to make reservation. No movie was found with that ID.";
    public static final String NOT_ENOUGH_SEATS = "Unable to make reservation. There are not enough available seats.";
    public static final String NO_RESERVATION_FOUND = "There is no reservation with that ID.";

    private final int errorCode;

    public ReservationException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public static ReservationException createMovieNotFoundException() {
        return new ReservationException(MOVIE_NOT_FOUND, 404);
    }

    public static ReservationException createNotEnoughSeatsException() {
        return new ReservationException(NOT_ENOUGH_SEATS, 400);
    }

    public static ReservationException createNoReservationFoundException() {
        return new ReservationException(NO_RESERVATION_FOUND, 404);
    }

}
