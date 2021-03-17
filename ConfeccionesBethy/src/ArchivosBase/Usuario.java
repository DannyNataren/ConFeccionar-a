package ArchivosBase;
public class Usuario {
    private String usuario;
    private int tipoUsuario;
    private String key;
    public Usuario(String usuario, int tipoUsuario, String key){
        this.usuario=usuario;
        this.tipoUsuario=tipoUsuario;
        this.key=key;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getKey(){
        return key;
    }
    public int getTipoUsuario(){
        return tipoUsuario;
    }
    public String toString(){
        return ("Usuario: "+usuario+". Tipo de usuario: "+tipoUsuario+"\n");
    }
}
