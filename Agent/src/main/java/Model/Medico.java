package Model;

public class Medico {
    private String crm;
    private double porcenParticipacao;
    private String consultorio;
    private Especialidade especialidade;

    public Medico() {
    }

    public Medico(String crm, double porcenParticipacao, String consultorio, Especialidade especialidade) {
        this.crm = crm;
        this.porcenParticipacao = porcenParticipacao;
        this.consultorio = consultorio;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public double getPorcenParticipacao() {
        return porcenParticipacao;
    }

    public void setPorcenParticipacao(double porcenParticipacao) {
        this.porcenParticipacao = porcenParticipacao;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm='" + crm + '\'' +
                ", porcenParticipacao=" + porcenParticipacao +
                ", consultorio='" + consultorio + '\'' +
                ", especialidade=" + especialidade +
                '}';
    }


}
