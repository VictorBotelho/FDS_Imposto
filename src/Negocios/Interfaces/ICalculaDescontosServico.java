package Negocios.Interfaces;

public interface ICalculaDescontosServico {

	double CalculaDescontoDeclaracaoSimplificada(double baseDeCaCalculo);

	double CalculaDescontoDeclaracaoCompleta(double baseDeCalculo, int idade, int nroDpendentes);

	double DescontoNroDepententesMenos65(int nroDpendentes, double baseDeCalculo);

	double DescontoNroDepententesMais65(int nroDpendentes, double baseDeCalculo);
}
