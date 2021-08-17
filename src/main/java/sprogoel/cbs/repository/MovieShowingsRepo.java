package sprogoel.cbs.repository;


import sprogoel.cbs.model.MovieShowing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieShowingsRepo {

    private static Map<Long, MovieShowing> showings;

    private MovieShowingsRepo() {
    }

    private static void init() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        showings = new HashMap<>();
        try {
            showings.put(1L, new MovieShowing(1L, dateFormat.parse("2021-08-17 10:00:00"), "Gladiator", new ArrayList<>()));
            showings.put(2L, new MovieShowing(2L, dateFormat.parse("2021-08-17 15:00:00"), "Inception", new ArrayList<>()));
            showings.put(3L, new MovieShowing(3L, dateFormat.parse("2021-08-18 10:00:00"), "Alien", new ArrayList<>()));
            showings.put(4L, new MovieShowing(4L, dateFormat.parse("2021-08-18 15:00:00"), "The Godfather", new ArrayList<>()));
            showings.put(5L, new MovieShowing(5L, dateFormat.parse("2021-08-18 21:00:00"), "Terminator", new ArrayList<>()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static MovieShowing getById(Long id) {
        if (showings == null) {
            init();
        }
        return showings.get(id);
    }

    public static List<MovieShowing> getAll() {
        if (showings == null) {
            init();
        }
        return new ArrayList<>(showings.values());
    }


}
