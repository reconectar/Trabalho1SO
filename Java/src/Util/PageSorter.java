package Util;

import Objects.Documento;

import java.util.Comparator;

// Correto ✔
public class PageSorter implements Comparator <Documento> {
    public int compare(Documento o1, Documento o2) {
        return o1.getPaginas() - o2.getPaginas();
    }

}