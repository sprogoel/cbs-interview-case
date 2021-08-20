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

    /**
     * Finds all movie showings.
     *
     * @return HTTP response with status code 200 and a list of {@link MovieShowingResponse}
     */
    @GET
    @Path("/show-all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response movieShowings() {
        List<MovieShowingResponse> result = repo.getAll().stream()
                        .map(MovieShowingResponse::new)
                        .collect(Collectors.toList());

        return Response.status(Response.Status.OK).entity(result).build();
    }

    /**
     * Request a movie by its ID.
     * <p>
     * Returns HTTP code 200 on success.
     * Returns HTTP code 404 if nothing is found.
     * @param id id of {@link MovieShowing}
     * @return HTTP response with status 200 and {@link MovieShowingResponse} as body if the movie is found.
     * Status code 404 if no movie is found.
     */
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

    /**
     * Attempt to reserve seating for a movie.
     * @param request {@link ReservationRequest}
     * @return On success: HTTP response with status 201 and {@link ReservationResponse} as body.
     * <p>On failure: Status 404 if the movie does not exist. Status 400 if there is not enough seating.
     */
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

    /**
     * Attempts to delete a reservation.
     * @param id id of the {@link sprogoel.cbs.model.Reservation}
     * @return HTTP Response with status 200 on success.
     * <p>On failure: Status code 404 if the reservation does not exist.
     */
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

    /**
     * Ping the server
     * @return The time the ping.
     */
    @GET
    @Path("/ping")
    public String ping() {
        logger.info("PINGING");
        return "ping: " + new Date();
    }


}
