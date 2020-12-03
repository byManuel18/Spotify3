package model;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javassist.expr.NewArray;

@Entity
@Table(name="Playlist")
public class Playlist{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="NAME")
	private String name;

	@Column(name="DESCRIPTION")
	private String description;


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID:_USER")
	private User creator;

	//N:M suscribers
	@JoinTable(
			name="rel_playlist_user",
			joinColumns = @JoinColumn(name="FK_Playlist",nullable=false),
			inverseJoinColumns = @JoinColumn(name="FK_User",nullable=false)
			)
	@ManyToMany(cascade=CascadeType.ALL)
	private List<User> subscribers=new ArrayList<User>();

	//N:M songs
	@JoinTable(
			name="rel_playlist_song",
			joinColumns = @JoinColumn(name="FK_Playlist",nullable=false),
			inverseJoinColumns = @JoinColumn(name="Fk_Song",nullable=false)
			)
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Song> songs=new ArrayList<Song>();

	public Playlist(){
		this(-1,"","",null);
	}

	public Playlist(String name, String descripcion,User creator){
		this(-1,name,descripcion,creator);
	}

	public Playlist(int id, String name, String description, User creator) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.creator = creator;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}


	public List<User> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<User> subscribers) {
		this.subscribers = subscribers;
	}


	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
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
		Playlist other = (Playlist) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", description=" + description + ", creator=" + creator + "]";
	}


}
