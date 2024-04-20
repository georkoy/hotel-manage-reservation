/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sabina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author George Koursos
 */
public class CompanyNamesFile {

    public CompanyNamesFile(String name,String maxroom) {
            try{
                File dir=new File("Filefolder");
            if(!dir.exists()){
                dir.mkdir();
            }
            FileOutputStream fos = new FileOutputStream("Filefolder/companies_name.txt", true);
            PrintWriter pw=new PrintWriter(fos);
                  pw.print(name+" "); 
                  pw.println(maxroom+" ");
                     pw.close();                     
        }
        catch (FileNotFoundException e){
             JOptionPane.showMessageDialog(Company_settings.getTakewindow(),"Error while saving the file. "+name+".\n No file exist !");
        }
      }//end con
    public  static void read() throws IOException{
     try{
         File dir=new File("Filefolder");
            if(!dir.exists()){
                dir.mkdir();
            }
        File file=new File("./Filefolder/companies_name.txt"); 
        Scanner scanner=new Scanner(file);
          while(scanner.hasNext()){
              Mainframe.addelemntCompanynames(scanner.next());
            Mainframe.addmaxroom(Integer.parseInt(scanner.next()));
           }            
     }
     catch (FileNotFoundException e){
      
         JOptionPane.showMessageDialog(Company_settings.getTakewindow(),"Error loading, companies_name.\n File not existing !");
     }
    
       catch (NoSuchElementException e){
            JOptionPane.showMessageDialog(null ,"Emty file companies_name.\nError Reloading.","Message Error ",JOptionPane.ERROR_MESSAGE);
             
       }     
    }
    public static void deletefile() {
        try (PrintWriter writer = new PrintWriter("Filefolder/companies_name.txt")) {
            writer.print("");
            writer.close();
        }
        catch (FileNotFoundException e){
        }
        
         for(int i=0;i<Mainframe.companynames.size();i++){
         try{
            FileOutputStream fos = new FileOutputStream("FileFolder/companies_name.txt", true);
            PrintWriter pw=new PrintWriter(fos);
                  pw.println(" "+Mainframe.companynames.get(i)+" "+Mainframe.companynamesmaxroom.get(i)); 
                     pw.close();                     
        }
        catch (FileNotFoundException e){
             JOptionPane.showMessageDialog(Company_settings.getTakewindow(),"Error while saving the file. "+Mainframe.companynames.get(i)+".\n No file exist !");
        }
    }
        Mainframe.company.removeAllItems();
        Mainframe.company.addItem("Company Name");
        Mainframe.company.setSelectedIndex(0);
        Mainframe.fillcompanycomobox();
    }
    public  static int roomcount(){
     try{
        File file=new File("./Filefolder/companies_name.txt");
        Scanner scanner=new Scanner(file);
        String companyname =Mainframe.getLeftList().getSelectedValue(),maxroom;
          while(scanner.hasNext()){
                if(scanner.next().equals(companyname)){
                    maxroom=scanner.next();
                    return Integer.parseInt(maxroom);
                }
                else{
                    scanner.next();
                }
           }
          
          scanner.close();
     }
     catch (FileNotFoundException e){
      
         JOptionPane.showMessageDialog(Company_settings.getTakewindow(),"Error reloading. companies_name.\n File not existing !");
     }
       
        return 0;
    }
}


