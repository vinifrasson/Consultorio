package Model;

import java.time.LocalDateTime;

public class Agendamento {

    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataAgendamento;
    private Boolean encaixar;
    private StatusAgendamento statusagendamento;

    public Agendamento() {
    }

    public Agendamento(Paciente paciente, Medico medico, LocalDateTime dataAgendamento, Boolean encaixar, StatusAgendamento statusagendamento) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataAgendamento = dataAgendamento;
        this.encaixar = encaixar;
        this.statusagendamento = statusagendamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Boolean getEncaixar() {
        return encaixar;
    }

    public void setEncaixar(Boolean encaixar) {
        this.encaixar = encaixar;
    }

    public StatusAgendamento getStatusagendamento() {
        return statusagendamento;
    }

    public void setStatusagendamento(StatusAgendamento statusagendamento) {
        this.statusagendamento = statusagendamento;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", dataAgendamento=" + dataAgendamento +
                ", encaixar=" + encaixar +
                ", statusagendamento=" + statusagendamento +
                '}';
    }
}
