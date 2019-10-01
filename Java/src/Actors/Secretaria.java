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
    private List <Documento> documentos;

    private Secretaria(){
        documentos = new ArrayList<Documento>();
    }

    public static Secretaria getInstance() {
        return singleton;
    }

    //Metodo para testes
    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    // TODO Fazer as logicas de ordenação
    //Metodos para ordenação
    public List<Documento> ordenarPorPaginasSJF() {
        System.out.println("Antes: " + this.getDocumentos()); //remover depois de teste
        this.getDocumentos().sort(new PageSorter());
        System.out.println("Depois: " + this.getDocumentos()); //remover depois de teste
        return this.getDocumentos();
    }

    //Incompleto, ordenador sem logica
    public List<Documento> ordenarPorPrioridadeSJF(){
        System.out.println("Antes: " + this.getDocumentos()); //remover depois de teste
        this.getDocumentos().sort(new PrioritySorter());
        System.out.println("Depois: " + this.getDocumentos()); //remover depois de teste
        return this.getDocumentos();
    }

    //Incompleto, ordenador sem logica
    public List<Documento> ordernarPorPrazoSJF(){
        System.out.println("Antes: " + this.getDocumentos()); //remover depois de teste
        this.getDocumentos().sort(Comparator.nullsLast(new DeadLineSorter()));
        System.out.println("Depois: " + this.getDocumentos()); //remover depois de teste
        return this.getDocumentos();
    }

    public List<Documento> dividirEmDuasImpressoras(){
        // TODO Usar as logicas de ordenação anteriores, porém mandando
        //  antes para cada impressora, usar os dados dos vetores para calcular
        //  resultado com 2 impressoras, talvez apenas dividir os vetores em 2
        return this.getDocumentos();
    }
}
