package poo;

public class Elevador {
    private int viagens;
    private int andarAtual;

    public Elevador(){
        this.viagens = 0;
        this.andarAtual = 0;
    }
    public int andarAtual(){
        return this.andarAtual;
    }

    public int viagens(){
        return this.viagens;
    }

    public void viajar(int andarDestino){
        this.andarAtual = andarDestino;
        this.viagens++;
    }

    public String estatisticas(){
        return "Viagens: " + this.viagens + " - Andar atual: " + this.andarAtual;
    }
}
