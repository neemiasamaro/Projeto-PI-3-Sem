//Equipe EatExpress - Neemias Amaro e Thiago Akira

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Login extends JFrame {

	JButton botao1, botao2;
    JLabel imagem;
    JLabel rEmail, rSenha;
    JTextField email, senha;

	public Login() {

		super("Entrar");

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

        rEmail = new JLabel("Email");
		rSenha = new JLabel("Senha");

		//-----------------------------------------------------------------------//

        email = new JTextField(30);
		senha = new JTextField(20);

		//-----------------------------------------------------------------------//

		botao1 = new JButton("Entrar");
        botao2 = new JButton("Voltar");

        //-----------------------------------------------------------------------//

		botao1.setBounds(110, 180, 130, 30);
        botao2.setBounds(250, 180, 130, 30);
        imagem.setBounds(250, 5, 255, 200);

		//-----------------------------------------------------------------------//

		rEmail.setBounds(50, 30, 130, 30);
		rSenha.setBounds(50, 70, 130, 30);
		
		//-----------------------------------------------------------------------//

        email.setBounds(100,  30, 130, 25);
		senha.setBounds(100,  70, 130, 25);
		
		//-----------------------------------------------------------------------//

		tela.add(rEmail);
		tela.add(rSenha);

		//-----------------------------------------------------------------------//

		tela.add(email);
		tela.add(senha);

		//-----------------------------------------------------------------------//

		tela.add(botao1);
		tela.add(botao2);
		tela.add(imagem);

		//-----------------------------------------------------------------------//

		botao1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String e_mail1 = email.getText();
					String senha1 = senha.getText();

					if(e_mail1.equals("")){
						if(senha1.equals("")){
							JOptionPane.showMessageDialog(null,"Existem campos vazios!\nPreencha novamente");
							email.setText(null);
							senha.setText(null);
							email.requestFocus();
						}
					}
					else{
						String file = "logins.txt";
						if(e_mail1.equals("admin") && senha1.equals("admin")){
							Admin admin = new Admin();
							admin.setVisible(true);
							setVisible(false);
						}
						else{
							try {
								FileWriter fw = new FileWriter( file, true );
								BufferedWriter bw = new BufferedWriter( fw );

								bw.write(rEmail.getText() + ": " + email.getText() + " || ");
								bw.write(rSenha.getText() + ": " +senha.getText() + " || ");
								
								bw.newLine();
								bw.close();
								fw.close();

								JOptionPane.showMessageDialog(null,"Login realizado com sucesso!");

								Verifica verifica = new Verifica();
								verifica.setVisible(true);
								setVisible(false);

							}catch(IOException ex){
								JOptionPane.showMessageDialog(null,"Erro!\n Arquivo!");
							}
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

		Login app = new Login();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
