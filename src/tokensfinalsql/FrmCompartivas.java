/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tokensfinalsql;

import static tokensfinalsql.FrmFinal.Clave;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hetzo
 */
public class FrmCompartivas extends javax.swing.JFrame {

    /**
     * Creates new form FrmCompartivas
     */
    public FrmCompartivas() {
        initComponents();
        this.setLocationRelativeTo(null);

        // Crear instancia del analizador léxico
        AnalizadorLexico analizador = new AnalizadorLexico();

        // Listas para almacenar palabras y símbolos identificados
        ArrayList<String> palabrasYSimbolos = new ArrayList<>();
        ArrayList<String> tokens = new ArrayList<>();

        // Separar palabras y símbolos del texto
        analizador.separar(Clave, palabrasYSimbolos);

        // Identificar tokens en base a las palabras y símbolos
        analizador.identificarTokens(palabrasYSimbolos, tokens);

        // Crear modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Palabra o Símbolo");
        modelo.addColumn("Token");

        // Agregar datos al modelo de tabla
        for (int i = 0; i < palabrasYSimbolos.size(); i++) {
            String palabra = palabrasYSimbolos.get(i);
            String token = tokens.get(i);
            modelo.addRow(new Object[]{palabra, token});
        }

        // Establecer modelo de tabla en la TablaPrincipalFinal
        TablaPrincipalFinal.setModel(modelo);
    }

    class AnalizadorLexico {

        public void separar(String texto, ArrayList<String> palabrasYSimbolos) {
            StringBuilder palabraOSimbolo = new StringBuilder();

            for (char c : texto.toCharArray()) {
                if (Character.isLetter(c) || Character.isDigit(c) || ".(),;'".contains(String.valueOf(c))) {
                    palabraOSimbolo.append(c);
                } else if (palabraOSimbolo.length() > 0) {
                    palabrasYSimbolos.add(palabraOSimbolo.toString());
                    palabraOSimbolo.setLength(0);
                }
            }

            if (palabraOSimbolo.length() > 0) {
                palabrasYSimbolos.add(palabraOSimbolo.toString());
            }
        }

        public void identificarTokens(ArrayList<String> palabrasYSimbolos, ArrayList<String> tokens) {
            for (String item : palabrasYSimbolos) {
                if ("select".equals(item) || "from".equals(item)) {
                    tokens.add("Palabra clave");
                } else if ("*".equals(item)) {
                    tokens.add("Operador Aritmético");  // Cambiado a "Operador Aritmético" en lugar de "Palabra clave"
                } else if (";".equals(item)) {
                    tokens.add("Fin de línea");
                } else if (",()'".contains(item)) {
                    tokens.add("Signo de puntuación");
                } else {
                    tokens.add("Identificador");
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPrincipalFinal = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        TablaPrincipalFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(TablaPrincipalFinal);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(235, 235, 235))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        FrmFinal ff = new FrmFinal();
        ff.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCompartivas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCompartivas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCompartivas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCompartivas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCompartivas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPrincipalFinal;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
