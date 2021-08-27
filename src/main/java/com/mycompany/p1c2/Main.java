/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2;

import com.mycompany.p1c2.fronted.VisualPrincipal;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author sergi
 */
public class Main {
    
    public static void main(String[] args) throws IOException {        
    try {
        // Set System L&F
    UIManager.setLookAndFeel(
        UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }       
        VisualPrincipal visual = new VisualPrincipal();
        visual.setLocationRelativeTo(null);
        visual.setSize(900, 700);
        visual.setVisible(true);    
       
    }     
}
