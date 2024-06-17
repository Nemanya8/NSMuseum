package com.pris.project.prisprojectmonolith.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idArtwork;

    private String name;
    private String description;
    private int creationDate;
    private String author;
    private String movement;
    private String museum;
    private double xCords;
    private double yCords;
    private int approxTime;
    private String type;
    private String image;

    public int getIdArtwork() {
        return idArtwork;
    }

    public void setIdArtwork(int idArtwork) {
        this.idArtwork = idArtwork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getMuseum() {
        return museum;
    }

    public void setMuseum(String museum) {
        this.museum = museum;
    }

    public double getxCords() {
        return xCords;
    }

    public void setxCords(double xCords) {
        this.xCords = xCords;
    }

    public double getyCords() {
        return yCords;
    }

    public void setyCords(double yCords) {
        this.yCords = yCords;
    }

    public int getApproxTime() {
        return approxTime;
    }

    public void setApproxTime(int approxTime) {
        this.approxTime = approxTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
