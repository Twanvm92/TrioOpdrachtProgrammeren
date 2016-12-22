/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * <code>TransactionScriptAdd</code> enherits from abstract class <code>TransactionScript</code>
 * Executes a query and deletes existing data
 * @see TransactionResultDelete
 * @author Mika Krooswijk
 * @see TransactionScript
 */
public class TransactionScriptDelete extends TransactionScript{
    JPanel panel;
    
    public TransactionScriptDelete(JPanel panel){
        this.panel = panel;
    }
    
    public ArrayList query(){
        return null;
    }
    
    public void deleteSub(String row){
        String query = "DELETE FROM abonnement WHERE AbonnementNr = \""+ row + "\"";
        
        try{
            Connection connection = this.dbconnection(panel); //make connection with the database
            Statement statment = connection.createStatement();
            statment.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(panel, "Could not delete abonnement", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    public void deleteProfiel(String row){
        String query = "DELETE FROM profiel WHERE profielNaam = \"" + row + "\"";
        
        try{
            Connection connection = this.dbconnection(panel); //make connection with the database
            Statement statment = connection.createStatement();
            statment.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(panel, "Could not delete abonnement", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    public void deleteKijk(String row){
        String query = "DELETE FROM watch WHERE AbonnementNr = \"" + row + "\"";
        
        try{
            Connection connection = this.dbconnection(panel); //make connection with the database
            Statement statment = connection.createStatement();
            statment.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(panel, "Could not delete abonnement", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
