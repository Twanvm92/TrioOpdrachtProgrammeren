/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a getrequest that returns the id of a program of a query result
 * @author mikakrooswijk
 */
public class TransactionResultProgramID{
     /**
     * 
     * @param programmaID The ID of a program that got caught by a query
     */
    String programmaID;
    
    public TransactionResultProgramID(String id){
        this.programmaID = id;
    }
    
        /**
     * 
     * @return The ID of a program
     */
    public String getNaam(){
        return programmaID;
    }
    
}
