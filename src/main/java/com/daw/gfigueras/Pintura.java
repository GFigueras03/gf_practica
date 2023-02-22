package com.daw.gfigueras;

public class Pintura extends ObraDeArte{
    private final double DESCUENTO = 0.10;
    private String tecnica;
    

    public Pintura(int id, Double precio, Double altura, Double peso, int nPiezas, String tipo, String nombre,
            String autor, String descripcion, String tecnica){
        super(id, precio, altura, peso, nPiezas, tipo, nombre, autor, descripcion);
        this.tecnica = tecnica;
    }

    //GETTERS Y SETTERS
    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica (String tecnica){
        this.tecnica = tecnica;
    }
    
   @Override
   public double getDescuento() {
       return (DESCUENTO * 100);
   }

    //METHODS

    @Override
    public double calcularDescuento(double precio) {
        return precio * DESCUENTO;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + getTipo() + ", Técnica: " + getTecnica();
    }

    
}
