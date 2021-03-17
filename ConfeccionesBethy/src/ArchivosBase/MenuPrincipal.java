package ArchivosBase;
import java.util.ArrayList;
import java.util.Scanner;
public class MenuPrincipal {
    static Scanner entrada=new Scanner(System.in);
    static ArrayList<Material> listaMaterial = new ArrayList<>();
    static GestionUsuarios gestion = new GestionUsuarios();
    static Pedido pedidos = new Pedido();
    public static void main(String[] args) {
        int tipoUsuario=-1,opcion;
        gestionarUsuaios(1);
        gestionarInventario(1);
        do{
            System.out.println("Digite la opcion deseada");
            System.out.println("1.Iniciar sesion\n2.Salir");
            opcion=entrada.nextInt();
            if (opcion!=2){
                switch(opcion){
                    case 1: 
                    do{
                        tipoUsuario=iniciarSesion();
                        }while(tipoUsuario==-1);
                    break;
                    case 2: break;
                    default: System.out.println("Opcion invalida");
                }
            }
        if (tipoUsuario!=-1 && opcion!=2) mostrarMenu(tipoUsuario);
    }while(opcion!=2);
    }
    public static void mostrarMenu(int usuario){
        switch (usuario){
            case 1: 
            int opcion2=4;
            do{
                System.out.println("Digite la opcion deseada:");
                System.out.println("1.Gestionar usuarios\n2.Gestionar inventario\n3.Gestionar Pedido\n4.Salir");
                opcion2=entrada.nextInt();
                if (opcion2!=4){
                    switch(opcion2){
                        case 1: gestionarUsuaios(2); break;
                        case 2: gestionarInventario(2); break;
                        case 3: gestionarPedidos(); break;
                        default: System.out.println("Opcion invalida");
                    }
                }
            }while(opcion2!=4);
            System.out.println("Fue un placer atenderle");
            break;
            case 2: 
            int opcion=2;
                do{
                    System.out.println("Digite la opcion deseada:");
                    System.out.println("1. Gestionar Pedidos\n2.salir de la sesion y del programa");
                    opcion = entrada.nextInt();
                    if (opcion!=2){
                        if (opcion==1) gestionarPedidos();
                        else System.out.println("Entrada invalida");
                    }
                }while(opcion!=2);
                System.out.println("Fue un placer servirle");
            break;
            default: System.out.println("Opcion invalida");
        }
    }
    public static int iniciarSesion(){
        int resultado=-1;
        System.out.println("Digite su usuario:");
        String usuario= entrada.next();
        System.out.println("Digite su contrasenia: ");
        String contrasenia= entrada.next();
        resultado=gestion.compararUsuario(usuario,contrasenia);
        return resultado;
    }
    public static void gestionarUsuaios(int opcion){
        if (opcion==1){
            System.out.println("Esta es la primera ejecucion.");
            gestion.registrarUsuario(0);
        }
        else{
            int opcionNavegacion=4;
            do{
                System.out.println("Digite la opcion deseada: ");
                System.out.println("1.Mostrar Usuarios\n2.Agregar usuarios\n3.Eliminar usuarios\n4.Salir");
                opcionNavegacion=entrada.nextInt();
                if (opcionNavegacion!=4){
                    switch(opcionNavegacion){
                        case 1: gestion.mostrarUsuarios(); break;
                        case 2: gestion.registrarUsuario(1); break;
                        case 3: gestion.eliminarUsuario(); break;
                        default: System.out.println("Opcion invalida");
                    }
                }
            }while(opcionNavegacion!=4);

        }
    }
    public static void gestionarInventario(int ejecucion){
        if (ejecucion==1){
            //Registro de los botones
            Boton madera,plastico,hierro,maderaC,maderaG,plasticoC,plasticoG,hierroC,hierroG;
            madera= new Boton(); madera.registrarBoton("456M56", "Boton", 30, 1.5f, "Variado", "Madera", 1.5f);
            plastico=new Boton(); plastico.registrarBoton("456M57", "Boton", 30, 1.0f, "Variado", "Plastico", 1.5f);
            hierro = new Boton(); hierro.registrarBoton("456M58", "Boton", 30, 2f, "Variado", "Hierro", 1.5f);
            maderaC=new Boton(); maderaC.registrarBoton("456C56", "Boton", 30, 1f, "Variado", "Madera", 1f);
            maderaG = new Boton(); maderaG.registrarBoton("456G56", "Boton", 30, 2f, "Variado", "Madera", 2f);
            plasticoC=new Boton(); plasticoC.registrarBoton("456C57", "Boton", 30, 0.5f, "Variado", "Plastico", 1f);
            plasticoG=new Boton(); plasticoG.registrarBoton("456G57", "Boton", 30, 1.5f, "Variado", "Plastico", 1.5f);
            hierroC = new Boton(); hierroC.registrarBoton("456C58", "Boton", 30, 1.5f, "Variado", "Hierro", 1f);
            hierroG = new Boton(); hierroG.registrarBoton("456G58", "Boton", 30, 2.5f, "Variado", "Hierro", 2f);
            listaMaterial.add(maderaC); listaMaterial.add(madera); listaMaterial.add(maderaG);
            listaMaterial.add(plasticoC); listaMaterial.add(plastico); listaMaterial.add(plasticoG);
            listaMaterial.add(hierroC); listaMaterial.add(hierro); listaMaterial.add(hierroG);
            //Registro de las telas
            Tela t1,t2,t3;
            t1 = new Tela();t1.registrarTela("455L21", "Tela", 30, 100f, "Azul", "Liso");
            t2 = new Tela();t2.registrarTela("455M21", "Tela", 30, 70f, "Azul Mezclilla", "Mezclilla");
            t3 = new Tela();t3.registrarTela("455G21", "Tela", 30, 120f, "Negra", "Gabardina");
            listaMaterial.add(t1); listaMaterial.add(t2); listaMaterial.add(t3);
            //Registro de Cierres
            Cierre c1,c2;
            c1=new Cierre(); c1.registrarCierre("454C22", "Cierre", 30, 15, "Variado", "Plastico", "Variada");
            c2= new Cierre(); c2.registrarCierre("452M22", "Cierre", 30, 17, "Variado", "Tela", "Variado");
            listaMaterial.add(c1); listaMaterial.add(c2);
        }
        else {
            int opcionInventario,cantidadIncrementar,cantidadDecrementar,pos=-1;
            do{
                System.out.println("Digite la opcion deseada:");
                System.out.println("1.Mostrar inventario\n2.Incrementar inventario\n3. Decrementar inventario\n4.Salir");
                opcionInventario= entrada.nextInt();
                if (opcionInventario!=4){
                    switch(opcionInventario){
                        case 1: System.out.println(listaMaterial); break;
                        case 2:
                            for (int i=0;i<listaMaterial.size();i++){
                                System.out.println(i+"."+listaMaterial.get(i));
                            }
                            do{
                                System.out.print("Digite el indice del elemnto al cual quiera incrementar su inventario: ");    
                                pos=entrada.nextInt();
                                if (pos<0 || pos>listaMaterial.size()-1) System.out.println("Algun dato erroneo, volver a digitar");
                            }while(pos<0 || pos>listaMaterial.size()-1);
                            do{
                                System.out.print("Digite la cantidad a incrementar: "); 
                                cantidadIncrementar=entrada.nextInt();
                                if (cantidadIncrementar<0) System.out.println("Cantidad invalida");
                            }while(cantidadIncrementar<0);
                            listaMaterial.get(pos).incrementarMaterial(cantidadIncrementar);
                        break;
                        case 3: 
                            for (int i=0;i<listaMaterial.size();i++){
                                System.out.println(i+"."+listaMaterial.get(i));
                            }   
                            do{
                                System.out.print("Digite la posicion de la cual decrementara: ");
                                opcionInventario=entrada.nextInt();
                                if (opcionInventario<0 || opcionInventario>listaMaterial.size()-1) System.out.println("Algun dato erroneo, volver a digitar");
                            }while(opcionInventario<0 || opcionInventario>listaMaterial.size()-1);
                                do{
                                    System.out.println("Digite la cantidad a decrementar");
                                    cantidadDecrementar = entrada.nextInt();
                                    if (cantidadDecrementar<0 ) System.out.println("Numero erroneo");
                                    else if (cantidadDecrementar>listaMaterial.get(pos).getCantidad()) System.out.println("Cantidad mayor a la existente en el inventario");
                                }while(cantidadDecrementar<0 || cantidadDecrementar>listaMaterial.get(pos).getCantidad());
                                listaMaterial.get(opcionInventario).descontarMaterial(cantidadDecrementar);
                        break;
                        default: System.out.println("Opcion invalida"); 
                        }
                }
            }while (opcionInventario!=4);
        }
    }
    public static void gestionarPedidos(){
        int respuesta;
        do{
            System.out.println("Digite la opcion deseada");
            System.out.println("1. Agregar un pedido\n2.Ver los pedidos realizados\n3.Eliminar un pedido\n4.Salir");
            respuesta= entrada.nextInt();
            if (respuesta!=4){
                switch (respuesta){
                    case 1: pedidos.agregarVenta(); break;
                    case 2:pedidos.verPedidos(); break;
                    case 3:pedidos.eliminarPedido(); break;
                    default: System.out.println("Opcion invalida");
                }
            }
        }while(respuesta!=4);
    }
}