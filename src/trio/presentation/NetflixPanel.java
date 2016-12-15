/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import trio.domain.Cards;
import trio.domain.Serie;

/**
 *
 * @author lukab
 */
public class NetflixPanel extends JPanel  {
    private ControlPanel panel;
    private NetfilxView view;
   
public NetflixPanel() {
     view = new NetfilxView();
    
     setBackground (Color.LIGHT_GRAY);
    panel = new ControlPanel(view);
    panel.setBackground(Color.DARK_GRAY);
   
    setLayout (new BorderLayout());
   
    add (view, BorderLayout.CENTER);
    add (panel, BorderLayout.WEST);
   
    add (new JLabel("Netflix Statistix : Luka Brinkman (2096156) , Mika Krooswijk (), Twan van Maastricht () "), BorderLayout.SOUTH);
    
    
    
  
}



}
