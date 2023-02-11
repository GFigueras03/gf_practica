package com.daw.gfigueras;

public class AlmacenObras {
    private ObraDeArte[] obrasGuardadas;
    private final int TAM_INICIAL   = 5;
    
    private int tamAlmacen          = TAM_INICIAL;
    private int ultimaObraGuardada  = 0;

    public AlmacenObras(){
        obrasGuardadas = new ObraDeArte[TAM_INICIAL];
    }

    public void push(ObraDeArte obra){
        if(ultimaObraGuardada == tamAlmacen){
            obrasGuardadas = cambiarTam(tamAlmacen);
        }
        obrasGuardadas[ultimaObraGuardada] = obra;
        ultimaObraGuardada++;
    }

    public ObraDeArte[] cambiarTam(int size){
        tamAlmacen++;
        ObraDeArte[] temp = new ObraDeArte[tamAlmacen];


        for(int i = 0; i< size; i++){
            temp[i] = obrasGuardadas[i];
        }
        return temp;
    }

    public String getObrasGuardadas() {
        String msg = "";
        for(int i = 0; i< tamAlmacen; i++){
            msg = obrasGuardadas[i].getNombre() + "\n";
        }
        return msg;
    }

    public ObraDeArte getObra(int index){
        return obrasGuardadas[index];
    }

    public int getTam(){
        return tamAlmacen;
    }
    
}
