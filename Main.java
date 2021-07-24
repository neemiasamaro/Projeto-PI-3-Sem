//Equipe EatExpress - Neemias Amaro e Thiago Akira

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JLabel imagem;

    public Main(){

        super("Main");

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

        imagem.setBounds(120, 5, 255, 200);
        tela.add(imagem);

        //-----------------------------------------------------------------------//

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        //-----------------------------------------------------------------------//
        
        try { 
			Thread.sleep (5000); 
			Inicio inicio = new Inicio();
			inicio.setVisible(true);
			setVisible(false);

		} catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null,"Erro!");
		}
		
    }
    public static void main(String[] args) {

        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
