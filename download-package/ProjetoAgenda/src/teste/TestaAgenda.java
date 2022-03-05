package teste;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import telas.TelaAgenda;

public class TestaAgenda {

	public static void main(String[] args) {
		TelaAgenda agenda = new TelaAgenda("AGENDA DE CONTATOS");
		agenda.setVisible(true);
		agenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		agenda.setLocation((tela.width-(agenda).getSize().width)/2,
				(tela.height-(agenda).getSize().height)/2);
		agenda.setVisible(true);
	}

}