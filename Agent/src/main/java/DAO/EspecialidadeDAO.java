package DAO;

import Factory.ConnectionFactory;
import Model.Especialidade;
import Model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {

    private Connection connection;

    public EspecialidadeDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaEspecialidade() {

        String sql = "CREATE TABLE IF NOT EXISTS especialidade (" +
                "nome VARCHAR(50) NOT NULL ," +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarEspecialidade(Especialidade especialidade){
        String sql = "INSERT INTO pessoas(nome) VALUES(?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,especialidade.getNome());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editarEspecialidade (Especialidade especialidade) {
        String sql = "UPDATE pessoas SET nome = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,especialidade.getNome());

            preparedStatement.execute();
            preparedStatement.close();
            System.out.println(
                    " | Nome da Pessoa: " + especialidade.getNome() +
            System.out.println();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public List<Especialidade> listarEspecialidade(){
        String sql = "SELECT * FROM Especialidade";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Especialidade> Especialidade = new ArrayList<>();

            while (resultSet.next()){
                Especialidade especialidade = new Especialidade();
                especialidade.setNome(resultSet.getString("nome"));

                Especialidade.add(especialidade);
            }
            return Especialidade;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
