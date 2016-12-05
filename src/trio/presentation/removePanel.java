/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import trio.domain.*;

/**
 *
 * @author lukab
 */
public class removePanel extends JPanel {
     JComboBox<String> overviewCB;
     
     JList movieList, serieList, profileList, accountList;
    
     
     
public removePanel(){
    
    overviewCB = new JComboBox<String>();
    overviewCB.addItem("Accounts");
    overviewCB.addItem("Profielen");
    overviewCB.addItem("Films");
    overviewCB.addItem("Series");

    movieList = new JList();
    
    
    
    add (overviewCB);
    
    
}
}
