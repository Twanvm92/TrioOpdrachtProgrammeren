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
import trio.domain.Serie;

/**
 *
 * @author lukab
 */
public class NetflixPanel extends JPanel  {
    private Serie serie;
    private controlPanel panel;
    private netflixView view;
     private JButton overviewBtn_1, overviewBtn_2, overviewBtn_3, overviewBtn_4;
   private JButton button[];
   
public NetflixPanel() {
    
    panel = new controlPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    view = new netflixView();
    
    
    panel.setBackground(Color.white);
    
     button = new JButton[6];
    button[0] = overviewBtn_1;
    button[1] =  overviewBtn_2;
    button[2] = overviewBtn_3;
    button[3] = overviewBtn_4;
    
    
    for (int i= 0; i< 4; i++){
        
        button[i] = new JButton("Overzicht " + (i+1));
        button[i].addActionListener(new controlHandler()); 
        button[i].setActionCommand(""+ i + 1);
       panel.add (button[i]); }
       
    
    setLayout (new BorderLayout());
   
    add (view, BorderLayout.CENTER);
    add (panel, BorderLayout.WEST);
   
    add (new JLabel("Netflix Statistix"), BorderLayout.SOUTH);
    
  
}

public class controlHandler implements ActionListener {
    public void actionPerformed (ActionEvent e) {
        
       /* if (getSource().getText().equals("mybutton") == true){
           view.showCard1();
       
        }
        
        if (e.getSource() == "Overzicht 2") {
            view.showCard2();
        }
        
        if (e.getSource() == "Overzicht 3") {
            view.showCard3();
        } */
       
       view.showCard3();
    }

}
}
