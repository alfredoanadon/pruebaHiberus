package es.pruebatec.conexionBBDD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Slogan")
public class Slogan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSlogan")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="text")
	private String text;
	
	@ManyToOne
	@JoinColumn(name="idUsuario",nullable=false,updatable=false)
	private Usuario usuario;
	
	public Slogan (String title, String text) {
		this.title=title;
		this.text=text;		
	}
	public Slogan() {}
	
	public int getId() {
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setText(String text) {
		this.text=text;
	}
	
}
