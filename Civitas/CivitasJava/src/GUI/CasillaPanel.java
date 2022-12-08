/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import civitas.Casilla;
import java.util.ArrayList;
import civitas.CasillaCalle;
import civitas.CasillaSorpresa;
import civitas.Jugador;
/**
 *
 * @author Luis
 */
public class CasillaPanel extends javax.swing.JPanel {

    /**
     * Creates new form CasillaPanel
     */private Casilla casilla;
       
    public CasillaPanel() {
        initComponents();
    } 
    void setCasilla(Casilla casilla){ //metdo que recibe como argumento un objeto de la clase jugador 
        this.casilla=casilla; // asociar lo que recibe como argumento con el atributo jugador
        //nombre.setText("Nombre: "); //dar valor al metodo setText a todas las variables textfield
       // saldo.setText("Saldo: ");
        String s = new String();
        if(casilla.getClass() == CasillaCalle.class){
            s = "Calle";
            casasCasilla.setText(Integer.toString(((CasillaCalle)this.casilla).getNumCasas()));
            hotelesC.setText(casilla.toString());
            compraCasilla.setText(Float.toString(((CasillaCalle)this.casilla).getPrecioCompra()));
        }
       // Espc.setText("Especulador: ");
      //  Casilla.setText("Número de casilla actual: ");
         //esto lo he puesto por el pavo
        textoTipoCasilla.setText(casilla.getNombre()); //dar valor al metodo setText a todas las variables textfield
        
      //llamar al metodo revalidate si se han añadido o eliminado componentes
    repaint();
    revalidate();
    this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TipoCasilla = new javax.swing.JLabel();
        casasC = new javax.swing.JLabel();
        hotelesC = new javax.swing.JLabel();
        compraC = new javax.swing.JLabel();
        textoTipoCasilla = new javax.swing.JTextField();
        casasCasilla = new javax.swing.JTextField();
        hotelesCasilla = new javax.swing.JTextField();
        compraCasilla = new javax.swing.JTextField();

        TipoCasilla.setText("jLabel1");
        add(TipoCasilla);

        casasC.setText("jLabel1");
        add(casasC);

        hotelesC.setText("jLabel1");
        add(hotelesC);

        compraC.setText("jLabel1");
        add(compraC);

        textoTipoCasilla.setEditable(false);
        textoTipoCasilla.setText("jTextField1");
        add(textoTipoCasilla);

        casasCasilla.setEditable(false);
        casasCasilla.setText("jTextField1");
        add(casasCasilla);

        hotelesCasilla.setEditable(false);
        hotelesCasilla.setText("jTextField1");
        add(hotelesCasilla);

        compraCasilla.setText("jTextField1");
        add(compraCasilla);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TipoCasilla;
    private javax.swing.JLabel casasC;
    private javax.swing.JTextField casasCasilla;
    private javax.swing.JLabel compraC;
    private javax.swing.JTextField compraCasilla;
    private javax.swing.JLabel hotelesC;
    private javax.swing.JTextField hotelesCasilla;
    private javax.swing.JTextField textoTipoCasilla;
    // End of variables declaration//GEN-END:variables
}
