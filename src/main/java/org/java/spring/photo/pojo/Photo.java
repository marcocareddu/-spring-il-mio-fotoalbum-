package org.java.spring.photo.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Length(min = 3, message = "Devi inserire almeno 3 caratteri.")
	@Length(max = 20, message = "Il nome deve essere lungo massimo 20 caratteri.")
	private String title;
	
	@Column(columnDefinition = "TEXT")
	@Length(min = 3, message = "Devi inserire almeno 3 caratteri.")
	private String description;
	
	@Length(min = 10, message = "Il link deve essere di almeno 10 caratteri.")
	private String url;
	
	private boolean visible;
	
//  Constructors
	public Photo() {
	}
	public Photo(String title, String description, String url, boolean visible) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
	
//	Getters & Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
