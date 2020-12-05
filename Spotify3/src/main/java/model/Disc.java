package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Disc")
public class Disc implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	@Column(name="Name")
	private String name;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Artist")
	private Artist artist;

	@Column(name="photo")
	private String photo;

	@Column(name="date")
	private LocalDate date;

	//1:N
	@OneToMany(mappedBy = "disc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Song> songlist;


	public Disc() {
		this(-1, "", null, "", null);
	}

	public Disc(String name, Artist artist, String photo, LocalDate date) {
		this(-1, name,artist,photo,date);
	}


	public Disc(int id, String name, Artist artist, String photo, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.photo = photo;
		this.date = date;
		this.songlist = new ArrayList<Song>();
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

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Song> getSonglist() {
		return songlist;
	}

	public void setSonglist(List<Song> songlist) {
		this.songlist = songlist;
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
		Disc other = (Disc) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disc [id=" + id + ", name=" + name + ", artist=" + artist + ", photo=" + photo + ", date=" + date;
	}


}
