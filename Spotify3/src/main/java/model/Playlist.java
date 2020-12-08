package model;

import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="Playlist")
@NamedQueries({
	@NamedQuery(name="Playlist_findAll", query="SELECT pl FROM Playlist pl"),
	@NamedQuery(name="Playlist_findById", query="FROM Playlist WHERE ID= :id"),
	@NamedQuery(name="Playlist_findForCreator", query="FROM Playlist WHERE ID_USER= :creator"),
	@NamedQuery(name="Playlist_findForName", query="FROM Playlist WHERE ID_USER=:creator AND name=:name"),
	@NamedQuery(name="Playlist_findEXceptUser", query="FROM Playlist WHERE ID_USER !=:id"),
	@NamedQuery(name="Playlist_SLECTALLEXCEPTUSERANDNAME",query="FROM Playlist WHERE ID_USER !=:id AND name LIKE :name"),
	//@NamedQuery(name="Playlist_SLECTALLEXCEPTUSERANDNAMEFROMCREATOR",query="SELECT l.name,l.id,l.description,l.ID_USER FROM Playlist"
	//		+ " AS l JOIN User AS u ON l.ID_USER=u.id WHERE l.ID_USER!=:id AND u.name LIKE :name"),

})
public class Playlist implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="NAME")
	private String name;

	@Column(name="DESCRIPTION")
	private String description;


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_USER")
	private User creator;

	//N:M suscribers
	@JoinTable(
			name="SUBSCRIPTION",
			joinColumns = @JoinColumn(name="id_Playlist",nullable=false),
			inverseJoinColumns = @JoinColumn(name="id_User",nullable=false)
			)
	@ManyToMany(cascade=CascadeType.ALL)
	private List<User> subscribers=new ArrayList<User>();

	//N:M songs
	/*@JoinTable(
			name="rel_playlist_song",
			joinColumns = @JoinColumn(name="id_Playlist",nullable=false),
			inverseJoinColumns = @JoinColumn(name="id_Song",nullable=false)
			)*/
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="playlists")
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
		List<Playlist> lp=this.creator.getPlaylistCreates();
		if(lp==null){
			lp=new ArrayList<Playlist>();
		}
		if(!lp.contains(this)){
			lp.add(this);
		}
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
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", description=" + description;
	}


}
