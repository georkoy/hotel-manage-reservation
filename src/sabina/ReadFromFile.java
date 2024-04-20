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
public class ReadFromFile {
private  int sumal,sumhw,sumkids;
   
    public ReadFromFile() {
        
    }
    
      public int[]  read(boolean sr ) {
                  sumal=0;sumhw=0;sumkids=0;
               int []  sab=new int[3];
          File file;
         try{
             File dir=new File("Filefolder");
            if(!dir.exists()){
                dir.mkdir();
            }
             if(!sr){
         file=new File("./Filefolder/"+Mainframe.getLeftList().getSelectedValue()+".txt");
             }
             else{
                 file=new File("./Filefolder/"+Mainframe.getLeftListdate().getSelectedValue()+".txt");
             }  
        Scanner scanner=new Scanner(file);
            Mainframe.cleartable();
                String room,from,till,pax,kids;
            int al=0,hw=0,dayfrom,monthfrom,yearfrom,daytill,monthtill,yeartill ,daysel,monthsel,yearasel;
        while(scanner.hasNext()){
          // System.gc();
                     room=scanner.next();
                    from=scanner.next();
                    till=scanner.next();
                    pax=scanner.next();
                    kids=scanner.next();
                   al= scanner.nextInt();
                   hw= scanner.nextInt();
                   String []splidfrom=from.split("/");
                   String []splidtill=till.split("/");
                   int days = 0;
                   if(Integer.parseInt(splidtill[1])>Integer.parseInt(splidfrom[1])){
                   
                   }
                   else{
                       days=(Integer.parseInt(splidtill[0])-Integer.parseInt(splidfrom[0]))+1;
                   }
                   if(!sr){
             Mainframe.getTableModel().addRow(new Object[]{room,from,till,Integer.toString(days),pax,kids});
                        }
                 else{
                    String parts[]=from.split("/");
                 dayfrom=Integer.parseInt(parts[0]);monthfrom=Integer.parseInt(parts[1]);yearfrom=Integer.parseInt(parts[2]);
                 String parts1[]=till.split("/");
                 daytill=Integer.parseInt(parts1[0]);monthtill=Integer.parseInt(parts[1]); yeartill=Integer.parseInt(parts[2]);
                 daysel=Integer.parseInt(Mainframe.getSelectday().getSelectedItem().toString());monthsel=Integer.parseInt(Mainframe.getSelectmonth().getSelectedItem().toString());yearasel=Integer.parseInt(Mainframe.getSelectyear().getSelectedItem().toString());
                    if(yearasel>=yearfrom && yearasel<=yeartill){
                     if(monthsel>=monthfrom && monthsel<=monthtill){
                        if(daysel>dayfrom && daysel<daytill){
                            sumal=sumal+al;
                             sumhw=sumhw+hw;
                             sumkids=sumkids+Integer.parseInt(kids);
                           //  System.out.println("readfile "+this.getSumkids());
                                sab[0]=getSumal();
                                sab[1]=getSumhw();
                                sab[2]=getSumkids();
                         }
                     }
                 }
                }
        }
        scanner.close();
       
     }
     catch (FileNotFoundException e){
      if(!Mainframe.getLeftListModel().isEmpty()){
        // JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error loading "+Mainframe.getLeftList().getSelectedValue()+".\n File not exist.");
      }
      }
    
       catch (NoSuchElementException e){
            JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Can't read file "+Mainframe.getLeftList().getSelectedValue()+".\nMaybe file is emty.","File error ",JOptionPane.ERROR_MESSAGE);           
       }
         catch(SecurityException e){
             System.err.println(e.toString());
         }
         return sab;
    }

    public  int getSumal() {
        return sumal;
    }

    public  int getSumhw() {
        return sumhw;
    }

    public  int getSumkids() {
        return sumkids;
    }
      
public  void copy(int rom){
 String room,from,till,pax,kids;
 int al,hw; 
  File file1,file2;
  String value=Mainframe.getLeftList().getSelectedValue();
     try{
     file1=new File("./Filefolder/"+value+".txt");   
     File dir=new File("Filefolder");
            if(!dir.exists()){
                dir.mkdir();
            } 
            FileOutputStream fos = new FileOutputStream("Filefolder/tmp.txt", true);
            PrintWriter pw=new PrintWriter(fos);
           Scanner scanner=new Scanner(file1);
                while(scanner.hasNext()){
                     room=scanner.next();
                    from=scanner.next();
                    till=scanner.next();
                    pax=scanner.next();
                    kids=scanner.next();
                   al= scanner.nextInt();
                   hw= scanner.nextInt();                  
            
                    if(rom!=Integer.parseInt(room)){
                    pw.print(room+" ");
                    pw.print(from+" ");
                    pw.print(till+" ");
                    pw.print(pax+" ");
                    pw.print(kids+" ");
                    pw.print(al+" ");
                    pw.println(hw+" ");                
                    }
                }//end while 
                 pw.close();
                scanner.close();
                fos.close();
              file1.delete();
                file2=new File("Filefolder/tmp.txt");
                File file3=new File("Filefolder/"+value+".txt");
                if(file2.exists()){    
                  file2.renameTo(file3);
                }
     }//end try     
    
     catch (IOException ew){
             JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error while loading or creating file .\n File not exist . ");
        }
 /*   catch (FileNotFoundException e){
      if(!Mainframe.getLeftListModel().isEmpty()){
         JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error loading "+Mainframe.getLeftList().getSelectedValue()+".\n File not exist.");
      }
      }*/
    
       catch (NoSuchElementException e){
            JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Can't read file "+Mainframe.getLeftList().getSelectedValue()+".\nMaybe file is emty.","File error ",JOptionPane.ERROR_MESSAGE);           
       }
         catch(SecurityException e){
             System.err.println(e.toString());
         }
}
}