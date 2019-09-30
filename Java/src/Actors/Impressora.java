package Actors;

import Objects.Documento;

import java.util.ArrayList;
import java.util.List;

public class Impressora {
    private static int id = 0;
    private int idImpressora;
    private List <Documento> documentos;
    private static final float TEMPO_POR_PAGINA = 1.5F;
    private static final float TEMPO_ENTRE_IMPRESSAO = 8F;

    public Impressora(){
        id++;
        this.setIdImpressora(id);
        documentos = new ArrayList<Documento>();
    }

    public int getIdImpressora() {
        return idImpressora;
    }

    private void setIdImpressora(int idImpressora) {
        this.idImpressora = idImpressora;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void addDocumento(Documento documento) {
        this.documentos.add(documento);
    }

    public float imprimir(){
        float tempoTotal = 0;
        if(!documentos.isEmpty()) {
            tempoTotal = TEMPO_ENTRE_IMPRESSAO + TEMPO_POR_PAGINA * documentos.get(0).getPaginas();
            documentos.remove(0);
            return tempoTotal;
        }else{
            System.out.println("Fila de impressão vazia!");
            return tempoTotal;
        }
    }
}
