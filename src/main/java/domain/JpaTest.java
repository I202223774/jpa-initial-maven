package domain;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaTest {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		//Insertar
		Departamento d = new Departamento();
		d.setNombre("Publicidad");
		manager.persist(d);
		
		//Actualizar
		//Departamento d = new Departamento();
		//d.setId(5L);
		//d.setNombre("Administracion");
		//manager.merge(d);
		
		//Eliminar - más eficiente
		//Departamento d = manager.getReference(Departamento.class, 9L);
		//manager.remove(d);
		
		//Eliminar 2 - devuelve una copia para eliminar
		//Departamento d = manager.find(Departamento.class, 10L);
		//manager.remove(d);
		
		tx.commit();
		
		//Listar
		//List<Departamento> lista = manager.createQuery("select d from Depa d", Departamento.class).getResultList();
		//for (Departamento departamento : lista) {
		//System.out.println(departamento);
		//}
		
		//Query nombrada
		//List<Departamento> lista = manager.createNamedQuery("listaDepartamentos", Departamento.class).getResultList();
		//for (Departamento departamento : lista) {
		//	System.out.println(departamento);
		//}
		
		//Query nombrada 2 "listaDepartamentos"
				List<Departamento> lista = manager.createNativeQuery("select * from tableDepa", Departamento.class).getResultList();
				for (Departamento departamento : lista) {
					System.out.println(departamento);
					
		}

	}

}
