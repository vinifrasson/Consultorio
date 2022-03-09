package DAO;

import Factory.ConnectionFactory;
import Model.Convenio;
import Model.Especialidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConvenioDAO {

    private Connection connection;

    public ConvenioDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    //nome String e valor float
    public void criaTabelaConvenio() {

        String sql = "CREATE TABLE IF NOT EXISTS convenio (" +
                "idConvenio BIGSERIAL PRIMARY KEY," +
                "nome VARCHAR(50) NOT NULL ," +
                "valor DECIMAL NOT NULL" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarConvenio(Convenio convenio){
        String sql = "INSERT INTO convenios(nome, valor) VALUES(?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,convenio.getNome());
            preparedStatement.setLong(2, convenio.getValor());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editarConvenio (Convenio convenio) {
        String sql = "UPDATE convenios SET nome = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,convenio.getNome());
            preparedStatement.setLong(2, convenio.getValor());

            preparedStatement.execute();
            preparedStatement.close();
            System.out.println(
                            " | Nome da Pessoa: " + convenio.getNome() +
                            " | Valor: " + convenio.getValor());
                            System.out.println();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public List<Convenio> listarConvenio(){
        String sql = "SELECT * FROM Conveio";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Convenio> Convenio = new ArrayList<>();

            while (resultSet.next()){
                Convenio convenio = new Convenio();
                convenio.setNome(resultSet.getString("nome"));
                convenio.setValor(ResultSet.getFloat("valor"));

                Convenio.add();
            }
            return Especialidade;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
