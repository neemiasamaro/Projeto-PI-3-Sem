//Equipe EatExpress - Neemias Amaro e Thiago Akira

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class Verifica extends JFrame {

    JButton botao1, botao2, botao3, botao4;
    JLabel imagem;

    public Verifica(){

        super("Verificar Produtos");
        
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

        botao1 = new JButton("Cadastrar Produtos");
        botao2 = new JButton("Meus Produtos");
        botao3 = new JButton("Voltar ao Inicio");
        botao4 = new JButton("Fechar");

        //-----------------------------------------------------------------------//

        botao1.setBounds(50, 25, 150, 30);
        botao2.setBounds(50, 65, 150, 30);
        botao3.setBounds(50, 105, 150, 30);
        botao4.setBounds(50, 145, 150, 30);
        imagem.setBounds(250, 5, 255, 200);

        //-----------------------------------------------------------------------//

        tela.add(botao1);
        tela.add(botao2);
        tela.add(botao3);
        tela.add(botao4);
        tela.add(imagem);

        //-----------------------------------------------------------------------//

        botao1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Produto produto = new Produto();
                    produto.setVisible(true);
                    setVisible(false);
                }
            }
        );

        //-----------------------------------------------------------------------//

        botao2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Path caminho = Paths.get("C:/Users/User/Desktop/Projeto Java PI/produtos.txt");
                    try {
                        byte[] texto = Files.readAllBytes(caminho);
                        String leitura = new String(texto);
                        JOptionPane.showMessageDialog(null, leitura);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"Erro!\n Arquivo!");
                    }
                }
            }
        );

        //-----------------------------------------------------------------------//

        botao3.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Inicio inicio = new Inicio();
                    inicio.setVisible(true);
                    setVisible(false);
                    
                }
            }
        );
        
        //-----------------------------------------------------------------------//

        botao4.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Finalizando...");
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

        Verifica app = new Verifica();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
