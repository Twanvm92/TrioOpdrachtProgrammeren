/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.domain;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trio.presentation.NetfilxView;

/**
 *
 * @author lukab
 */
public class Cards {
    private NetfilxView view;


            
    public Cards(NetfilxView view){
        this.view = view; 
   
       
    }
    
    
      public void showCard1(){
        
       ((CardLayout)view.getLayout()).show(view, "CARD1");
     
    }
        
   public void showCard2(){
       
       ((CardLayout)view.getLayout()).show(view, "CARD2");
   }
   
   public void showCard3(){
       
       ((CardLayout)view.getLayout()).show(view, "CARD3");
   }
   
   public void showCard4(){
       
        ((CardLayout)view.getLayout()).show(view, "CARD4");
   }
   
   public void showCard5() {
       
        ((CardLayout)view.getLayout()).show(view, "CARD5");
   }
   
   public void showCard6() {
       
        ((CardLayout)view.getLayout()).show(view, "CARD6");
   }
   
    public void showCard7() {
       
        ((CardLayout)view.getLayout()).show(view, "CARD7");
   }
    
     public void showCard8() {
       
        ((CardLayout)view.getLayout()).show(view, "CARD8");
        
        
   }
     
      public void showCard9() {
       
        ((CardLayout)view.getLayout()).show(view, "CARD9");
   }
}
