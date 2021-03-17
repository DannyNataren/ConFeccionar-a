package ArchivosBase;
public class Cierre extends Material {
    private String color;
    private String material;
    private String longitud;
    public void registrarCierre(String id, String nombre, int cantidad, float precio,String color, String material, String longitud){
        super.registrarMaterial(id, nombre, cantidad, precio);
        this.color=color;
        this.material=material;
        this.longitud=longitud;
    }
    public void descontarCierre(int cantidad){
        super.descontarMaterial(cantidad);
    }
    public String toString(){
        return (super.getNombre()+" de tipo "+material+", color "+ color+", longitud de "+longitud+"cm y un id: "+id+". Cantidad: "+super.getCantidad()+". Precio: "+super.getPrecio()+" pesos\n");
    }
}
