package com.pris.project.prisprojectmonolith.repository;

import com.pris.project.prisprojectmonolith.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
