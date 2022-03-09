package DAO;

import Factory.ConnectionFactory;
import Model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoasDAO {

    private Connection connection;

    public PessoasDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaMedico() {

        String sql = "CREATE TABLE IF NOT EXISTS medico (" +
                "idMedico BIGSERIAL PRIMARY KEY," +
                "nome VARCHAR(50) NOT NULL ," +
                "telefone VARCHAR(50) NOT NULL ," +
                "nacionalidade VARCHAR(50) NOT NULL ," +
                "cpf VARCHAR(50) NOT NULL ," +
                "rg VARCHAR(50) NOT NULL ," +
                "email VARCHAR(50) NOT NULL ," +
                "login VARCHAR (50) NOT NULL," +
                "senha VARCHAR(50) NOT NULL ," +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarPessoa(Pessoa pessoa){
        String sql = "INSERT INTO pessoas(nome, telefone, nacionalidade, cpf, rg, email, login, senha, sexo) VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,pessoa.getNome());
            preparedStatement.setString(2,pessoa.getTelefone());
            preparedStatement.setString(3,pessoa.getNacionalidade());
            preparedStatement.setString(4,pessoa.getCpf());
            preparedStatement.setString(5,pessoa.getRg());
            preparedStatement.setString(6,pessoa.getEmail());
            preparedStatement.setString(7,pessoa.getLogin());
            preparedStatement.setString(8,pessoa.getSenha());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editarPessoa (Pessoa pessoa) {
        String sql = "UPDATE pessoas SET nome = ?, telefone = ?, nacionalidade = ?, cpf = ?, rg = ?, email = ?, login = ?, senha = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,pessoa.getNome());
            preparedStatement.setString(2,pessoa.getTelefone());
            preparedStatement.setString(3,pessoa.getNacionalidade());
            preparedStatement.setString(4,pessoa.getCpf());
            preparedStatement.setString(5,pessoa.getRg());
            preparedStatement.setString(6,pessoa.getEmail());
            preparedStatement.setString(7,pessoa.getLogin());
            preparedStatement.setString(8,pessoa.getSenha());

            preparedStatement.execute();
            preparedStatement.close();
            System.out.println(
                    " | Nome da Pessoa: " + pessoa.getNome() +
                    " | Telefone da Pessoa: " + pessoa.getTelefone() +
                    " | Nacionalidade: " + pessoa.getNacionalidade() +
                    " | CPF da Pessoa: " + pessoa.getCpf() +
                    " | RG da pessoa: " + pessoa.getRg() +
                    " | E-mail da Pessoa: " + pessoa.getEmail() +
                    " | Login: " + pessoa.getLogin() +
                    " | Senha: " + pessoa.getSenha());
            System.out.println();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public List<Pessoa> listarPessoas(){
        String sql = "SELECT * FROM pessoas";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pessoa> pessoas = new ArrayList<>();

            while (resultSet.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setTelefone(resultSet.getString("telefone"));
                pessoa.setNacionalidade(resultSet.getString("nacionalidade"));
                pessoa.setCpf(resultSet.getString("cpf"));
                pessoa.setRg(resultSet.getString("rg"));
                pessoa.setEmail(resultSet.getString("email"));

                pessoas.add(pessoa);
            }
            return pessoas;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
