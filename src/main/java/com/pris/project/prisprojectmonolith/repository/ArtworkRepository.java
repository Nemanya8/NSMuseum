package com.pris.project.prisprojectmonolith.repository;

import com.pris.project.prisprojectmonolith.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<Artwork, Integer> {
    Artwork findByName(String name);
}
