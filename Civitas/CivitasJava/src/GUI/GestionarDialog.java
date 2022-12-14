 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
/**
 *
 * @author Luis
 */
public class GestionarDialog extends javax.swing.JDialog {
    private int gestionElegida; //atributo de instancia de tipo int para guardar el índice de la gestión inmobiliaria
    
    public GestionarDialog(java.awt.Frame parent){
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        gestionElegida =-1; 
   DefaultListModel gestiones = new DefaultListModel<>(); // datos para la lista
 ArrayList<String> opciones = new ArrayList<> (Arrays.asList( "Construir casa","Construir hotel", "Terminar"));
 for (String s: opciones){
 gestiones.addElement(s);} //se completan los datos
 listaGestiones.setModel(gestiones); //se le dice a la lista cuáles son esos datos
 this.setVisible(true);
    }
   public int getGestion(){ //añadimos su consultor antes estaba protegido
        return gestionElegida;
    }
   // public void gestionar(Jugador jugador){ LO MISMO QUE LO DE ABAJO
    //    setGestiones();
    //    repaint();
        
  //  }
   
 //   public void setGestiones(){ EN TEORIA SE PONE PERO EL CHAVAL NO LO PONE
   
  //      }
    /**
     * Creates new form GestionarDialog
     */
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GestionesInmobiliarias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaGestiones = new javax.swing.JList<>();
        realizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        GestionesInmobiliarias.setText("GestionesInmobiliarias");

        listaGestiones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaGestiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaGestionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaGestiones);

        realizar.setText("realizar");
        realizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realizarMouseClicked(evt);
            }
        });
        realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(GestionesInmobiliarias)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(realizar)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(realizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(GestionesInmobiliarias)))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void realizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realizarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_formMouseClicked

    private void realizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realizarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_realizarMouseClicked

    private void listaGestionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaGestionesMouseClicked
        // TODO add your handling code here:
         gestionElegida= listaGestiones.getSelectedIndex();
         dispose();
    }//GEN-LAST:event_listaGestionesMouseClicked

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
     /*   try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionarDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarDialog dialog = new GestionarDialog(new javax.swing.JFrame()); /// revisar por si dentro del parentesis poner ,true
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GestionesInmobiliarias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaGestiones;
    private javax.swing.JButton realizar;
    // End of variables declaration//GEN-END:variables
}
