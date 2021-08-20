package sprogoel.cbs.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(schema = "cbs", name = "movie_showing")
public class MovieShowing {

    public static final int MAX_SEAT_COUNT = 50;

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String title;


    @OneToMany(mappedBy = "movieShowing", fetch = FetchType.EAGER)
    private Set<Reservation> reservationList;

    public MovieShowing(Date date, String title, Set<Reservation> reservationList) {
        this.date = date;
        this.title = title;
        this.reservationList = reservationList;
    }

    public MovieShowing() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Set<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(Set<Reservation> reservationList) {
        this.reservationList = reservationList;
    }


    public int calcRemainingSeats() {
        int totalReserved = reservationList.stream().mapToInt(Reservation::getSeatCount).sum();
        return MAX_SEAT_COUNT - totalReserved;
    }

    public boolean isSeatingAvailable() {
        return calcRemainingSeats() > 0;
    }
}
