package com.example.restapimongodb.controllers;

import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.models.Movie;
//import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MovieController {

    @Autowired
    private MovieService mService;

    @GetMapping("/movies")
    public ResponseEntity getMovies()
    {
        return new ResponseEntity( mService.getMovies(), HttpStatus.OK);

    }


    @GetMapping("/movies/{id}")
    public ResponseEntity getAMovie(@PathVariable("id") String id) {

        Optional<Movie> movie=null;


        try {
            movie=mService.getAMovie(id);

        } catch (Exception e) {



            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

        }


        return new ResponseEntity(movie, HttpStatus.OK);

    }

    @GetMapping("/movies/title")
    public ResponseEntity getTitleMovies(@RequestParam(value = "title") String title){
        var customizedResponse = new CustomizedResponse("A list of movies where title contains " + title, mService.getMoviesByTitle(title));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @PostMapping(value= "/movies", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity  addMovie(@RequestBody Movie movie)
    {
        mService.addMovie(movie);
        return new ResponseEntity(movie,HttpStatus.OK);

    }

    @GetMapping("/movies/feature")
    public ResponseEntity getfeaturedMovies()
    {

        return new ResponseEntity(mService.getfeaturedMovies("true"), HttpStatus.OK);
    }

/*
    @PutMapping(value="/movies", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateMovie(@RequestBody Movie movie)
    {
        mService.updateMovie(movie);
        return new ResponseEntity(movie,HttpStatus.OK);

        var customizedResponse = new CustomizedResponse(" Movie with ID:  " + id + "was updated successfully " , Collections.singletonList(service.editMovie(id, newMovie)));

        return new ResponseEntity(customizedResponse, HttpStatus.OK);

    }*/

    @PutMapping(value = "/movies/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity editMovie(@PathVariable("id") String id, @RequestBody Movie newMovie )

    {


        var customizedResponse = new CustomizedResponse(" Movie with ID:  " + id + "was updated successfully " , Collections.singletonList(mService.editMovie(id, newMovie)));

        if((mService.editMovie(id, newMovie)==null))
        {
            return new ResponseEntity("Provide Id is not Found", HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity(customizedResponse, HttpStatus.OK);
        }




    }



    @DeleteMapping("/movies/{id}")
    public ResponseEntity deleteAMovie(@PathVariable("id") String id)
    {

        mService.deleteAMovie(id);
        return new ResponseEntity(HttpStatus.OK);


    }
}
