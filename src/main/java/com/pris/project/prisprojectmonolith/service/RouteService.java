package com.pris.project.prisprojectmonolith.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pris.project.prisprojectmonolith.model.Artwork;
import com.pris.project.prisprojectmonolith.model.Route;
import com.pris.project.prisprojectmonolith.repository.ArtworkRepository;
import com.pris.project.prisprojectmonolith.repository.RouteRepository;


@Service
public class RouteService {
	
	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private ArtworkRepository artworkRepository;
	
	 public Route createRoute(Route route) {
		List<Artwork> artworks = route.getArtworks();
		
	        for(Artwork a : artworks) {
	        	Optional<Artwork> test = artworkRepository.findById(a.idArtwork);
	        	if(!test.isPresent()) {
	        		throw new RuntimeException("Artwork with id " + a.idArtwork + " not found");
	        	}
	        }
	        return routeRepository.save(route);
	    }


	public List<Route> getAllRoutes() {
			return routeRepository.findAll();
	}

	public Optional<Route> getRoutekById(int idRoute) {
		return routeRepository.findById(idRoute);
	}

	public Route updateRoute(int id, Route route) {
        Optional<Route> existingRoute = routeRepository.findById(id);
        if (existingRoute.isPresent()) {
            route.setIdRoute(id);
            return routeRepository.save(route);
        } else {
            throw new RuntimeException("Route with id " + id + " not found");
        }
    }
	
	public void deleteRoute(int id) {
        Optional<Route> existingRoute = routeRepository.findById(id);
        if (existingRoute.isPresent()) {
            routeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Route with id " + id + " not found");
        }
    }

}
