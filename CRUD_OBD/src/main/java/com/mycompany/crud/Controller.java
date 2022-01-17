
package com.mycompany.crud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.Pedido;
import models.Producto;

/**
 *
 * @author Katsu
 */
public class Controller implements Serializable {
    
    private static EntityManagerFactory emf;
    
    static {
        emf = Persistence.createEntityManagerFactory("db.odb");
    }
    
    static final String LIST_PRODUCTS = "SELECT p FROM Producto p";
    static final String CREATE_PEDIDO = "INSERT INTO Pedido(alumno,ciclo,estado, producto_id) VALUES (?,?,?,?)";
    static final String DELETE_PEDIDO = "DELETE FROM Pedido WHERE id=?";
    static final String LIST_COMANDAS = "SELECT p FROM Pedido p WHERE p.estado=:estado";
    static final String MARCAR_PEDIDO = "UPDATE Pedido SET estado = 'Recogido' WHERE id=?";
    static final String GET_PEDIDO = "SELECT p FROM Pedido p WHERE p.id=:id";
    

    public void savePedido(Pedido p){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
    

    public void listarComandas(){

        var todo = new ArrayList<Pedido>();

        EntityManager em = emf.createEntityManager();
        TypedQuery<Pedido> q = em.createQuery(LIST_COMANDAS, Pedido.class);
        q.setParameter("estado", "pendiente");
        todo = (ArrayList<Pedido>) q.getResultList();
        em.close();

        todo.forEach( 
            (l)->{
                System.out.println("\n"+l.getAlumno()+" "+l.getCiclo()+" " + l.getEstado() + " " + l.getId() + "\n");
            }
        );
    }    
    
    public void marcarPedido(){
        Long nPedido;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte el id del pedido recogido: ");
        nPedido = sc.nextLong();
        
        EntityManager em = emf.createEntityManager();  

        var p = getPedido(nPedido, em);
        
        em.getTransaction().begin();
        
        p.setRecogido();
        
       em.getTransaction().commit();
        System.out.println("Pedido recogido");
       em.close();
    }
    
    public void listarCarta(){
    
        var todo = new ArrayList<Producto>();

        EntityManager em = emf.createEntityManager();
        TypedQuery<Producto> q = em.createQuery(LIST_PRODUCTS, Producto.class);
        todo = (ArrayList<Producto>) q.getResultList();
        em.close();
        todo.forEach( 
            (l)->{
                System.out.println(l);
            });      
    }
    
    public void eliminarPedido(){
        Long pedido;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte el id del pedido a eliminar: ");
        pedido = sc.nextLong();   
        
        EntityManager em = emf.createEntityManager();  
        var p = getPedido(pedido, em);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        System.out.println("Se ha eliminado el pedido");
        em.close();
    }
    
    
     public static Pedido getPedido(Long id, EntityManager em) {

        TypedQuery<Pedido> tq = em.createQuery(GET_PEDIDO, Pedido.class);
        tq.setParameter("id", id);
        var pedido = tq.getSingleResult();
        return pedido;
    }    
        
}
   
    



