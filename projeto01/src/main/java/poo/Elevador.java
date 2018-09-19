package poo;

public class Elevador {
    private int viagens;
    private int andarAtual;
    private Botoes botoes;

    public Elevador(int andares){
        this.viagens = 0;
        this.andarAtual = 0;
        this.botoes = new Botoes(andares);
    }
    public int andarAtual(){
        return andarAtual;
    }
    public int viagens(){
        return viagens;
    }
    public boolean viajar(int andar){
        return false;
    }
    public String estatisticas(){
        return "Quantidade de viagens: " + viagens +
                "Andar atual: " + andarAtual;
    }
}
