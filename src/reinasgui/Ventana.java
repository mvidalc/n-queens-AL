/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinasgui;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 *
 * @author Miguel Vidal
 */
public class Ventana extends javax.swing.JFrame {

    static int N;
    static int cont = 1;

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ejecutar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JTFCaselles = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Ejecutar.setText("Calcula");
        Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EjecutarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nº de caselles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(Ejecutar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(JTFCaselles, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFCaselles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(Ejecutar)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjecutarActionPerformed

        
        if (JTFCaselles.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo sin rellenar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                N = Integer.parseInt(JTFCaselles.getText());
                if (N < 4) {
                    JOptionPane.showMessageDialog(this, "No existe solución", "Información", JOptionPane.OK_OPTION);
                } else {
                    run();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se ha introducido un número", "Error", JOptionPane.ERROR_MESSAGE);
                JTFCaselles.setText("");
            }
        }
    }//GEN-LAST:event_EjecutarActionPerformed

    
    
    void run(){
        
        char[][] mat = new char[N][N];
        
        // inicializamos la matriz con '-'
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], '-');
        }

        nQueen(mat, 0);
        
    }
    
    /* Método para crear la ventana y pasarle la matriz */
    public static void print(char mat[][]) {
        
        JFrame tauler = new JFrame("Tauler");
        tauler.setSize(600, 600);
        tauler.setTitle("Tauler d'escacs");
        Tauler t = new Tauler(mat, N, N);
        tauler.add(t);
        cont++;
        tauler.setVisible(true);

    }

        /*Método para mirar si la reina no mata a nadie */
    private static boolean isSafe(char mat[][], int r, int c) {
        // Si hay dos reinas en la misma columna, devuelve false
        for (int i = 0; i < r; i++) {
            if (mat[i][c] == 'Q') {
                return false;
            }
        }

        // Si hay dos reinas en la diagonal \ , devuelve false
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }

        // Si hay dos reinas en la diagonal / , devuelve false
        for (int i = r, j = c; i >= 0 && j < N; i--, j++) {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static void nQueen(char mat[][], int r) {
        /* CASO TRIVIAL
           Si todas las reinas estan colocadas, guardamos la solución
        */
        if (r == N) {
            print(mat);
            return;
        } else {
            /* CASO NO TRIVIAL
               Colocamos una reina en cada cuadrado de la fila r
               recorremos recursivamente para cada movimiento valido
            */
            for (int i = 0; i < N; i++) {
                // Si no hay dos reinas en peligro
                if (isSafe(mat, r, i)) {
                    // Colocamos la reina
                    mat[r][i] = 'Q';
                    // Backtracking para la siguitente fila
                    nQueen(mat, r + 1);
                    // Quitamos la reina del cuadrado actual al salir de la recursividad
                    mat[r][i] = '-';
                }
            }
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ejecutar;
    private javax.swing.JTextField JTFCaselles;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}