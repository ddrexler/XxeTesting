/**
 * Created by Dave on 12/05/2018.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 *
 * @author leandros
 */
public class Recension implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String text;


    private int rating;

    private LocalDateTime creationDate;

    private String imagePath;

    private Product product;

    private User user;

    public Recension() {

    }

    public Recension(String text, int rating, LocalDateTime creationDate, String imagePath, Product product, User user) {
        this.text = text;
        this.rating = rating;
        this.creationDate = creationDate;
        this.imagePath = imagePath;
        this.product = product;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

