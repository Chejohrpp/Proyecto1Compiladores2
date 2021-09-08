/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2.fronted.funciones;

import com.mycompany.p1c2.ReglasGram.pistas.*;
import com.mycompany.p1c2.objetos.ReportError;
import com.mycompany.p1c2.toolsFronted.*;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergi
 */
public class CrearPista extends javax.swing.JPanel {

        private DefaultTableModel tablaErrores =  new DefaultTableModel();
    /**
     * Creates new form CrearPista
     */
    public CrearPista() {
        initComponents();
        visualizacion();
        tablaErrores = (DefaultTableModel) tableError.getModel();
        limpiarErrores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtSource = new javax.swing.JTextArea();
        btnCompilar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtLineaColumna = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableError = new javax.swing.JTable();

        txtSource.setColumns(20);
        txtSource.setRows(5);
        jScrollPane1.setViewportView(txtSource);

        btnCompilar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Crear una Pista Nueva");

        txtLineaColumna.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLineaColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLineaColumnaActionPerformed(evt);
            }
        });

        tableError.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Linea", "Columna", "Tipo", "Descripcion", "Posibles Soluciones"
            }
        ));
        jScrollPane2.setViewportView(tableError);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnCompilar)
                        .addGap(0, 406, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addComponent(txtLineaColumna))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnCompilar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLineaColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        // TODO add your handling code here:
        limpiarErrores();
        String expresion = txtSource.getText();
        try{
            Reader inputString = new StringReader(expresion);
            BufferedReader reader = new BufferedReader(inputString);
            Lexer lexer = new Lexer(reader);            
            Parser parser = new Parser(lexer);
            try{
                parser.parse();
            }catch(Exception e){
                //e.printStackTrace();
            }
            ArrayList<ReportError> error = (ArrayList) parser.getListaErrores();
            for (ReportError reportError : error) {
                //System.out.println(reportError.toString());
                String[] data = {String.valueOf(reportError.getLinea()),
                    String.valueOf(reportError.getColumna()),reportError.getTipoError(),reportError.getDescripcion(),reportError.getSolucion()};
                tablaErrores.addRow(data);
            }
            if (error.size()==0) {
                System.out.println("COOL");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void txtLineaColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLineaColumnaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLineaColumnaActionPerformed

    private void visualizacion(){
        LineNumberTextArea lineNumber = new LineNumberTextArea(txtSource);
        jScrollPane1.setRowHeaderView(lineNumber);
        txtSource.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                lineNumber.updateLineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lineNumber.updateLineNumbers();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lineNumber.updateLineNumbers();
            }
            
        });
        txtLineaColumna.setEnabled(false);
        LineaColumna lineaColumna = new LineaColumna(txtSource, txtLineaColumna);
        lineaColumna.actualizar();
    }
    
    private void limpiarErrores(){
        for (int i = tablaErrores.getRowCount()-1; i >= 0; i--) {
            tablaErrores.removeRow(i);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompilar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableError;
    private javax.swing.JTextField txtLineaColumna;
    private javax.swing.JTextArea txtSource;
    // End of variables declaration//GEN-END:variables
}
