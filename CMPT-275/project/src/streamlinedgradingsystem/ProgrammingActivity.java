/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;
import ca.sfu.cmpt275.deliverable.colinq.Activity;
import java.io.File;
import java.util.*;

/**
 *
 * @author jsargent
 */
public class ProgrammingActivity extends Activity{
   
   private Rubric actRubric;
     
   //default constructor
   public ProgrammingActivity(){}
   
   //constructor
   public ProgrammingActivity (String name, String subPath, String type, String due, String lang, String solPath, boolean group, int activityID, int courseid, int num, Rubric rubric){
       
       super();
       actRubric = rubric;
      
       
   }
   
   //set rubric
   public void setActRubric(Rubric rubric){
   
       actRubric = rubric;
   }
   
   //get rubric
   public Rubric getActRubric(){
   
       return actRubric;
       
   }
    
}
