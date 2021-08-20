package sprogoel.cbs.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "cbs", name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_showing_id")
    private MovieShowing movieShowing;

    @Column(name = "reservation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationTime;

    @Column(name = "seat_count")
    private Integer seatCount;

    public Reservation(MovieShowing movieShowing, Date reservationTime, Integer seatCount) {
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
