package DadosComuns;

public class ValidadorPessoa {
    public static boolean validaNome(String nome) {
        return nome.contains(" ");
    }
    public static boolean validaTelefone(String telefone) {
        return (telefone.length() == 8);
    }
}