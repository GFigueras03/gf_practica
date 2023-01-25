package com.daw.gfigueras;

public class ObraDeArte {
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

    protected int importe_peso;
    protected int importe_altura;

    protected String[] esculturaMaterial = {"Hierro", "Cobre", "Acero"};
    protected String[] pctoricaMaterial = {"Oleo", "Acuarela", "Carboncillo"};

    //*CONSTRUCTOR
    public ObraDeArte(int id, Double precio, Double altura, Double peso, int nPiezas, String tipo, String nombre, String autor,
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
    public int pesaMasde1Kg(ObraDeArte obra){ // METODO QUE DEVUELVE BOOLEAN SEGUN PESO
        if((obra.getPeso() * 1000) >= 1){ // PESA MAS DE 1KG
            importe_peso = 100;
            return importe_peso;
        }else{
            importe_peso = 20;
            return importe_peso;
        }
    }
    public int alturaMasDe2m(ObraDeArte obra){
        if((obra.getAltura() >= 2.0 )){
            importe_altura = 100;
            return importe_altura;
        }
        else{
            importe_altura = 20;
            return importe_altura;
        }
    }

    public int plusNpiezas(ObraDeArte obra){
        int precio = 0;
        if (obra.getnPiezas() > 2) { //INCREMENTO NºPIEZAS
            precio = (precio + ((obra.getnPiezas() -2 ) * 10));
        }
        return precio;
    }
    public String importeAdiccional(int nPiezas){
        String texto = "";
        if(nPiezas > 2 ){
            for(int i = 3; i< nPiezas + 1; i++){
                texto += "Importe adicional - Pieza " + i + " (€): 10\n";
            }
        }else{
            texto = "";
        }
        return texto;
    }

   

}
