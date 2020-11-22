package programacaoII.motorista;

import javax.persistence.Entity;

import programacaoII.BaseEntity;

@Entity
public class Motorista extends BaseEntity {

	private String nome;
	private String idade;
	private String cpf;
	private String veiculo;

	public Motorista() {
	}

	public Motorista(String nome, String idade, String cpf, String veiculo) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.veiculo = veiculo;
	}

	public String getNome() {
		return nome;
	}

	public String getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getVeiculo() {
		return veiculo;
	}

}
