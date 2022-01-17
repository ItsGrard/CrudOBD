
package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;

/**
 *
 * @author Katsu
 */
@Entity
public class Pedido implements Serializable{
    @Id
    @GeneratedValue
    Long id;
    String alumno;
    String ciclo;
    String fecha;
    String estado;
    int prodId;
    @ManyToOne
    @JoinColumn(name="prodId")
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


   // DATABASE HANDLER Long hora;

    public Pedido() {
    }

    public Pedido(Long id, String alumno, String ciclo, String estado, int prodId) {
        this.id = id;
        this.alumno = alumno;
        this.ciclo = ciclo;
        this.estado = estado;
        this.prodId = prodId;
    }
    public Pedido(String alumno, String ciclo, String estado, int prodId) {
        this.alumno = alumno;
        this.ciclo = ciclo;
        this.estado = estado;
        this.prodId = prodId;
    }    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", alumno=" + alumno + ", ciclo=" + ciclo + ", fecha=" + fecha + ", estado=" + estado + ", prodId=" + prodId + '}'+ "\n";
    }


    public void setRecogido() {
       this.estado = "recogido";
    }

  
}
