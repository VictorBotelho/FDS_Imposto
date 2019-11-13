package Negocios;

import java.util.List;

import DAO.CadastroDAOException;
import DadosComuns.PessoaFisica;
import Negocios.Interfaces.IDeclaracaoServico;

public class DeclaracaoServico implements IDeclaracaoServico {

	private double FaixaInicial;
	private double FaixaIntermediaria;

	public double getFaixaInicial() {
		return FaixaInicial;
	}

	public void setFaixaInicial(double faixaInicial) {
		FaixaInicial = faixaInicial;
	}

	public double getFaixaIntermediaria() {
		return FaixaIntermediaria;
	}

	public void setFaixaIntermediaria(double faixaIntermediaria) {
		FaixaIntermediaria = faixaIntermediaria;
	}

	public DeclaracaoServico(double faixaInicial, double faixaIntermediaria) {
		this.FaixaInicial = faixaInicial;
		this.FaixaIntermediaria = faixaIntermediaria;
	}

	public double CalculaBaseDeCalculo(double contribuicaoPrevidenciariaOficial, double totalDeRendimentos) {
		return totalDeRendimentos - contribuicaoPrevidenciariaOficial;
	}

	public int DefineTipoDeclaracao(double baseDeCaCalculo) {
		if (baseDeCaCalculo < 12000)
			return 1;
		if (baseDeCaCalculo >= 12000 || baseDeCaCalculo < 24000)
			return 2;
		else
			return 3;
	}

	public void CalculaValorDevido(double baseDeCalculoFinal) {

		double faixaInicial = 12000;
		double faixaIntermediaria = 24000;
		double diferencaInicial = baseDeCalculoFinal - faixaInicial;
		double diferencaIntermediaria = baseDeCalculoFinal - faixaIntermediaria;
		double percentualFaixaDois = 0.15;
		double percentualFaixaTres = 0.275;

		int tipo = DefineTipoDeclaracao(baseDeCalculoFinal);

		if (tipo == 1) {
			System.out.println("Não precisa declarar.");
		}
		if (tipo == 2) {
			double valorFinal = diferencaInicial * percentualFaixaDois;
			System.out.println("Declaração Simples \nValor devido: " + valorFinal);
		} else if (tipo == 3) {
			double valorFaixaAnterior = faixaInicial * percentualFaixaDois;
			double valorFinal = valorFaixaAnterior + (diferencaIntermediaria * percentualFaixaTres);
			System.out.println("Declaração Completa \nValor devido: " + valorFinal);
		}
	}

	@Override
	public boolean adicionar(PessoaFisica p) throws CadastroDAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PessoaFisica getPessoaPorNome(String n) throws CadastroDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaFisica> getTodos() throws CadastroDAOException {
		// TODO Auto-generated method stub
		return null;
	}
}
