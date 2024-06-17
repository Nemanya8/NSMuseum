package com.pris.project.prisprojectmonolith.controller;

import com.pris.project.prisprojectmonolith.model.Artwork;
import com.pris.project.prisprojectmonolith.service.ArtworkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artworks")
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

    @PostMapping
    public ResponseEntity<Artwork> createArtwork(@RequestBody @Valid Artwork artwork) {
        Artwork createdArtwork = artworkService.createArtwork(artwork);
        return ResponseEntity.ok(createdArtwork);
    }

    @GetMapping("/getAllArtworks")
    public ResponseEntity<List<Artwork>> getAllArtwork() {
        List<Artwork> artworks = artworkService.getAllArtwork();
        return ResponseEntity.ok(artworks);
    }

    @GetMapping("/{artworkId}")
    public ResponseEntity<Artwork> getArtworkById(@PathVariable int artworkId) {
        Optional<Artwork> artwork = artworkService.getArtworkById(artworkId);
        return artwork.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{artworkId}")
    public ResponseEntity<Artwork> updateArtwork(@PathVariable int artworkId, @RequestBody @Valid Artwork artwork) {
        try {
            Artwork updatedArtwork = artworkService.updateArtwork(artworkId, artwork);
            return ResponseEntity.ok(updatedArtwork);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{artworkId}")
    public ResponseEntity<Void> deleteArtwork(@PathVariable int artworkId) {
        try {
            artworkService.deleteArtwork(artworkId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
