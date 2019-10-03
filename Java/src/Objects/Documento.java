package Objects;

import java.time.LocalTime;

public class Documento {
    private int paginas;
    private Cliente proprietario;
    private LocalTime prazo;

    public Documento(int paginas, Cliente proprietario, LocalTime prazo) {
        this.setPaginas(paginas);
        this.setProprietario(proprietario);
        if (prazo.toSecondOfDay() == 0) {
            LocalTime prazoMax = LocalTime.MAX;
            this.setPrazo(prazoMax);
        } else {
            this.setPrazo(prazo);
        }
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) throws IllegalArgumentException {
        if (paginas <= 0) {
            throw new IllegalArgumentException("Numero de paginas nao pode ser menor ou igual a 0!");
        } else {
            this.paginas = paginas;
        }
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public LocalTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalTime prazo) {
        this.prazo = prazo;
    }

    @Override
    public String toString() {
        return "Proprietário: " + this.getProprietario().toString() + System.lineSeparator() +
                "Paginas: " + this.getPaginas() + System.lineSeparator() +
                "Prazo: " + this.getPrazo();
    }
}
