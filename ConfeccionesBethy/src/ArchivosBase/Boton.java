package ArchivosBase;
public class Boton extends Material {
    private String color;
    private String material;
    private float radio;
    public void registrarBoton(String id, String nombre, int cantidad, float precio, String color,String material,float radio){
        super.registrarMaterial(id, nombre, cantidad, precio);
        this.color=color;
        this.material=material;
        this.radio=radio;
    }
    public void descontarBoton(int cantidad){
        super.descontarMaterial(cantidad);
    }
    public String toString(){
        return (super.getNombre()+" tipo "+material+", color "+color+" y radio"+radio+". Con id "+super.getId()+", cantidad: "+super.getCantidad()+" y precio: "+super.getPrecio()+" pesos\n");
    }
}
