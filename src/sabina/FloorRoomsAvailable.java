/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sabina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author George Koursos
 */
public class FloorRoomsAvailable {
private ArrayList<String>groundfloorarraylist=new ArrayList<String>();
private ArrayList<String>firstfloorarraylist=new ArrayList<String>();
private ArrayList<String>secondfloorarraylist=new ArrayList<String>();
private ArrayList<String>thirdfloorarraylist=new ArrayList<String>();
private ArrayList<String>fourthfloorarraylist=new ArrayList<String>();

    public FloorRoomsAvailable() {
    }
    

    
    public void fillarrylist(int indexfloor,String room){
        String namefile;
        if(indexfloor==1){
            namefile="groundfloor";
            groundfloorarraylist.add(room);
        }
        else if(indexfloor==2){
            namefile="firstfloor";
            firstfloorarraylist.add(room);
            }
    else if(indexfloor==3){
        namefile="seconfloor";
        secondfloorarraylist.add(room);
    }
    else if(indexfloor==4){
        namefile="thirdfloor";
        thirdfloorarraylist.add(room);
    }
    else{
        namefile="fourthfloor";
        fourthfloorarraylist.add(room);
    }
        try{
             File dir=new File("Filefolder");
            if(!dir.exists()){
                dir.mkdir();
            }
            FileOutputStream fos = new FileOutputStream("Filefolder/"+namefile+".txt", true);
            PrintWriter pw=new PrintWriter(fos);
            pw.print(room+" ");   
            pw.close();
           
        }
        catch (FileNotFoundException e){
             JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error while loading or creating file .\n File not exist . ");
        }
    }

    public void roomback(int indexfloor,String  room){
        if(indexfloor==1){
            groundfloorarraylist.remove(room);
        try{
             File dir=new File("Filefolder");
            if(!dir.exists()){
                dir.mkdir();
            }
            FileOutputStream fos = new FileOutputStream("Filefoder/groundfloor.txt", true);
            PrintWriter pw=new PrintWriter(fos);
             try (PrintWriter writer = new PrintWriter("Filefolder/groundfloor.txt")) {
            writer.print("");
        }
        catch (FileNotFoundException e){
        }
            for(int i=0;i<groundfloorarraylist.size();i++){
                 pw.write(groundfloorarraylist.get(i)+" ");
            }
            pw.close();
        }
        catch (FileNotFoundException e){
             JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error while loading or creating file .\n File not exist . ");
        }  
        }
        else if(indexfloor==2){
                firstfloorarraylist.remove(room);
        try{
            FileOutputStream fos = new FileOutputStream("Filefolder/firstfloor.txt", true);
            PrintWriter pw=new PrintWriter(fos);
             try (PrintWriter writer = new PrintWriter("Filefolder/firstfloor.txt")) {
            writer.print("");
        }
        catch (FileNotFoundException e){
        }
            for(int i=0;i<firstfloorarraylist.size();i++){
                 pw.write(firstfloorarraylist.get(i)+" ");
            }
            pw.close();
        }
        catch (FileNotFoundException e){
             JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error while loading or creating file .\n File not exist . ");
        }
        }
        
            
    else if(indexfloor==3){
           secondfloorarraylist.remove(room);
        try{
            FileOutputStream fos = new FileOutputStream("Filefolder/secondfloor.txt", true);
            PrintWriter pw=new PrintWriter(fos);
             try (PrintWriter writer = new PrintWriter("Filefolder/secondfloor.txt")) {
            writer.print("");
        }
        catch (FileNotFoundException e){
        }
            for(int i=0;i<secondfloorarraylist.size();i++){
                 pw.write(secondfloorarraylist.get(i)+" ");
            }
            pw.close();
        }
        catch (FileNotFoundException e){
             JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error while loading or creating file .\n File not exist . ");
        }
    }
    else if(indexfloor==4){
            thirdfloorarraylist.remove(room);
        try{
            FileOutputStream fos = new FileOutputStream("Filefolder/thirdfloor.txt", true);
            PrintWriter pw=new PrintWriter(fos);
             try (PrintWriter writer = new PrintWriter("Filefolder/thirdfloor.txt")) {
            writer.print("");
        }
        catch (FileNotFoundException e){
        }
            for(int i=0;i<thirdfloorarraylist.size();i++){
                 pw.write(thirdfloorarraylist.get(i)+" ");
            }
            pw.close();
        }
        catch (FileNotFoundException e){
             JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error while loading or creating file .\n File not exist . ");
        }
    }
    else{
           fourthfloorarraylist.remove(room);
        try{
            FileOutputStream fos = new FileOutputStream("Filefolder/fourthfloor.txt", true);
            PrintWriter pw=new PrintWriter(fos);
             try (PrintWriter writer = new PrintWriter("Filefolder/fourthfloor.txt")) {
            writer.print("");
        }
        catch (FileNotFoundException e){
        }
            for(int i=0;i<fourthfloorarraylist.size();i++){
                 pw.write(fourthfloorarraylist.get(i)+" ");
            }
            pw.close();
        }
        catch (FileNotFoundException e){
             JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error while loading or creating file .\n File not exist . ");
        }
    }
        
    }

    public void initlists(){
        for(int i=0;i<5;i++){
            
         try{
             if(i==0){
        File file=new File("./Filefolder/groundfloor.txt");
        Scanner scanner=new Scanner(file);         
        while(scanner.hasNext()){
            groundfloorarraylist.add(scanner.next());
        }
             }
             else if(i==1){
             File file=new File("./Filefolder/firstfloor.txt");
        Scanner scanner=new Scanner(file);         
        while(scanner.hasNext()){
            firstfloorarraylist.add(scanner.next());
        }
             }
             else if(i==2){
             File file=new File("./Filefolder/secondfloor.txt");
        Scanner scanner=new Scanner(file);         
        while(scanner.hasNext()){
            secondfloorarraylist.add(scanner.next());
        }
             }
             else if(i==3){
             File file=new File("./Filefolder/thirdfloor.txt");
        Scanner scanner=new Scanner(file);         
        while(scanner.hasNext()){
            thirdfloorarraylist.add(scanner.next());
        }
             }
             else{
           File file=new File("./Filefolder/fourthfloor.txt");
        Scanner scanner=new Scanner(file);         
        while(scanner.hasNext()){
            fourthfloorarraylist.add(scanner.next());
        }
         }
         }//end try
                 
     catch (FileNotFoundException e){
      if(!Mainframe.getLeftListModel().isEmpty()){
         JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error loadinο "+Mainframe.getLeftList().getSelectedValue()+".\n File not exist.");
      }
      }
    
       catch (NoSuchElementException e){
            JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Can't read file "+Mainframe.getLeftList().getSelectedValue()+".\nMaybe file is emty.","File error ",JOptionPane.ERROR_MESSAGE);
             
       }
       
    
        }
    
    }
    public ArrayList<String> getGroundfloorarraylist() {
        return groundfloorarraylist;
    }

    public ArrayList<String> getFirstfloorarraylist() {
        return firstfloorarraylist;
    }

    public ArrayList<String> getSecondfloorarraylist() {
        return secondfloorarraylist;
    }

    public ArrayList<String> getThirdfloorarraylist() {
        return thirdfloorarraylist;
    }

    public ArrayList<String> getFourthfloorarraylist() {
        return fourthfloorarraylist;
    }
    
}
