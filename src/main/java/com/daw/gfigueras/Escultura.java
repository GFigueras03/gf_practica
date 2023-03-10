package com.daw.gfigueras;
public class Escultura extends ObraDeArte {

    //!ATRIBUTES
    private final double DESCUENTO = 0.20;
    private final double SOBRECOSTE_ESCULTURA = 50.0;
    private String material;

    //*CONSTRUCTOR

    public Escultura(int id, Double precio, Double altura, Double peso, int nPiezas, String tipo, String nombre,
            String autor, String descripcion, String material){
        super(id, precio, altura, peso, nPiezas, tipo, nombre, autor, descripcion);
        this.material = material;
    }

    //?GETTERS & SETTERS
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material){
        this.material = material;
    }
    //?

    //?METHODS
    @Override
    public double getDescuento() {
        return (DESCUENTO * 100);
    }

    @Override
    public double calcularDescuento(double precio) {
        return (precio * DESCUENTO) + SOBRECOSTE_ESCULTURA;
    }
    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + getTipo() + ", Material: " + getMaterial();
    }

    
}
