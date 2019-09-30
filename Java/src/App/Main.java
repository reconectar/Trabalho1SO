package App;

import Actors.Impressora;
import Objects.Cliente;
import Objects.Documento;
import Objects.LeitorDeArquivo;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        // Testando as classes
        LocalTime testeData = LocalTime.now();
        Cliente testeCliente = new Cliente("Arthur", 'D');
        Documento testeDocumento = new Documento(90, testeCliente, testeData);

        System.out.println(testeDocumento.toString());
        Impressora impressora1 = new Impressora();
        impressora1.addDocumento(testeDocumento);
        System.out.println("Tempo da impressao: " + impressora1.imprimir());

        try{
        //Leitor
        LeitorDeArquivo leitor = new LeitorDeArquivo();
        System.out.println("Numero de documentos: " + leitor.getNumeroInicialDeDocumentos() + System.lineSeparator() +
                leitor.lerArquivo().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}