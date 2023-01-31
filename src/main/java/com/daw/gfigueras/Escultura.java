package com.daw.gfigueras;
public class Escultura extends ObraDeArte {

    //!ATRIBUTES
    private String material;

    //*CONSTRUCTOR

    public Escultura(int id, Double precio, Double altura, Double peso, int nPiezas, String tipo, String nombre,
            String autor, String descripcion, String material) throws IllegalArgumentException{
        super(id, precio, altura, peso, nPiezas, tipo, nombre, autor, descripcion);
        checkMaterial(material);
        this.material = material;
    }

    //?GETTERS & SETTERS
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) throws IllegalArgumentException {
        checkMaterial(material);
        this.material = material;
    }
    //?

    //?METHODS
    private void checkMaterial(String material) throws IllegalArgumentException{
        if(!(material.equals("Acero")) && !(material.equals("Cobre")) && !(material.equals("Hierro"))){
            throw new IllegalArgumentException("EL material debe ser: Acero, Cobre o Hierro");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + getTipo() + ", Material: " + getMaterial();
    }

    
}
