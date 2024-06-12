package com.pris.project.prisprojectmonolith.service;

import com.pris.project.prisprojectmonolith.model.Artwork;
import com.pris.project.prisprojectmonolith.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtworkService {

    @Autowired
    private ArtworkRepository artworkRepository;

    public Artwork createArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    public List<Artwork> getAllArtwork(){
        return artworkRepository.findAll();
    }

    public Optional<Artwork> getArtworkById(int id){
        return artworkRepository.findById(id);
    }

    public Artwork updateArtwork(int id, Artwork artwork) {
        Optional<Artwork> existingArtwork = artworkRepository.findById(id);
        if (existingArtwork.isPresent()) {
            artwork.setIdArtwork(id);
            return artworkRepository.save(artwork);
        } else {
            throw new RuntimeException("Artwork with id " + id + " not found");
        }
    }

    public void deleteArtwork(int id) {
        Optional<Artwork> existingArtwork = artworkRepository.findById(id);
        if (existingArtwork.isPresent()) {
            artworkRepository.deleteById(id);
        } else {
            throw new RuntimeException("Artwork with id " + id + " not found");
        }
    }
}
