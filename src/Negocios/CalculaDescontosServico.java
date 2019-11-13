package Negocios;

import Negocios.Interfaces.*;

public class CalculaDescontosServico implements ICalculaDescontosServico

{
	public double CalculaDescontoDeclaracaoSimplificada(double baseDeCaCalculo)

	{
		return baseDeCaCalculo - (baseDeCaCalculo * 0.05);
	}

	public double CalculaDescontoDeclaracaoCompleta(double baseDeCalculo, int idade, int nroDpendentes)

	{
		if (idade > 14 && idade < 65) {
			return DescontoNroDepententesMenos65(nroDpendentes, baseDeCalculo);
		} else {
			return DescontoNroDepententesMais65(nroDpendentes, baseDeCalculo);
		}
	}

	public double DescontoNroDepententesMenos65(int nroDpendentes, double baseDeCalculo)

	{
		if (nroDpendentes > 0) {
			if (nroDpendentes == 1 || nroDpendentes == 2) {
				double percentual = baseDeCalculo * 0.02;
				double valorFinal = baseDeCalculo - percentual;
				return valorFinal;
			}

			if (nroDpendentes >= 3 || nroDpendentes <= 5) {
				double percentual = baseDeCalculo * 0.035;
				double valorFinal = baseDeCalculo - percentual;
				return valorFinal;
			}

			else if (nroDpendentes > 5) {
				double percentual = baseDeCalculo * 0.05;
				double valorFinal = baseDeCalculo - percentual;
				return valorFinal;
			}
		}
		return 0;
	}

	public double DescontoNroDepententesMais65(int nroDpendentes, double baseDeCalculo)
	{
		if (nroDpendentes > 0)
		{
			if (nroDpendentes == 1 || nroDpendentes == 2)
			{
				double percentual = baseDeCalculo * 0.03;
				double valorFinal = baseDeCalculo - percentual;
				return valorFinal;
			}
			if (nroDpendentes >= 3 || nroDpendentes <= 5)
			{
				double percentual = baseDeCalculo * 0.045;
				double valorFinal = baseDeCalculo - percentual;
				return valorFinal;
			}
			else if (nroDpendentes > 5)
			{
				double percentual = baseDeCalculo * 0.06;
				double valorFinal = baseDeCalculo - percentual;
				return valorFinal;
			}
		}
		return 0;
	}

}
