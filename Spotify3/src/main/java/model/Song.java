package model;

import java.awt.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Song {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="NAME", nullable=false)
	private String name;

	@Column(name="Duration")
	private int duration;

	//1:N
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_GENRE")
	private Genre genre;

	//1:M
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_DISC")
	private Disc disc;

	//N:M playlist
	@JoinTable(
			name="rel_song_playlist",
			joinColumns = @JoinColumn(name = "FK_SONG", nullable=false),
			inverseJoinColumns = @JoinColumn(name="FK_Playlist", nullable=false)
			)
	@ManyToMany(cascade= CascadeType.ALL)
	private ArrayList<Playlist> playlists = new ArrayList<Playlist>();


	public Song(){
		this(-1,"",0,null,null);
	}

	public Song(String name, int duration, Genre genre, Disc disc){
		this(-1,name, duration, genre, disc);
	}

	public Song(int id, String name, int duration, Genre genre, Disc disc) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.genre = genre;
		this.disc = disc;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Disc getDisc() {
		return disc;
	}

	public void setDisc(Disc disc) {
		this.disc = disc;
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
		Song other = (Song) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", duration=" + duration + ", genre=" + genre + ", disc=" + disc
				+ "]";
	}


}
