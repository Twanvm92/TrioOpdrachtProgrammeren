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
import trio.transaction.TransactionResultComboxOverview1;
import trio.transaction.TransactionResultComboxOverview6;
import trio.transaction.TransactionScript;
import trio.transaction.TransactionScript1;
import trio.transaction.TransactionScript4;
import trio.transaction.TransactionScript6;
import trio.transaction.TransactionScriptComboxOverview1;
import trio.transaction.TransactionScriptComboxOverview6;

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
        myTitles = new JComboBox<String>();
      
         TransactionScriptComboxOverview6 script = new TransactionScriptComboxOverview6(OverviewPanel6.this);
        ArrayList<TransactionResultComboxOverview6> resultArray = script.query();
        
        for (int x = 0; x < resultArray.size(); x++ ) {
            TransactionResultComboxOverview6 result = resultArray.get(x);
            myTitles.addItem(result.getTitel());
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
           
           
          String select = myTitles.getSelectedItem().toString();
          String s = " ";
          
          System.out.println(select);
           
          script2 = new TransactionScript6(select);
          ArrayList<TransactionResult6> list = new ArrayList<TransactionResult6>();
           list = script2.query();
       
       
        for (Object result : list) {
            
            
           s += result.toString() + " \n";
           
        }
          
       }
   }
    
}
