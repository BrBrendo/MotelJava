package dao;


import model.Cliente;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
Classe CRUD
DAO = Data Access Object
*/

public class ProdutoDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Produto> Produto = new ArrayList<Produto>();

    public ProdutoDAO() {
        conn = new ConnectionFactory().getConnection();
    }
    
    
    //criar
    public void create(Produto produto) {
        String sql = "INSERT INTO Produto  (nome, preco) VALUES (?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.execute();
            stmt.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    
    // Listar
    public ArrayList<Produto> list() {
        String sql = "SELECT * FROM Produto";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("produtoID"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                (Produto).add(produto);
            }
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
        return Produto;
    }
    //mudar
    public void update(Produto produto) {
        String sql = "UPDATE Funcionario SET nome = ?, preco = ? WHERE nome = ? ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getNome());
            stmt.execute();
            stmt.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    //deletar
    public void delete(String nome) {
        String sql = "DELETE FROM Funcionario WHERE nome = " + nome;
        try {
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
    }
    //busca
    public ArrayList<Produto> searchByName(String search) {
        String sql = "SELECT * FROM Funcionario WHERE name LIKE '%" + search + "%' ";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	Produto produto = new Produto();
            	produto.setId(rs.getInt("produtoID"));
            	produto.setNome(rs.getString("nome"));
            	produto.setPreco(rs.getDouble("preco"));
            	Produto.add(produto);
            }
        } catch (Exception error) {
            throw new RuntimeException("Error: " + error);
        }
        return Produto;
    }
    
}