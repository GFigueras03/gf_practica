package com.daw.gfigueras;

public class ObraDeArte {
    //!ATRIBUTES
    private int id;
    private int nPiezas;
    private double precio;
    private double altura;
    private double peso;
    private String tipo;
    private String nombre;
    private String autor;
    private String descripcion;

    //*CONSTRUCTOR
    public ObraDeArte(int id, int precio, int altura, int peso, int nPiezas, String tipo, String nombre, String autor,
            String descripcion) {
        this.id = id;
        this.precio = precio;
        this.altura = altura;
        this.peso = peso;
        this.nPiezas = nPiezas;
        this.tipo = tipo;
        this.nombre = nombre;
        this.autor = autor;
        this.descripcion = descripcion;
    }
    //?GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getnPiezas() {
        return nPiezas;
    }

    public void setnPiezas(int nPiezas) {
        this.nPiezas = nPiezas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //?METHODS
    

}
