package App;

import Actors.Impressora;
import Actors.Secretaria;
import Objects.Documento;
import Objects.LeitorDeArquivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {

            // 2 Singletons abaixo (Nao podem ser instanciados novamente)
            Secretaria secretaria = Secretaria.getInstance();
            LeitorDeArquivo leitor = LeitorDeArquivo.getInstance();

            //Declarando as impressoras
            Impressora impressora1 = new Impressora();
            Impressora impressora2 = new Impressora();

            //Lendo o arquivo para gerar a lista de documentos
            secretaria.setDocumentos(leitor.lerArquivo());

            int opcao = 0;
            Scanner input = new Scanner(System.in);
            System.out.println("");
            System.out
                    .println("### Trabalho pratico 1 - Sistema operacionais ###");
            System.out.println("\n                     ======================================== ");
            System.out.println("                  |    1 - SJF por paginas                     |");
            System.out.println("                  |    2 - SJF por prioridade                  |");
            System.out.println("                  |    3 - SJF por prazo                       |");
            System.out.println("                  |    4 - Prazo > Prioridade > Paginas(Todos) |");
            System.out.println("                  |    5 - 2 Impressoras + (Todos)             |");
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
                    //Ordenando a lista por prazo e SJF e adicionando a impressora
                    impressora1.addDocumentos(secretaria.ordenarPorPrazoSJF());
                    break;
                case 4:
                    //Ordenando a lista  com uma mistura de todos (Prazo > Prioridade > Paginas) e adicionando a impressora
                    impressora1.addDocumentos(secretaria.ordenarComTodos());
                    break;
                case 5:
                    List<Documento> docsADividir = secretaria.ordenarComTodos();
                    for (int i = 0; i < docsADividir.size(); i++) {
                        if (i % 2 == 0) {
                            impressora1.addDocumento(docsADividir.get(i));
                        }else{
                            impressora2.addDocumento(docsADividir.get(i));
                        }
                    }
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

            //Exibindo resultados da impressao
            impressora1.imprimirTodos();
            if (!impressora2.getDocumentos().isEmpty()) {
                impressora2.imprimirTodos();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}