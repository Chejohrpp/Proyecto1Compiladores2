/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2.fronted.funciones;

import com.mycompany.p1c2.Almacenamiento.Almacenamiento;
import com.mycompany.p1c2.objetos.DescSonido;
import com.mycompany.p1c2.objetos.ListaReproduccion;
import com.mycompany.p1c2.objetos.Sonido;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author sergi
 */
public class Reproductor extends javax.swing.JPanel {
    private Timer t;
    private ActionListener ac;
    private int porcentaje=0;
    private AudioInputStream audioInputStream;
    private Clip clip;
    private XYSeries series;
    private Almacenamiento almacenamiento =  new Almacenamiento();
    private Sonido sonido; 
    private ArrayList<DescSonido> listaSonido;
    private DefaultListModel model = new DefaultListModel();
    private DefaultListModel modelListR = new DefaultListModel();
    private DefaultListModel modelContList = new DefaultListModel();
    /**
     * Creates new form Reproductor
     */
    public Reproductor() {
        initComponents();
        listaAllSongs.setModel(model);
        listaReproduccion.setModel(modelListR);
        listaContReproduccion.setModel(modelContList);
        graficar();
        getSonido();
        controlVolumen(60);
    }
    private void getSonido(){
        try{
            sonido = almacenamiento.getDatosMusica();
            if (sonido != null) {
                DescSonido desc = sonido.getListaSonido().get(3);
                ByteArrayInputStream bis = new ByteArrayInputStream(desc.getAudio());
                AudioFormat audioFormat = new AudioFormat(44100, 16, 2, true, false);
                audioInputStream=new AudioInputStream(bis, audioFormat, desc.getAudio().length);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                listaSonido =  sonido.getListaSonido();
                actualizarLista();
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void controlVolumen(int vol){
        float volume = vol/100f;
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float range = gainControl.getMaximum() - gainControl.getMinimum();
        float gain = (range * volume) + gainControl.getMinimum();
        gainControl.setValue(gain);
    }
    
    private void cambiarCancion(String name){        
        for (DescSonido desc : listaSonido) {
            if (name.equals(desc.getName())) {
                try{
                    ByteArrayInputStream bis = new ByteArrayInputStream(desc.getAudio());
                    AudioFormat audioFormat = new AudioFormat(44100, 16, 2, true, false);
                    audioInputStream=new AudioInputStream(bis, audioFormat, desc.getAudio().length);
                    if (clip.isOpen()) {
                        clip.close();
                    }
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }        
    }
    private void actualizarLista(){
        model.removeAllElements();
        for (DescSonido descSonido : listaSonido) {
            model.addElement(descSonido.getName());
        }
        modelListR.removeAllElements();
        for (ListaReproduccion lista : sonido.getListaReproducciones()) {
            modelListR.addElement(lista.getName());
        }
        showContLista(null);
    }
    
    private void showContLista(String name){
        modelContList.removeAllElements();
        if (name != null) {
            for (ListaReproduccion lista : sonido.getListaReproducciones()) {
                String nameAux = lista.getName();
                if (nameAux.equals(name)) {
                    for (DescSonido cont : lista.getContenido()) {
                        modelContList.addElement(cont.getName());
                    }
                }
            } 
        }else{
            return;
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

        jpanelGrafico = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaAllSongs = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        sliderVolumen = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        pbTiempo = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaReproduccion = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaContReproduccion = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jpanelGrafico.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jpanelGraficoLayout = new javax.swing.GroupLayout(jpanelGrafico);
        jpanelGrafico.setLayout(jpanelGraficoLayout);
        jpanelGraficoLayout.setHorizontalGroup(
            jpanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpanelGraficoLayout.setVerticalGroup(
            jpanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        listaAllSongs.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "kiss_of_death", "one_last_kiss" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaAllSongs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaAllSongs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaAllSongsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaAllSongs);

        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        sliderVolumen.setOrientation(javax.swing.JSlider.VERTICAL);
        sliderVolumen.setValue(60);
        sliderVolumen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderVolumenStateChanged(evt);
            }
        });
        sliderVolumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sliderVolumenMousePressed(evt);
            }
        });

        jLabel4.setText("Volumen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(sliderVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sliderVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listaReproduccion.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "openings", "party" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaReproduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaReproduccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaReproduccion);

        listaContReproduccion.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "kiss_of_death", "one_last_kiss" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaContReproduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaContReproduccionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaContReproduccion);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Todas las canciones");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Listas de reproduccion");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Contenido de la lista");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pbTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:        
        if (porcentaje ==0) {
            cargarBarra();
        }
        playSound();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        clip.setMicrosecondPosition(0);
        reset();
    }//GEN-LAST:event_btnResetActionPerformed
    
