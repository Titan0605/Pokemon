import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.SQLException;
public class PeleaPokemon extends javax.swing.JFrame {
    
    
    DataB_Pokemons datosPokes = new DataB_Pokemons();
    
    int defensa1, ataque1, velocidad1, defensa2, ataque2, velocidad2;
    String nombre1, nombre2;
    int Hp1, Hp2, maxHp1, maxHp2;     
    String iniciador, eleccionEnemigo;      
    boolean primerTurno = true;
    
    public PeleaPokemon() {
        initComponents();
        
        Pelear.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                AtaqueInt segundaInt = new AtaqueInt(PeleaPokemon.this);
                segundaInt.setVisible(true);
            }
    
    });
        obtenerDatos();
        pelea();
        
    }
    
    private void obtenerDatos(){
        if(primerTurno){
            datosPokes.consultaUnPokemon("JuegoPokemon", "TPokemones", 1);
            this.nombre1 = datosPokes.nombre;
            this.maxHp1 = datosPokes.health;
            this.defensa1 = datosPokes.defense;
            this.velocidad1 = datosPokes.velocity;
            this.ataque1 = datosPokes.atack;
            BarraEnemigo.setValue(Hp1);
            datosPokes.consultaUnPokemon("JuegoPokemon", "TPokemones", 2);
            this.nombre2 = datosPokes.nombre;
            this.maxHp2 = datosPokes.health;
            this.defensa2 = datosPokes.defense;
            this.velocidad2 = datosPokes.velocity;
            this.ataque2 = datosPokes.atack;
            BarraEnemigo1.setValue(Hp2);
            pelea();
        } else {
            try{
                datosPokes.conexion().close();
            }catch(SQLException e){
                System.out.println("Error al cerrar a la base de datos: "+e.getMessage());
            }
        }
    }
    
    public void inicioTurno(){
        if(velocidad1 > velocidad2){
           iniciador = "Jugador";
        }else{
           iniciador = "Enemigo";
        }
    }
    
    private void pelea(){ 
        PokemonEnemyName.setText(nombre2);
        PokemonPlayerName.setText(nombre1);
        if(primerTurno){
            Hp1 = maxHp1;
            Hp2 = maxHp2;
        }
        if(primerTurno){
            primerTurno =  false;
            inicioTurno();
        }
        if(iniciador.equals("Enemigo")){
            Pelear.setEnabled(false);
            inventario.setEnabled(false);
            pokemon.setEnabled(false);
            huir.setEnabled(false);
            eleccionEnemigo();
        }
        if(iniciador.equals("Jugador")){
            Pelear.setEnabled(true);
            inventario.setEnabled(true);
            pokemon.setEnabled(true);
            huir.setEnabled(true);
        }
    }
    
    public void eleccionEnemigo(){
        int eleccion, vida= 0;
        if(Hp2 < 20){
            eleccionEnemigo = "suma";
            
        }else{
            eleccionEnemigo = "restar";
            eleccion = (int) (Math.random() * 4);
            switch(eleccion){
                case 0 -> vida = 10;
                case 1 -> vida = 50;
                case 2 -> vida = 20;
                case 3 -> vida = 30;
                case 4 -> {
                    vida = 10;
                    eleccionEnemigo = "suma";
                }
            }
            
        }
        iniciador = "Jugador";
        afectarDeEnemigo(eleccionEnemigo, vida);
    }
    
    public void afectarDeEnemigo(String aff, int valor){
        if (aff.equals("suma")) {
            if (maxHp2 > (Hp2 + valor)) {
                this.Hp2 = this.Hp2 + valor;
            } else {
                this.Hp2 = maxHp2;
            }
        } else {
            if (maxHp1 > valor) {
                this.Hp1 = this.Hp1 - valor;
            } else {
                this.Hp1 = 0;
                finCombate();
            }
        }
        this.BarraEnemigo1.setValue(Hp1);
        System.out.println("El valor de vida del jugador es: " + Hp1);
        pelea();
    }
    
    public void afectar(String aff, int valor) {
//        this.BarraYo.setValue(valor);
//        System.out.println(valor);
        if (aff.equals("suma")) {
            if (maxHp1+1 > (Hp1 + valor)) {
                this.Hp1 = this.Hp1 + valor;
            } else {
                this.Hp1 = maxHp1;
            }
            iniciador = "Enemigo";
        } else {
            if (maxHp2+1 > valor) {
                this.Hp2 = this.Hp2 - valor;
            } else {
                this.Hp2 = 0;
                finCombate();
            }
        }
        this.BarraEnemigo1.setValue(Hp2);
        System.out.println("El valor del enemigo es: " + Hp2);
        pelea();
    }
    
    /*
    public void nAtack1(){
        iniciador = "Enemigo";
        afectar("resta", 50);
    }
    
    public void nAtack2(){
        iniciador = "Enemigo";
        afectar("resta", 60);
        
    }
    
    public void nAtack3(){
        iniciador = "Enemigo";
        afectar("resta", 70);
        
    }
    
    public void nAtack4(){
        iniciador = "Enemigo";
        afectar("resta", 30);
        
    }
    */
    
    public void finCombate() {
        if (Hp1 <= 0) {
            JOptionPane.showMessageDialog(null, "Lo siento has perdido");
        }
        if (Hp2 <= 0) {
            JOptionPane.showMessageDialog(null, "El jugador ha Ganado!");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PokemonEnemyName = new javax.swing.JLabel();
        BarraEnemigo = new javax.swing.JProgressBar();
        EnemyLVL = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        PokemonPlayerName = new javax.swing.JLabel();
        BarraEnemigo1 = new javax.swing.JProgressBar();
        EnemyLVL1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Pelear = new javax.swing.JButton();
        pokemon = new javax.swing.JButton();
        inventario = new javax.swing.JButton();
        huir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel1.setText("\"Nombre pokemon\"");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(488, 132));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PokemonEnemyName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PokemonEnemyName.setText("Pokemon");

        BarraEnemigo.setBackground(new java.awt.Color(102, 255, 102));
        BarraEnemigo.setForeground(new java.awt.Color(102, 255, 102));

        EnemyLVL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EnemyLVL.setText("LVL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarraEnemigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(PokemonEnemyName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(EnemyLVL)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PokemonEnemyName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnemyLVL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(BarraEnemigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PokemonPlayerName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PokemonPlayerName.setText("Pokemon");

        BarraEnemigo1.setBackground(new java.awt.Color(102, 255, 102));
        BarraEnemigo1.setForeground(new java.awt.Color(102, 255, 102));

        EnemyLVL1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EnemyLVL1.setText("LVL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarraEnemigo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(PokemonPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(EnemyLVL1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PokemonPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnemyLVL1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(BarraEnemigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel3.setText("Que hara el pokemon?");

        Pelear.setFont(new java.awt.Font("Microsoft Tai Le", 0, 12)); // NOI18N
        Pelear.setText("Pelear");

        pokemon.setText("Pokemon");
        pokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokemonActionPerformed(evt);
            }
        });

        inventario.setText("Inventario");
        inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioActionPerformed(evt);
            }
        });

        huir.setText("Huir");
        huir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(huir, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Pelear, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pelear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(huir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(448, 448, 448))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   /* public void afectar(String aff, int valor){
       if(aff.equals("suma") ){
           if(101>(hp2+valor)){
           this.hp2 = this.hp2 + valor;
           }else{
               this.hp2 = 100;
           }
       }else{
           if(hp2>valor){
               
           this.hp2=this.hp2 - valor;
           
           }else{
               this.hp2=0;
           }
       }
       this.jProgressBar3.setValue(hp2);
        System.out.println("el valor es "+hp2);
    } */
    
    private void huirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huirActionPerformed
        // afectar("resta",50);

    }//GEN-LAST:event_huirActionPerformed

    private void inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioActionPerformed
        // TODO add your handling code here:
        iniciador = "Enemigo";
        afectar("suma", 10);
        
    }//GEN-LAST:event_inventarioActionPerformed

    private void pokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokemonActionPerformed
        // afectar("suma",10);
    }//GEN-LAST:event_pokemonActionPerformed
    
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
            java.util.logging.Logger.getLogger(PeleaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeleaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeleaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeleaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeleaPokemon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BarraEnemigo;
    private javax.swing.JProgressBar BarraEnemigo1;
    private javax.swing.JLabel EnemyLVL;
    private javax.swing.JLabel EnemyLVL1;
    private javax.swing.JButton Pelear;
    private javax.swing.JLabel PokemonEnemyName;
    private javax.swing.JLabel PokemonPlayerName;
    private javax.swing.JButton huir;
    private javax.swing.JButton inventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton pokemon;
    // End of variables declaration//GEN-END:variables
}
