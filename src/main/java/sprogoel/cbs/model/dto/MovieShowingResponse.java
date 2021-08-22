package sprogoel.cbs.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import sprogoel.cbs.model.MovieShowing;

import java.io.Serializable;
import java.util.Date;

public class MovieShowingResponse implements Serializable {

    private Long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
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
