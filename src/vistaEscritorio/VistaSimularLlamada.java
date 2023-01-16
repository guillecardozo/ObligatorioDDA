/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaEscritorio;

import controlador.IvistaSimularLlamada;
import controlador.controladorSimularLlamada;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Fachada;
import modelo.Llamada;
import modelo.Puesto;

public class VistaSimularLlamada extends javax.swing.JFrame implements IvistaSimularLlamada {

    private ArrayList<String> numerosDigitados = new ArrayList();
    private controladorSimularLlamada controlador;
    private boolean inicioLlamada = false;
    private boolean inicioOtraLlamada = false;
    private boolean cedulaDigitada = false;//Cuando se digita la cedula se pasa a true
    private boolean sectorYaElegido = false;//Cuando se elije el sector se pasa a true
    String numeros = "";

    private Fachada modelo = Fachada.getInstancia();

    /**
     * Creates new form VentanaSimularLlamada
     */
    public VistaSimularLlamada(boolean modal) {
        initComponents();
        inputMensaje.setLineWrap(true);
        setTitle("Simulador de llamadas");
        setLocationRelativeTo(null);
        controlador = new controladorSimularLlamada(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bIniciar = new javax.swing.JButton();
        bFinalizar = new javax.swing.JButton();
        lbMensaje = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        bNumeral = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b0 = new javax.swing.JButton();
        bAsterisco = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputMensaje = new javax.swing.JTextArea();
        bSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bIniciar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        bIniciar.setForeground(new java.awt.Color(0, 204, 51));
        bIniciar.setText("Iniciar");
        bIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarActionPerformed(evt);
            }
        });

        bFinalizar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        bFinalizar.setForeground(new java.awt.Color(255, 0, 0));
        bFinalizar.setText("Finalizar");
        bFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinalizarActionPerformed(evt);
            }
        });

        lbMensaje.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbMensaje.setText("Mensaje de la central telefónica:");

        b1.setText("1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b3.setText("3");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b5.setText("5");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b9.setText("9");
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        b6.setText("6");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        bNumeral.setText("#");
        bNumeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNumeralActionPerformed(evt);
            }
        });

        b8.setText("8");
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b2.setText("2");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b4.setText("4");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b0.setText("0");
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });

        bAsterisco.setText("*");

        b7.setText("7");
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        inputMensaje.setColumns(20);
        inputMensaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputMensaje.setRows(5);
        jScrollPane1.setViewportView(inputMensaje);

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbMensaje)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bIniciar)
                                .addGap(56, 56, 56)
                                .addComponent(bFinalizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bAsterisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                    .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                    .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .addComponent(b6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bNumeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(124, 124, 124)))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bFinalizar)
                    .addComponent(bIniciar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lbMensaje))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bAsterisco, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(b0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bNumeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(bSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarActionPerformed
        // TODO add your handling code here:
        if (!inicioOtraLlamada) {
            iniciarLlamada();
        }
    }//GEN-LAST:event_bIniciarActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {//esto esta en true, pasarlo a false en elegir sector
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {//ver si cedula digitada y sector
                sectorYaElegido = true;
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {
                sectorYaElegido = true;
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {
                sectorYaElegido = true;
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {
                sectorYaElegido = true;
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {
                sectorYaElegido = true;
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {
                sectorYaElegido = true;
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {
                sectorYaElegido = true;
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {
                sectorYaElegido = true;
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b9ActionPerformed

    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numerosDigitados.add(evt.getActionCommand());
            inputMensaje.setText(imprimirNumero(evt.getActionCommand()));
        } else {
            if (cedulaDigitada == true && sectorYaElegido == false) {
                sectorYaElegido = true;
                controlador.llamarASector(evt.getActionCommand());
            }
        }
    }//GEN-LAST:event_b0ActionPerformed

    private void bNumeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNumeralActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada) {
            numeros = "";
            controlador.existeCliente();
            Cliente unCliente = controlador.existeCliente();
            controlador.elegirSector(unCliente);
            inicioLlamada = false;//Lo paso a false para que cuando toquemos el numeral de nuevo no haga nada
        }
    }//GEN-LAST:event_bNumeralActionPerformed

    private void bFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarActionPerformed
        // TODO add your handling code here:
        if (inicioLlamada || cedulaDigitada) {
            controlador.finalizarLlamada();
        }
    }//GEN-LAST:event_bFinalizarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        controlador.salir();
    }//GEN-LAST:event_formWindowClosing

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
        controlador.salir();
    }//GEN-LAST:event_bSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b0;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton bAsterisco;
    private javax.swing.JButton bFinalizar;
    private javax.swing.JButton bIniciar;
    private javax.swing.JButton bNumeral;
    private javax.swing.JButton bSalir;
    private javax.swing.JTextArea inputMensaje;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMensaje;
    // End of variables declaration//GEN-END:variables

    private void iniciarLlamada() {
        inicioLlamada = true;
        inicioOtraLlamada = true;
        controlador.iniciarLlamada();
    }

    @Override
    public void mostrarError() {
        inputMensaje.setText("Comuníquese más tarde...");
    }

    @Override
    public void digitarCedula() {
        inputMensaje.setText("Ingrese su cédula seguida de la tecla numeral");
    }

    @Override
    public void cedulaYaDigitada() {
        cedulaDigitada = true;
    }

    @Override
    public void digitarSector() {
        inputMensaje.setText("Para comunicarse con Ventas digite 1\n Atención al cliente digite 2\n Recursos Humanos digite 3");
    }
    
    
    //Método que transforma el array de numeros digitados en un solo String con la cedula
    @Override
    public String obtenerCedulaDigitada() {
        String lista = "";
        for (String unNumero : numerosDigitados) {
            lista += unNumero;
        }
        return lista;
    }

    @Override
    public void errorClienteNoExiste() {
        inputMensaje.setText("Cliente no registrado");
    }

    @Override
    public void mensajeSectorNoDisponible() {
        inputMensaje.setText("Sector no disponible");
    }

    @Override
    public void mostrarMensajeLlamadaEnEspera(Puesto puesto) {
        inputMensaje.setText("Aguarde en línea, Ud. se encuentra a " + Fachada.getInstancia().cantidadLlamadasEnEspera()
                + " llamada(s) de ser atendido.\n La espera estimada es de "
                + Fachada.getInstancia().esperaEstimada() + " minuto(s)");
    }

    @Override
    public void mostrarMensajeLlamadaEnCurso(Llamada unaLlamada) {
        inputMensaje.setText("Llamada en curso... ud. se está comunicando con "
                + unaLlamada.getSector().getNombre() + ".\nEstá siendo atendido por " + unaLlamada.getTrabajador()
                + ". \nSu llamada se ha iniciado en " + unaLlamada.getFechaHoraAtendida());
    }

    @Override
    public void mostrarErrorSectorNoValido() {
        inputMensaje.setText("Sector no válido");
    }

    @Override
    public void mostrarDetallesLlamadaFinalizada(Llamada unaLlamada) {
        inicioLlamada = false;
        inicioOtraLlamada = false;
        numerosDigitados.clear();
        inputMensaje.setText("Llamada finalizada... Duracion: "
                + unaLlamada.tiempoLlamada() + " segundos." + "\nCosto: $"
                + unaLlamada.getCliente().getTipo().costo(unaLlamada)
                + "\nSu saldo es de: $" + unaLlamada.getCliente().getSaldo());
    }

    @Override
    public void mostrarMensajeLlamadaFinalizada() {
        inputMensaje.setText("Llamada Finalizada");
    }

    private String imprimirNumero(String actionCommand) {
        return numeros += actionCommand;
    }
    
    @Override
    public void mostrarDialogo() {
        int r = JOptionPane.showConfirmDialog(this, "¿Desea finalizar la llamada y cerrar?");
        if (r == JOptionPane.YES_OPTION) {
            controlador.salirYAvisar();
            dispose();
        }
    }
    
    @Override
    public void mostrarDialogoConfirmacion(){
        int r = JOptionPane.showConfirmDialog(this, "¿Confirma que desea cerrrar?");
        if (r == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
    
    @Override
    public void cerrarVentana(){
        dispose();
    }

}