package DadosComuns;

import DAO.CadastroDAOException;
import DAO.CadastroDAOJavaDataBase;
import Negocios.Interfaces.IDeclaracaoServico;

import java.util.List;


public class CadastroFachada {
    private IDeclaracaoServico dao;
    
    public CadastroFachada() throws CadastroException {
        try {
            dao = CadastroDAOJavaDataBase.getInstance();
        } catch (CadastroDAOException e) {
            throw new CadastroException("Falha de criação da fachada!", e);
        }
    }
    
    public PessoaFisica adicionarPessoa(String nome, String telefone, boolean masculino) throws CadastroException{
        if(!ValidadorPessoa.validaNome(nome)) {
            throw new CadastroException("Nome de pessoa inválido!");
        }
        if(!ValidadorPessoa.validaTelefone(telefone)) {
            throw new CadastroException("Número de telefone inválido!");
        }
        PessoaFisica p = new PessoaFisica();
        try {
            boolean ok = dao.adicionar(p);
            if(ok) {
                return p;
            }
            return null;
        } catch (CadastroDAOException e) {
            throw new CadastroException("Falha ao adicionar pessoa!", e);
        }
    }

    /*public List<PessoaFisica> buscarHomens() throws CadastroException{
        try {
            return dao.getHomens();
        } catch (CadastroDAOException e) {
            throw new CadastroException("Falha ao buscar homens!", e);
        }
    }*/

    /*public List<Pessoa> buscarMulheres() throws CadastroException{
        try {
            return dao.getMulheres();
        } catch (CadastroDAOException e) {
            throw new CadastroException("Falha ao buscar mulheres!", e);
        }
    }*/

    public List<PessoaFisica> buscarTodos() throws CadastroException{
        try {
            return dao.getTodos();
        } catch (CadastroDAOException e) {
            throw new CadastroException("Falha ao buscar pessoas!", e);
        }
    }

    public PessoaFisica buscarPessoaPorNome(String n) throws CadastroException{
        try{
            return dao.getPessoaPorNome(n);
        } catch(CadastroDAOException e) {
            throw new CadastroException("Falha ao buscar pessoa", e);
        }
    }
}