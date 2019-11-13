package Apresentacao;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListaContribuintes extends JFrame {
	private JTextArea texto;
	private List<?> listagem;
	
	public ListaContribuintes(List<?> l) {
		super("Listagem");
		listagem = l;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		texto = new JTextArea();
		preencher();
		JScrollPane painelRolagem = new JScrollPane(texto);
		getContentPane().add(painelRolagem);
		setBounds(20, 20, 200, 100);
	}
	
	private void preencher() {
		for(Object o : listagem) {
			texto.append(o.toString() + "\r\n");
		}
	}
}

