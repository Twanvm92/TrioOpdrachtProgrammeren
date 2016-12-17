/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import java.awt.BorderLayout;
import java.awt.Font;
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
    private JLabel titleLabel, purposeLabel;
    
    
    public OverviewPanel6() {
        setLayout( new BorderLayout(40,40));
        setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
        myTitles = new JComboBox<String>();

        TransactionScriptComboxFilm script = new TransactionScriptComboxFilm(this);
        ArrayList<TransactionResultComboxFilm> resultArray = script.query();

        for ( int x = 0; x < resultArray.size(); x++) {
            TransactionResultComboxFilm result = resultArray.get(x);
            myTitles.addItem(result.getFilm());
        }
     
        
      
        
        
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
        overview1_Center.add (new JTextArea(100, 100), BorderLayout.CENTER);
        add(overview1_North, BorderLayout.NORTH);
        add (overview1_Center, BorderLayout.CENTER);
}
}
