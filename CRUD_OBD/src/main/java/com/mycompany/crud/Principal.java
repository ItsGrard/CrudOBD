
package com.mycompany.crud;

import java.util.Scanner;
import models.Pedido;

/**
 *
 * @author Katsu
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller contr = new Controller();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("Elija accion a realizar: \n" + "Crear pedido: 1\n"
            + "Eliminar pedido: 2\n" + "Marcar pedido como recogido: 3 \n"
            +"Listar todas las comandas pendientes: 4\n"
            +"Listar la carta: 5\n"
            +"Salir: 6\n");
            opcion = sc.nextInt();
            switch (opcion){
            
                case 1: createPedido(contr);
                break;
                case 2: contr.eliminarPedido();
                break;
                case 3: contr.marcarPedido();
                break;
                case 4: contr.listarComandas();
                break;
                case 5: contr.listarCarta();
                break;
                case 6:
                break;
                default: opcion = 0; System.out.println("Seleccione una opcion.");
            }
        }while(opcion != 6);
        
    }
        
        public static void createPedido(Controller contr){
            String nombre;
            String ciclo;
            String estado;
            Scanner sc = new Scanner(System.in);
            System.out.println("Inserte su nombre: ");
            nombre = sc.next();
            System.out.println("Inserte su ciclo: ");
            ciclo = sc.next();
            System.out.println("Inserte el estado: ");
            estado = sc.next();
            System.out.println("Inserte el id del producto: ");
            int idProd = sc.nextInt();
            
            Pedido p = new Pedido(nombre, ciclo, estado, idProd);
            contr.savePedido(p);
    
    }

    
}
