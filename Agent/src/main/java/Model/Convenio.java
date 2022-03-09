package Model;

public class Convenio extends AbstractEntity {

    private String nome;
    private float valor;

    public Convenio() {
    }

    public Convenio(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Convenio{" +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
