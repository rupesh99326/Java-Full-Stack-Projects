package com.cognizant.moviecruiser.authenticationservicemoviecruiser.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="movie_item")
public class movie {
	@Id
	@Column(name="mo_id")
	private long id;
	@Column(name="mo_title")
	private String title;
	
	@Column(name="mo_boxoffice")
	private long box_office;
	@Column(name="mo_active")
	private boolean active;
	@Column(name="mo_date_of_launch")
	private Date Date_of_Launch;
	@Column(name="mo_genre")
	private String genre;
	@Column(name="mo_hasteaser")
	private boolean has_teaser;
	
	@Column(name="mo_image")
	private String image;
	@Override
	public String toString() {
		return "movie [id=" + id + ", title=" + title + ", box_office=" + box_office + ", active=" + active
				+ ", Date_of_Launch=" + Date_of_Launch + ", genre=" + genre + ", has_teaser=" + has_teaser + ", image="
				+ image + "]";
	}

	 @ManyToMany
	    @JoinTable(name = "favorites",
	        joinColumns = @JoinColumn(name = "fvt_mov_id"), 
	        inverseJoinColumns = @JoinColumn(name = "fvt_us_id"))
	private List<Users> users;
	
	
	public movie() {
		super();
		// TODO Auto-generated constructor stub
	}



	public movie(long id, String title, long box_office, boolean active, Date date_of_Launch, String genre,
			boolean has_teaser, String image) {
		this.id = id;
		this.title = title;
		this.box_office = box_office;
		this.active = active;
		Date_of_Launch = date_of_Launch;
		this.genre = genre;
		this.has_teaser = has_teaser;
		this.image = image;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public long getBox_office() {
		return box_office;
	}


	public void setBox_office(long box_office) {
		this.box_office = box_office;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Date getDate_of_Launch() {
		return Date_of_Launch;
	}


	public void setDate_of_Launch(Date date_of_Launch) {
		Date_of_Launch = date_of_Launch;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public boolean isHas_teaser() {
		return has_teaser;
	}


	public void setHas_teaser(boolean has_teaser) {
		this.has_teaser = has_teaser;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		movie other = (movie) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
