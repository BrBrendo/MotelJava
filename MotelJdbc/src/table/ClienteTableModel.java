package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import model.Cliente;



// Classe utlizada para poder preencher a tabela de remédios no JFrame
public class ClienteTableModel extends AbstractTableModel {

    public static final int CLIENTE_ID_COL = 0;
    public static final int CLIENTE_CPF_COL = 1;
    public static final int CLIENTE_ENTRADA_COL = 2;
    public static final int CLIENTE_SAIDA_COL = 3;
    public static final int CLIENTE_SUITE_COL = 4;
    
    
    public ArrayList<Cliente> clientes;

    public ClienteTableModel(ArrayList<Cliente>list) {
        clientes = new ArrayList<Cliente>(list);
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int lines, int columns) {
    	Cliente cliente = clientes.get(lines);
        if (columns == CLIENTE_ID_COL) {
            return cliente.getId();
        }
        if (columns == CLIENTE_CPF_COL) {
            return cliente.getCpf();
        }
        if (columns == CLIENTE_ENTRADA_COL) {
            return cliente.getEntrada();
        }
        if (columns == CLIENTE_SAIDA_COL) {
            return cliente.getSaida();
        }
        if (columns == CLIENTE_SUITE_COL) {
            return cliente.getQuarto();
        }
        return "";
    }

    @Override
    public String getColumnName(int columns) {
    	   if (columns == CLIENTE_ID_COL) {
               return "clienteID";
           }
           if (columns == CLIENTE_CPF_COL) {
               return "cpf";
           }
           if (columns == CLIENTE_ENTRADA_COL) {
               return "entrada";
           }
           if (columns == CLIENTE_SAIDA_COL) {
               return "saida";
           }
           if (columns == CLIENTE_SUITE_COL) {
               return "suite";
           }
        return "";
    }

}