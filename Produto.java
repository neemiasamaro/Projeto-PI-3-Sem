//Equipe EatExpress - Neemias Amaro e Thiago Akira

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Produto extends JFrame {

	JButton botao1, botao2;
    JLabel imagem;
    JLabel rPrato, rValor, rQuant, rId;
    JTextField prato, valor, quant, id;

	public Produto() {

		super("Cadastrar Produtos");

		Container tela = getContentPane();
        tela.setBackground(new Color(180, 180, 180));
		setLayout(null);
        setSize(500, 255);
		
		//-----------------------------------------------------------------------//

		ImageIcon icone = new ImageIcon("imagens/icone.png");
		setIconImage(icone.getImage());		
        icone.setImage(icone.getImage().getScaledInstance(200, 200, 100));
		imagem = new JLabel(icone);

		//-----------------------------------------------------------------------//

        rPrato = new JLabel("Prato");
		rValor = new JLabel("Valor");
		rQuant = new JLabel("Quantidade");
        rId = new JLabel("Id Produto");
		
		//-----------------------------------------------------------------------//

        prato = new JTextField(20);
		valor = new JTextField(4);
		quant = new JTextField(2);
		id = new JTextField(4);

		//-----------------------------------------------------------------------//

		botao1 = new JButton("Cadastrar Produto");
        botao2 = new JButton("Voltar");
        
		//-----------------------------------------------------------------------//

		botao1.setBounds(120, 180, 130, 30);
        botao2.setBounds(260, 180, 130, 30);
        imagem.setBounds(250, 5, 255, 200);

		//-----------------------------------------------------------------------//

		rPrato.setBounds(50,  25, 130, 30);
		rValor.setBounds(50,  65, 130, 30);
		rQuant.setBounds(50, 105, 130, 30);
        rId.setBounds(50, 145, 130, 30);

		//-----------------------------------------------------------------------//

		prato.setBounds(120,  25, 130, 25);
		valor.setBounds(120,  65,  130, 25);
		quant.setBounds(120, 105,  130, 25);
		id.setBounds(120, 145,  130, 25);

		//-----------------------------------------------------------------------//

		tela.add(rPrato);
		tela.add(rValor);
		tela.add(rQuant);
		tela.add(rId);

		//-----------------------------------------------------------------------//

		tela.add(prato);
		tela.add(valor);
		tela.add(quant);
		tela.add(id);

		//-----------------------------------------------------------------------//

		tela.add(botao1);
		tela.add(botao2);
		tela.add(imagem);

		//-----------------------------------------------------------------------//
		
		botao1.addActionListener(
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String prato1 = prato.getText();
				String valor1 = valor.getText();
				String quant1 = quant.getText();
				String id1 = id.getText();
				
				if(prato1.equals("")){
					if(valor1.equals("")){
						if(quant1.equals("")){
							if(id1.equals("")){
								JOptionPane.showMessageDialog(null,"Existem campos vazios!\nPreencha novamente");
								prato.setText(null);
								valor.setText(null);
								quant.setText(null);
								id.setText(null);
							}
						}
					}
				}
				else{
					String file = "produtos.txt";
					
					try {
						FileWriter fw = new FileWriter( file, true );
						BufferedWriter bw = new BufferedWriter( fw );

						bw.write( rPrato.getText() + ": " + prato.getText() + " | ");
						bw.write( rValor.getText() + ": " + valor.getText() + " | ");
						bw.write( rQuant.getText() + ": " + quant.getText() + " | ");
						bw.write( rId.getText() + ": " + id.getText());

						bw.newLine();
						bw.close();
						fw.close();

						JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");

						Verifica verifica = new Verifica();
						verifica.setVisible(true);
						setVisible(false);

					}catch(IOException ex){
						JOptionPane.showMessageDialog(null,"Erro!\n Arquivo!");
					}
				}
			}
		}
	);

	//-----------------------------------------------------------------------//

	botao2.addActionListener(
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Verifica verifica = new Verifica();
			verifica.setVisible(true);
			setVisible(false);
			}
		}
	);

	//-----------------------------------------------------------------------//

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {

		Produto app = new Produto();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
