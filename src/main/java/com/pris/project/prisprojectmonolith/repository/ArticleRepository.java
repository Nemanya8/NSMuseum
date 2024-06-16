package com.pris.project.prisprojectmonolith.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pris.project.prisprojectmonolith.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	List<Article> findByName(String name);
}
