package Actors;

import Objects.Documento;

import java.util.ArrayList;
import java.util.List;

public class Impressora {
    private static int id = 0;
    private int idImpressora;
    private List <Documento> documentos;

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

    // TODO Fazer método Imprimir
}
