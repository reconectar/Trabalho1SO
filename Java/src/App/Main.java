package App;

import Actors.Impressora;
import Actors.Secretaria;
import Objects.Documento;
import Objects.LeitorDeArquivo;

import java.util.List;
import java.util.Scanner;

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

            int opcao;
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("### Trabalho pratico 1 - Sistema operacionais ###");
            System.out.println("\n                     ========================================== ");
            System.out.println("                  |    1 - Menor No de paginas                    |");
            System.out.println("                  |    2 - Maior prioridade                       |");
            System.out.println("                  |    3 - Menor prazo                            |");
            System.out.println("                  |    4 - Prazo > Prioridade > Paginas (Todos)   |");
            System.out.println("                  |    5 - Menor No de paginas + 2 impressoras    |");
            System.out.println("                  |    6 - Maior prioridade + 2 Impressoras       |");
            System.out.println("                  |    7 - Menor prazo + 2 Impressoras            |");
            System.out.println("                  |    8 - (Todos) + 2 Impressoras                |");
            System.out.println("                    =========================================== \n");
            System.out.print("Opção -> ");
            opcao = input.nextInt();
            System.out.println();
            switch (opcao) {
                case 1:
                    //Ordenando a lista por paginas e SJF e adicionando a impressora
                    impressora1.addDocumentos(secretaria.menorPaginasPrimeiro());
                    break;
                case 2:
                    //Ordenando a lista por prioridade e SJF e adicionando a impressora
                    impressora1.addDocumentos(secretaria.maiorPrioridadePrimeiro());
                    break;
                case 3:
                    //Ordenando a lista por prazo e SJF e adicionando a impressora
                    impressora1.addDocumentos(secretaria.menorPrazoPrimeiro());
                    break;
                case 4:
                    //Ordenando a lista  com uma mistura de todos (Prazo > Prioridade > Paginas) e adicionando a impressora
                    impressora1.addDocumentos(secretaria.ordenarComTodos());
                    break;
                case 5:
                    List<Documento> docsADividirPaginas = secretaria.menorPaginasPrimeiro();
                    DuasImpressoras(docsADividirPaginas, impressora1, impressora2);
                    break;
                case 6:
                    List<Documento> docsADividirPrioridade = secretaria.maiorPrioridadePrimeiro();
                    DuasImpressoras(docsADividirPrioridade, impressora1, impressora2);
                    break;
                case 7:
                    List<Documento> docsADividirPrazo = secretaria.menorPrazoPrimeiro();
                    DuasImpressoras(docsADividirPrazo, impressora1, impressora2);
                case 8:
                    List<Documento> docsADividirTodos = secretaria.ordenarComTodos();
                    DuasImpressoras(docsADividirTodos, impressora1, impressora2);
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

    private static void DuasImpressoras(List<Documento> lista, Impressora impressora1, Impressora impressora2)
    {
        for (int i = 0; i < lista.size(); i++) {
            if (i % 2 == 0) {
                impressora1.addDocumento(lista.get(i));
            }else{
                impressora2.addDocumento(lista.get(i));
            }
        }
    }
}