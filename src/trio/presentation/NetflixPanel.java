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

/**
 * The <code> NetflixPanel </code> is the basic panel that links the <code> ControlPanel </code>
 * and <code> NetfilxView </code> together
 * @see ControlPanel
 * @author Lukab
 * @see NetfilxView
 */
public class NetflixPanel extends JPanel  {
    private ControlPanel panel;
    private NetfilxView view;
   
public NetflixPanel() {
     view = new NetfilxView();
    
     setBackground (Color.LIGHT_GRAY);
     
     // initialize the ControlPanel with a view object as an argument.
    panel = new ControlPanel(view);
    panel.setBackground(Color.DARK_GRAY);
   
    setLayout (new BorderLayout());
   
    add (view, BorderLayout.CENTER);
    add (panel, BorderLayout.WEST);
   
    add (new JLabel("Netflix Statistix :                2016, 23IVT1C, Luka Brinkman (2096156) , Mika Krooswijk (2111998), Twan van Maastricht ()"), BorderLayout.SOUTH);
    
    
    
  
}



}
