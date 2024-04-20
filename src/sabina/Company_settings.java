/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sabina;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author George Koursos
 */

public class Company_settings extends JDialog {
 public static DefaultListModel<String> leftListModel,origLeftListModel;
    private JList<String> leftList;
    private JTextField newcomanyfileld,maxroom;
    JLabel companiesnames;
    private JButton add,delete;
    private static Company_settings takewindow;
    
    public Company_settings(Frame paret) {
        super(paret,"Company Setting",true);
        setSize(630, 380);
          setLocationRelativeTo(null);
       // setMaximumSize(new Dimension(450,400));
      //  setMinimumSize(new Dimension(450, 400));
    //    setPreferredSize(new Dimension(450, 400));
      //  setResizable(false);
        setLayout(new BorderLayout());
         leftListModel = new DefaultListModel<String>();
         origLeftListModel = new DefaultListModel<String>();
          leftList = new JList<String>(leftListModel);
        leftList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane leftScrollPane = new JScrollPane(leftList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
      companiesnames=new JLabel("<HTML><u><b>Companies Names :</u></b></HTML>");
        leftPanel.add(companiesnames, BorderLayout.NORTH);
        leftScrollPane.setPreferredSize(new Dimension(companiesnames.getPreferredSize().width, 300));
        leftPanel.add(leftScrollPane, BorderLayout.CENTER);
        
        JPanel centermainpanel=new JPanel(new FlowLayout());
        
         JPanel buttonsanel = new JPanel(new GridLayout(2, 1, 7, 10));
        add=new JButton("Add");
        delete=new JButton("Delete");
        buttonsanel.add(add);
        buttonsanel.add(delete);
             add.setEnabled(false);
              delete.setEnabled(false);
              JPanel newcmpanel=new JPanel(new GridLayout(2,2,7,7));
               newcomanyfileld=new JTextField(10);
              newcmpanel.add(new JLabel("New company Name (Searching) :"));
              newcmpanel.add(newcomanyfileld);
              newcomanyfileld.setHorizontalAlignment(JTextField.CENTER);
              newcmpanel.add(new JLabel("Max rooms :"));
              maxroom=new JTextField(10);
              newcmpanel.add(maxroom);
              maxroom.setHorizontalAlignment(JTextField.CENTER);
              
        centermainpanel.add(leftPanel);
        centermainpanel.add(buttonsanel);
        centermainpanel.add(newcmpanel);
          newcomanyfileld.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                ckeck();
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                ckeck();
                filter();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
           ckeck();
            }
            
           
             private void filter()
            {
                String filter = newcomanyfileld.getText();
                leftListModel.clear();
                for (int i = 0; i < origLeftListModel.getSize(); i++)  {
                    String s = origLeftListModel.get(i);
                    if (s.contains(filter))  {
                        leftListModel.addElement(s);
                        if(s.equals(filter)){
                            add.setEnabled(false);
                        }
                        else{
                            add.setEnabled(true);
                        }
                    }
                }
            }
        });
          
          maxroom.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                ckeck1();
            }
            @Override
            public void removeUpdate(DocumentEvent de) {
                ckeck1();
            }
            @Override
            public void changedUpdate(DocumentEvent de) {
               ckeck1();
            }
        });
          newcomanyfileld.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
             leftList.clearSelection();
             add.setEnabled(false);
            }
            @Override
            public void mousePressed(MouseEvent me) {               
            }

            @Override
            public void mouseReleased(MouseEvent me) {
               leftList.clearSelection();
             add.setEnabled(false);
            }
            @Override
            public void mouseEntered(MouseEvent me) {
               
            }

            @Override
            public void mouseExited(MouseEvent me) {
               
            }
        });
        
        add(centermainpanel,BorderLayout.CENTER);
 
    
    leftList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                    if(leftList.isSelectionEmpty()){
                        delete.setEnabled(false);
                      
                        add.setEnabled(true);
                    }
                    else{
                        delete.setEnabled(true);
                      
                        add.setEnabled(false);
                    }
                
            }
        });
    add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {    
                String max=null;
                new CompanyNamesFile(newcomanyfileld.getText(),maxroom.getText());
                if(Integer.parseInt(maxroom.getText())<10){
                    max="0"+maxroom.getText();
                }
                else{
                    max=maxroom.getText();
                }
               Mainframe.setCompany(newcomanyfileld.getText());
                    leftListModel.addElement(newcomanyfileld.getText());
                    origLeftListModel.addElement(newcomanyfileld.getText());
                    Mainframe.addelemntCompanynames(newcomanyfileld.getText());
                    Mainframe.addmaxroom(Integer.parseInt(max));
                    newcomanyfileld.setText("");
                    maxroom.setText("");
                    add.setEnabled(false);
                    after();
            }
        });
    delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              int ans=  JOptionPane.showConfirmDialog(rootPane, "Are you sure  to delete "+leftList.getSelectedValue()+" company ?\nAll information wiil be lost !","Delete Company",JOptionPane.YES_NO_OPTION);
                if(ans==JOptionPane.YES_OPTION) {
                    String value=leftList.getSelectedValue();//.toString();
                Mainframe.removeelemntCompanynames(value);
             int index=leftList.getSelectedIndex();
                    leftListModel.remove(index);
                    origLeftListModel.remove(index);
                    newcomanyfileld.requestFocusInWindow();  
                    after();
                     add.setEnabled(false);
                     File file =new File("Filefolder/"+value+".txt");
                     file.delete();
                    CompanyNamesFile.deletefile();                    
                           }
                else{
                //do nothing
                }
            }
        });
        addWindowListener(new WindowAdapter() {
              @Override
            public void windowClosing(WindowEvent we) {
               leftListModel.clear();
               origLeftListModel.clear();
            }
        });
    }//end con

    public static void setLeftListModel(String s) {
        leftListModel.addElement(s);
        origLeftListModel.addElement(s);
    }
    private void after(){
            leftListModel.clear();
            origLeftListModel.clear();
     for (String companyname : Mainframe.companynames) {
         leftListModel.addElement(companyname);
         origLeftListModel.addElement(companyname);
     }
        }
   
     public static Company_settings getTakewindow() {
        return takewindow;
    }
      private void ckeck1(){
                 try{
                    Integer.parseInt(maxroom.getText());
                 }
                 catch(NumberFormatException e){
                  JOptionPane.showMessageDialog(Mainframe.getTakewindow(),"Invalid Input  !\nOnly Integers are allowed .");
                     try{    
                        }
                        catch (IllegalStateException r){

                        }
                 }
                
            if(newcomanyfileld.getText().equals("") || newcomanyfileld.getText().isEmpty() || maxroom.getText().equals("") || maxroom.getText().isEmpty() ){
                add.setEnabled(false);   
            }
            else{
            add.setEnabled(true);                 
            }
            }      
       private void ckeck(){
            if(newcomanyfileld.getText().equals("") || newcomanyfileld.getText().isEmpty() || maxroom.getText().equals("") || maxroom.getText().isEmpty() ){
                add.setEnabled(false);   
            }
            else{
            add.setEnabled(true);                 
            }
            }
    
}
