package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Produto;

// Classe utlizada para poder preencher a tabela de remédios no JFrame
public class ProdutoTableModel extends AbstractTableModel {

    public static final int PRODUTO_ID_COL = 0;
    public static final int PRODUTO_NOME_COL = 1;
    public static final int PRODUTO_PRECO_COL = 2;

    public ArrayList<Produto> produtos;

    public ProdutoTableModel(ArrayList<Produto>list) {
        produtos = new ArrayList<Produto>(list);
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int lines, int columns) {
        Produto produto = produtos.get(lines);
        if (columns == PRODUTO_ID_COL) {
            return produto.getId();
        }
        if (columns == PRODUTO_NOME_COL) {
            return produto.getNome();
        }
        if (columns == PRODUTO_PRECO_COL) {
            return produto.getPreco();
        }
        
        return "";
    }

    @Override
    public String getColumnName(int columns) {
        if (columns == PRODUTO_ID_COL) {
            return "ProdutoID";
        }
        if (columns == PRODUTO_NOME_COL) {
            return "Nome";
        }
        if (columns == PRODUTO_PRECO_COL) {
            return "preco";
        }
        return "";
    }

}