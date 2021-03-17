package ArchivosBase;
import java.util.ArrayList;
public class Venta {
    private float subPrecioFinalMaterial;
    private float subPrecioFinalPrenda=0;
    private float precioFinal;
    private Cliente cliente = new Cliente();
    private ArrayList<Prenda> listaPrendas = new ArrayList<>();
    public void iniciarPedido(){
        int respuesta=1,respuestaP=0;
        do {
            do{
                System.out.println("Desea registrar un 1-Vestido (Boda o XV anios) 2-Prenda para dama (blusa pantalon, etc)");
                respuestaP=MenuPrincipal.entrada.nextInt();
                if (respuestaP<1 || respuestaP>2) System.out.println("Dato erroneo");
            }while(respuestaP<1 || respuestaP>2);
            if (respuestaP==1){
                String tipo ,disenio=" ", talla=" ";
                int opcion,opcion2,opcion3;
                do{
                    System.out.println("Desea un vestido de...... 1-Boda  o 2-XV anios");
                    opcion= MenuPrincipal.entrada.nextInt();
                    if (opcion<1 || opcion>2) System.out.println("Numero invalido");
                }while (opcion<0 || opcion>2);
                tipo = (opcion==1)? "Boda":"XV anios";
                do{
                    System.out.println("Desea un disenio..... 1-Sencillo o 2-Personalizado");
                    opcion3= MenuPrincipal.entrada.nextInt();
                    if (opcion3<1 || opcion3>2) System.out.println("Numero invalido");
                }while (opcion3<1 || opcion3>2);
                disenio=(opcion3==1)? "Sencillo":"Personalizado";
                do{
                    System.out.println("Digite la talla que busca:\n1.S\n2.M\n3.L\n4.XL\n5.XXL");
                    opcion2= MenuPrincipal.entrada.nextInt();
                    if (opcion2<1 || opcion2>5) System.out.println("Opcion invalido");
                }while(opcion2<1 || opcion2>5);
                switch(opcion2){
                    case 1: talla="S"; break;
                    case 2: talla="M"; break;
                    case 3: talla="L"; break;
                    case 4: talla="XL"; break;
                    case 5: talla="XXL"; break;
                    default: System.out.println("Entrada erronea");
                }
                Vestido vestido = new Vestido(tipo, disenio, talla);
                subPrecioFinalPrenda+=vestido.calcularTotal();
                listaPrendas.add(vestido);
                calcularTotal();
            }
            else{
                String tipo=" ";
                int respuestaPr;
                do{
                    System.out.println("Digite el tipo de prenda que llevara el cliente (Prox. Mas prendas): 1-Blusa 2-Pantalon 3-Falda 4-Mayon");
                    respuestaPr=MenuPrincipal.entrada.nextInt();
                    if (respuestaPr<1 || respuestaPr>4) System.out.println("Numero invalido");
                }while (respuestaPr<1 || respuestaPr>4);
                switch(respuestaPr){
                    case 1: tipo="Blusa"; break;
                    case 2: tipo="Pantalon"; break;
                    case 3: tipo="Falda"; break;
                    case 4: tipo="Mayon"; break;
                    default: System.out.println("Opcion invalida");
                }
                PrendaDama pDama = new PrendaDama(tipo);
                subPrecioFinalPrenda+=pDama.calcularTotal();
                listaPrendas.add(pDama);
                calcularTotal();
            }
            do{
                System.out.println("Desea registrar otra prenda 1-si 2-no");
                respuesta= MenuPrincipal.entrada.nextInt();
                if (respuesta<1 || respuesta>2) System.out.println("Numero erroneo");
            }while(respuesta<1 || respuesta>2);
        }while (respuesta==1);
        cliente.agregarCliente();
        System.out.println("Pedido aniadido");
    }
    public void calcularTotal(){
        int opcion,pos,cantidad;
        float subPrecioMaterial;
        do{
            System.out.println("Gastara algun material 1-si 2-no");
            opcion = MenuPrincipal.entrada.nextInt();
            if (opcion<1 || opcion>2) System.out.println("Numero invalido");
        }while(opcion<1 || opcion>2);
        if (opcion==1){
            do{
                if (opcion==1){
                    for (int i=0;i<MenuPrincipal.listaMaterial.size();i++){
                        System.out.println(i+"."+MenuPrincipal.listaMaterial.get(i));
                    }
                    do{
                        System.out.println("Digite el indice del cual vaya a decrementar:");
                        pos = MenuPrincipal.entrada.nextInt();
                    }while(pos<0 || pos>MenuPrincipal.listaMaterial.size());
                    do{
                        System.out.println("Digite la cantidad que gastara");
                        cantidad=MenuPrincipal.entrada.nextInt();
                        if (cantidad<0) System.out.println("Numero erroneo");
                    }while(cantidad<0);
                    if (cantidad<=MenuPrincipal.listaMaterial.get(pos).cantidad){
                        subPrecioMaterial= MenuPrincipal.listaMaterial.get(pos).getPrecio()*cantidad;
                        subPrecioFinalMaterial+=subPrecioMaterial;
                        MenuPrincipal.listaMaterial.get(pos).descontarMaterial(cantidad);
                        do{
                            System.out.println("Desea agregar otro material 1=si 2=no");
                            opcion=MenuPrincipal.entrada.nextInt();
                            if (opcion<1 || opcion>2) System.out.println("Numero erroneo");
                        }while(opcion!=1 && opcion!=2);
                    }
                    else System.out.println("El material a usar supera al existente, vuelva a ingresar los datos");
                }

            }while(opcion!=2);
        }
        precioFinal=subPrecioFinalMaterial+subPrecioFinalPrenda;
    }
    public String toString(){
        return ("Clinte "+cliente+"\nVentas: "+listaPrendas+"\nGanancia total: "+precioFinal);
    }
}
