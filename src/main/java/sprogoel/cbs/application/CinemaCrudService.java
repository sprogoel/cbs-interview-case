package sprogoel.cbs.application;

import sprogoel.cbs.model.MovieShowing;
import sprogoel.cbs.model.dto.MovieShowingResponse;
import sprogoel.cbs.model.dto.ReservationRequest;
import sprogoel.cbs.repository.MovieShowingsRepo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/cbs")
public class CinemaCrudService {


    @GET
    @Path("/show-all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MovieShowingResponse> movieShowings(){
        return MovieShowingsRepo.getAll().stream().map(MovieShowingResponse::new).collect(Collectors.toList());
    }


    @POST
    @Path("/reserve")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response reserve(ReservationRequest request){

        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/cancel")
    @Produces({MediaType.APPLICATION_JSON})
    public Response cancel(){

        return Response.status(Response.Status.CREATED).build();
    }


}
