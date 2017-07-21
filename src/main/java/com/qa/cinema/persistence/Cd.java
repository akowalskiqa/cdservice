package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cd {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String artistName;
	private String genre;
	private String albumTitle;

	public Cd() {

	}

	public Cd(String artistName, String genre, String albumTitle) {
		this.artistName = artistName;
		this.genre = genre;
		this.albumTitle = albumTitle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String title) {
		this.artistName = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}



}
