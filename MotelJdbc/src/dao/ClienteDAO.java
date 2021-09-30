package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDAO {
	
	
	private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Cliente> Cliente = new ArrayList<Cliente>();

    public ClienteDAO() {
        conn = new ConnectionFactory().getConnection();
    }
    
    
    //criar
    public void create(Cliente cliente) {
        String sql = "INSERT INTO Cliente  (cpf, entrada, saida, suite) VALUES (?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getCpf());
            stmt.setDate(2, (Date) cliente.getEntrada());
            stmt.setDate(3, (Date) cliente.getSaida());
            stmt.setInt(4, cliente.getQuarto());
            stmt.execute();
            stmt.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    
    
    // Listar
    public ArrayList<Cliente> list() {
        String sql = "SELECT * FROM Quarto";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setEntrada(rs.getDate("entrada"));
                cliente.setSaida(rs.getDate("saida"));
                cliente.setQuarto(rs.getInt("suite"));
                (Cliente).add(cliente);
            }
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
        return Cliente;
    }
    //mudar
    public void update(Cliente cliente, int ID) {
        String sql = "UPDATE Cliente SET cpf = ?, entrada = ?, saida = ?, suite = ? WHERE cpf = ? ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getCpf());
            stmt.setDate(2, (Date) cliente.getEntrada());
            stmt.setDate(3, (Date) cliente.getSaida());
            stmt.setInt(4, cliente.getQuarto());
            stmt.setInt(5, ID);
            stmt.execute();
            stmt.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    //deletar
    public void delete(int ID) {
        String sql = "DELETE FROM Cliente WHERE cpf = " + ID;
        try {
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    //busca
    public ArrayList<Cliente> searchByName(int search) {
        String sql = "SELECT * FROM Cliente WHERE clienteID LIKE '%" + search + "%' ";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setEntrada(rs.getDate("entrada"));
                cliente.setSaida(rs.getDate("saida"));
                cliente.setQuarto(rs.getInt("suite"));
                Cliente.add(cliente);
            }
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
        return Cliente;
    }
    
}