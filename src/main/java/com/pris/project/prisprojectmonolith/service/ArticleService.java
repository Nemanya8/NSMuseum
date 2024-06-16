package com.pris.project.prisprojectmonolith.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pris.project.prisprojectmonolith.model.Article;
import com.pris.project.prisprojectmonolith.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	public Article createArticle(Article article) {
		return articleRepository.save(article);
	}
	
	public List<Article> getAllArticle() {
		return articleRepository.findAll();
	}
	
	public Optional<Article> getArticleById(int id) {
		return articleRepository.findById(id);
	}
	
	public List<Article> getArticlesByName(String name) {
		return articleRepository.findByName(name);
	}

    public Article updateArticle(int id, Article article) {
        Optional<Article> existingArticle = articleRepository.findById(id);
        if (existingArticle.isPresent()) {
            article.setIdArticle(id);
            return articleRepository.save(article);
        } else {
            throw new RuntimeException("Article with id " + id + " not found");
        }
    }

    public void deleteArticle(int id) {
        Optional<Article> existingArticle = articleRepository.findById(id);
        if (existingArticle.isPresent()) {
            articleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Article with id " + id + " not found");
        }
    }
}
