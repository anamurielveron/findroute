import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);

        // Create label for "Travelling to..."
        JLabel label = new JLabel("Where would you like to explore?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(50, 20, 400, 30);

        // Create buttons
        JButton buttonPokemon = new JButton("Paldea (Pokemon)");
        JButton buttonManila = new JButton("Manila");

        // Set button positions and sizes
        buttonPokemon.setBounds(150, 60, 200, 50);
        buttonManila.setBounds(150, 120, 200, 50);

        // Add label and buttons to the frame
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(label);
        frame.getContentPane().add(buttonPokemon);
        frame.getContentPane().add(buttonManila);

        // Register action listeners for the buttons
        buttonPokemon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pokemon pressed");
                Pokemon pokemon = new Pokemon();
                pokemon.run();
            }
        });

        buttonManila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Manila pressed");
                Manila manila = new Manila();
                manila.run();
            }
        });

        frame.setVisible(true);
    }
}
