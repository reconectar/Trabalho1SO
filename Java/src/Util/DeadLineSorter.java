package Util;

import Objects.Documento;

import java.util.Comparator;

//SJF de prazo
public class DeadLineSorter implements Comparator<Documento> {
    public int compare(Documento o1, Documento o2) {
        if (o1.getPrazo() == null) {
            return (o2.getPrazo() == null) ? 1 : 0;
        }
        if (o2.getPrazo() == null) {
            return -1;
        }
        return o1.getPrazo().compareTo(o2.getPrazo());
    }
}
