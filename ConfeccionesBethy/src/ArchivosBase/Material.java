package ArchivosBase;
public class Material{
    protected String id;
    protected String nombre;
    protected int cantidad;
    protected float precio;
    public void registrarMaterial(String id, String nombre, int cantidad, float precio){
        this.id=id;
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.precio=precio;
    }
    public void incrementarMaterial(int cantidad){
        this.cantidad+=cantidad;
    }
    public void descontarMaterial(int cantidad){
        this.cantidad-=cantidad;
    }
    public String getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public float getPrecio(){
        return precio;
    }
}