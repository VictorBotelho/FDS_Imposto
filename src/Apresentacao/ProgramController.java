package Apresentacao;

import DadosComuns.CadastroPessoaFisica;
import DadosComuns.PessoaFisica;
import java.util.Scanner;

public class ProgramController {

	static Scanner in = new Scanner(System.in);

	/*public static void main(String[] args)
	{
		System.out.println("Olá, digite seus dados para cadastro.");
		CriaPessoaFisica();
		SelecionaTipoCalculo();
	}

	public static void CriaPessoaFisica() {
		PessoaFisica pf = new PessoaFisica();

		System.out.print("Insira seu nome:");
		pf.Nome = in.nextLine();

		System.out.print("Insira seu CPF somente com numeros:");
		pf.Cpf = in.nextLine();

		AdicionaPessoaFisica(pf);
	}

	public static void AdicionaPessoaFisica(PessoaFisica pessoa) {
		CadastroPessoaFisica cadastro = new CadastroPessoaFisica();
		cadastro.PessoasFisicasCadastradas.add(pessoa);
	}

	public static void SelecionaTipoCalculo() {
		System.out.println(
				"Qual maneira voce quer calcular sua declaracao de imposto?\nDigite 1 para SIMPLES ou 2 para COMPLETA");
		int tipo = in.nextInt();

		switch (tipo) {
		case 1:
			CriaDeclaracao.DeclaracaoSimples();
			break;
		case 2:
			CriaDeclaracao.DeclaracaoCompleta();
			break;
		}
	}*/
}
