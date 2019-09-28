package Objects;

import Objects.Cliente;

import java.time.LocalDateTime;

public class Documento {
    private int paginas;
    private Cliente proprietario;
    private LocalDateTime prazo;

    public Documento(int paginas, Cliente proprietario, LocalDateTime prazo) {
        this.setPaginas(paginas);
        this.setProprietario(proprietario);
        this.setPrazo(prazo);
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) throws IllegalArgumentException{
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

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }
}
