package com.daw.gfigueras;

public class Pintura extends ObraDeArte{
    private String tecnica;

    public Pintura(int id, Double precio, Double altura, Double peso, int nPiezas, String tipo, String nombre,
            String autor, String descripcion, String tecnica) throws IllegalArgumentException {
        super(id, precio, altura, peso, nPiezas, tipo, nombre, autor, descripcion);
        checkTecnica(tecnica);
        this.tecnica = tecnica;
    }

    //GETTERS Y SETTERS
    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
    
    //METHODS
    private void checkTecnica(String tecnica) throws IllegalArgumentException{
        if(!(tecnica.equals("Acuarela")) && !(tecnica.equals("Oleo")) && !(tecnica.equals("Carboncillo"))){
            throw new IllegalArgumentException("La tecnica debe ser: Acuarela, Oleo o Carboncillo");
        }
    }



    
}
