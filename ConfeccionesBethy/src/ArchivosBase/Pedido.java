package ArchivosBase;
import java.util.ArrayList;
public class Pedido {
    private ArrayList<Venta> listaVentas = new ArrayList<>();
    public void agregarVenta(){
        Venta venta = new Venta();
        venta.iniciarPedido();
        listaVentas.add(venta);
    }
    public void verPedidos(){
        if (!listaVentas.isEmpty()){
            for (int i=0;i<listaVentas.size();i++){
                System.out.println(i+". "+listaVentas.get(i));
            }
        }
        else System.out.println("Sin pedidos para mostrar");
    }
    public void eliminarPedido(){
        int pos;
        if (!listaVentas.isEmpty()){
            for (int i=0;i<listaVentas.size();i++){
                System.out.println(i+". "+listaVentas.get(i));
            }
            System.out.println("Digite el indice del pedido a elimimar");
            pos= MenuPrincipal.entrada.nextInt();
            if (pos>=0) listaVentas.remove(pos);
            else System.out.println("Indice invalido");
            System.out.println("Pedido eliminado");
        }
        else System.out.println("Sin pedidos para eliminar");
    }
}
