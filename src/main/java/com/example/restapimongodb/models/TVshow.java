package com.example.restapimongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tvshows")
public class TVshow {
    @Id
    private String _id;
    private String title;
    private String poster;
    private String poster1;
    private String description;
    private String dateReleased;
    private String channel;
    private String rating;
    private String feature;
    private String type;
    private String rentprice;
    private String purchaseprice;

    public TVshow() {
    }

    public TVshow(String id, String title, String poster, String poster1, String description, String dateReleased, String channel, String rating, String feature, String type, String rentprice, String purchaseprice) {
        this._id = id;
        this.title = title;
        this.poster = poster;
        this.poster1 = poster1;
        this.description = description;
        this.dateReleased = dateReleased;
        this.channel = channel;
        this.rating = rating;
        this.feature = feature;
        this.type = type;
        this.rentprice = rentprice;
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

    public String getChannel() {
        return channel;
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

    public void setChannel(String channel) {
        this.channel = channel;
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
}
