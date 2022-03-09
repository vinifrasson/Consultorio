package Model;

public class Secretario {

    private long idSecretario;
    private double salario;
    private double dataContratacao;
    private String pis;
    private String nomeSecretario;

    public Secretario() {
    }

    public Secretario(String nomeSecretario) {
        this.nomeSecretario = nomeSecretario;
    }

    public Secretario(long idSecretario, double salario, double dataContratacao, String pis) {
        this.idSecretario = idSecretario;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.pis = pis;
    }

    public long getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(long idSecretario) {
        this.idSecretario = idSecretario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(double dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    @Override
    public String toString() {
        return "Secretario{" +
                "idSecretario=" + idSecretario +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", pis='" + pis + '\'' +
                ", nomeSecretario='" + nomeSecretario + '\'' +
                '}';
    }
}
