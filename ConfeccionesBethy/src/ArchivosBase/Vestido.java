package ArchivosBase;
public class Vestido extends Prenda {
    private String tipo;
    private String disenio;
    private String talla;
    private float precioVestido=0;
    public Vestido(String tipo, String disenio, String talla){
        this.tipo=tipo;
        this.disenio=disenio;
        this.talla=talla;
    }
    @Override
    public float calcularTotal(){
        if (tipo.compareTo("Boda")==0){
            if (disenio.compareTo("Sencillo")==0){
                precioVestido+=5000;
            }
            else if (disenio.compareTo("Personalizado")==0){
                precioVestido+=10000;
            }
            switch(talla){
                case "S": precioVestido+=0; break;
                case "M": precioVestido+=1000; break;
                case "L": precioVestido+=2000; break;
                case "XL": precioVestido+=3000; break;
                case "XXL": precioVestido+=4000; break;
                default: System.out.println("Entrada invalida");
            }
        }
        else if(tipo.compareTo("XV anios")==0){
            if (disenio.compareTo("Sencillo")==0){
                precioVestido+=4000;
            }
            else if (disenio.compareTo("Personalizado")==0){
                precioVestido+=7000;
            }
            switch(talla){
                case "S": precioVestido+=0; break;
                case "M": precioVestido+=1000; break;
                case "L": precioVestido+=2000; break;
                case "XL": precioVestido+=3000; break;
                case "XXL": precioVestido+=3500; break;
                default: System.out.println("Entrada invalida");
            }
        }
        return precioVestido;
    }
    public String toString(){
        return ("Vestido de "+tipo+". Talla: "+talla+". Y con un precio de "+precioVestido+" pesos MXN");
    }
}
