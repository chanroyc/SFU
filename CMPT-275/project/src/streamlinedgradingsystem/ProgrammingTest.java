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
public class ProgrammingTest {
    private String testName;
    private int numInputFile;
    private String pathToInputFiles;
    private String pathToConsoleInput;
    private int numOutputFile;
    private String pathToOutputFiles;
    private String pathToConsoleOutput;
    private boolean consoleInput;
    private boolean consoleOutput;
    private String environment;
    
    //default constructor
    ProgrammingTest(){}
    
    //constructor
    ProgrammingTest(String testName, int numInputFile, String pathToInputFiles, String pathToConsoleInput, int numOutputFile, String pathToOutputFiles, 
            String pathToConsoleOutput, String environment){
        this.testName = testName;
        this.numInputFile = numInputFile;
        this.pathToInputFiles =  pathToInputFiles;
        this.pathToConsoleInput = pathToConsoleInput;
        this.numOutputFile = numOutputFile;
        this.pathToOutputFiles = pathToOutputFiles;
        this.pathToConsoleOutput = pathToConsoleOutput;
        this.environment = environment;
    }
    
    //set test name
    public void setTestName(String testNam){
        testName = testNam;
    }
    
    //set number of input file
    public void setNumInput(int numIn){
        numInputFile = numIn;
       
    }
    
    //set input file path
    public void setPathToInputFiles(String pathInput){
        pathToInputFiles = pathInput;
    }
    
    //set console input file path
    public void setPathToConsoleInput(String consoleInput){
        pathToConsoleInput = consoleInput;
    }
   
    //set number of output file
    public void setNumOutputFile(int numOut){
        numOutputFile = numOut;
    }
    
    //set output file path
    public void setPathToOutputFiles(String pathOut){
        pathToOutputFiles = pathOut;
    }
    
    //set console output path
    public void setPathToConsoleOutput(String consoleOut){
        pathToConsoleOutput = consoleOut;
    }
    
    //set environment
    public void setEnvironment(String env){
        environment = env;
    }
    
    //get test name
    public String getTestName(){
        return testName;
    }
    
    //get number of input
    public int getNumInput(){
        return numInputFile;
    }
    
    //get input file path
    public String getPathToInputFiles(){
        return pathToInputFiles;
    }
    
    //get console input path
    public String getPathToConsoleInput(){
        return pathToConsoleInput;
    }
    
    //get number of output 
    public int getNumOutput(){
    
        return numOutputFile;
    }
    
    //get output file path
    public String getPathToOutputFiles(){
        return pathToOutputFiles;
    }
    
    //get console output
    public String getPathToConsoleOutput(){
        return pathToConsoleOutput;
    }
    
    //get environment
    public String getEnvironment(){
    
        return environment;
    }
}
    
