package com.daw.gfigueras;

public class Pintura extends ObraDeArte{
    private String tecnica;

    public Pintura(int id, Double precio, Double altura, Double peso, int nPiezas, String tipo, String nombre,
            String autor, String descripcion, String tecnica) throws IllegalArgumentException {
        super(id, precio, altura, peso, nPiezas, tipo, nombre, autor, descripcion);
        this.tecnica = tecnica;
    }
    
}
