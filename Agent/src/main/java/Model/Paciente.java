package Model;

import java.time.LocalDateTime;

public class Paciente extends Pessoa {

    private String tipoAtendimento;
    private Convenio convenio;
    private String numCartaoConvenio;
    private LocalDateTime dataVencimento;

    public Paciente() {
    }

    public Paciente(String nome, String telefone, String nacionalidade, String cpf, String rg, String email, String login, String senha, Sexo sexo) {
        super(nome, telefone, nacionalidade, cpf, rg, email, login, senha, sexo);
    }

    public Paciente(String tipoAtendimento, Convenio convenio, String numCartaoConvenio, LocalDateTime dataVencimento) {
        this.tipoAtendimento = tipoAtendimento;
        this.convenio = convenio;
        this.numCartaoConvenio = numCartaoConvenio;
        this.dataVencimento = dataVencimento;
    }

    public Paciente(String nome, String telefone, String nacionalidade, String cpf, String rg, String email, String login, String senha, Sexo sexo, String tipoAtendimento, Convenio convenio, String numCartaoConvenio, LocalDateTime dataVencimento) {
        super(nome, telefone, nacionalidade, cpf, rg, email, login, senha, sexo);
        this.tipoAtendimento = tipoAtendimento;
        this.convenio = convenio;
        this.numCartaoConvenio = numCartaoConvenio;
        this.dataVencimento = dataVencimento;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getNumCartaoConvenio() {
        return numCartaoConvenio;
    }

    public void setNumCartaoConvenio(String numCartaoConvenio) {
        this.numCartaoConvenio = numCartaoConvenio;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "tipoAtendimento='" + tipoAtendimento + '\'' +
                ", convenio=" + convenio +
                ", numCartaoConvenio='" + numCartaoConvenio + '\'' +
                ", dataVencimento=" + dataVencimento +
                '}';
    }
}
