package poo;

import java.util.ArrayList;

public class Edificio {
    private ArrayList<Elevador> elevadores;
    private int maximoAndares;
    private int minimoAndares;
    private int maximoElevadores;
    private int minimoElevadores;

    public Edificio(){
        elevadores = new ArrayList<>();
        maximoAndares = 70;
        minimoAndares = 4;
        maximoElevadores = 6;
        minimoElevadores = 1;
    }
    public boolean configurarEdificio(int numeroAndares, int numeroElevadores){
        return false;
    }
    public int solicitarElevador(int andarUsuario){
        return 0;
    }
    public boolean viajar(int andarDestino){
        return false;
    }
    public String estatisticas(){
        return "";
    }
}
