package ArchivosBase;
import java.util.Scanner;
public class Cliente {
    static Scanner entradaC = new Scanner(System.in);
    private String nombres;
    private String apellidos;
    private String numTelefono;
    public void agregarCliente(){
        System.out.println("Digite los nombre del cliente:");
        nombres=entradaC.nextLine();
        System.out.println("Digite los apellidos cliente:");
        apellidos=entradaC.nextLine();
        boolean validarNum=false;
        do{        
            System.out.println("Digite su numero de telefono");
            numTelefono=entradaC.next();
            validarNum=validarNumero();
            if (!validarNum) System.out.println("Numero de digitos menor al permitido");
        }while(validarNum==false);
    }
    public boolean validarNumero(){
        if (numTelefono.length()==10)
            return true;
        return false;
    }
    public String toString(){
        return ("cliente: "+nombres+" "+apellidos+". Numero de telefono: "+numTelefono);
    }
}
