package com.pris.project.prisprojectmonolith.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRoute;

    private String name;
    private String description;
    private String algoritham;

    @ManyToMany
    @JoinTable(
            name = "route_artwork",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "artwork_id")
    )
    private List<Artwork> artworks;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
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

    public String getAlgoritham() {
        return algoritham;
    }

    public void setAlgoritham(String algoritham) {
        this.algoritham = algoritham;
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<Artwork> artworks) {
        this.artworks = artworks;
    }
}
