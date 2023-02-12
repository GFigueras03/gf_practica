package com.daw.gfigueras;

public abstract class ObraDeArte {
    //!CONSTANTES
    //!ATRIBUTES
    protected int id;
    protected int nPiezas;
    protected double precio;
    protected double altura;
    protected double peso;
    protected String tipo;
    protected String nombre;
    protected String autor;
    protected String descripcion;

    protected String[] esculturaMaterial = {"Hierro", "Cobre", "Acero"};
    protected String[] pctoricaMaterial = {"Oleo", "Acuarela", "Carboncillo"};

    //*CONSTRUCTOR
    public ObraDeArte(int id, Double precio, Double altura, Double peso, int nPiezas, String tipo, String nombre, String autor,String descripcion) throws IllegalArgumentException {
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
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
    public abstract double calcularDescuento(double precio);
    public abstract double getDescuento();

    @Override
    public String toString() {
        return "ObraDeArte id=" + id + ", nPiezas=" + nPiezas + ", precio=" + precio + ", altura=" + altura + ", peso="
                + peso + ", nombre=" + nombre + ", autor=" + autor + ", descripcion=" + descripcion;
    }
    
   

}
