package com.pris.project.prisprojectmonolith.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pris.project.prisprojectmonolith.model.Route;
import com.pris.project.prisprojectmonolith.service.RouteService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/routes")
public class RouteController {
	
	@Autowired
    private RouteService routeService;
	
	@PostMapping("/newRoute")
    public ResponseEntity<Route> createRoute(@RequestBody @Valid Route route) {
       Route createdRoute = routeService.createRoute(route);
        return ResponseEntity.ok(createdRoute);
    }
	
	@GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(routes);
    }
	
	 @GetMapping("/{idRoute}")
	    public ResponseEntity<Route> getRouteById(@PathVariable int idRoute) {
	        Optional<Route> route = routeService.getRoutekById(idRoute);
	        if (route.isPresent()) {
	            return ResponseEntity.ok(route.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 @PutMapping("/{idRoute}")
	    public ResponseEntity<Route> updateUser(@PathVariable int idRoute, @RequestBody @Valid Route route) {
	        try {
	            Route updatedRoute = routeService.updateRoute(idRoute, route);
	            return ResponseEntity.ok(updatedRoute);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{idRoute}")
	    public ResponseEntity<Void> deleteRoute(@PathVariable int idRoute) {
	        try {
	            routeService.deleteRoute(idRoute);
	            return ResponseEntity.noContent().build();
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
