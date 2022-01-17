
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Katsu
 */
@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String producto;
    private short disponible;
    private float precio;
    private String tipo;

    @OneToMany(mappedBy="producto", fetch=FetchType.EAGER)
    private List<Pedido> pedidos;

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public Producto() {
    }

    public Producto(Long id, String producto, short disponible, float precio, String tipo) {
        this.id = id;
        this.producto = producto;
        this.disponible = disponible;
        this.precio = precio;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public short getDisponible() {
        return disponible;
    }

    public void setDisponible(short disponible) {
        this.disponible = disponible;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", producto=" + producto + ", disponible=" + disponible + ", precio=" + precio + ", tipo=" + tipo + '}' + "\n";
    }
    
    
}
