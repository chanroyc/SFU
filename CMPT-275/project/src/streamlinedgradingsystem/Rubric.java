/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;

/**
 *
 * @author jsargent
 */
public class Rubric {
    
    private int itemNum;
    private String rubricText;
    private float itemWeight;
    private int activityID;
    
    public Rubric(int num, String text, float value){
    
        itemNum = num;
        rubricText = text;
        itemWeight = value;
    }
    
    public void setItemNum(int num){
    
        itemNum = num;
    }
    
    public void setRubricText(String text){
    
        rubricText = text;
    }
    
    public void setItemValue(float value){
            
        itemWeight = value;
    }
    
    public int getItemNumber(){
    
        return itemNum;
    }
    
    public String getRubricText(){
    
        return rubricText;
    }
    
    public float getWeight(){
    
        return itemWeight;
    }
    
}
