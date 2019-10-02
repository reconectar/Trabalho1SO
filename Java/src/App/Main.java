package App;

import Actors.Impressora;
import Actors.Secretaria;
import Objects.Documento;
import Objects.LeitorDeArquivo;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

// TODO Fazer menu
public class Main {

    public static void main(String[] args) {
        try{

            // 2 Singletons abaixo (Nao podem ser instanciados novamente)
            Secretaria secretaria = Secretaria.getInstance();
            LeitorDeArquivo leitor = LeitorDeArquivo.getInstance();

            //Instanciando as impressoras
            Impressora impressora1 = new Impressora();
            Impressora impressora2 = new Impressora();

            //Lendo o arquivo para gerar a lista de documentos
            secretaria.setDocumentos(leitor.lerArquivo());

            int opcao = 0;
            Scanner input = new Scanner(System.in);
            do {
                System.out
                        .println("\n\n### SISCOM - Sistema Comercial de Controle de Compras e Vendas ###");
                System.out.println("\n                  ======================================== ");
                System.out.println("                  |     1 - SJF por paginas                    |");
                System.out.println("                  |     2 - SJF por prioridade                 |");
                System.out.println("                  |     3 - SJF por prazo                      |");
                System.out.println("                  |     4 - Prazo > Prioridade > Paginas       |");
                System.out.println("                  |     5 - 2 Impressoras                      |");
                System.out.println("                  |     0 - Sair                               |");
                System.out.println("                    ======================================== \n");
                System.out.print("Opção -> ");
                opcao = input.nextInt();
                System.out.println("");
                switch (opcao) {
                    case 1:
                        //Ordenando a lista por paginas e SJF e adicionando a impressora
                        impressora1.addDocumentos(secretaria.ordenarPorPaginasSJF());
                        break;
                    case 2:
                        //Ordenando a lista por prioridade e SJF e adicionando a impressora
                        impressora1.addDocumentos(secretaria.ordenarPorPrioridadeSJF());
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            } while (opcao != 0);





            //Ordenando a lista por prazo e SJF e adicionando a impressora
            //impressora1.addDocumentos(secretaria.ordenarPorPrazoSJF());

            //Ordenando a lista  com uma mistura de todos (Prazo > Prioridade > Paginas) e adicionando a impressora
            impressora1.addDocumentos(secretaria.ordenarComTodos());

            //Exibindo resultados da impressao
            impressora1.imprimirTodos();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}