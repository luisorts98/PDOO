/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import civitas.Casilla;
import civitas.CasillaCalle;
import GUI.VistaDado; //NO SE SI PONERLO
import civitas.Civitas;
import civitas.Jugador; 
import civitas.OperacionJuego; 
import civitas.OperacionInmobiliaria; 
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import civitas.Diario;
import controladorCivitas.Respuesta;
/**
 *
 * @author Luis
 */
public class CivitasView extends javax.swing.JFrame implements Vista {
   private Civitas juego; // añadimos una variable de instancia juego
   // JugadorPanel jugadorPanel; //no se si es asi pero es para que no falle abajo
    //CasillaPanel casillaPanel;
  //  VistaDado vista;
  // private DiarioDialog diario = new DiarioDialog(this);
   private GestionarDialog gestion;
    private PropiedadDialog propiedad;
    //GestionarDialog gestionarD=new GestionarDialog(this);
   // PropiedadDialog propiedadD=new PropiedadDialog(this);
  public  void setCivitasJuego(Civitas civitas){ //Creamos un metodo setCivitasJuego que recibe como argumento un objeto y lo asigna a la variable juego
        // tambien ponemos lo de setVisible para vincula la vista con el modelo 
        this.juego=civitas;
        setVisible(true); //poner visible la vista, vinculando la vista
        //con el modelo
    }
    
    /**
     * Creates new form CivitasView
     */
    public CivitasView() {
        initComponents();
        setLocationRelativeTo(null);
       // jugadorPanel =new JugadorPanel();
       // casillaPanel =   new CasillaPanel();
       // jugadorPanel1.add(jugadorPanel);
    }
    
    public void actualiza(){
         this.AreaRanking.setVisible(false);
        this.Ranking.setVisible(false);
        
        Jugador jugador = juego.getJugadorActual();
        this.jugadorPanel1.setJugador(jugador); //asocia el panel del jugador al jugador actual
       
        int indice_casilla = jugador.getCasillaActual();
        
        Casilla casilla = juego.getTablero().getCasilla(indice_casilla);
         this.casillaPanel1.setCasilla(casilla);
        this.TextCasillaActual.setText(casilla.toString());
        
        if(juego.finalDelJuego()){
            this.AreaRanking.setVisible(true);
            this.Ranking.setVisible(true);
            
            this.AreaRanking.setText(juego.ranking().toString());
            //asigna al textArea un string con toda la información relativa
            //al ranking de jugadores
        }
        
        repaint();
        revalidate();
        
     /*   jugadorPanel.setJugador(juego.getJugadorActual());
        jugadorPanel.setVisible(true); //NO SE SI PONERLO pero es para que sea vea
        casillaPanel.setCasilla(juego.getCasillaActual());
        casillaPanel.setVisible(true);
        
      Ranking.setVisible(false); //empiezan sin verse al principio
      AreaRanking.setVisible(false); 
      
      if(juego.finalDelJuego()==true){ //comprobamos si estamos al final del juego si estamos al final poenmos ranking y area ranking visibles
          ArrayList<Jugador> rank=juego.ranking();
          String r=""; //asignamos a un textArea un string con toda la información realirva al ranking
          
          for(int i=0; i<rank.size(); i++){
              r=r+rank.get(i).toString()+"\n";  //ahi hacemos lo de arriba
              
          }
          AreaRanking.setText(r);
          AreaRanking.setVisible(true); //Lo ponemos visibles porque estamos al final del juego
          Ranking.setVisible(true);
      }
      repaint();
      revalidate();  */
    }
    public void mostrarSiguienteOperacion(OperacionJuego operacion){
        ProximaOperacion.setText("Siguiente operación: ");
        proximaOperacion.setText(operacion.toString()); //actualiza el textfield 
        //de la siguietne operación con al operación que recibe como argumento
        proximaOperacion.setVisible(true);
         if (operacion == OperacionJuego.AVANZAR){ //si la siguiente operacion es avanzar
         VistaDado.createInstance(this); //O VISTA O VISTADADO (muesta la vista(Singlento) del dado
         VistaDado.getInstance().setVisible(true);
         }
         repaint();
    }
    
