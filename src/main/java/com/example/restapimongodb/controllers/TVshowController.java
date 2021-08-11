package com.example.restapimongodb.controllers;

import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.models.Movie;
import com.example.restapimongodb.models.TVshow;
import com.example.restapimongodb.services.TVshowService;
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
public class TVshowController {



        @Autowired
        private TVshowService tvService;


        @GetMapping("/tvshows")
        public ResponseEntity<TVshow> getTVshows()
        {
            return new ResponseEntity(tvService.getTVshows(),HttpStatus.OK);

        }

        @GetMapping("/tvshows/{id}")
        public ResponseEntity getAtvshow(@PathVariable("id") String id) {

                Optional<TVshow> tvshow=null;


                try {
                        tvshow=tvService.getAtvshow(id);

                } catch (Exception e) {



                        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

                }


                return new ResponseEntity(tvshow, HttpStatus.OK);
        }

        @PostMapping(value= "/tvshows", consumes={MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity addTVshow(@RequestBody TVshow tvshow)
        {
            tvService.addTVshow(tvshow);
                return new ResponseEntity(tvshow,HttpStatus.OK);

        }

        @GetMapping("/tvshows/feature")
        public ResponseEntity getfeaturedTVshows()
        {



                return new ResponseEntity(tvService.getfeaturedTVshows("true"), HttpStatus.OK);
        }

        @PutMapping(value="/tvshows/{id}", consumes={MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity editTVshow(@PathVariable("id") String id,@RequestBody TVshow newTVshow)
        {
                var customizedResponse = new CustomizedResponse(" Movie with ID:  " + id + "was updated successfully " , Collections.singletonList(tvService.editTVshow(id, newTVshow)));

                if((tvService.editTVshow(id, newTVshow)==null))
                {
                        return new ResponseEntity("Provide Id is not Found", HttpStatus.NOT_FOUND);
                }
                else
                {
                        return new ResponseEntity(customizedResponse, HttpStatus.OK);
                }

        }

        @GetMapping("/tvshows/title")
        public ResponseEntity getTitleTVshow(@RequestParam(value = "title") String title){
                var customizedResponse = new CustomizedResponse("A list of movies where title contains " + title, tvService.getTVshowsByTitle(title));
                return new ResponseEntity(customizedResponse, HttpStatus.OK);
        }


        @DeleteMapping("/tvshows/{id}")
        public ResponseEntity deleteATVshow(@PathVariable("id") String id)
        {

                tvService.deleteATVshow(id);
                return new ResponseEntity(HttpStatus.OK);


        }
}
