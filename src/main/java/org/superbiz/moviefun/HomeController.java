package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Controller
@Transactional
public class HomeController {

    private final MoviesBean moviesBean;

    public HomeController(MoviesBean moviesBean) {
        this.moviesBean = moviesBean;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        
        for (Movie movie : moviesBean.getMovies()) {
            moviesBean.addMovie(movie);
        }

        model.put("movies", moviesBean.getMovies());

        return "setup";
    }
}