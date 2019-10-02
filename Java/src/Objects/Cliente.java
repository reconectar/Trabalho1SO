package Objects;

public class Cliente {
    private String nome;
    private char categoria;
    private int prioridade;

    public Cliente(String nome, char categoria) {
        this.setNome(nome);
        this.setCategoria(categoria);
        if (this.getCategoria() == 'D') {
            this.setPrioridade(1);
        } else if (this.getCategoria() == 'C') {
            this.setPrioridade(2);
        } else {
            this.setPrioridade(3);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getCategoria() {
        return this.categoria;
    }

    public void setCategoria(char categoria) throws IllegalArgumentException {
        if ((categoria != 'P') || (categoria != 'C') || (categoria != 'D')) {
            this.categoria = categoria;
        } else {
            throw new IllegalArgumentException("Somente categorias P, C ou D aceitos!");
        }
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return this.getNome() + "(" + this.getCategoria() + ")";
    }
}
