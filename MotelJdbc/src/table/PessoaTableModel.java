package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Pessoa;

// Classe utlizada para poder preencher a tabela de remédios no JFrame
public class PessoaTableModel extends AbstractTableModel {

    public static final int PESSOA_CPF_COL = 0;
    public static final int PESSOA_NOME_COL = 1;
    public static final int PESSOA_DATA_COL = 2;
    public static final int PESSOA_TELEFONE_COL = 3;

    public ArrayList<Pessoa> pessoas;

    public PessoaTableModel(ArrayList<Pessoa>list) {
        pessoas = new ArrayList<Pessoa>(list);
    }

    @Override
    public int getRowCount() {
        return pessoas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int lines, int columns) {
        Pessoa pessoa = pessoas.get(lines);
        if (columns == PESSOA_CPF_COL) {
            return pessoa.getCpf();
        }
        if (columns == PESSOA_NOME_COL) {
            return pessoa.getNome();
        }
        if (columns == PESSOA_DATA_COL) {
            return pessoa.getDataNascimento();
        }
        if (columns == PESSOA_TELEFONE_COL) {
            return pessoa.getTelefone();
        }
        return "";
    }

    @Override
    public String getColumnName(int columns) {
        if (columns == PESSOA_CPF_COL) {
            return "Code";
        }
        if (columns == PESSOA_NOME_COL) {
            return "Name";
        }
        if (columns == PESSOA_DATA_COL) {
            return "Description";
        }
        if (columns == PESSOA_TELEFONE_COL) {
            return "Composition";
        }
        return "";
    }

}