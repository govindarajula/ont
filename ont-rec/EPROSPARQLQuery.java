/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;

/**
 ************* program for sparql query **********
*/
public class SPARQLQuery2 
{
    public static void main(String args[])
    {
       
        String inputFileName = "C:\\Users\\akash\\OneDrive\\Desktop\\Projects\\eprs paper\\EPRO.owl";  
        Model model = FileManager.get().loadModel(inputFileName);
    
     
//query String
// It displays count of all the users who purchased the product earlier
String queryString = "PREFIX EPRO:<http://www.eprs.com/>" +
"SELECT DISTINCT(COUNT(?User) AS ?Count) ?Item" +
"WHERE {{ ?User :purchased ?Item }}" +
"GROUPBY ?Item";
     

com.hp.hpl.jena.query.Query query = QueryFactory.create(queryString);
QueryExecution qe = QueryExecutionFactory.create(query, model);
ResultSet results = qe.execSelect();

System.out.println("\n Displaying user count: \n");

for ( ; results.hasNext() ; ) {
    QuerySolution soln = results.nextSolution() ;
    //System.out.print(soln.getResource("x").getLocalName());
    System.out.print(" Count of purchased user(s)  ");
    System.out.println(soln.getResource("Item").getLocalName());
}

qe.close(); 
  
    }
}
