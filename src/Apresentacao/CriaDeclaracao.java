package Apresentacao;

import java.util.Scanner;

import Negocios.CalculaDescontosServico;
import Negocios.DeclaracaoServico;

public class CriaDeclaracao {

	static Scanner in = new Scanner(System.in);

	static CalculaDescontosServico calculaDesconto = new CalculaDescontosServico();

	static DeclaracaoServico declaracao = new DeclaracaoServico(12000, 24000);

	public static void DeclaracaoSimples() {

		double contribuicaoPrevidenciariaOficial;
		double totalRendimentos;

		System.out.println("Insira abaixo sua Contribuicao previdenciaria oficial:");
		contribuicaoPrevidenciariaOficial = in.nextDouble();

		System.out.println("Insira abaixo seu Total de Rendimentos no periodo:");
		totalRendimentos = in.nextDouble();

		double baseDeCalculo = declaracao.CalculaBaseDeCalculo(contribuicaoPrevidenciariaOficial, totalRendimentos);
		double baseComDesconto = calculaDesconto.CalculaDescontoDeclaracaoSimplificada(baseDeCalculo);
		declaracao.CalculaValorDevido(baseComDesconto);
	}

	public static void DeclaracaoCompleta() {

		int idade;
		int nroDependentes;
		double contribuicaoPrevidenciariaOficial;
		double totalRendimentos;

		System.out.println("Insira abaixo sua idade:");
		idade = in.nextInt();

		System.out.println("Insira abaixo o numero de Dependentes:");
		nroDependentes = in.nextInt();

		System.out.println("Insira abaixo sua Contribuicao previdenciaria oficial:");
		contribuicaoPrevidenciariaOficial = in.nextInt();

		System.out.println("Insira abaixo seu Total de Rendimentos no periodo:");
		totalRendimentos = in.nextDouble();

		double baseDeCalculo = declaracao.CalculaBaseDeCalculo(contribuicaoPrevidenciariaOficial, totalRendimentos);
		double baseComDesconto = calculaDesconto.CalculaDescontoDeclaracaoCompleta(baseDeCalculo, idade,
				nroDependentes);
		declaracao.CalculaValorDevido(baseComDesconto);
	}
}
