package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import model.Funcionario;


// Classe utlizada para poder preencher a tabela de remédios no JFrame
public class FuncionarioTableModel extends AbstractTableModel {

    public static final int FUNCIONARIO_ID_COL = 0;
    public static final int FUNCIONARIO_CPF_COL = 1;
    public static final int FUNCIONARIO_ENTRADA_COL = 2;

    public ArrayList<Funcionario> funcionarios;

    public FuncionarioTableModel(ArrayList<Funcionario>list) {
        funcionarios = new ArrayList<Funcionario>(list);
    }

    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int lines, int columns) {
    	Funcionario funcionario = funcionarios.get(lines);
        if (columns == FUNCIONARIO_ID_COL) {
            return funcionario.getId();
        }
        if (columns == FUNCIONARIO_CPF_COL) {
            return funcionario.getCpf();
        }
        if (columns == FUNCIONARIO_ENTRADA_COL) {
            return funcionario.getDataEntrada();
        }
        return "";
    }

    @Override
    public String getColumnName(int columns) {
        if (columns == FUNCIONARIO_ID_COL) {
            return "funcionarioID";
        }
        if (columns == FUNCIONARIO_CPF_COL) {
            return "Cpf";
        }
        if (columns == FUNCIONARIO_ENTRADA_COL) {
            return "data_entrada";
        }
        return "";
    }

}