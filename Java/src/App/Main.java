package App;

import Actors.Impressora;
import Actors.Secretaria;
import Objects.LeitorDeArquivo;

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

            //Ordenando a lista e adicionando a impressora por paginas e SJF
            //impressora1.addDocumentos(secretaria.ordenarPorPaginasSJF());

            //Ordenando a lista e adicionando a impressora por prioridade e SJF
            impressora1.addDocumentos(secretaria.ordenarPorPrioridadeSJF());

            //Ordenando a lista e adicionando a impressora por prazo e SJF
            //impressora1.addDocumentos(secretaria.ordernarPorPrazoSJF());

            //Exibindo resultados da impressao
            impressora1.imprimirTodos();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}