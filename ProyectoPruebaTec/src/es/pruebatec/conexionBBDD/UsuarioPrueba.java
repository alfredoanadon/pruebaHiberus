package es.pruebatec.conexionBBDD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuarioPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFact=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).addAnnotatedClass(Slogan.class).buildSessionFactory();
		
		Session miSesion=miFact.openSession();
		
		try {
			List<Slogan> sloganes= new ArrayList<Slogan>();
			
			Slogan ejemplo=new Slogan("prueba","hola es el primer slogan");
			Usuario usuario1=new Usuario(false,"Alfredo","Anadon","Madrid", "Madrid", "alfredo.anadon96@gmail.com", sloganes);
			
			miSesion.beginTransaction();
			
			usuario1.loggearse();
			usuario1.insertarSlogan(ejemplo);
			
			miSesion.save(usuario1);
			miSesion.getTransaction().commit();
			System.out.println("Registro correcto");
			
			//Leer registro Remoto
			
			miSesion.beginTransaction();
			
			System.out.println("Leemos id del usuario" + usuario1.getName() + " cuyo ID es" + usuario1.getId() );
			
			Usuario usuarioInsert = miSesion.get(Usuario.class, usuario1.getId());
			
			System.out.println("Registro realizado");
			
			miSesion.getTransaction().commit();
			
			usuario1.unloggin();
			//Evitar fugas de memoria
					
			
		}catch (Exception ex1) {
				ex1.printStackTrace();
			}
			
		finally {
			miSesion.close();
			
			miFact.close();
		}

	}

}
