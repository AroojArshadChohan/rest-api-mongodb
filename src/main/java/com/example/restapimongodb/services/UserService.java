package com.example.restapimongodb.services;


import com.example.restapimongodb.models.UserModel;
import com.example.restapimongodb.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.MongoTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {


    //Validation
    //Calculation
    //Call your model
    //Business Logic

    @Autowired
    private UserRepository uRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserModel> getUsers()
    {
        return uRepo.findAll();

    }

    public List<UserModel> getUser(UserModel userModel)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("username" ).is(userModel.getUsername()));
        query.addCriteria(Criteria.where("password" ).is(userModel.getPassword()));
        List<UserModel> userreturn=mongoTemplate.find(query, UserModel.class);

        /*
        Query query = new Query();
        query.addCriteria(Criteria.where("title" ).is(title));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
         */

        return userreturn;


    }

    public Optional<UserModel> getAUser(String id)// throws Exception
    {

        Optional<UserModel> user = uRepo.findById(id);



        return user;

    }

    public List<UserModel> getUserByEmail(String email)// throws Exception
    {


        Query query = new Query();
        query.addCriteria(Criteria.where("username" ).is(email));
        List<UserModel> user = mongoTemplate.find(query, UserModel.class);



        return user;

    }

    public void addUser(UserModel userModel)
    {
        String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());

        userModel.setPassword(encodedPassword);

        uRepo.insert(userModel);
    }
    public void deleteAUser( String id)
    {
        uRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel foundUserModel = uRepo.findByUsername(username);

        String userN = foundUserModel.getUsername();
        String password = foundUserModel.getPassword();

        return new User(userN, password, new ArrayList<>());
    }
}
