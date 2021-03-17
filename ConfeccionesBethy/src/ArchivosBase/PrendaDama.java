package ArchivosBase;
import java.util.Scanner;
public class PrendaDama extends Prenda {
    static Scanner entrada2 = new Scanner(System.in);
    private String tipo;
    private float precio;
    private String descripcion;
    public PrendaDama(String tipo){
        this.tipo=tipo;
    }
    public float calcularTotal(){
        System.out.println("Digite una breve descripcion de la prenda");
        descripcion= entrada2.nextLine();
        do{
            System.out.println("Digite el precio de la prenda");
            precio=MenuPrincipal.entrada.nextFloat();
            if (precio<0) System.out.println("Cantidad invalida");
        }while(precio<0);
        return precio;
    }
    public String toString(){
        return("Prenda tipo: "+tipo+". Precio: "+precio+"Descripcion: "+descripcion);
    }
}
