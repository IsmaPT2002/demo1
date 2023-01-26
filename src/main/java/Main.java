import entities.Autor;
import entities.Lector;
import entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();

        //añadir un autor
        em.getTransaction().begin();
        Autor autor = new Autor();
        autor.setNombre("Jorge");
        autor.setNacionalidad("Española");
        em.persist(autor);
        em.getTransaction().commit();

        //añadir un libro
        em.getTransaction().begin();
        Libro libro = new Libro();
        libro.setTitulo("El Quijote");
        libro.setIsbn("123456789");
        libro.setAutor(autor);
        em.persist(libro);
        em.getTransaction().commit();

        //añadir un lector
        em.getTransaction().begin();
        Lector lector = new Lector();
        lector.setNombre("Pepe");
        lector.setApellido("Pérez");
        em.persist(lector);
        em.getTransaction().commit();

        //añadir un libro a la lista de un lector
        em.getTransaction().begin();

        //añadir un lector a un libro
        em.getTransaction().begin();
        libro.getLectores().add(lector);
        em.getTransaction().commit();

        //mostrar los libros de un lector
        System.out.println("Los libros de " + lector.getNombre() + " son:");
        for (Libro l : lector.getLibros()) {
            System.out.println(l.getTitulo());
        }

        //mostrar los lectores de un libro
        System.out.println("Los lectores de " + libro.getTitulo() + " son:");
        for (Lector l : libro.getLectores()) {
            System.out.println(l.getNombre());
        }

        //mostrar los libros de un autor
        System.out.println("Los libros de " + autor.getNombre() + " son:");
        for (Libro l : autor.getLibros()) {
            System.out.println(l.getTitulo());
        }

        //mostrar el autor de un libro
        System.out.println("El autor de " + libro.getTitulo() + " es " + libro.getAutor().getNombre());
    }
}
