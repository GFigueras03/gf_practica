package com.daw.gfigueras;
import static com.daw.gfigueras.Constantes.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Galeria {
    //CONSTANTES

    //ATRIBUTOS
    private static ArrayObras obrasGuardadas            = new ArrayObras();
    private static boolean menu                         = true;


    public static void main(String[] args) {
        Pintura obra1       = new Pintura(0, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica","P.Picasso", "Cuadro Guerra civil", "Oleo"); 
        Pintura obra2       = new Pintura(1, 200.0, 1.0, 1.0, 1, "Pintura",  "La Vie","P.Picasso", "Pintura de Oleo", "Oleo"); 
        Pintura obra3       = new Pintura(2, 300.0, 1.4, 1.0, 1, "Pintura",  "El Sueño","P.Picasso", "Pintura de Acuarela", "Acuarela"); 
        Pintura obra4       = new Pintura(3, 400.0, 1.0, 1.0, 1, "Pintura",  "Retrato de Dora Maar","P.Picasso", "Pintura de Carboncillo", "Carboncillo"); 
        Escultura obra5     = new Escultura(4, 350.0, 1.0, 0.8, 1, "Escultura",  "El Piel roja","U.Checa", "Escultura de Acero", "Acero"); 

        obrasGuardadas.push(obra1);
        obrasGuardadas.push(obra2);
        obrasGuardadas.push(obra3);
        obrasGuardadas.push(obra4);
        obrasGuardadas.push(obra5);

        ejecutarMenu();
        
            
    }// *MAIN

    // ?METODOS

    //MENU
    public static void ejecutarMenu() {
      try{
        while (menu == true) {
            int option = imprimirInteger(BIENVENIDO_GALERIA);
            switch (option) {
                case CASE_MENU_TODAS_OBRAS:
                    menuMostrarTodasLasObras();
                    volverAlMenu();
                    break;

                case CASE_MENU_DAR_ALTA_OBRA:
                    obrasGuardadas.push(darAltaObra());
                    volverAlMenu();
                    break;

                case CASE_MENU_MOD_DATOS:
                    modificarDatos();
                    break;

                case CASE_MENU_VIS_DATOS:
                    menuVisualizarDatos();
                    break;

                case CASE_MENU_OBT_PRECIO:
                   menuObtenerPrecio();
                   break;

                case CASE_MENU_IMPR_ETIQUETA:
                    menuMostrarEtiqueta();
                    break;

                case CASE_MENU_SALIR:
                    System.out.println(TEXTO_AMARILLO + SALIR + TEXTO_BLANCO);
                    menu = false;
                    break;

                default:
                    System.out.println(ERROR_MENU);
                    volverAlMenu();
                    break;
            }
        }
      }catch(InputMismatchException imme){
        System.out.println(ERROR_MENU);
        volverAlMenu();
      }
    }
    // DAR DE ALTA UNA OBRA
    public static ObraDeArte darAltaObra() {
        ObraDeArte obra         = null;
        boolean tipoEsCorrecto  = false;
        int id                  = calcularId();
        int piezas              = imprimirInteger(TEXTO_NºPIEZAS);
        double precio           = imprimirDouble(TEXTO_PRECIO);
        double altura           = imprimirDouble(TEXTO_ALTURA);
        double peso             = imprimirDouble(TEXTO_PESO);
        String tipo             = imprimirString(TEXTO_TIPO);
        String nombre           = imprimirString(TEXTO_NOMBRE);
        String autor            = imprimirString(TEXTO_AUTOR);
        String descripcion      = imprimirString(TEXTO_DESCRIPCION);
        do{
            switch (tipo.toUpperCase()) {
                case CHECK_ESCULTURA:
                    String material = imprimirString(TEXTO_MATERIAL);
                    checkMaterial(material);
                    obra = new Escultura(id, precio, altura, peso, piezas, tipo, nombre, autor, descripcion,material);
                    System.out.println(ESCULTURA_TRUE);
                    tipoEsCorrecto = true;
                    break;

                case CHECK_PINTURA:
                    String tecnica = imprimirString(TEXTO_TECNICA);
                    checkTecnica(tecnica);
                    obra = new Pintura(id, precio, altura, peso, piezas, tipo, nombre, autor, descripcion, tecnica);
                    System.out.println(PINTURA_TRUE);
                    tipoEsCorrecto = true;
                    break;

                default:
                    tipoEsCorrecto = false;
                    tipo = imprimirString(TEXTO_TIPO_INCORRECTO);
                    break;
            }
        }while(!tipoEsCorrecto);  
        return obra;
    }
   
    public static int calcularId(){
        int id = obrasGuardadas.getTam();
            return id;
        }

    public static void checkTecnica(String tecnica){
        if(!(tecnica.toUpperCase().equals(ACUARELA)) && !(tecnica.toUpperCase().equals(OLEO)) && !(tecnica.toUpperCase().equals(CARBONCILLO))){
            tecnica = imprimirString(TEXTO_TECNICA_ERR);
            checkTecnica(tecnica);
        }
    }
    public static void checkMaterial(String material){
        if(!(material.toUpperCase().equals(HIERRO)) && !(material.toUpperCase().equals(COBRE)) && !(material.toUpperCase().equals(ACERO))){
            material = imprimirString(TEXTO_MATERIAL_ERR);
            checkMaterial(material);
        }
    }
    //METODOS DEL MENU

    public static void volverAlMenu(){
        imprimirString("\n" + VOLVER_MENU);
        System.out.println(TEXTO_POR_DEFECTO);
        ejecutarMenu();
    }

    public static void menuMostrarTodasLasObras() { // MOSTRAR OBRAS PARA EL MENU
        System.out.println(TEXTO_VERDE + TEX_MOSTRAR_TODAS_OBRAS);
        for (int i = 0; i < obrasGuardadas.getTam(); i++) {
            System.out.println(NOMBRE_TODAS_OBRAS + obrasGuardadas.getObra(i).getNombre() + ID_TODAS_OBRAS + obrasGuardadas.getObra(i).getId());
        }
    }

    public static void menuVisualizarDatos(){
        try{
            int obraEscogida = imprimirInteger(CLEAR_CONSOLE + OPCION0_MENU);
                if (obrasGuardadas.getObra(obraEscogida).getId() == obraEscogida) {
                    System.out.println(mostrarObra(obrasGuardadas.getObra(obraEscogida)));
                    volverAlMenu();
                } 
        }catch(IndexOutOfBoundsException ioobe){
            System.out.println(ERROR_ID_SOLCITADO);
            volverAlMenu();
        }
    }
    public static void menuObtenerPrecio(){
        try{
            int obraEscogidaDos = imprimirInteger(CLEAR_CONSOLE + OPCION4_MENU);
                if(obrasGuardadas.getObra(obraEscogidaDos).getId() == obraEscogidaDos){
                    System.out.println(obtenerPrecioVentaEtiqueta(obrasGuardadas.getObra(obraEscogidaDos), obrasGuardadas.getObra(obraEscogidaDos).getDescuento()));
                    volverAlMenu();
                }
            }catch(IndexOutOfBoundsException ioobe){
                System.out.println(ERROR_ID_SOLCITADO);
                volverAlMenu();
            }
    }
    
    public static void menuMostrarEtiqueta(){
        try{
            int obraEscogidaTres = imprimirInteger(CLEAR_CONSOLE + OPCION5_MENU);
            if(obrasGuardadas.getObra(obraEscogidaTres).getId() == obraEscogidaTres){
                System.out.println(obtenerTicket(obrasGuardadas.getObra(obraEscogidaTres)));
                    volverAlMenu();
                }
        }catch(IndexOutOfBoundsException ioobe){
            System.out.println(ERROR_ID_SOLCITADO);
            volverAlMenu();
        } 
    }

    //METODO OBTENER PRECIO VENTA

    public static double obtenerPrecioVenta(ObraDeArte obra) { // OBTENER PRECIO DE VENTA SIN PORCENTAJES FINALES
        double comisionGaleriaEuros = ((obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100);
        int importePeso             = obra.calcularPrecioPeso();
        int importeAltura           = obra.calcularPrecioAltura();
        int importePlusPiezas       = obra.calcularPlusPiezas();

        double precio = obra.getPrecio();
        precio += comisionGaleriaEuros;
        precio += importeAltura;
        precio += importePeso;
        precio += importePlusPiezas;
        return precio;
    }

    public static double calcularPrecioFinalVenta(ObraDeArte obra) {
        double precio = obtenerPrecioVenta(obra) - obra.calcularDescuento(obtenerPrecioVenta(obra));
        return precio * CONVERSOR_DOLARES;
    }

    //METODO MODIFICAR DATOS

    public static void modificarDatos() {
        boolean menu = true;
        int idPedido = imprimirInteger(CLEAR_CONSOLE + MODIFICAR_OBRA_ID);
        try{
            if(obrasGuardadas.getObra(idPedido).getId() == idPedido){
            System.out.println(mostrarObra(obrasGuardadas.getObra(idPedido)));
            int idCampoelegido = imprimirInteger(MENU_MODIFICAR);
            while (menu == true) {
                switch (idCampoelegido) {
                    case CASE_MOD_NOMBRE:
                        obrasGuardadas.getObra(idPedido).setNombre(imprimirString(CAMBIAR_NOMBRE));
                        menu = false;
                        break;

                    case CASE_MOD_AUTOR:
                        obrasGuardadas.getObra(idPedido).setAutor(imprimirString(CAMBIAR_AUTOR));
                        menu = false;
                        break;

                    case CASE_MOD_PRECIO:
                        obrasGuardadas.getObra(idPedido).setPrecio(imprimirDouble(CAMBIAR_PRECIO));
                        menu = false;
                        break;

                    case CASE_MOD_ALTURA:
                        obrasGuardadas.getObra(idPedido).setAltura(imprimirDouble(CAMBIAR_ALTURA));
                        menu = false;
                        break;

                    case CASE_MOD_PESO:
                        obrasGuardadas.getObra(idPedido).setPeso(imprimirDouble(CAMBIAR_PESO));
                        menu = false;
                        break;

                    case CASE_MOD_NPIEZAS:
                        obrasGuardadas.getObra(idPedido).setnPiezas(imprimirInteger(CAMBIAR_NºPIEZAS));
                        menu = false;
                        break;

                    case CASE_MOD_TIPO: // MODIFICAMOS TIPO CHECKEANDO Y CAMBIANDO LA TECNICA/MATERIAL
                        if (obrasGuardadas.getObra(idPedido).getTipo().toUpperCase().equals(CHECK_ESCULTURA) || 
                            obrasGuardadas.getObra(idPedido).getTipo().toUpperCase().equals(CHECK_PINTURA)) {
                                
                            String tipo = imprimirString(TEXTO_TIPO);
                            if (tipo.toUpperCase().equals(CHECK_PINTURA)) {
                                String tecnica = imprimirString(TEXTO_TECNICA);

                                Pintura obraTemp = (Pintura)obrasGuardadas.getObra(idPedido);
                                obraTemp.setTecnica(tecnica);
                                
                                menu = false;
                                break;

                            } else if (tipo.toUpperCase().equals(CHECK_ESCULTURA)) {
                                String material = imprimirString(TEXTO_MATERIAL);

                                Escultura obraTemp = (Escultura)obrasGuardadas.getObra(idPedido);
                                obraTemp.setMaterial(material);

                                menu = false;
                                break;

                            } else {
                                System.out.println(TEXTO_ERROR);

                            }
                        }
                    case CASE_MOD_TEC_MAT:
                        if (obrasGuardadas.getObra(idPedido).getTipo().toUpperCase().equals(CHECK_ESCULTURA)) {
                            Escultura escTemp = (Escultura)obrasGuardadas.getObra(idPedido);
                            String material = imprimirString(TEXTO_MATERIAL);
                            escTemp.setMaterial(material);
                            menu = false;

                        } else {
                            Pintura pintTemp = (Pintura)obrasGuardadas.getObra(idPedido);
                            String tecnica = imprimirString(TEXTO_TECNICA);
                            pintTemp.setTecnica(tecnica);
                            menu = false;
                        }
                        break;
                    case CASE_MOD_DESCRIPCION:
                        imprimirString(CAMBIAR_DESCRIPCION);
                        obrasGuardadas.getObra(idPedido).setDescripcion(imprimirString(CAMBIAR_DESCRIPCION));
                        menu = false;
                        break;

                    case CASE_MOD_CERRAR_MENU:
                        menu = false;
                        break;
                }
                System.out.println(mostrarObra(obrasGuardadas.getObra(idPedido)));
            }
        }
        }catch(IndexOutOfBoundsException ioobe){
            System.out.println(ERROR_ID_SOLCITADO);
            volverAlMenu();
        }
    }

    //METODOS MOSTRAR OBRAS Y STRINGS 
    public static String mostrarObra(ObraDeArte obra) { // MUESTRA OBRA POR FORMATO CORTO
        return TEXTO_VERDE + MOSTRAR_OBRA_STRING + TEXTO_BLANCO + String.format(FORMATO_VISUALIZAR,
                obra.getNombre(), obra.getId(), obra.getAutor(), obra.getPrecio(), obra.getAltura(), obra.getPeso(),
                obra.getnPiezas(), obra.getDescripcion(), obra.getTipo() );
    }

    public static String obtenerTicket(ObraDeArte obra) {
        return TEXTO_VERDE + ETIQUETA_STRING + TEXTO_BLANCO + "Nombre: " + obra.getNombre() + "\nAutor: " + obra.getAutor()
                + "\nDescripcion: " +
                obra.getDescripcion() + "\n";
    }

    public static String obtenerPrecioVentaEtiqueta(ObraDeArte obra, double descuento) { // MUESTRA OBRA POR FORMATO
        return  TEXTO_VERDE + PRECIO_VENTA_STRING + TEXTO_BLANCO + String.format(FORMATO_ETIQUETA, obra.getNombre(),
            obra.getAltura(), obra.getPeso(), obra.getnPiezas(), obra.getPrecio(),
            (obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100, obra.calcularPrecioPeso(),
            obra.calcularPrecioAltura(),
            obra.imprimirImporteAdiccional(), obtenerPrecioVenta(obra), descuento, obra.getTipo(),
            obra.calcularDescuento(obtenerPrecioVenta(obra)),
            calcularPrecioFinalVenta(obra));
    }

    //METODOS SCANNER CON TEXTO PERSONALIZADO

     public static String imprimirString(String texto) {
        Scanner textSc = new Scanner(System.in);
        System.out.print(TEXTO_BLANCO + texto + TEXTO_MORADO);
        String resultado = textSc.nextLine();
        return resultado;
       
    }

    public static int imprimirInteger(String texto) {
        int resultado = -1;
        Scanner numberSc = new Scanner(System.in);
        try{
            System.out.print(TEXTO_BLANCO + texto + TEXTO_MORADO);
            resultado = numberSc.nextInt();
            return resultado;

        }catch(InputMismatchException imme){
            return -1;
        }
     
    }

    public static double imprimirDouble(String texto) {
        Scanner doubleSc = new Scanner(System.in);
        System.out.print(TEXTO_BLANCO + texto + TEXTO_MORADO);
        double resultado = doubleSc.nextDouble();
        return resultado;

    }
}

