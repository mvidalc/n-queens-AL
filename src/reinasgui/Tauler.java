/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinasgui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Miguel Vidal
 */
public class Tauler extends JPanel {

    private int files;
    private int columnes;
    private Color n = Color.DARK_GRAY;
    private Color b = Color.WHITE;
    private Color q = Color.RED;
    private Color temp;
    char tauler[][];
    boolean reina = false;
    BufferedImage imagen;

    Tauler(char tauler[][], int Ample, int Alt) {

        this.tauler = tauler;
        this.files = Ample;
        this.columnes = Alt;

        try {
            if (files < 7) {
                imagen = ImageIO.read(new File("imagenes\\reinamid.png"));
            } else {
                imagen = ImageIO.read(new File("imagenes\\reinamini.png"));
            }

        } catch (IOException ex) {
            Logger.getLogger(Tauler.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setLayout(new GridLayout(files, columnes));

        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                JPanel panel = new JPanel();
                JLabel IReina = new JLabel(new ImageIcon(imagen));
                if (tauler[i][j] == 'Q') {
                    panel.add(IReina);
                    IReina.setBounds(0, 0, 40, 40);
                }
                if ((i + j) % 2 == 0) {
                    temp = b;
                    panel.setBackground(temp);
                } else {
                    temp = n;
                    panel.setBackground(temp);

                }

                this.add(panel);
            }
        }
    }
}
