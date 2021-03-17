package ArchivosBase;
public class Tela extends Material {
    private String color;
    private String material;
    public void registrarTela(String id, String nombre, int cantidad, float precio, String color, String material){
        super.registrarMaterial(id,nombre,cantidad,precio);
        this.color=color;
        this.material=material;
    }
    public void descontarTela(int cantidad){
        super.descontarMaterial(cantidad);
    }
    public String toString(){
        return (super.getNombre()+" tipo "+material+"y Color: "+color+". Con ID: "+super.getId()+". Cantidad de metros: "+super.getCantidad()+" y precio: "+super.getPrecio()+" pesos\n");
    }
}
