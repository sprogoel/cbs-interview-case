package sprogoel.cbs.model;

import java.util.Date;
import java.util.List;

public class MovieShowing {

    public static final int MAX_SEAT_COUNT = 50;

    private Long id;
    private Date date;
    private String title;
    private List<Reservation> reservationList;

    public MovieShowing(Long id, Date date, String title, List<Reservation> reservationList) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.reservationList = reservationList;
    }

    public MovieShowing() {
    }

    public Long getId() {
        return id;
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

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
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
