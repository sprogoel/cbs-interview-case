package sprogoel.cbs.model.dto;

import sprogoel.cbs.model.MovieShowing;

import java.util.Date;

public class MovieShowingResponse {

    private Long id;
    private Date date;
    private String title;
    private int remainingSeats;

    public MovieShowingResponse(MovieShowing showing) {
        this.id = showing.getId();
        this.date = showing.getDate();
        this.title = showing.getTitle();
        this.remainingSeats = showing.calcRemainingSeats();
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }
}
