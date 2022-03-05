package telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import agenda.Contato;
import agenda.Nomes;

/*DECLARAÇÃO DE VARIÁVEIS*/
public class TelaAgenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpFundo;
	private JLabel jlNome,jlEndereco,jlTelefone,jlIndice1,jlIndice2,jlDDD, jlImagem;
	private JLabel jlAviso1, jlAviso2, jlSlogan, jlSlogan1, jlSlogan2;
	private JTextField jtfNome, jtfEndereco, jtfTelefone,jtfIndice1,jtfIndice2,jtfDDD;
	private JButton jbCadastrar,jbVerificar,jbAlterar,jbRemover,jbApagar;
	private JTextArea jtaMostrar;
	private ImageIcon imagem;
	private JScrollPane scroll;
	
	/*MATRIZ*/
	List<Contato>contato = new ArrayList<Contato>();
	
	/*FORMATAÇÕES*/
	Font fonte = new Font("Courrier New 11", Font.BOLD, 12);
	Font fonte2 = new Font("Times New Roman", Font.BOLD, 12);
	Font fonte3 = new Font("Times New Roman", Font.ITALIC, 12);
	Font font4 = new Font("Agency FB", Font.BOLD,36);
	Font font5 = new Font("Agency FB", Font.ITALIC, 18);
	Font font6 = new Font("Agency FB", Font.CENTER_BASELINE,36);
	Color azul = new Color(101,203,195);
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	/*FORMATAÇÃO DA JANELA*/
	public TelaAgenda(String title) {
		super("AGENDA DE CONTATOS");
		iniciarComponentes();
		iniciarEventos();
		jtfNome.setDocument(new Nomes());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		URL caminhoIcone = getClass().getResource("/imagem/agenda.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(iconeTitulo);
	}

	private void iniciarComponentes() {
		setSize(1200,700);
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);

		/*DEFININDO OS CAMPOS*/
		jlNome = new JLabel("NOME*");
		jtfNome = new JTextField();

		jlEndereco = new JLabel("ENDEREÇO*");
		jtfEndereco = new JTextField();

		jlDDD = new JLabel("DDD");
		jtfDDD = new JTextField();

		jlTelefone = new JLabel("TELEFONE*");
		jtfTelefone = new JTextField();

		jlIndice1 = new JLabel("INDICE (ALTERAR)");
		jtfIndice1 = new JTextField();

		jlIndice2 = new JLabel("INDICE (REMOVER)");
		jtfIndice2 = new JTextField();

		jbCadastrar = new JButton("CADASTRAR");
		jbVerificar = new JButton("VERIFICAR");
		jbAlterar = new JButton("ALTERAR");
		jbRemover = new JButton("REMOVER");
		jbApagar = new JButton("APAGAR");

		jtaMostrar = new JTextArea("");
		scroll = new JScrollPane(jtaMostrar);

		imagem = new ImageIcon(getClass().getResource("/imagem/logoAgenda.png"));

		jlImagem = new JLabel(imagem);
		jpFundo = new JPanel();

		jlAviso1 = new JLabel("*Para alterar algum contato você deverá inserir o indice após completar todos os campos novamente.");
		jlAviso2 = new JLabel("*Para remover algum contato você deverá apenas inserir o indice do mesmo.");
		
		jlSlogan = new JLabel("•••");
		jlSlogan1 = new JLabel("HEY, OLÁ!");
		jlSlogan2 = new JLabel("Comece agora a adicionar seus contatos.");

		/*ESTILIZANDO COMPONENTES*/
		jlNome.setForeground(Color.BLACK);
		jlNome.setFont(fonte);
		jtfNome.setBorder(new LineBorder(Color.GRAY));

		jlEndereco.setForeground(Color.BLACK);
		jlEndereco.setFont(fonte);
		jtfEndereco.setBorder(new LineBorder(Color.GRAY));

		jlDDD.setForeground(Color.BLACK);
		jlDDD.setFont(fonte);
		jtfDDD.setBorder(new LineBorder(Color.GRAY));

		jlTelefone.setForeground(Color.BLACK);
		jlTelefone.setFont(fonte);
		jtfTelefone.setBorder(new LineBorder(Color.GRAY));

		jlIndice1.setForeground(Color.BLACK);
		jlIndice1.setFont(fonte);
		jtfIndice1.setBorder(new LineBorder(Color.GRAY));

		jlIndice2.setForeground(Color.BLACK);
		jlIndice2.setFont(fonte);
		jtfIndice2.setBorder(new LineBorder(Color.GRAY));
		
		jpFundo.setBackground(Color.WHITE);
		jpFundo.setLayout(null);

		jlAviso1.setForeground(Color.BLACK);
		jlAviso1.setFont(fonte3);
		jlAviso2.setForeground(Color.BLACK);
		jlAviso2.setFont(fonte3);
		
		jlSlogan.setForeground(azul);
		jlSlogan.setFont(font6);
		jlSlogan1.setForeground(Color.WHITE);
		jlSlogan1.setFont(font4);
		jlSlogan2.setForeground(Color.WHITE);
		jlSlogan2.setFont(font5);
		
		jtaMostrar.setForeground(azul);
		jtaMostrar.setBackground(Color.WHITE);
		jtaMostrar.setFont(fonte2);
		
		scroll.setForeground(azul);
		scroll.setBackground(Color.WHITE);
		scroll.setFont(fonte2);
		scroll.setBorder(new LineBorder(azul));

		/*ESTILIZANDO BOTÕES*/
		
		jbCadastrar.setBackground(azul);
		jbCadastrar.setForeground(Color.WHITE);
		jbCadastrar.setFont(fonte2);
		jbCadastrar.setBorder(null);
		jbCadastrar.setCursor(cursor);
		jbCadastrar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				jbCadastrar.setBackground(azul);
				jbCadastrar.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbCadastrar.setBackground(Color.WHITE);
				jbCadastrar.setForeground(azul);
				jbCadastrar.setBorder(new LineBorder(azul));
			}
		});

		jbAlterar.setBackground(azul);
		jbAlterar.setForeground(Color.WHITE);
		jbAlterar.setFont(fonte2);
		jbAlterar.setBorder(null);
		jbAlterar.setCursor(cursor);
		jbAlterar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				jbAlterar.setBackground(azul);
				jbAlterar.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbAlterar.setBackground(Color.WHITE);
				jbAlterar.setForeground(azul);
				jbAlterar.setBorder(new LineBorder(azul));
			}
		});

		jbRemover.setBackground(azul);
		jbRemover.setForeground(Color.WHITE);
		jbRemover.setFont(fonte2);
		jbRemover.setBorder(null);
		jbRemover.setCursor(cursor);
		jbRemover.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				jbRemover.setBackground(azul);
				jbRemover.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbRemover.setBackground(Color.WHITE);
				jbRemover.setForeground(azul);
				jbRemover.setBorder(new LineBorder(azul));
			}
		});

		jbVerificar.setBackground(azul);
		jbVerificar.setForeground(Color.WHITE);
		jbVerificar.setFont(fonte2);
		jbVerificar.setBorder(null);
		jbVerificar.setCursor(cursor);
		jbVerificar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				jbVerificar.setBackground(azul);
				jbVerificar.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbVerificar.setBackground(Color.WHITE);
				jbVerificar.setForeground(azul);
				jbVerificar.setBorder(new LineBorder(azul));
			}
		});


		jbApagar.setBackground(azul);
		jbApagar.setForeground(Color.WHITE);
		jbApagar.setBorder(null);
		jbApagar.setFont(fonte2);
		jbApagar.setCursor(cursor);
		jbApagar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				jbApagar.setBackground(azul);
				jbApagar.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbApagar.setBackground(Color.WHITE);
				jbApagar.setForeground(azul);
				jbApagar.setBorder(new LineBorder(azul));
			}
		});

		/*ADICIONANDO OS CAMPOS*/
		add(jlNome);
		add(jtfNome);
		add(jlEndereco);
		add(jtfEndereco);
		add(jlDDD);
		add(jtfDDD);
		add(jlTelefone);
		add(jtfTelefone);
		add(jlIndice1);
		add(jtfIndice1);
		add(jlIndice2);
		add(jtfIndice2);
		add(jbCadastrar);
		add(jbVerificar);
		add(jbAlterar);
		add(jbRemover);
		add(jbApagar);
		add(scroll);
		add(jlAviso1);
		add(jlAviso2);
		add(jpFundo);
		add(jlSlogan);
		add(jlSlogan1);
		add(jlSlogan2);
		add(jlImagem);

		/*FORMATACÃO DAS CAIXAS*/
		jpFundo.setBounds(500, 0, 1000, 750);
		jlNome.setBounds(600, 10, 50, 20);
		jtfNome.setBounds(600, 40, 480, 25);
		jlEndereco.setBounds(600, 100, 100, 20);
		jtfEndereco.setBounds(600, 130, 480, 25);
		jlDDD.setBounds(600, 190, 100, 20);
		jtfDDD.setBounds(600, 210, 40, 25);
		jlTelefone.setBounds(650, 190, 100, 20);
		jtfTelefone.setBounds(650, 210, 430, 25);
		jbCadastrar.setBounds(600, 260, 220, 25);
		jbVerificar.setBounds(860, 260, 220, 25);

		/*Caixa de Texto*/
		jbApagar.setBounds(600, 420, 480, 25);
		scroll.setBounds(600, 310, 480, 105);
		
		/*Alterar*/
		jlIndice1.setBounds(600, 460, 200, 20);
		jlAviso1.setBounds(600, 470, 600, 50);
		jtfIndice1.setBounds(600, 510, 40, 25);
		jbAlterar.setBounds(650, 510, 430, 25);

		/*Remover*/
		jlIndice2.setBounds(600, 570, 200, 20);
		jlAviso2.setBounds(600, 580, 600, 50);
		jtfIndice2.setBounds(600, 620, 40, 25);
		jbRemover.setBounds(650, 620, 430, 25);
	
		jlSlogan.setBounds(225, 90, 500, 50);
		jlSlogan1.setBounds(200, 150, 500, 50);
		jlSlogan2.setBounds(150, 190, 500, 50);
		jlImagem.setBounds(0, 180, 500, 500);
	}

	private void iniciarEventos() {
		/*CADASTRAR*/
		jbCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!jtfNome.getText().isEmpty()&& !jtfEndereco.getText().isEmpty()&& 
							!jtfTelefone.getText().isEmpty()&& !jtfDDD.getText().isEmpty()) {
						contato.add(new Contato(jtfNome.getText(), 
								jtfEndereco.getText(),
								Integer.parseInt(jtfTelefone.getText()),
								Integer.parseInt(jtfDDD.getText())));
						jtfNome.setText("");
						jtfEndereco.setText("");
						jtfDDD.setText("");
						jtfTelefone.setText("");
						jtaMostrar.setText("");
						jtaMostrar.setText("Pressione 'Verificar'...");
					} else {
						jtaMostrar.setText("");
						jtaMostrar.setText("Complete todos os campos...");
					}

				} catch (Exception e2) {
					jtaMostrar.setText("");
					jtaMostrar.setText("Apenas números são aceitos nos campos 'Telefone' e 'DDD'...");
				}
			}
		});

		/*VERIFICAR*/
		jbVerificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText(""); 
				int i, n = 0;
				for (i=1; i<n; i++)
					jtaMostrar.setText(""); 
				for (Contato contato2 : contato) {
					jtaMostrar.append("\n"+(i++)+"."
							+" Nome: "+contato2.getNome()
							+"\nEndereço: "+contato2.getEndereco()
							+"\nTelefone: "+"("+contato2.getnDDD()+")"+" "+contato2.getTelefone()
							+"\n");
				}
			}
		});

		/*ALTERAR*/
		jbAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!jtfNome.getText().isEmpty()&& !jtfEndereco.getText().isEmpty()&& !jtfTelefone.getText().isEmpty()&& 
							!jtfDDD.getText().isEmpty()&& !jtfIndice1.getText().isEmpty()) {
						int indice = Integer.parseInt(jtfIndice1.getText());
						contato.get(indice-1).setNome(jtfNome.getText());
						contato.get(indice-1).setEndereco(jtfEndereco.getText());
						contato.get(indice-1).setnDDD(Integer.parseInt(jtfDDD.getText()));
						contato.get(indice-1).setTelefone(Integer.parseInt(jtfTelefone.getText()));
						jtfNome.setText("");
						jtfEndereco.setText("");
						jtfDDD.setText("");
						jtfTelefone.setText("");
						jtfIndice1.setText("");
						jtaMostrar.setText("");
						jtaMostrar.setText("Pressione 'Verificar' novamente...");
					} else {
						jtaMostrar.setText("");
						jtaMostrar.setText("Complete todos os campos...");
					}	
				} catch (Exception e2) {
					jtaMostrar.setText("");
					jtaMostrar.setText("Apenas números são aceitos nos campos 'Indice', 'Telefone' e 'DDD'...");
				}
			}
		});

		/*REMOVER*/
		jbRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!jtfIndice2.getText().isEmpty()) {
						int indice = Integer.parseInt(jtfIndice2.getText());
						contato.remove(indice-1);
						jtfIndice2.setText("");
						jtaMostrar.setText("Pressione 'Verificar' novamente...");
					} else {
						jtaMostrar.setText("");
						jtaMostrar.setText("Insira o indice...");
					}
				} catch (Exception e2) {
					jtaMostrar.setText("");
					jtaMostrar.setText("Apenas números são aceitos no campo 'Indice'...");
				}
			}
		});

		/*APAGAR*/
		jbApagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jtaMostrar.setText("");
				contato.clear();
			}
		});
	}

}