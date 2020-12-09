package model;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SONG")
@NamedQueries({
	@NamedQuery(name="Song_findAll", query="SELECT s FROM Song s"),
	@NamedQuery(name="Song_findByName", query="FROM Song WHERE NAME LIKE :name"),
	@NamedQuery(name="Song_findForDisc", query ="FROM Song WHERE ID_DISC= :disc"),
	@NamedQuery(name="Song_exist", query ="FROM Song WHERE ID_DISC=:id and name= :name")
})
public class Song implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="NAME", nullable=false)
	private String name;

	@Column(name="Duration")
	private int duration;

	//1:N
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="ID_GENRE")
	private Genre genre;

	//1:M
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_DISC")
	private Disc disc;

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
		List<Song> ls=this.disc.getSonglist();
		if(ls==null){
			ls=new ArrayList<Song>();
		}
		if(!ls.contains(this)){
			ls.add(this);
		}
	}


	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", duration=" + duration + ", genre=" + genre;
	}


}