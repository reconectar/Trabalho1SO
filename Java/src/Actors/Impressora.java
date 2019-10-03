package Actors;

import Objects.Documento;
import Objects.LeitorDeArquivo;

import java.util.ArrayList;
import java.util.List;

public class Impressora {
    private static int id = 0;

    private int idImpressora;
    private List<Documento> documentos;
    private static final float TEMPO_POR_PAGINA = 1.5F;
    private static final float TEMPO_ENTRE_IMPRESSAO = 8F;

    public Impressora() {
        id++;
        this.setIdImpressora(id);
        documentos = new ArrayList<Documento>();
    }

    public void addDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public int getIdImpressora() {
        return idImpressora;
    }

    private void setIdImpressora(int idImpressora) {
        this.idImpressora = idImpressora;
    }

    public void addDocumento(Documento documento) {
        this.documentos.add(documento);
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    private float imprimir() {
        float tempoTotal = 0;
        tempoTotal = TEMPO_ENTRE_IMPRESSAO + TEMPO_POR_PAGINA * documentos.get(0).getPaginas();
        documentos.remove(0);
        return tempoTotal;
    }

    public float[] imprimirTodos() {
        float tempoTotalTodos = 0;
        int cont = 0;
        int contEstouro = 0;
        int tamanho = documentos.size();
        float[] retornos = new float[tamanho];
        float tempoTotal;
        System.out.println("");
        System.out.println("****************** Impressora" + this.getIdImpressora() + " ******************");
        while (!documentos.isEmpty()) {
            int prazo = documentos.get(0).getPrazo().toSecondOfDay();
            String proprietario = documentos.get(0).getProprietario().toString();
            tempoTotal = this.imprimir();
            System.out.print("Tempo de retorno Doc" + (cont + 1) + ": "
                    + (tempoTotal + tempoTotalTodos) + " seg" + " - "
                    + proprietario + " " +
                    "- prazo: " +prazo);
            retornos[cont] = tempoTotal + tempoTotalTodos;
            if(retornos[cont] >= prazo){
                System.out.print(" (Estourado)\n");
                contEstouro++;
            }else{
                System.out.print("\n");
            }
            tempoTotalTodos += tempoTotal;
            cont++;
        }
        System.out.println("");
        float media = 0;
        for (cont = 0; cont < tamanho; cont++) {
            media += retornos[cont];
        }
        System.out.println(" --- Porcentagem de estouro: " + (contEstouro*100)/tamanho + "% --- ");
        System.out.println("Media de retorno da impressora: " + media / tamanho + " seg");
        System.out.println("Media de resposta da impressora: " + (media - retornos[retornos.length - 1]) / tamanho + " seg");
        System.out.println("Tempo total de impressao da impressora: " + tempoTotalTodos + " seg");
        System.out.println("**************************************************");

        return retornos;
        // Observacoes sobre os usos deste array retornado:
        // ultimo elemento = tempo total
        // soma dos elementos + divisao pelo numero de elementos = media de retorno
        // (soma dos elementos - ultimo elemento) dividido pelo numero de elementos = media de resposta
    }
}
