package sprogoel.cbs.model.dto;

public class ReservationRequest {
    private Long showingId;
    private int seatCount;

    public ReservationRequest(Long showingId, int seatCount) {
        this.showingId = showingId;
        this.seatCount = seatCount;
    }

    public Long getShowingId() {
        return showingId;
    }

    public int getSeatCount() {
        return seatCount;
    }
}
