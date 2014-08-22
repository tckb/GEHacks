/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tckb.ge;

import com.tckb.ge.stubs.ICameraInfoGE;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.NetworkLink;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.RefreshMode;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Link;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import org.jawin.COMException;

/**
 *
 * @author tckb
 */
public class GEControls extends javax.swing.JFrame {

    private GEFrame geFrame;
    private final File kmlFile = new File("genKML.kml");
    private boolean stopSim;
    SwingWorker updateWorker = null;
    ICameraInfoGE cam = null;

    /**
     * Creates new form NewJFrame
     */
    public GEControls() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jDialog1 = new javax.swing.JDialog();
        tilt = new javax.swing.JPanel();
        geStart = new javax.swing.JButton();
        geRunSim = new javax.swing.JButton();
        geStopSim = new javax.swing.JButton();
        geSearch = new javax.swing.JButton();
        geLoadKML = new javax.swing.JButton();
        geLon = new javax.swing.JTextField();
        geLat = new javax.swing.JTextField();
        geTilt = new javax.swing.JSlider();
        geAzm = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        azm = new javax.swing.JLabel();
        geAlt = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GE simulator");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tilt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        geStart.setText("GE start");
        geStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geStartActionPerformed(evt);
            }
        });

        geRunSim.setText("Run sim");
        geRunSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geRunSimActionPerformed(evt);
            }
        });

        geStopSim.setText("Stop sim");
        geStopSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geStopSimActionPerformed(evt);
            }
        });

        geSearch.setText("Go!");
        geSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geSearchActionPerformed(evt);
            }
        });

        geLoadKML.setText("load kml");
        geLoadKML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geLoadKMLActionPerformed(evt);
            }
        });

        geLon.setText("-120");

        geLat.setText("35");

        geTilt.setMaximum(180);
        geTilt.setPaintTicks(true);
        geTilt.setValue(0);
        geTilt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                geTiltStateChanged(evt);
            }
        });

        geAzm.setMaximum(360);
        geAzm.setPaintTicks(true);
        geAzm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                geAzmStateChanged(evt);
            }
        });

        jLabel1.setText("Latitude");

        jLabel2.setText("Longitude");

        jLabel3.setText("Altitude");

        jLabel4.setText("Tilt");

        jLabel5.setText("Azmuth");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, geTilt, org.jdesktop.beansbinding.ELProperty.create("${value} deg"), jLabel6, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, geAzm, org.jdesktop.beansbinding.ELProperty.create("${value} deg"), azm, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        geAlt.setMaximum(1000000);
        geAlt.setMinimum(1000);
        geAlt.setMinorTickSpacing(1000);
        geAlt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                geAltStateChanged(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, geAlt, org.jdesktop.beansbinding.ELProperty.create("${value/1000} km"), jLabel7, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout tiltLayout = new javax.swing.GroupLayout(tilt);
        tilt.setLayout(tiltLayout);
        tiltLayout.setHorizontalGroup(
            tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tiltLayout.createSequentialGroup()
                .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tiltLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tiltLayout.createSequentialGroup()
                                .addComponent(geStart, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(geRunSim, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tiltLayout.createSequentialGroup()
                                .addComponent(geLoadKML, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(geStopSim, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(geAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tiltLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18))
                    .addGroup(tiltLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tiltLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(geLon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tiltLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(36, 36, 36)
                                .addComponent(geLat, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(geSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(geTilt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(geAzm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(tiltLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(azm)))
                    .addGroup(tiltLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        tiltLayout.setVerticalGroup(
            tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tiltLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tiltLayout.createSequentialGroup()
                        .addComponent(geAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)))
                    .addGroup(tiltLayout.createSequentialGroup()
                        .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(geStart)
                                .addComponent(geRunSim))
                            .addComponent(geTilt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tiltLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(geAzm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(azm)))
                            .addGroup(tiltLayout.createSequentialGroup()
                                .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(geLoadKML)
                                    .addComponent(geStopSim))
                                .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tiltLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(geLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                        .addGroup(tiltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(geLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(tiltLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(geSearch)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tilt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tilt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geStartActionPerformed
        try {
            geFrame = GEFrame.getFrame();
            geFrame.startGE();
            cam = geFrame.getGEObject().GetCamera(1);
            cam.setRange(100);
        } catch (COMException ex) {
            Logger.getLogger(GEControls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_geStartActionPerformed

    private void geRunSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geRunSimActionPerformed

        doKML();
    }//GEN-LAST:event_geRunSimActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        geFrame.closeGE();
    }//GEN-LAST:event_formWindowClosing

    private void geStopSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geStopSimActionPerformed
        updateWorker.cancel(true);
        kmlFile.delete();
    }//GEN-LAST:event_geStopSimActionPerformed

    private void geSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geSearchActionPerformed
        try {
            cam.setFocusPointLatitude(Double.parseDouble(geLat.getText()));
            cam.setFocusPointLongitude(Double.parseDouble(geLon.getText()));
            geFrame.getGEObject().SetCamera(cam, 4.0);
        } catch (COMException ex) {
            Logger.getLogger(GEControls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_geSearchActionPerformed


    private void geLoadKMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geLoadKMLActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showDialog(this, "open kml file");
        File kml = chooser.getSelectedFile();
        if (kml != null) {
            geFrame.loadKMLFileToGE(kml);
        }

    }//GEN-LAST:event_geLoadKMLActionPerformed

    private void geAltStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_geAltStateChanged

        try {
            cam.setFocusPointAltitude((double) (geAlt.getValue()));
            cam.setFocusPointAltitudeMode(2);

            geFrame.getGEObject().SetCamera(cam, 4.0);
        } catch (COMException ex) {
            Logger.getLogger(GEControls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_geAltStateChanged

    private void geTiltStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_geTiltStateChanged
        try {
            cam.setTilt((double) (geTilt.getValue()));
            geFrame.getGEObject().SetCamera(cam, 4.0);
        } catch (COMException ex) {
            Logger.getLogger(GEControls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_geTiltStateChanged

    private void geAzmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_geAzmStateChanged
        try {
            cam.setAzimuth((double) (geAzm.getValue()));

            geFrame.getGEObject().SetCamera(cam, 4.0);
        } catch (COMException ex) {
            Logger.getLogger(GEControls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_geAzmStateChanged
    private File genLinkKML(File kmlFile, double updateInterval) throws FileNotFoundException, IOException {
        File linkKML = new File("link.kml");
        Kml kml = new Kml();
        NetworkLink networklink = new NetworkLink();
        Link link = new Link();
        Document kmlDoc = kml.createAndSetDocument();
        kmlDoc.setVisibility(true);
        kmlDoc.getFeature().add(networklink);
        networklink.setName(kmlFile.getName());
        networklink.setRefreshVisibility(true);
        networklink.setFlyToView(true);

        link.setHref(kmlFile.getAbsolutePath());
        link.setRefreshInterval(updateInterval);
        link.setRefreshMode(RefreshMode.ON_INTERVAL);
        networklink.setLink(link);
        linkKML.createNewFile();
        kml.marshal(linkKML);

        return linkKML;
    }

    public void updateKML(File targetKML) {
        double lat = new Random().nextDouble() * 100;
        double longi = new Random().nextDouble() * 100;
        double alt = new Random().nextDouble() * 100;
        try {

            if (targetKML.exists()) {
                targetKML.delete();
            }
            targetKML.createNewFile();

            Kml kml = new Kml();
            Placemark myPlace = kml.createAndSetPlacemark();
            Coordinate c = new Coordinate(lat, longi, alt);
            myPlace.withName("Random Placemark").withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(lat, longi, alt);
            myPlace.setDescription("Position:" + c.toString());

            kml.marshal(targetKML);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public File createKML() {
        try {
            kmlFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(GEControls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kmlFile;
    }

    private void doKML() {
        try {
            final File localFile = this.createKML();
            File linkFile = this.genLinkKML(localFile, 4.0);
            geFrame.loadKMLFileToGE(linkFile);
            updateWorker = new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {

                    while (true) {

                        if (!stopSim) {
                            updateKML(kmlFile);
                            Thread.sleep(5000);
                        }

                    }
                }
            };
            updateWorker.execute();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
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
            java.util.logging.Logger.getLogger(GEControls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GEControls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GEControls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GEControls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GEControls().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel azm;
    private javax.swing.JSlider geAlt;
    private javax.swing.JSlider geAzm;
    private javax.swing.JTextField geLat;
    private javax.swing.JButton geLoadKML;
    private javax.swing.JTextField geLon;
    private javax.swing.JButton geRunSim;
    private javax.swing.JButton geSearch;
    private javax.swing.JButton geStart;
    private javax.swing.JButton geStopSim;
    private javax.swing.JSlider geTilt;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel tilt;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
