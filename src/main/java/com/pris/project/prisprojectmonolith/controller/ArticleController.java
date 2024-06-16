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

import com.pris.project.prisprojectmonolith.model.Article;
import com.pris.project.prisprojectmonolith.service.ArticleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
    @GetMapping
    public ResponseEntity<List<Article>> allArticles() {
        List<Article> articles = articleService.getAllArticle();
        return ResponseEntity.ok(articles);
    }
    
    @GetMapping("name/{articleName}")
    public ResponseEntity<List<Article>> articlesByName(@PathVariable String articleName) {
    	List<Article> articles = articleService.getArticlesByName(articleName);
    	return ResponseEntity.ok(articles);
    }
	
    @PostMapping
	public ResponseEntity<Article> createArticle(@RequestBody @Valid Article article) {
		Article createdArticle = articleService.createArticle(article);
		return ResponseEntity.ok(createdArticle);
	}
	
    @GetMapping("/{articleId}")
    public ResponseEntity<Article> getArticleById(@PathVariable int articleId) {
    	Optional<Article> article = articleService.getArticleById(articleId);
    	return article.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{articleId}")
    public ResponseEntity<Article> updateArticle(@PathVariable int articleId, @RequestBody @Valid Article article) {
        try {
            Article updatedArticle = articleService.updateArticle(articleId, article);
            return ResponseEntity.ok(updatedArticle);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable int articleId) {
        try {
            articleService.deleteArticle(articleId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
