/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import trio.transaction.TransactionResult1;
import trio.transaction.TransactionResult6;
import trio.transaction.TransactionScript;
import trio.transaction.TransactionScript1;
import trio.transaction.TransactionScript4;
import trio.transaction.TransactionScript6;
import java.util.ArrayList;
import javax.swing.*;
import trio.transaction.TransactionResultComboxFilm;
import trio.transaction.TransactionScriptComboxFilm;


/**
 *
 * @author lukab
 */
public class OverviewPanel6 extends JPanel{
    
    private JComboBox<String> myTitles;
    private JTextArea area;
    private TransactionScript6 script2;
    private JLabel titleLabel, purposeLabel;
    
    
    public OverviewPanel6() {
        setLayout( new BorderLayout(40,40));
        setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
        
        
        // declare and initialize new Transitionscript
        // put results of the query() method in an arraylist.
        TransactionScriptComboxFilm script = new TransactionScriptComboxFilm(this);
        ArrayList<TransactionResultComboxFilm> resultArray = script.query();
        
        myTitles = new JComboBox<String>();
        
        // add results from resultArray to JCombobox
        for ( int x = 0; x < resultArray.size(); x++) {
            TransactionResultComboxFilm result = resultArray.get(x);
            myTitles.addItem(result.getFilm());
        }
    
        
        area = new JTextArea();
       area.setFont(new Font("Monospaced", Font.PLAIN, 12));
       area.setLineWrap(true);
       
         myTitles.addActionListener(new action());

        
        
        titleLabel = new JLabel("Selecteer film  ");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        purposeLabel = new JLabel("Kijkers die de film volledig hebben afgekeken ");
        purposeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JPanel overview1_North = new JPanel();
        overview1_North.add(titleLabel);
        overview1_North.add(myTitles);
        
        JPanel overview1_Center = new JPanel();
        overview1_Center.setLayout(new BorderLayout(0, 10));
        overview1_Center.add (purposeLabel, BorderLayout.NORTH);
        overview1_Center.add (area, BorderLayout.CENTER);
        add(overview1_North, BorderLayout.NORTH);
        add (overview1_Center, BorderLayout.CENTER);
}
    
    public class action implements ActionListener { // listens to actions that have been performed
       @Override
       public void actionPerformed(ActionEvent e) {
           
            String s = " ";
          String select = myTitles.getSelectedItem().toString();
         
           
          script2 = new TransactionScript6(select);
          ArrayList<TransactionResult6> list = new ArrayList<TransactionResult6>();
           list = script2.query();
       
       
        for (TransactionResult6 r : list) {
            
            
           s += r.toString() + " \n";
          
           
        }
            
            area.setText(s);
          
       }
    }
    
}
