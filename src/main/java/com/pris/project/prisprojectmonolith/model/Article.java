package com.pris.project.prisprojectmonolith.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Article {

	public enum Epoch {
		EVROPA, REGION, NOVI_SAD
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idArticle;
	
	@NotNull
	@Length(min = 4, max = 50)
    private String name;
	
	@NotNull
	@Length(min = 0, max = 5000)
    private String description;
    
	@NotNull
	private Epoch epoch;
    
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
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

	public Epoch getEpoch() {
		return epoch;
	}

	public void setEpoch(Epoch epoch) {
		this.epoch = epoch;
	}
}
