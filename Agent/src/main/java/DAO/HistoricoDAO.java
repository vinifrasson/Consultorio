package DAO;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoricoDAO {

    private Connection connection;

    public HistoricoDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaHistorico() {

        String sql = "CREATE TABLE IF NOT EXISTS historico (" +
                "idHistorico BIGSERIAL PRIMARY KEY," +
                "idAgenda INT," +
                "idPaciente INT," +
                "idStatusAgenda INT," +
                "observacao VARCHAR(200) NOT NULL," +
                "data TIMESTAMP NOT NULL" +
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
