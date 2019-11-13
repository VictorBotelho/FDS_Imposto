package DadosComuns;

public class Declaracao {
	 public PessoaFisica Pessoa; 
	 
	 public double ContribuicaoPrevidenciariaOficial;  

     public double TotalDeRendimentos;

     public PessoaFisica getPessoa() {
		return Pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		Pessoa = pessoa;
	}

	public double getContribuicaoPrevidenciariaOficial() {
		return ContribuicaoPrevidenciariaOficial;
	}

	public void setContribuicaoPrevidenciariaOficial(double contribuicaoPrevidenciariaOficial) {
		ContribuicaoPrevidenciariaOficial = contribuicaoPrevidenciariaOficial;
	}

	public double getTotalDeRendimentos() {
		return TotalDeRendimentos;
	}

	public void setTotalDeRendimentos(double totalDeRendimentos) {
		TotalDeRendimentos = totalDeRendimentos;
	}

	 
}
