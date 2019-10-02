package Util;

import Objects.Documento;

import java.util.Comparator;

//SJF de prioridade
public class PrioritySorter implements Comparator<Documento> {
    public int compare(Documento o1, Documento o2) {
        return o1.getProprietario().getPrioridade() - o2.getProprietario().getPrioridade();
    }
}