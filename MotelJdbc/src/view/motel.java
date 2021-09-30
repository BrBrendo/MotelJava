package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import dao.QuartoDAO;
import model.Cliente;
import model.Funcionario;
import model.Pessoa;
import model.Produto;
import model.Quarto;
import table.ClienteTableModel;
import table.FuncionarioTableModel;
import table.PessoaTableModel;
import table.ProdutoTableModel;
import table.QuartoTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;



public class motel {

	private JFrame frame;
	private JTextField cpfPessoa;
	private JTextField nomePessoa;
	private JTextField dataPessoa;
	private JTextField telefonePessoa;
	 Pessoa pessoa = new Pessoa();
	 Funcionario funcionario = new Funcionario();
	 Quarto quarto = new Quarto();
	 Produto produto = new Produto();
	 Cliente cliente = new Cliente();
	 
	 
	    // Instancia objeto de acesso aos dados do nosso model
	    PessoaDAO pessoaDAO = new PessoaDAO();
	    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	    QuartoDAO quartoDAO = new QuartoDAO();
	    ProdutoDAO produtoDAO = new ProdutoDAO();
	    ClienteDAO clienteDAO = new ClienteDAO();
	    
	    
	    private JTextField CpfFuncionario;
	    private JTable table;
	    private JTable table_1;
	    private JTextField dataEntrada;
	    private JTextField nomeProduto;
	    private JTable table_2;
	    private JTable table_3;
	    private JTable table_4;
	    private JTextField cpfCliente;
	    private JTextField estrelaQuarto;
	    private JTextField precoQuarto;
	    private JTextField produtoQuarto;
	    private JTextField qteQuarto;
	    private JTextField idQuarto;
	    private JTextField entradaCliente;
	    private JTextField saidaCliente;
	    private JTextField suiteCliente;
	    private JTextField precoProduto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					motel window = new motel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public motel() {
		initialize();
		table.setModel(new PessoaTableModel(new PessoaDAO().list()));
		table_1.setModel(new FuncionarioTableModel(new FuncionarioDAO().list()));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"quartoID", "estrelas", "preco", "produtos", "quantidade"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_3.setModel(new ClienteTableModel(new ClienteDAO().list()));
		table_4.setModel(new ProdutoTableModel(new ProdutoDAO().list()));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 503, 385);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Pessoa", null, panel, null);
		panel.setLayout(null);
		
