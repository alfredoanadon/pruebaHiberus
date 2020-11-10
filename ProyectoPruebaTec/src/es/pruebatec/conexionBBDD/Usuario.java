package es.pruebatec.conexionBBDD;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.*;


@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Slogan> slogan;
	
	@Column(name="name")
	private String name;
	
	@Column(name="logg")
	private boolean logg;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="email")
	private String email;
	
	/*@Column(name="has_sloganes")
	private Slogan sloganes;*/
	
	public Usuario(boolean logg,String name, String lastname, String address, String city, String email, List<Slogan> sloganes) {
		this.logg=logg;
		this.name=name;
		this.lastname=lastname;
		this.setAddress(address);
		this.setCity(city);
		this.setEmail(email);
		this.slogan=sloganes;
		
	}
	public Usuario() {}
	
	public void insertarSlogan(Slogan slogIn) {
		if (slogan==null) slogan =new ArrayList<>();
		if(slogan.size()>3) {
			System.out.println("Esloganes maximos alcanzados");
		
			List<Slogan> nuevos = new ArrayList<Slogan>();
			for(int i = 0; i<3;i++) {
				nuevos.add(slogan.get(i));
				i++;						
				}
			slogan=nuevos;
			System.out.println("Esloganes eliminados excepto 3 primeros");
		}else {
			slogan.add(slogIn);
			System.out.println("Inserto eslogan en la posicion" + slogan.size());
		}
	}
	
	public void eliminarSlogan(Slogan slogIn) {
		if(slogan==null) slogan=new ArrayList<Slogan>();
		if(slogan.size()<=0) {
			System.out.println("No hay eslogans a eliminar");
		}if(slogan.size()==1) {
			slogan.remove(0);
		}else {
			slogan.remove(slogIn);
			System.out.println("Eliminamos primer slogan que encontramos con id: "+slogIn.getId()+ " y titulo"+slogIn.getTitle());
		}
	}
	
	public void loggearse() {
		System.out.println("Comprobamos si usuario "+this.getName()+" esta loggeaado");
		
		if(this.getLogg()) {
			System.out.println("Este usuario esta loggeado");
		}else {
			System.out.println("Este usuario no esta loggeado. Loggin...");
		this.setLogg(true);
		System.out.println("Usuario "+ this.getName()+" esta loggeado. Bienvenido");
		}				
	}
	
	public void unloggin() {
System.out.println("Comprobamos si usuario "+this.getName()+" esta loggeaado");
		
		if(this.getLogg()) {
			System.out.println("Este usuario esta loggeado");
			this.setLogg(false);
			System.out.println("Usuario "+this.getName()+" se ha desconectado");
		}else {
			System.out.println("Este usuario no esta loggeado.");
		}	
	}
	
	/* GETTERS AND SETTERS*/
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", slogan=" + slogan + ", name=" + name + ", logg=" + logg + ", lastname="
				+ lastname + ", address=" + address + ", city=" + city + ", email=" + email + "]";
	}
	public boolean getLogg() {		
		return this.logg;
	}
	public void setLogg(boolean logg) {
		this.logg=logg;
	}
	public int getId() {
		return this.id;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public void setLastName(String lastname) {
		this.lastname=lastname;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}