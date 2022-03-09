package DAO;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {


    private Connection connection;

    public MedicoDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaMedico() {

        String sql = "CREATE TABLE IF NOT EXISTS medico (" +
                "idMedico BIGSERIAL PRIMARY KEY," +
                "crm VARCHAR(50) NOT NULL ," +
                "consultorio VARCHAR (50) NOT NULL," +
                "porcenParticipacao DOUBLE PRECISION" +
                "idEspecialidade BIGINT," +
                "CONSTRAINT fk_idEpecialidade FOREIGN  KEY (idEspecialidades)"+
                "REFERENCES consultorio.especialidades(id)"+
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
