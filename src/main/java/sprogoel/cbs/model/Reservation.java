package sprogoel.cbs.model;

import java.util.Date;

public class Reservation {

    private Long id;
    private MovieShowing movieShowing;
    private Date reservationTime;
    private Integer seatCount;

    public Reservation(Long id, MovieShowing movieShowing, Date reservationTime, Integer seatCount) {
        this.id = id;
        this.movieShowing = movieShowing;
        this.reservationTime = reservationTime;
        this.seatCount = seatCount;
    }

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public MovieShowing getMovieShowing() {
        return movieShowing;
    }

    public void setMovieShowing(MovieShowing movieShowing) {
        this.movieShowing = movieShowing;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }
}
