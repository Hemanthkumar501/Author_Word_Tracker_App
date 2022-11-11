package com.book.onboard.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id")
	@JsonProperty("id")
	private Integer Id;
	
	@JsonProperty("name")
	@Column(name = "book_name")
	private String name;
	
	@JsonProperty("datetimestamp")
	@Column(name = "datetimestamp")
	private String datetimestamp;

	@ManyToOne
	@JoinColumn(name="author_id", nullable=false)
	private Author author;
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonProperty("chapters")
	private List<BookChapter> chapters;

	@JsonProperty("chapters")
	public List<BookChapter> getChapters() {
		return chapters;
	}

	@JsonProperty("chapters")
	public void setChapters(List<BookChapter> chapters) {
		this.chapters = chapters;
	}

	
	
	@JsonProperty("id")
	public Integer getId() {
		return Id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		Id = id;
	}

	
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	
	@JsonProperty("datetimestamp")
	public String getDatetimestamp() {
		return datetimestamp;
	}
	@JsonProperty("datetimestamp")
	public void setDatetimestamp(String datetimestamp) {
		this.datetimestamp = datetimestamp;
	}
}
