package Actors;

import Objects.Documento;

import java.util.ArrayList;
import java.util.List;

public class Secretaria {
    private List <Documento> documentos;
    public Secretaria(){
        documentos = new ArrayList<Documento>();
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
}
