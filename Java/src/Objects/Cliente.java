package Objects;

public class Cliente {
    private String nome;
    private char categoria;

    public Cliente(String nome, int prioridade) {
        this.setNome(nome);
        this.setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoria() {
        return this.categoria;
    }

    public void setCategoria(int categoria) throws IllegalArgumentException{
        if((categoria != 'P') || (categoria != 'C') || (categoria != 'D')) {
            this.setCategoria(categoria);
        } else {
            throw new IllegalArgumentException("Somente categorias P, C ou D aceitos!");
        }
    }
}
