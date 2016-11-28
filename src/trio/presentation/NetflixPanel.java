/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import java.awt.*;
import javax.swing.*;
import trio.domain.Serie;

/**
 *
 * @author lukab
 */
public class NetflixPanel extends JPanel  {
    private Serie serie;
    private controlPanel panel;
    private netflixView view;
   
public NetflixPanel() {
    
    panel = new controlPanel();
    view = new netflixView();
    
    panel.setBackground(Color.white);
    
    setLayout (new BorderLayout());
   
    add (panel, BorderLayout.WEST);
    add (view, BorderLayout.CENTER);
    add (new JLabel("Netflix Statistix"), BorderLayout.SOUTH);
}


    
}
