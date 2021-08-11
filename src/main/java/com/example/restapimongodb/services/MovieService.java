package com.example.restapimongodb.services;

import com.example.restapimongodb.models.MovieRepository;
import com.example.restapimongodb.models.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MovieRepository mRepo;

    public List<Movie> getMovies()
    {
        return mRepo.findAll();

    }

    public Optional<Movie> getAMovie(String id) throws Exception
    {

        Optional<Movie> movie = mRepo.findById(id);

        // This is saying that if movie ref variable does not contain a value then

        if (!movie.isPresent())
        {
            throw new Exception (" Movie with " + id + " is not found ");
        }


        return movie;

    }

    public List<Movie> getMoviesByTitle(String title)
    {

        Query query = new Query();
        query.addCriteria(Criteria.where("title" ).regex(title));

        List<Movie> movies = mongoTemplate.find(query, Movie.class);

        return movies;




    }


    public void addMovie(Movie movie)
    {

        mRepo.insert(movie);
    }

    public void deleteAMovie( String id)
    {
        mRepo.deleteById(id);
    }

    public List<Movie> getfeaturedMovies(String r)

    {

        // business logics
        Query query = new Query();
        query.addCriteria(Criteria.where("feature" ).is(r));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        return movies;


    }
/*
    public Movie updateMovie(Movie movie)
    {

        mRepo.findById(movie.getId());
        return mRepo.save(movie);

    }
    */


    public Movie editMovie(String id, Movie newMovieData)
    {
        // get the resource based on the id

        Optional<Movie> movie = mRepo.findById(id);

        // validation code to validate the id
   //
        if(movie.isPresent()) {
            movie.get().setTitle(newMovieData.getTitle());
            movie.get().setDescription(newMovieData.getDescription());
            movie.get().setRating(newMovieData.getRating());
            movie.get().setRentprice(newMovieData.getRentprice());
            movie.get().setPurchaseprice(newMovieData.getPurchaseprice());

            Movie updateMovie = mRepo.save(movie.get());
            return updateMovie;

        }
        else
        {
            Movie updateMovie = null;
            return updateMovie;
        }




    }
}
