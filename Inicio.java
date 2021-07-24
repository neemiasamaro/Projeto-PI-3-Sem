//Equipe EatExpress - Neemias Amaro e Thiago Akira

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Inicio extends JFrame {

	JButton botao1, botao2, botao3;
	JLabel imagem;

	public Inicio() {

		super("Inicio");

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

		botao1 = new JButton("Entrar");
		botao2 = new JButton("Criar Conta");
		botao3 = new JButton("Fechar");

		//-----------------------------------------------------------------------//

		botao1.setBounds(50, 65, 130, 30);
		botao2.setBounds(50, 105, 130, 30);
		botao3.setBounds(66, 175, 100, 25);
		imagem.setBounds(250, 5, 255, 200);

		//-----------------------------------------------------------------------//

		tela.add(botao1);
		tela.add(botao2);
		tela.add(botao3);
		tela.add(imagem);

		//-----------------------------------------------------------------------//

		botao1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
				}
			}
		);

		//-----------------------------------------------------------------------//

		botao2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Cadastro criar = new Cadastro();
				criar.setVisible(true);
				setVisible(false);
				}
			}
		);

		//-----------------------------------------------------------------------//

		botao3.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					setVisible(true);
					System.exit(0);
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

		Inicio app = new Inicio();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
