/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;

/**
 * This program creates and displays sample Explainable Produt Recommendations OWL ontology
 */
public class CreateEPRSOWLOntology 
{
   public static void main(String argv[]) 
    {
    String ns="http://www.eprs.com/";
    OntModel m =  ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
       
 OntClass CAspect = m.createClass(ns + "Aspect");
 OntClass CBrand = m.createClass(ns + "Brand");
 OntClass CItem = m.createClass(ns + "Item");
 OntClass CRecommendation = m.createClass(ns + "Recommendation");
 OntClass CReview = m.createClass(ns + "Review");
 OntClass CSentiment = m.createClass(ns + "Sentiment");
 OntClass CUser = m.createClass(ns + "User");
 
 ObjectProperty Obelongtobrand =   m.createObjectProperty(ns + "belongtobrand");
 ObjectProperty Oboughtwith =   m.createObjectProperty(ns + "boughtwith");
 ObjectProperty Ohasaspect =   m.createObjectProperty(ns + "hasaspect");
 ObjectProperty Ohassentiment =   m.createObjectProperty(ns + "hassentiment");
 ObjectProperty Omentioned =   m.createObjectProperty(ns + "mentioned");
 ObjectProperty Opurchased =   m.createObjectProperty(ns + "purchased");
 ObjectProperty Oviewed =   m.createObjectProperty(ns + "viewed");

 Individual IAspect = CAspect.createIndividual(ns + "iphone_battery");
 
  Literal LSentiment = m.createTypedLiteral("Positive", XSDDatatype.XSDstring);
  //Literal LSpiciness = m.createTypedLiteral("Mild", XSDDatatype.XSDstring);
  //Literal LPrice = m.createTypedLiteral(125, XSDDatatype.XSDinteger);
   
  Statement s1 = m.createStatement(CAspect, Ohassentiment, LSentiment);
  //Statement s2 = m.createStatement(CPizza, PhasSpiciness, LSpiciness);
  //Statement s3 = m.createStatement(CPizza, PPrice, LPrice);
  
    m.add(s1);
   // m.add(s2);
   // m.add(s3);

   m.write(System.out,"RDF/XML-ABBREV");
   // m.write(System.out,"N-TRIPLE");

    }
}
