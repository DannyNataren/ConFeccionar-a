package ArchivosBase;
import java.util.ArrayList;
import java.util.Scanner;
public class GestionUsuarios {
    static Scanner entradaG = new Scanner(System.in);
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public void mostrarUsuarios(){
        System.out.println(listaUsuarios);
    }
    public void registrarUsuario(int ejecucion){
        int respuestaC=1,tipo=0;
        if (ejecucion==0){
            Usuario usuario = new Usuario("Elizabeth", 1, "Bethy450420");
            Usuario usuario2  = new Usuario("Erika", 2, "987654321Erika");
            listaUsuarios.add(usuario);
            listaUsuarios.add(usuario2);
        }
        else{
            String key;
            do{
                System.out.println("Digite el nombre de usuario:");
                String user= entradaG.next();
                do{
                    System.out.println("Digite el tipo de usuario que sera: 1-Administrador 2-Empleado");
                    tipo = entradaG.nextInt();
                    if (tipo<1 || tipo>2) System.out.println("Numero erroneo");
                }while(tipo<1 || tipo>2);
                System.out.println("Digite la nueva contraseña que tendra:");
                key = entradaG.next();
                Usuario usuario= new Usuario(user, tipo, key);
                listaUsuarios.add(usuario);
                System.out.println("Desea agregar otro usuario 1-si 2-no");
                respuestaC=entradaG.nextInt();
                if (respuestaC!=1 && respuestaC!=2) System.out.println("Opcion invalida");
            }while(respuestaC==1);
            System.out.println("Usuario aniadido correctamente");
        }
    }
    public void eliminarUsuario(){
        int pos=-1;
        for (int i=0;i<listaUsuarios.size();i++){
            System.out.println((i)+". "+listaUsuarios.get(i));
        }
        System.out.println("Digite el nombre a eliminar: ");
        String usuario= entradaG.next();
        for (int i=0;i<listaUsuarios.size();i++){
            if (listaUsuarios.get(i).getUsuario().compareTo(usuario)==0)
                pos = i;
        }
        if (pos>=0){
            listaUsuarios.remove(pos);
            System.out.println("Ususario eliminado");
        }
        else System.out.println("No existe tal usuario");
    }
    public int compararUsuario(String usuario, String contrasenia){
        int pos=-1;
        for (int i=0;i<listaUsuarios.size();i++){
            if (listaUsuarios.get(i).getUsuario().compareTo(usuario)==0){
                if (listaUsuarios.get(i).getKey().compareTo(contrasenia)==0)
                    pos = i;
                else break;
            }
        }
        if (pos!=-1)
            return (listaUsuarios.get(pos).getTipoUsuario());
        return -1;
    }
}