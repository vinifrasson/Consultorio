package DAO;

import Factory.ConnectionFactory;
import Model.Agendamento;

import java.sql.*;

public class AgendaDAO {

    private Connection connection;

    public AgendaDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void tabelaAgenda() {
        String sql = "CREATE TABLE IF NOT EXISTS consultorio.agenda (" +
                "cadastro TIMESTAMP not null," +
                "atualizado TIMESTAMP," +
                "excluido TIMESTAMP," +
                "id BIGINT PRIMARY KEY," +
                "statusAgenda varchar(15) not null," +
                "dataAgendamento TIMESTAMP not null," +
                "encaixe BOOLEAN" +
                "idPaciente BIGINT NOT NULL," +
                "CONSTRAINT fk_idPaciente FOREIGN KEY (idPaciente)" +
                "REFERENCES consultorio.paciente(id)" +
                "idMedico BIGINT NOT NULL," +
                "CONSTRAINT  fk_idMedico FOREIGN KEY (idMedico)" +
                "REFERENCES consultorio.medico(id)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarAgenda(Agendamento agendamento){
        String sql = "INSERT INTO consultorio.agenda " +
                "(cadastro, statusAgenda, dataAgendamento, encaixe, idPaciente, idMedico)" +
                "VALUES (now(),?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, agendamento.getStatusagendamento().toString());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(agendamento.getDataAgendamento()));
            preparedStatement.setBoolean(3, agendamento.getEncaixar());
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}