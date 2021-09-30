package model;

import java.util.Date;

public class Pessoa {
	
	private int cpf;
    private String nome;
    private Date dataNascimento;
    private int telefone;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Pessoa:info [cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone
				+ "]";
	}
	
	

}
