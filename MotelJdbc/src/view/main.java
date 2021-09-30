package view;

import dao.PessoaDAO;
import model.Pessoa;

public class main {

	public static void main(String[] args) {
		
		PessoaDAO dao = new PessoaDAO();
		
		for(Pessoa p : dao.list()) {
			System.out.println(p.toString());
		}

	}

}
