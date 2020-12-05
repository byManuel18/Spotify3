package model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="GENRE")
@NamedQueries({
	@NamedQuery(name="Genre_findAll",
	            query="SELECT g FROM Genre g"),
	@NamedQuery(name="Genre_exist",
	query="FROM Genre WHERE name= :name"),

})
public class Genre implements Serializable{


	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;

	public Genre(){
		this(-1,"");
	}

	public Genre(String name) {
		this(-1,name);
	}

	public Genre(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
	}


}