    private void reset(){        
        pbTiempo.setValue(0);
        porcentaje = 0;
        series.add(0,0);
        series.clear();
    }
    private void sliderVolumenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderVolumenStateChanged
        // TODO add your handling code here:
        controlVolumen(sliderVolumen.getValue());
    }//GEN-LAST:event_sliderVolumenStateChanged

    private void sliderVolumenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderVolumenMousePressed
        // TODO add your handling code here:
        controlVolumen(sliderVolumen.getValue());
    }//GEN-LAST:event_sliderVolumenMousePressed

    private void listaAllSongsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAllSongsMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
           cambiarCancion(listaAllSongs.getSelectedValue());
           series.setKey(listaAllSongs.getSelectedValue());
           reset();
        }
    }//GEN-LAST:event_listaAllSongsMouseClicked

    private void listaContReproduccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaContReproduccionMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            cambiarCancion(listaContReproduccion.getSelectedValue());
            series.setKey(listaContReproduccion.getSelectedValue());
            reset();           
        }
    }//GEN-LAST:event_listaContReproduccionMouseClicked

    private void listaReproduccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaReproduccionMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            showContLista(listaReproduccion.getSelectedValue());        
        }
    }//GEN-LAST:event_listaReproduccionMouseClicked
    private void playSound(){
        try{
            if (clip.isActive()) {
                clip.stop();
                t.stop();
            }else{                
                clip.start();
                t.start();
            }
            if (!clip.isOpen()) {
                clip.open();
                clip.start();
                t.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void cargarBarra(){        
        ac = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                porcentaje = (porcentaje +1);
                pbTiempo.setValue(porcentaje);           
                int tiempo = porcentaje;
                double frecuencia =  Math.random();
                series.add(tiempo,frecuencia);
                if (series.getItemCount() > 10) {
                    series.remove(0);
                }
                if (pbTiempo.getValue()==pbTiempo.getMaximum() || !clip.isActive()) {
                    if (clip.isOpen()) {
                        clip.setMicrosecondPosition(0);
                        
                    }
                    t.stop();
                    reset();
                }
            }            
        };
        int waitingTime = (int) (clip.getMicrosecondLength()/1000);
        int max = waitingTime / 200;
        int delay = waitingTime / max;
        pbTiempo.setMaximum(max);        
        t = new Timer(delay,ac);
        t.start();
    }
        
    
    private void graficar(){
        series = new XYSeries("");
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Frecuencia vs Tiempo","Tiempo(s)" , "Frecuencia (hz)", dataset, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel panel = new ChartPanel(chart);
        panel.setDomainZoomable(true);
        jpanelGrafico.setLayout(new BorderLayout());
        jpanelGrafico.add(panel, BorderLayout.CENTER);   
    }
    
    private void test(){
        int bytesPorFrame = audioInputStream.getFormat().getFrameSize(); 
        int numBytes = 1024 * bytesPorFrame; 
        byte[] audioBytes = new byte[numBytes];
        
    }
    public Clip getClip(){
        return clip;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpanelGrafico;
    private javax.swing.JList<String> listaAllSongs;
    private javax.swing.JList<String> listaContReproduccion;
    private javax.swing.JList<String> listaReproduccion;
    private javax.swing.JProgressBar pbTiempo;
    private javax.swing.JSlider sliderVolumen;
    // End of variables declaration//GEN-END:variables
}
