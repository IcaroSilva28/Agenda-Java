package agenda;

public class Contato{
	private String nome;
	private String endereco;
	private int telefone;
	private int nDDD;

	/*CONSTRUTOR*/
	public Contato(String nome, String endereco, int telefone, int nDDD) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nDDD = nDDD;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public void setTelefone(String text) {

	}

	public int getnDDD() {
		return nDDD;
	}

	public void setnDDD(int nDDD) {
		this.nDDD = nDDD;
	}
}