		cpfPessoa = new JTextField();
		cpfPessoa.setBounds(117, 11, 256, 20);
		panel.add(cpfPessoa);
		cpfPessoa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("cpf");
		lblNewLabel.setBounds(10, 14, 48, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(10, 52, 48, 14);
		panel.add(lblNome);
		
		JLabel lblDataNascimento = new JLabel("data nascimento");
		lblDataNascimento.setBounds(10, 92, 85, 14);
		panel.add(lblDataNascimento);
		
		JLabel lblTelefone = new JLabel("telefone");
		lblTelefone.setBounds(10, 135, 48, 14);
		panel.add(lblTelefone);
		
		telefonePessoa = new JTextField();
		telefonePessoa.setBounds(117, 132, 256, 20);
		panel.add(telefonePessoa);
		telefonePessoa.setColumns(10);
		
		dataPessoa = new JTextField();
		dataPessoa.setBounds(117, 89, 256, 20);
		panel.add(dataPessoa);
		dataPessoa.setColumns(10);
		
		nomePessoa = new JTextField();
		nomePessoa.setBounds(117, 49, 256, 20);
		panel.add(nomePessoa);
		nomePessoa.setColumns(10);
		
		
		//ADICIONAAAR
		Button adicionar = new Button("adicionar");
		adicionar.setBounds(49, 171, 70, 22);
		panel.add(adicionar);
		adicionar.setActionCommand("adicionar");
		
		
		//ATUZALIZAAAR
		Button update = new Button("update");
		update.setBounds(241, 171, 70, 22);
		panel.add(update);
		
		
		//DELETAR
		Button delete = new Button("delete");
		delete.setBounds(347, 171, 70, 22);
		panel.add(delete);
		
		
		///===========ABA PESSOA=======================
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(59, 199, 358, 158);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		table.setBounds(0, 0, 358, 158);
		panel_2.add(table);
		
		Button read = new Button("atualizar");
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new PessoaTableModel(new PessoaDAO().list()));
			}
		});
		read.setActionCommand("read");
		read.setBounds(423, 199, 70, 22);
		panel.add(read);
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Deletar cadastro", JOptionPane.YES_NO_OPTION);
		        if (choice == 0) {
		            //confirmaçao
		            int  id = Integer.parseInt(cpfPessoa.getText());
		           pessoaDAO.delete(id);
				
		        }
			}
		});
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				pessoa.setCpf(Integer.parseInt(cpfPessoa.getText()));
                pessoa.setNome(nomePessoa.getText());
                try {
					pessoa.setDataNascimento(formatter.parse(dataPessoa.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                pessoa.setTelefone(Integer.parseInt(telefonePessoa.getText()));
                pessoaDAO.update(pessoa);
				
				
				
			}
		});
		
	
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				pessoa.setCpf(Integer.parseInt(cpfPessoa.getText()));
                pessoa.setNome(nomePessoa.getText());
                try {
					pessoa.setDataNascimento(formatter.parse(dataPessoa.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                pessoa.setTelefone(Integer.parseInt(telefonePessoa.getText()));
                pessoaDAO.create(pessoa);
                
			}
		});
		
		
		
		//========= aba FUNCIONARIO=================
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Funcionario", null, panel_1, null);
		panel_1.setLayout(null);
		
		Button adicionar_1 = new Button("adicionar");
		
		
		adicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				funcionario.setCpf(Integer.parseInt(CpfFuncionario.getText()));
				try {
					funcionario.setDataEntrada(formatter.parse(dataEntrada.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				funcionarioDAO.create(funcionario);
			}
				
		});
		adicionar_1.setActionCommand("adicionar");
		adicionar_1.setBounds(46, 164, 70, 22);
		panel_1.add(adicionar_1);
		
		Button update_1 = new Button("update");
		update_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				funcionario.setCpf(Integer.parseInt(CpfFuncionario.getText()));
				 try {
						funcionario.setDataEntrada(formatter.parse(dataEntrada.getText()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				funcionarioDAO.update(funcionario);
			}
		});
		update_1.setBounds(238, 164, 70, 22);
		panel_1.add(update_1);
		
		Button delete_1 = new Button("delete");
		delete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int choice = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Deletar cadastro", JOptionPane.YES_NO_OPTION);
		        if (choice == 0) {
		            //confirmaçao
		            int  cpf = Integer.parseInt(CpfFuncionario.getText());
		           funcionarioDAO.delete(cpf);
				
			}
		  }
		});
		delete_1.setBounds(344, 164, 70, 22);
		panel_1.add(delete_1);
		
		JLabel lblNewLabel_1 = new JLabel("cpf");
		lblNewLabel_1.setBounds(10, 29, 48, 14);
		panel_1.add(lblNewLabel_1);
		
		CpfFuncionario = new JTextField();
		CpfFuncionario.setColumns(10);
		CpfFuncionario.setBounds(100, 26, 256, 20);
		panel_1.add(CpfFuncionario);
		
		table_1 = new JTable();
		table_1.setToolTipText("");
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setBounds(56, 199, 358, 158);
		panel_1.add(table_1);
		
		dataEntrada = new JTextField();
		dataEntrada.setColumns(10);
		dataEntrada.setBounds(100, 68, 256, 20);
		panel_1.add(dataEntrada);
		
		JLabel lblNewLabel_1_2 = new JLabel("entrada");
		lblNewLabel_1_2.setBounds(10, 71, 48, 14);
		panel_1.add(lblNewLabel_1_2);
		
		Button read_1 = new Button("atualizar");
		read_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_1.setModel(new FuncionarioTableModel(new FuncionarioDAO().list()));
			}
		});
		read_1.setActionCommand("read_1");
		read_1.setBounds(420, 200, 70, 22);
		panel_1.add(read_1);
		
		//======== ABA QUARTO=====================================================
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Quarto", null, panel_4, null);
		panel_4.setLayout(null);
		// adicionar
		Button adicionar_1_1_2 = new Button("adicionar");
		adicionar_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				quarto.setEstrelas(Integer.parseInt(estrelaQuarto.getText()));
				quarto.setPreco(Double.parseDouble(precoQuarto.getText()));
				quarto.setProduto(Integer.parseInt(produtoQuarto.getText()));
				quarto.setQuantidade(Integer.parseInt(qteQuarto.getText()));
				
				quartoDAO.create(quarto);
			}
				
			
		});
		adicionar_1_1_2.setActionCommand("adicionar");
		adicionar_1_1_2.setBounds(39, 168, 70, 22);
		panel_4.add(adicionar_1_1_2);
		///// update
		Button update_1_1_2 = new Button("update");
		update_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				quarto.setEstrelas(Integer.parseInt(estrelaQuarto.getText()));
				quarto.setPreco(Double.parseDouble(precoQuarto.getText()));
				quarto.setProduto(Integer.parseInt(produtoQuarto.getText()));
				quarto.setQuantidade(Integer.parseInt(qteQuarto.getText()));
				int id = (Integer.parseInt(idQuarto.getText()));
				quartoDAO.update(quarto,id);
			}
		});
		update_1_1_2.setBounds(189, 168, 70, 22);
		panel_4.add(update_1_1_2);
		/////deletar
		Button delete_1_1_2 = new Button("delete");
		delete_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int choice = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Deletar cadastro", JOptionPane.YES_NO_OPTION);
		        if (choice == 0) {
		            //confirmaçao
		            int  id = Integer.parseInt(idQuarto.getText());
		           quartoDAO.delete(id);
				}
		   }
		});
		delete_1_1_2.setBounds(292, 168, 70, 22);
		panel_4.add(delete_1_1_2);
		
		Button read_1_1_2 = new Button("atualizar");
		read_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_2.setModel(new QuartoTableModel(new QuartoDAO().list()));
				
				
			}
		});
		read_1_1_2.setActionCommand("read_1");
		read_1_1_2.setBounds(421, 199, 70, 22);
		panel_4.add(read_1_1_2);
		
		table_3 = new JTable();
		table_3.setToolTipText("");
		table_3.setSurrendersFocusOnKeystroke(true);
		table_3.setBounds(57, 199, 358, 158);
		panel_4.add(table_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("estrelas");
		lblNewLabel_1_1_2.setBounds(10, 37, 48, 14);
		panel_4.add(lblNewLabel_1_1_2);
		
		estrelaQuarto = new JTextField();
		estrelaQuarto.setColumns(10);
		estrelaQuarto.setBounds(106, 34, 256, 20);
		panel_4.add(estrelaQuarto);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("pre\u00E7os");
		lblNewLabel_1_1_2_1.setBounds(10, 65, 48, 14);
		panel_4.add(lblNewLabel_1_1_2_1);
		
		precoQuarto = new JTextField();
		precoQuarto.setColumns(10);
		precoQuarto.setBounds(106, 62, 256, 20);
		panel_4.add(precoQuarto);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("produto");
		lblNewLabel_1_1_2_2.setBounds(10, 93, 48, 14);
		panel_4.add(lblNewLabel_1_1_2_2);
		
		produtoQuarto = new JTextField();
		produtoQuarto.setColumns(10);
		produtoQuarto.setBounds(106, 90, 256, 20);
		panel_4.add(produtoQuarto);
		
		JLabel lblNewLabel_1_1_2_3 = new JLabel("quantidade");
		lblNewLabel_1_1_2_3.setBounds(10, 121, 63, 14);
		panel_4.add(lblNewLabel_1_1_2_3);
		
		qteQuarto = new JTextField();
		qteQuarto.setColumns(10);
		qteQuarto.setBounds(106, 118, 256, 20);
		panel_4.add(qteQuarto);
		
		JLabel lblNewLabel_1_1_2_4 = new JLabel("id");
		lblNewLabel_1_1_2_4.setBounds(10, 14, 48, 14);
		panel_4.add(lblNewLabel_1_1_2_4);
		
		idQuarto = new JTextField();
		idQuarto.setColumns(10);
		idQuarto.setBounds(106, 11, 256, 20);
		panel_4.add(idQuarto);
		
		////===========ABA CLIENTE===================================
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Cliente", null, panel_5, null);
		panel_5.setLayout(null);
		
		//ADICIONAR
		Button adicionar_1_1_1 = new Button("adicionar");
		adicionar_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				cliente.setCpf(Integer.parseInt(cpfCliente.getText()));
				try {
					cliente.setEntrada(formatter.parse(entradaCliente.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cliente.setSaida(formatter.parse(saidaCliente.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				cliente.setQuarto(Integer.parseInt(suiteCliente.getText()));
				
				clienteDAO.create(cliente);
			}
		});
		adicionar_1_1_1.setActionCommand("adicionar");
		adicionar_1_1_1.setBounds(57, 166, 70, 22);
		panel_5.add(adicionar_1_1_1);
		////update
		Button update_1_1_1 = new Button("update");
		update_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				cliente.setCpf(Integer.parseInt(cpfCliente.getText()));
				try {
					cliente.setEntrada(formatter.parse(entradaCliente.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cliente.setSaida(formatter.parse(saidaCliente.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				cliente.setQuarto(Integer.parseInt(suiteCliente.getText()));
				int cpf = Integer.parseInt(cpfCliente.getText());
				clienteDAO.update(cliente,cpf);
			
				
			}
		});
		update_1_1_1.setBounds(195, 166, 70, 22);
		panel_5.add(update_1_1_1);
		//deletar
		Button delete_1_1_1 = new Button("delete");
		delete_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int choice = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Deletar cadastro", JOptionPane.YES_NO_OPTION);
		        if (choice == 0) {
		            //confirmaçao
		            int  id = Integer.parseInt(cpfCliente.getText());
		           clienteDAO.delete(id);
				}
			}
		});
		delete_1_1_1.setBounds(303, 166, 70, 22);
		panel_5.add(delete_1_1_1);
		//atualizar
		Button read_1_1_1 = new Button("atualizar");
		read_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_3.setModel(new ClienteTableModel(new ClienteDAO().list()));
				
			}
		});
		read_1_1_1.setActionCommand("read_1");
		read_1_1_1.setBounds(429, 199, 70, 22);
		panel_5.add(read_1_1_1);
		
		table_4 = new JTable();
		table_4.setToolTipText("");
		table_4.setSurrendersFocusOnKeystroke(true);
		table_4.setBounds(57, 199, 358, 158);
		panel_5.add(table_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("cpf");
		lblNewLabel_1_1_1.setBounds(10, 42, 48, 14);
		panel_5.add(lblNewLabel_1_1_1);
		
		cpfCliente = new JTextField();
		cpfCliente.setColumns(10);
		cpfCliente.setBounds(57, 39, 256, 20);
		panel_5.add(cpfCliente);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("entrada");
		lblNewLabel_1_1_1_1.setBounds(10, 70, 48, 14);
		panel_5.add(lblNewLabel_1_1_1_1);
		
		entradaCliente = new JTextField();
		entradaCliente.setColumns(10);
		entradaCliente.setBounds(57, 67, 256, 20);
		panel_5.add(entradaCliente);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("saida");
		lblNewLabel_1_1_1_2.setBounds(10, 98, 48, 14);
		panel_5.add(lblNewLabel_1_1_1_2);
		
		saidaCliente = new JTextField();
		saidaCliente.setColumns(10);
		saidaCliente.setBounds(57, 98, 256, 20);
		panel_5.add(saidaCliente);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("suite");
		lblNewLabel_1_1_1_3.setBounds(10, 126, 48, 14);
		panel_5.add(lblNewLabel_1_1_1_3);
		
		suiteCliente = new JTextField();
		suiteCliente.setColumns(10);
		suiteCliente.setBounds(57, 123, 256, 20);
		panel_5.add(suiteCliente);
		
		
		//========= ABA PRODUTO===============================
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Produto", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("nome");
		lblNewLabel_1_1.setBounds(24, 42, 48, 14);
		panel_3.add(lblNewLabel_1_1);
		
		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(61, 39, 256, 20);
		panel_3.add(nomeProduto);
		/////adicionar
		Button adicionar_1_1 = new Button("adicionar");
		adicionar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				produto.setNome(nomeProduto.getText());
				produto.setPreco(Double.parseDouble(precoProduto.getText()));	
				produtoDAO.create(produto);
			}
		});
		adicionar_1_1.setActionCommand("adicionar");
		adicionar_1_1.setBounds(60, 170, 70, 22);
		panel_3.add(adicionar_1_1);
		/// updatee
		Button update_1_1 = new Button("update");
		update_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				produto.setNome(nomeProduto.getText());
				produto.setPreco(Double.parseDouble(precoProduto.getText()));	
				
				produtoDAO.update(produto);
				
			}
		});
		update_1_1.setBounds(212, 170, 70, 22);
		panel_3.add(update_1_1);
		
		// delete
		Button delete_1_1 = new Button("delete");
		delete_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int choice = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Deletar cadastro", JOptionPane.YES_NO_OPTION);
		        if (choice == 0) {
		            //confirmaçao
		            String  id = nomeProduto.getText();
		           produtoDAO.delete(id);
				}
				
				
			}
			
		});
		delete_1_1.setBounds(318, 170, 70, 22);
		panel_3.add(delete_1_1);
		
		// atualizar
		Button read_1_1 = new Button("atualizar");
		read_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_4.setModel(new ProdutoTableModel(new ProdutoDAO().list()));
				
			}
		});
		read_1_1.setActionCommand("read_1");
		read_1_1.setBounds(418, 207, 70, 22);
		panel_3.add(read_1_1);
		
		table_2 = new JTable();
		table_2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_2.setToolTipText("");
		table_2.setBounds(54, 198, 358, 159);
		panel_3.add(table_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("pre\u00E7o");
		lblNewLabel_1_1_3.setBounds(24, 70, 48, 14);
		panel_3.add(lblNewLabel_1_1_3);
		
		precoProduto = new JTextField();
		precoProduto.setColumns(10);
		precoProduto.setBounds(61, 67, 256, 20);
		panel_3.add(precoProduto);

	}
}
