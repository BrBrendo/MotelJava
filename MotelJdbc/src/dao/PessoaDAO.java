package dao;

import model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;



/*
Classe CRUD
DAO = Data Access Object
*/

public class PessoaDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Pessoa> Pessoa = new ArrayList<Pessoa>();

    public PessoaDAO() {
        conn = new ConnectionFactory().getConnection();
    }
    
    
    //criar
    public void create(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa  (cpf, nome, data_nascimento, telefone) VALUES (?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getNome());
            stmt.setDate(3, new java.sql.Date (pessoa.getDataNascimento().getTime()));
            stmt.setInt(4, pessoa.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    
    
    // Listar
    public ArrayList<Pessoa> list() {
        String sql = "SELECT * FROM Pessoa";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setCpf(rs.getInt("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("data_nascimento"));
                pessoa.setTelefone(rs.getInt("telefone"));
                (Pessoa).add(pessoa);
            }
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
        return Pessoa;
    }
    


    //mudar
    public void update(Pessoa pessoa) {
        String sql = "UPDATE Pessoa SET cpf = ?, nome = ?, data_nascimento = ?, telefone = ? WHERE cpf = ? ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getNome());
            stmt.setDate(3, new java.sql.Date (pessoa.getDataNascimento().getTime()));
            stmt.setInt(4, pessoa.getTelefone());
            stmt.setInt(5, pessoa.getCpf());
            stmt.execute();
            stmt.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    //deletar
    public void delete(int cpf) {
        String sql = "DELETE FROM Pessoa WHERE cpf = " + cpf;
        try {
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    //busca
    public ArrayList<Pessoa> searchByName(String search) {
        String sql = "SELECT * FROM Pessoa WHERE name LIKE '%" + search + "%' ";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setCpf(rs.getInt("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("data_nascimento"));
                pessoa.setTelefone(rs.getInt("telefone"));
                Pessoa.add(pessoa);
            }
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
        return Pessoa;
    }
    
}