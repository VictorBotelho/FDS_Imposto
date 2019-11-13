package Negocios.Interfaces;

import java.util.List;

import DAO.CadastroDAOException;
import DadosComuns.PessoaFisica;

public interface IDeclaracaoServico {
	
	double CalculaBaseDeCalculo(double contribuicaoPrevidenciariaOficial, double totalDeRendimentos);

	int DefineTipoDeclaracao(double baseDeCaCalculo);

	void CalculaValorDevido(double baseDeCalculoFinal);
	
	    boolean adicionar(PessoaFisica p) throws CadastroDAOException;
	    PessoaFisica getPessoaPorNome(String n) throws CadastroDAOException;
	    //List<Pessoa> getHomens() throws CadastroDAOException;
	    //List<Pessoa> getMulheres() throws CadastroDAOException;
	    List<PessoaFisica> getTodos() throws CadastroDAOException;
	
}
