package Model;

import java.math.BigDecimal;

public class Historico extends AbstractEntity {

    private Agendamento agenda;
    private String observacao;
    private Secretario secretario;
    private Paciente paciente;
    private BigDecimal data;
    private StatusAgendamento statusAgendamento;

    public Historico() {
    }

    public Historico(Agendamento agenda, String observacao, Secretario secretario, Paciente paciente, BigDecimal data, StatusAgendamento statusAgendamento) {
        this.agenda = agenda;
        this.observacao = observacao;
        this.secretario = secretario;
        this.paciente = paciente;
        this.data = data;
        this.statusAgendamento = statusAgendamento;
    }

    public Agendamento getAgenda() {
        return agenda;
    }

    public void setAgenda(Agendamento agenda) {
        this.agenda = agenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Secretario getSecretario() {
        return secretario;
    }

    public void setSecretario(Secretario secretario) {
        this.secretario = secretario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public BigDecimal getData() {
        return data;
    }

    public void setData(BigDecimal data) {
        this.data = data;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "agenda=" + agenda +
                ", observacao='" + observacao + '\'' +
                ", secretario=" + secretario +
                ", paciente=" + paciente +
                 ", data=" + data +
                ", statusAgendamento=" + statusAgendamento +
                '}';
    }
}
