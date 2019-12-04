package com.cognizant.moviecruiser.model;

import java.util.Date;

public class Movie {
	private long id;
	private String title;
	private long boxoffice;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasteaser;

	@Override
	public String toString() {
		return "Movie [id=" + id + ", Title=" + title + ", boxoffice=" + boxoffice + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", genre=" + genre + ", hasteaser=" + hasteaser + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String Title) {
		title = Title;
	}

	public long getBoxoffice() {
		return boxoffice;
	}

	public void setBoxoffice(long boxoffice) {
		this.boxoffice = boxoffice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasteaser() {
		return hasteaser;
	}

	public void setHasteaser(boolean hasteaser) {
		this.hasteaser = hasteaser;
	}

	public Movie(long id, String Title, long boxoffice, boolean active, Date dateOfLaunch, String genre,
			boolean hasteaser) {
		super();
		this.id = id;
		title = Title;
		this.boxoffice = boxoffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasteaser = hasteaser;
	}
}
