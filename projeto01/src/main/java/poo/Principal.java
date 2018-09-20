package poo;

import java.util.Scanner;

public class Principal {
    public static void menu(Edificio e){
        boolean menu = true;
        while(menu){
            System.out.println( ">>>>>>>>>>>MENU<<<<<<<<<<<\n"+
                                "(0) Configurar o edifício\n"+
                                "(1) Solicitar elevador\n"+
                                "(2) Solicitar destino\n"+
                                "(3) Estatísticas dos elevadores\n"+
                                "(4) Listar elevadores para revisão\n"+
                                "(5) Sair\n\n" +
                                "Digite a opção desejada: ");

            Scanner teclado = new Scanner(System.in);
            int opção = teclado.nextInt();
            switch (opção){
                //Configurar o edifício
                case 0:{
                    System.out.println( ">>CONFIGURAR EDIFÍCIO<<\n" +
                                        "Digite a quantidade de andares\n" +
                                        "Escolha apartir de " + e.limiteAndares());
                    int andares = teclado.nextInt();
                    System.out.println("Digite a quantidade de elevadores");
                    System.out.println("Escolha apartir de " + e.limiteElevadores());
                    int elevadores = teclado.nextInt();
                    if(e.configuraEdificio(andares, elevadores)){
                        System.out.println("Configuração realizada com sucesso!");
                    }else System.out.println("Configuração inválida");
                    break;
                }
                //Solicitar elevador
                case 1:{
                    System.out.println( ">>SOLICITAR ELEVADOR<<\n"+
                                        "Digite o seu andar atual");
                    int andarUsuario = teclado.nextInt();
                    if(e.solicitarElevador(andarUsuario)){
                        System.out.println("Solicitação realizada com sucesso!");
                    }
                    else System.out.println("Solicitação inválida!");
                    break;
                }
                //Solicitar destino
                case 2:{
                    System.out.println( ">>SOLICITAR DESTINO<<\n"+
                                        "Digite o elevador onde você está");
                    int elevador = teclado.nextInt();
                    System.out.println("Digite o andar de destino");
                    int andarDestino = teclado.nextInt();
                    if(e.solicitarViagem(andarDestino, elevador)){
                        System.out.println("Solicitação realizada com sucesso!");
                    }
                    else System.out.println("Solicitação inválida!");
                    break;
                }
                //Estatísticas dos elevadores
                case 3:{
                    System.out.println(e.estatisticas());
                    break;
                }
                //Listar elevadores para revisão
                case 4:{
                    System.out.println(e.listaRevisão());
                    break;
                }
                //Sair
                case 5:{
                    menu = false;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Edificio e = new Edificio();
        menu(e);
        System.out.println("Saindo...");
    }
}