  public  OperacionInmobiliaria elegirOperacion(){ //NI PUTA IDEA
      GestionarDialog gestionarD = new GestionarDialog(this);
      int gestionElegida = gestionarD.getGestion();
      OperacionInmobiliaria operacion = OperacionInmobiliaria.values()[gestionElegida];
      return operacion;
    }
  
  public int elegirPropiedad(){
      PropiedadDialog propiedadesD = new PropiedadDialog(this, juego.getJugadorActual());
      int propiedadElegida = propiedadesD.getIndicePropiedad();
      return propiedadElegida;
  }
  
   public void mostrarEventos(){
        if (!Diario.getInstance().getEventos().isEmpty()) {
//creear dialogo solo si hay eventos pendientes
            new DiarioDialog(this); //crea la ventana del diario
        }
    }
   
 /*
    
   public void gestionar(){
       gestionarD.gestionar(juego.getJugadorActual());
       
   }*/
   public  Respuesta comprar(){
       
         Respuesta respuesta= Respuesta.NO;
        int opcion= 1-JOptionPane.showConfirmDialog(null,"Quieres comprar la calle actual?","Compra",JOptionPane.YES_NO_OPTION);
        //Para mostrar la ventana en la ue nos pregunte si queremos comprar y devuelvael enumerado comrrespondiente a la respuesta 
        //return Respuesta.values()[opcion]; //con esto devolvemos el enumeroado correspondiente a la respuesta.
   
        
        if(opcion == 0){
            respuesta = Respuesta.NO;
        }
        else if(opcion == 1){
            respuesta = Respuesta.SI;
        }
        
        return respuesta;
        
    }
    public void pausa(){
        int val= JOptionPane.showConfirmDialog(null, "¿continuar?", "siguiente paso", JOptionPane.YES_NO_OPTION);
        if (val==1) System.exit(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProximaOperacion = new javax.swing.JLabel();
        proximaOperacion = new javax.swing.JTextField();
        Ranking = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaRanking = new javax.swing.JTextArea();
        TextCasillaActual = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        CasillaActual = new javax.swing.JLabel();
        jugadorPanel1 = new GUI.JugadorPanel();
        casillaPanel1 = new GUI.CasillaPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProximaOperacion.setText("Operacion juego");

        proximaOperacion.setEditable(false);
        proximaOperacion.setText("operacion juego");
        proximaOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximaOperacionActionPerformed(evt);
            }
        });

        Ranking.setText("Ranking");

        AreaRanking.setEditable(false);
        AreaRanking.setColumns(20);
        AreaRanking.setRows(5);
        jScrollPane1.setViewportView(AreaRanking);

        TextCasillaActual.setEditable(false);
        TextCasillaActual.setText("jTextField1");

        Titulo.setText("CIVITAS");

        CasillaActual.setText("CasillaActual");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(Ranking))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ProximaOperacion)
                                        .addGap(28, 28, 28)
                                        .addComponent(proximaOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addComponent(jugadorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CasillaActual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextCasillaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(casillaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CasillaActual)
                    .addComponent(TextCasillaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casillaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugadorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProximaOperacion)
                            .addComponent(proximaOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(Ranking))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(506, 506, 506))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proximaOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proximaOperacionActionPerformed

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
            java.util.logging.Logger.getLogger(CivitasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CivitasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CivitasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CivitasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      //  java.awt.EventQueue.invokeLater(new Runnable() {
      //      public void run() {
      //          new CivitasView().setVisible(true);
      //      }
      //  });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaRanking;
    private javax.swing.JLabel CasillaActual;
    private javax.swing.JLabel ProximaOperacion;
    private javax.swing.JLabel Ranking;
    private javax.swing.JTextField TextCasillaActual;
    private javax.swing.JLabel Titulo;
    private GUI.CasillaPanel casillaPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.JugadorPanel jugadorPanel1;
    private javax.swing.JTextField proximaOperacion;
    // End of variables declaration//GEN-END:variables
}
//lo de jugadorPanel de arriba en el año pasado se creo uno nuevo t lo llamos contenedo vista jugador