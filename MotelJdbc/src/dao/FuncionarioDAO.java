package dao;

import model.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
Classe CRUD
DAO = Data Access Object
*/

public class FuncionarioDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Funcionario> Funcionario = new ArrayList<Funcionario>();

    public FuncionarioDAO() {
        conn = new ConnectionFactory().getConnection();
    }
    
    
    //criar
    public void create(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario  (cpf, data_entrada) VALUES (?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, funcionario.getCpf());
            stmt.setDate(2, new java.sql.Date( funcionario.getDataEntrada().getTime()));
            stmt.execute();
            stmt.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    
    
    // Listar
    public ArrayList<Funcionario> list() {
        String sql = "SELECT * FROM Funcionario";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	Funcionario funcionario = new Funcionario();
            	funcionario.setId(rs.getInt("funcionarioID"));
            	funcionario.setCpf(rs.getInt("cpf"));
            	funcionario.setDataEntrada(rs.getDate("data_entrada"));
                (Funcionario).add(funcionario);
            }
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
        return Funcionario;
    }
    
    //mudar
    public void update(Funcionario funcionario) {
        String sql = "UPDATE Funcionario SET cpf = ?, data_entrada = ? WHERE cpf = ? ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, funcionario.getCpf());
            stmt.setDate(2, new java.sql.Date( funcionario.getDataEntrada().getTime()));
            stmt.setInt(3, funcionario.getCpf());
            stmt.execute();
            stmt.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    //deletar
    public void delete(int cpf) {
        String sql = "DELETE FROM Funcionario WHERE cpf = " + cpf;
        try {
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    //busca
    public ArrayList<Funcionario> searchByName(String search) {
        String sql = "SELECT * FROM Funcionario WHERE name LIKE '%" + search + "%' ";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	Funcionario funcionario = new Funcionario();
            	funcionario.setId(rs.getInt("funcionarioID"));
            	funcionario.setCpf(rs.getInt("cpf"));
            	funcionario.setDataEntrada(rs.getDate("data_entrada"));
                Funcionario.add(funcionario);
            }
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
        return Funcionario;
    }
    
}