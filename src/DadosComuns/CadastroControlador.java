package DadosComuns;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import DadosComuns.*;


public class CadastroControlador {
    private CadastroFachada fachada;
    private ListaPessoaFisica modelSaidaTexto;

    public CadastroControlador() throws CadastroException {
        fachada = new CadastroFachada();
        modelSaidaTexto = new ListaPessoaFisica(toListString(fachada.buscarTodos()));
    }

    public ListModel<String> getListaPessoaFisica(){
        return modelSaidaTexto;
    }
    
    private List<String> toListString(List<PessoaFisica> listaOrigem) {
        List<String> listaDestino = new ArrayList<String>(listaOrigem.size());
        for(PessoaFisica p : listaOrigem) {
            listaDestino.add(p.toString());
        }
        return listaDestino;
    }
    
    public boolean adicionarPessoa(String nome, String telefone, boolean masculino) throws CadastroException {
    	PessoaFisica p = fachada.adicionarPessoa(nome, telefone, masculino);
        if(p != null){
            modelSaidaTexto.add(p.toString());
            return true;
        }
        return false;
    }

    /*public List<String> buscarHomens() throws CadastroException {
        return toListString(fachada.buscarHomens());
    }

    public List<String> buscarMulheres() throws CadastroException {
        return toListString(fachada.buscarMulheres());
    }*/

    public List<String> getTodos() throws CadastroException {
        return toListString(fachada.buscarTodos());
    }
}
