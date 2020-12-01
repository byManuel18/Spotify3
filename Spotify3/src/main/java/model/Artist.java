package model;

import java.util.HashSet;
import java.util.Set;

public class Artist {
	private int id;
	private String name;
	private String nationality;
	private String photo;
	private Set<Disc> disclist;

	public Artist() {
		this(-1, "", "", "");
	}

	public Artist(String name, String nationality, String photo){
		this(-1,name,nationality,photo);
	}

	public Artist(int id, String name, String nationality, String photo) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.photo = photo;
		this.disclist=new HashSet<Disc>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Set<Disc> getDisclist() {
		return disclist;
	}


	public void setDisclist(Set<Disc> disclist) {
		this.disclist = disclist;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Artist other = (Artist) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", nationality=" + nationality + ", photo=" + photo;
	}


}
