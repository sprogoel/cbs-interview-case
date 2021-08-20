package sprogoel.cbs.model.dto;

import java.io.Serializable;

public class ReservationRequest implements Serializable {
    private Long showingId;
    private int seatCount;

    public ReservationRequest() {
    }

    public ReservationRequest(Long showingId, int seatCount) {
        this.showingId = showingId;
        this.seatCount = seatCount;
    }


    public Long getShowingId() {
        return showingId;
    }

    public void setShowingId(Long showingId) {
        this.showingId = showingId;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "showingId=" + showingId +
                ", seatCount=" + seatCount +
                '}';
    }
}
