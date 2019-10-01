package Util;

import Objects.Documento;

import java.util.Comparator;

public class PrioritySorter implements Comparator<Documento> {
    public int compare(Documento o1, Documento o2) {
        return o1.getProprietario().getPrioridade() - o2.getProprietario().getPrioridade();
    }
}