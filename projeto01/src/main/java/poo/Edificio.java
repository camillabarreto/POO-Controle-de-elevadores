package poo;

import java.util.ArrayList;

public class Edificio {
    private ArrayList<Elevador> listaElevadores;
    private int numeroAndares;
    private int maxAndares;
    private int minAndares;
    private int maxElevadores;
    private int minElevadores;

    public Edificio(){
        listaElevadores = new ArrayList<>();
        numeroAndares = 0;
        maxAndares = 70;
        minAndares = 4;
        maxElevadores = 6;
        minElevadores = 1;
    }

    public String limiteAndares(){
        return minAndares + " até " + maxAndares;
    }

    public String limiteElevadores(){
        return minElevadores + " até " + maxElevadores;
    }

    public boolean configuraEdificio(int numeroAndares, int numeroElevadores){
        if((numeroAndares < minAndares) || (numeroAndares > maxAndares)) return false;
        if((numeroElevadores < minElevadores) || (numeroElevadores > maxElevadores)) return false;
        if(listaElevadores.size() > 0){
            listaElevadores.clear();
        }
        for (int i = 0; i < numeroElevadores; i++) {
            listaElevadores.add(new Elevador());
        }
        this.numeroAndares = numeroAndares;
        return true;
    }

    public boolean solicitarElevador(int andarUsuario){
        if(listaElevadores.size() == 0) return false;
        if((andarUsuario < 0) || (andarUsuario >= numeroAndares)) return false;
        int index = 0;
        int dif0 = listaElevadores.get(index).andarAtual() - andarUsuario;
        for (Elevador e: listaElevadores) {
            if(e.andarAtual() == andarUsuario) return true;
            int dif1 = e.andarAtual() - andarUsuario;
            if(Math.abs(dif1) < Math.abs(dif0)){
                dif0 = dif1;
                index = listaElevadores.indexOf(e);
            }else if(Math.abs(dif1) == Math.abs(dif0)){
                if(e.viagens() < listaElevadores.get(index).viagens()){
                    dif0 = dif1;
                    index = listaElevadores.indexOf(e);
                }else if(e.viagens() == listaElevadores.get(index).viagens()){
                    if(dif1 > dif0){
                        dif0 = dif1;
                        index = listaElevadores.indexOf(e);
                    }
                }
            }
        }
        listaElevadores.get(index).viajar(andarUsuario);
        return true;
    }

    public boolean solicitarViagem(int andarDestino, int index){
        if(listaElevadores.size() == 0) return false;
        if((andarDestino < 0)||(andarDestino > numeroAndares)) return false;
        if((index < 0 ) || (index >= listaElevadores.size())) return false;
        listaElevadores.get(index).viajar(andarDestino);
        return true;
    }

    public StringBuilder listaRevisão(){
        StringBuilder str = new StringBuilder();
        if(listaElevadores.size() == 0){
            str.append("Não há elevadores disponíveis, configure o edifício");
            return str;
        }
        for (Elevador e: listaElevadores) {
            if(e.viagens() > 90){
                str.append("Elevador " + listaElevadores.indexOf(e) + " > " + e.estatisticas() + "\n");
            }
        }
        if(str.length() == 0){
            str.append("Não há elevadores precisando de revisão");
            return str;
        }
        return str;
    }

    public StringBuilder estatisticas(){
        StringBuilder str = new StringBuilder();
        if(listaElevadores.size() == 0){
            str.append("Não há elevadores disponíveis, configure o edifício");
            return str;
        }
        for (Elevador e: listaElevadores) {
            str.append("Elevador " + listaElevadores.indexOf(e) + " > " + e.estatisticas() + "\n");
        }
        return str;
    }
}
