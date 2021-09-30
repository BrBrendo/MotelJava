package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import model.Quarto;


// Classe utlizada para poder preencher a tabela de remédios no JFrame
public class QuartoTableModel extends AbstractTableModel {

    public static final int QUARTO_ID_COL = 0;
    public static final int QUARTO_ESTRELA_COL = 1;
    public static final int QUARTO_PRECO_COL = 2;
    public static final int QUARTO_PRODUTO_COL = 3;
    public static final int QUARTO_QUANTIDADE_COL = 4;
    
    
    public ArrayList<Quarto> quartos;

    public QuartoTableModel(ArrayList<Quarto>list) {
        quartos = new ArrayList<Quarto>(list);
    }

    @Override
    public int getRowCount() {
        return quartos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int lines, int columns) {
    	Quarto quarto = quartos.get(lines);
        if (columns == QUARTO_ID_COL) {
            return quarto.getId();
        }
        if (columns == QUARTO_ESTRELA_COL) {
            return quarto.getEstrelas();
        }
        if (columns == QUARTO_PRECO_COL) {
            return quarto.getPreco();
        }
        if (columns == QUARTO_PRODUTO_COL) {
            return quarto.getProduto();
        }
        if (columns == QUARTO_QUANTIDADE_COL) {
            return quarto.getQuantidade();
        }
        return "";
    }

    @Override
    public String getColumnName(int columns) {
    	   if (columns == QUARTO_ID_COL) {
               return "quartoID";
           }
           if (columns == QUARTO_ESTRELA_COL) {
               return "estrelas";
           }
           if (columns == QUARTO_PRECO_COL) {
               return "preco";
           }
           if (columns == QUARTO_PRODUTO_COL) {
               return "produtos";
           }
           if (columns == QUARTO_QUANTIDADE_COL) {
               return "quantidade";
           }
        return "";
    }

}