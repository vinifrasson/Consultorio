package DAO;

import Factory.ConnectionFactory;
import Model.Secretario;

import java.sql.*;

public class SecretarioDAO {

    private Connection connection;

    public SecretarioDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaSecretario() {

        String sql = "CREATE TABLE IF NOT EXISTS secretario (" +
                "idSecretario BIGSERIAL PRIMARY KEY," +
                "idEspecialidade BIGINT," +
                "pis VARCHAR(50) NOT NULL ," +
                "nomeSecretario VARCHAR (50) NOT NULL," +
                "dataContratacao DOUBLE PRECISION" +
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
