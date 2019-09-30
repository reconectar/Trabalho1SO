package Objects;

public class Cliente {
    private String nome;
    private char categoria;

    public Cliente(String nome, char categoria) {
        this.setNome(nome);
        this.setCategoria(categoria);
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

    public void setCategoria(char categoria) throws IllegalArgumentException{
        if((categoria != 'P') || (categoria != 'C') || (categoria != 'D')) {
            this.categoria = categoria;
        } else {
            throw new IllegalArgumentException("Somente categorias P, C ou D aceitos!");
        }
    }

    @Override
    public String toString() {
        return this.getNome() + "(" + this.getCategoria() + ")";
    }
}
