//Equipe EatExpress - Neemias Amaro e Thiago Akira

import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class Admin extends JFrame {

    protected Admin(){

        super("Visualizar itens");

        Path caminho1 = Paths.get("C:/Users/User/Desktop/Projeto Java PI/produtos.txt");
        Path caminho2 = Paths.get("C:/Users/User/Desktop/Projeto Java PI/cadastros.txt");    
            try {
                byte [] texto1 = Files.readAllBytes(caminho1);
                byte [] texto2 = Files.readAllBytes(caminho2);
                String leitura1 = new String(texto1);
                String leitura2 = new String(texto2);
                JOptionPane.showMessageDialog(null, "Pratos cadastrados:\n" + leitura1 + "\nUsuarios Cadastrados: \n" + leitura2);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Erro!");
            }

    }
    public static void main(String[] args) {

        Admin app = new Admin();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
