package sprogoel.cbs.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import sprogoel.cbs.model.Reservation;

import java.io.Serializable;
import java.util.Date;

public class ReservationResponse implements Serializable {

    private Long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date reservationTime;
    private Long movieId;
    private int seatsReserved;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.reservationTime = reservation.getReservationTime();
        this.movieId = reservation.getMovieShowing().getId();
        this.seatsReserved = reservation.getSeatCount();
    }

    public ReservationResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public int getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(int seatsReserved) {
        this.seatsReserved = seatsReserved;
    }
}
