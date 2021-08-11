package com.example.restapimongodb.services;

import com.example.restapimongodb.models.Movie;
import com.example.restapimongodb.models.TVshow;
import com.example.restapimongodb.models.TVshowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TVshowService {

    @Autowired
    private TVshowRepository tvRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<TVshow> getTVshows()
    {
        return tvRepo.findAll();

    }


    public Optional<TVshow> getAtvshow(String id) throws Exception
    {

        Optional<TVshow> tvshow= tvRepo.findById(id);

        // This is saying that if movie ref variable does not contain a value then

        if (!tvshow.isPresent())
        {
            throw new Exception (" TV show with " + id + " is not found ");
        }

        return tvshow;

    }

    public void addTVshow(TVshow tvshow)
    {

        tvRepo.insert(tvshow);
    }

    public List<TVshow> getTVshowsByTitle(String title)
    {

        Query query = new Query();
        query.addCriteria(Criteria.where("title" ).regex(title));
        List<TVshow> tvshow = mongoTemplate.find(query, TVshow.class);
        return tvshow;




    }

    public List<TVshow> getfeaturedTVshows(String r)

    {
        Query query = new Query();
        query.addCriteria(Criteria.where("feature" ).is(r));
        List<TVshow> tvshows = mongoTemplate.find(query, TVshow.class);
        return tvshows;


    }
    public TVshow editTVshow(String id,TVshow newtvshow)
    {



        // get the resource based on the id

        Optional<TVshow> tvshow = tvRepo.findById(id);

        // validation code to validate the id
        //
        if(tvshow.isPresent()) {
            tvshow.get().setTitle(newtvshow.getTitle());
            tvshow.get().setDescription(newtvshow.getDescription());
            tvshow.get().setRating(newtvshow.getRating());
            tvshow.get().setRentprice(newtvshow.getRentprice());
            tvshow.get().setPurchaseprice(newtvshow.getPurchaseprice());

            TVshow updateTVshow = tvRepo.save(tvshow.get());
            return updateTVshow;

        }
        else
        {
            TVshow updateTVshow = null;
            return updateTVshow;
        }

    }


    public void deleteATVshow( String id)
    {

        tvRepo.deleteById(id);

    }
}
