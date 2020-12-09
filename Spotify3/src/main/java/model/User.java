package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="USER")
@NamedQueries({
	@NamedQuery(name="User_findbyname",
	            query="FROM User WHERE MAIL= :name"),
	@NamedQuery(name="User_findAll",
    query="FROM User"),
})
public class User implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="MAIL")
	private String mail;
	@Column(name="NAME")
	private String name;
	@Column(name="PHOTO")
	private String photo;
	@Column(name="ACTIVE")
	private boolean active=false;

	@JoinTable(
			name="SUBSCRIPTION",
				inverseJoinColumns = @JoinColumn(name="id_Playlist",nullable=false),
			    joinColumns = @JoinColumn(name="id_User",nullable=false)
			)
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Playlist> subscriptions=new ArrayList<Playlist>();

	//1:N
	@OneToMany(mappedBy="creator",cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	private List<Playlist> playlistCreates=new ArrayList<Playlist>();

	public User(){
		this(-1,"","","",true);
	}

	public User(String mail,String name,String photo,boolean active){
		this(-1,mail,name,photo,active);
	}

	public User(int id, String mail, String name, String photo,boolean active) {
		this.id = id;
		this.mail = mail;
		this.name = name;
		this.photo = photo;
		this.active=active;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public List<Playlist> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Playlist> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public List<Playlist> getPlaylistCreates() {
		return playlistCreates;
	}

	public void setPlaylistCreates(List<Playlist> playlistCreates) {
		this.playlistCreates = playlistCreates;
		for(Playlist pl:this.playlistCreates){
			pl.setCreator(this);
		}
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", name=" + name + ", photo=" + photo + ", active=" + active + "]";
	}




}
