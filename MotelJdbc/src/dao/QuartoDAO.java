package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Quarto;

public class QuartoDAO {
	 	
	
		private Connection conn;
	    private PreparedStatement stmt;
	    private Statement st;
	    private ResultSet rs;
	    private ArrayList<Quarto> Quarto = new ArrayList<Quarto>();

	    public QuartoDAO() {
	        conn = new ConnectionFactory().getConnection();
	    }
	    
	    
	    //criar
	    public void create(Quarto quarto) {
	        String sql = "INSERT INTO Quarto  (estrelas, preco, produtos, quantidade) VALUES (?, ?, ?, ?)";
	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, quarto.getEstrelas());
	            stmt.setDouble(2, quarto.getPreco());
	            stmt.setInt(3, quarto.getProduto());
	            stmt.setInt(4, quarto.getQuantidade());
	            stmt.execute();
	            stmt.close();
	        } catch (Exception error) {
	            throw new RuntimeException("Error: " + error);
	        }
	    }
	    
	    
	    // Listar
	    public ArrayList<Quarto> list() {
	        String sql = "SELECT * FROM Quarto";
	        try {
	            st = conn.createStatement();
	            rs = st.executeQuery(sql);
	            while (rs.next()) {
	                Quarto quarto = new Quarto();
	                quarto.setEstrelas(rs.getInt("estrelas"));
	                quarto.setPreco(rs.getDouble("preco"));
	                quarto.setProduto(rs.getInt("produtos"));
	                quarto.setQuantidade(rs.getInt("quantidade"));
	                (Quarto).add(quarto);
	            }
	        } catch (Exception error) {
	            throw new RuntimeException("Error: " + error);
	        }
	        return Quarto;
	    }
	    //mudar
	    public void update(Quarto quarto,int ID) {
	        String sql = "UPDATE Quarto SET estrelas = ?, preco = ?, produtos = ?, quantidade = ? WHERE quartoID = ? ";
	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, quarto.getEstrelas());
	            stmt.setDouble(2, quarto.getPreco());
	            stmt.setInt(3, quarto.getProduto());
	            stmt.setInt(4, quarto.getQuantidade());
	            stmt.setInt(5, ID);
	            stmt.execute();
	            stmt.close();
	        } catch (Exception error) {
	            throw new RuntimeException("Error: " + error);
	        }
	    }
	    //deletar
	    public void delete(int ID) {
	        String sql = "DELETE FROM Quarto WHERE quartoID = " + ID;
	        try {
	            st = conn.createStatement();
	            st.execute(sql);
	            st.close();
	        } catch (Exception error) {
	            throw new RuntimeException("Error: " + error);
	        }
	    }
	    //busca
	    public ArrayList<Quarto> searchByName(int search) {
	        String sql = "SELECT * FROM Quarto WHERE quartoID LIKE '%" + search + "%' ";
	        try {
	            st = conn.createStatement();
	            rs = st.executeQuery(sql);
	            while (rs.next()) {
	                Quarto quarto = new Quarto();
	                quarto.setEstrelas(rs.getInt("estrelas"));
	                quarto.setPreco(rs.getDouble("preco"));
	                quarto.setProduto(rs.getInt("produtos"));
	                quarto.setQuantidade(rs.getInt("quantidade"));
	                Quarto.add(quarto);
	            }
	        } catch (Exception error) {
	            throw new RuntimeException("Error: " + error);
	        }
	        return Quarto;
	    }
	    
	}
