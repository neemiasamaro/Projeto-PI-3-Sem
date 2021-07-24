//Equipe EatExpress - Neemias Amaro e Thiago Akira

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Cadastro extends JFrame {

	JButton botao1, botao2;
    JLabel imagem;
    JLabel rNome, rEmail, rSenha, rSenha2;
    JTextField nome, email, senha, senha2;

	public Cadastro() {

		super("Criar Conta");

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

        rNome = new JLabel("Nome");
		rEmail = new JLabel("Email");
        rSenha = new JLabel("Senha");
		rSenha2 = new JLabel("Confirmar Senha");

		//-----------------------------------------------------------------------//

        nome = new JTextField(30);
		email = new JTextField(20);
        senha = new JTextField(20);
		senha2 = new JTextField(20);

		//-----------------------------------------------------------------------//

		botao1 = new JButton("Cadastrar-se");
        botao2 = new JButton("Voltar");

		//-----------------------------------------------------------------------//
        
		botao1.setBounds(110, 180, 130, 30);
        botao2.setBounds(250, 180, 130, 30);
        imagem.setBounds(250, 5, 255, 200);

		//-----------------------------------------------------------------------//

		rNome.setBounds(50, 25, 130, 30);
		rEmail.setBounds(50, 65, 130, 30);
        rSenha.setBounds(50, 105, 130, 30);
        rSenha2.setBounds(50, 145, 130, 30);

		//-----------------------------------------------------------------------//

		nome.setBounds(100,  25, 130, 25);
		email.setBounds(100,  65, 130, 25);
        senha.setBounds(100, 105, 130, 25);
        senha2.setBounds(150, 145, 80, 25);

		//-----------------------------------------------------------------------//

		tela.add(rNome);
		tela.add(rEmail);
        tela.add(rSenha);
		tela.add(rSenha2);

		//-----------------------------------------------------------------------//

		tela.add(nome);
		tela.add(email);
        tela.add(senha);
		tela.add(senha2);

		//-----------------------------------------------------------------------//

		tela.add(botao1);
		tela.add(botao2);
		tela.add(imagem);
		
		//-----------------------------------------------------------------------//

		botao1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String name = nome.getText();
					String e_mail = email.getText();
					String senha1 = senha.getText();
					String confirma = senha2.getText();

					if(name.equals("")){
						if(e_mail.equals("")){
							if(senha1.equals("")){
								if(confirma.equals("")){
									JOptionPane.showMessageDialog(null,"Existem campos vazios!\nPreencha novamente");
									nome.setText(null);
									email.setText(null);
									senha.setText(null);
									senha2.setText(null);
									nome.requestFocus();
								}
							}
						}
					}
					else{
						if(senha1.equals(confirma)){

									String file = "C:/Users/User/Desktop/Projeto Java PI/Arquivoscadastros.txt";

									try {
										FileWriter fw = new FileWriter( file, true );
										BufferedWriter bw = new BufferedWriter( fw );

										bw.write(rNome.getText() + ": " + nome.getText() + " || ");
										bw.write(rEmail.getText() + ": " + email.getText() + " || ");
										bw.write(rSenha.getText() + ": " + senha.getText() + " || ");

										bw.newLine();
										bw.close();
										fw.close();
										JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");

										Verifica verifica = new Verifica();
										verifica.setVisible(true);
										setVisible(false);

									}catch(IOException ex){
										JOptionPane.showMessageDialog(null,"Erro!\n Arquivo!");
									}
								
						}
						else {
							JOptionPane.showMessageDialog(null,"As senhas não coincidem!\nPreencha novamente");
							senha.setText(null);
							senha2.setText(null);
						}
					}
				}
			}
		);

		//-----------------------------------------------------------------------//

		botao2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Inicio inicio = new Inicio();
				inicio.setVisible(true);
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
		Cadastro app = new Cadastro();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
