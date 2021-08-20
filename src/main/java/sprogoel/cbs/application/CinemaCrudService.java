package sprogoel.cbs.application;

import org.slf4j.Logger;
import sprogoel.cbs.application.reservation.ReservationException;
import sprogoel.cbs.application.reservation.ReservationService;
import sprogoel.cbs.model.MovieShowing;
import sprogoel.cbs.model.dto.MovieShowingResponse;
import sprogoel.cbs.model.dto.ReservationRequest;
import sprogoel.cbs.model.dto.ReservationResponse;
import sprogoel.cbs.repository.MovieShowingsRepo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@RequestScoped
@Path("/cbs")
public class CinemaCrudService {
    private static final Logger logger = getLogger(CinemaCrudService.class);

    @Inject
    ReservationService reservationService;

    @Inject
    MovieShowingsRepo repo;

    @GET
    @Path("/show-all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MovieShowingResponse> movieShowings() {
        return repo.getAll().stream().map(MovieShowingResponse::new).collect(Collectors.toList());
    }

    @GET
    @Path("/show/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response movieShowing(@PathParam("id") Long id) {

        MovieShowing showing = repo.getById(id);
        if (showing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(new MovieShowingResponse(showing)).build();
    }

    @POST
    @Path("/reserve")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response reserve(ReservationRequest request) {
        logger.info("Received Reservation Request: {}", request);
        try {
            ReservationResponse response = new ReservationResponse(reservationService.createReservation(request));
            return Response.status(Response.Status.CREATED).entity(response).build();
        } catch (ReservationException re) {
            return Response.status(re.getErrorCode()).entity(re.getMessage()).build();
        }
    }

    @DELETE
    @Path("/cancel/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response cancel(@PathParam("id") Long id) {
        try {
            reservationService.deleteReservation(id);
            return Response.status(Response.Status.OK).build();
        } catch (ReservationException re) {
            return Response.status(re.getErrorCode()).entity(re.getMessage()).build();
        }
    }

    @GET
    @Path("/ping")
    public String ping() {
        logger.info("PINGING");
        return "ping: " + new Date();
    }


}
