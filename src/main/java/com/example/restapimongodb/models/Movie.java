package com.example.restapimongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class Movie {

    @Id
   private String _id;
   private String title;
   private String poster;
   private String poster1;
    private String description;
    private String dateReleased;
    private String lead;
    private String rating;
    private String feature;
    private String type;
    private String rentprice;
    private String purchaseprice;

    public Movie() {
    }

    public Movie(String id, String title, String poster, String poster1, String description, String dateReleased, String lead, String rating, String feature, String type, String rentprice, String purchaseprice) {
        this._id = id;
        this.title = title;
        this.poster = poster;
        this.poster1 = poster1;
        this.description = description;
        this.dateReleased = dateReleased;
        this.lead = lead;
        this.rating = rating;
        this.feature = feature;
        this.type = type;
        this.rentprice = rentprice;
        this.purchaseprice = purchaseprice;
    }

    public void setId(String id) {
        this._id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setPoster1(String poster1) {
        this.poster1 = poster1;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRentprice(String rentprice) {
        this.rentprice = rentprice;
    }

    public void setPurchaseprice(String purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public String getId() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getPoster1() {
        return poster1;
    }

    public String getDescription() {
        return description;
    }

    public String getDateReleased() {
        return dateReleased;
    }

    public String getLead() {
        return lead;
    }

    public String getRating() {
        return rating;
    }

    public String getFeature() {
        return feature;
    }

    public String getType() {
        return type;
    }

    public String getRentprice() {
        return rentprice;
    }

    public String getPurchaseprice() {
        return purchaseprice;
    }
}
