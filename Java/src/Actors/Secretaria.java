package Actors;

import Objects.Documento;
import Util.DeadLineSorter;
import Util.PageSorter;
import Util.PrioritySorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Secretaria {
    private static Secretaria singleton = new Secretaria();
    private List<Documento> documentos;

    private Secretaria() {
        documentos = new ArrayList<>();
    }

    public static Secretaria getInstance() {
        return singleton;
    }

    //Metodo para testes
    private List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    //Metodos para ordenacao
    public List<Documento> menorPaginasPrimeiro() {
        this.getDocumentos().sort(new PageSorter());
        return this.getDocumentos();
    }

    public List<Documento> maiorPrioridadePrimeiro() {
        this.getDocumentos().sort(new PrioritySorter());
        return this.getDocumentos();
    }

    public List<Documento> menorPrazoPrimeiro() {
        this.getDocumentos().sort(Comparator.nullsLast(new DeadLineSorter()));
        return this.getDocumentos();
    }

    public List<Documento> ordenarComTodos() {
        this.getDocumentos().sort(new PageSorter());
        this.getDocumentos().sort(new PrioritySorter());
        this.getDocumentos().sort(Comparator.nullsLast(new DeadLineSorter())); // Obs: O ultimo que possui maior valor
        return this.getDocumentos();
    }

}