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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "chapter")
public class BookChapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "chapter_name")
	private String name;
	@Column(name = "datetimestamp")
	private String datetimestamp;

	@ManyToOne
	@JoinColumn(name = "b_id", nullable = false)
	@JsonIgnore
	private Book book;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
	private List<BookRecord> records;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDatetimestamp() {
		return datetimestamp;
	}

	public void setDatetimestamp(String datetimestamp) {
		this.datetimestamp = datetimestamp;
	}

	public List<BookRecord> getRecords() {
		return records;
	}

	public void setRecords(List<BookRecord> records) {
		this.records = records;
	}
}
