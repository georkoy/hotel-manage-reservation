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
import javax.swing.JOptionPane;

/**
 *
 * @author George Koursos
 */
public class SaveToFile {
    
      public SaveToFile(String roomnuber,String fromdate,String tilldate,String pax,String kids,int al,int hw ) {
          
          try{
            File dir=new File("Filefolder");
            if(!dir.exists()){
                dir.mkdir();
            }
            FileOutputStream fos = new FileOutputStream("Filefolder/"+Mainframe.company.getSelectedItem().toString()+".txt", true);
            PrintWriter pw=new PrintWriter(fos);
              System.out.println(roomnuber);
            pw.print(roomnuber+" ");
             pw.print(fromdate+" ");
               pw.print(tilldate+" ");
                pw.print(pax+" ");
                  pw.print(kids+" ");
                      pw.print(al+" ");
                          pw.println(hw+" ");
                     pw.close();                
        }
        catch (FileNotFoundException e){
             JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Error while loading or creating file .\n File not exist . ");
        }
         
        catch(IOException d){
        
        }
          }//end constr
    
}
