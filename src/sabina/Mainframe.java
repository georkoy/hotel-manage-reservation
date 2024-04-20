/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sabina;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author George Koursos
 */
public class Mainframe extends  JFrame{
    private static JTable table;
    private static DefaultTableModel tableModel = new DefaultTableModel();
    public static DefaultListModel<String> leftListModel  =new DefaultListModel<String>();
    private static JList<String> leftList;
    public static DefaultListModel<String> leftListModeldate  =new DefaultListModel<String>();
    private static JList<String> leftListdate;
    private final JPanel buttonmainpanel;
    private final JPanel buttonspanel;
    private final static String fs="Firstscreen";
    private final static String ss="Secondscreen";
     private final static String tds="Thirdscreen";
    private JButton next=new JButton("Search By Company");
    private JButton searchbydate=new JButton("Search By Date");
    private JButton back=new JButton("Return");
    private JPanel cardlayoutpanel,firstscreen,secondscreen;
    private JComboBox<String> roomflor = new JComboBox<>();
     private JComboBox<String> roomnumber = new JComboBox<>();
      private JComboBox<String> pax = new JComboBox<>();
       private JComboBox<String> kids = new JComboBox<>();
    public static JComboBox<String> company = new JComboBox<>();
   private JCheckBox companyremindckeckbox;
   private JButton add_delete_company;
private JComboBox<String> fromday = new JComboBox<>();
private JComboBox<String> frommonth = new JComboBox<>();
private JComboBox<String> fromyear = new JComboBox<>();
private JComboBox<String> tillday = new JComboBox<>();
private JComboBox<String> tillmonth = new JComboBox<>();
private JComboBox<String> tillyear = new JComboBox<>();
private static JComboBox<String> selectday = new JComboBox<>();
private static JComboBox<String> selectmonth = new JComboBox<>();
private static JComboBox<String> selectyear = new JComboBox<>();
private JRadioButton radio1,radio2;
private CardLayout cardpanel;
private boolean roomnumberbl=false;
private boolean roomflorbl=false;
private boolean companybl=false;
private boolean fromdaybl=false;
private boolean  frommonthbl=false;
private boolean fromyearbl=true;
private boolean tilldaybl=false;
private boolean tillmonthbl=false;
private boolean tillyearbl=true;
private boolean paxbl=false;
private boolean kidsbl=false;
private boolean ckeck=false;
private static JTextField people=new JTextField(10);
private static JTextField kidsdate=new JTextField(10);
private static JTextField aldate=new JTextField(10);
private static JTextField hbdate=new JTextField(10);
private  JTextField total=new JTextField(10);
private static int alcounter,hwcounter;
public static  Company_settings companysettings;
public static  ArrayList<String> companynames=new ArrayList<String>();
public static  ArrayList<Integer> companynamesmaxroom=new ArrayList<Integer>();
private JButton entrybutton;
private static Mainframe takewindow;
private FloorRoomsAvailable roomavailable=new FloorRoomsAvailable();
private ReadFromFile readfromfile=new ReadFromFile();
private JLabel roominfo=new JLabel("Rooms 0/0");
private JLabel sumrooms=new JLabel("Total Rooms 0/0");
private JLabel datelabel=new JLabel("date");
private JLabel timelabel=new JLabel("time");
private int maxroom=0,row=0;
private ListSelectionModel model;
private DateFormat dateFormat;
private  Date date;
private String[] spliddate;
private JFrame frame= new JFrame();
 private TestPane hourlabel=new  TestPane();
 private ImageIcon loading = new ImageIcon("ajax-loader.gif");
 private JLabel loadinglabel=new JLabel("",loading,JLabel.CENTER);
 private boolean  mouseinvent=false;
public Mainframe() {
        setSize(530, 510); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Information Add");
         //  this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                setLocationRelativeTo(null);
        companysettings=new Company_settings(this);
        setLayout(new BorderLayout());
        frame=this;
        try {
            //*******
            CompanyNamesFile.read();
        } catch (IOException ex) {
            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
         dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
          date = new Date();            
            String tmpdate=dateFormat.format(date);
            spliddate= tmpdate.split(" ");
        //***********         
      /*      JMenuBar menubar=new JMenuBar();
      //menu settings
       JMenu menuoption=new JMenu("Options");
       JMenuItem itemexit=new JMenuItem("Exit");
       JMenuItem itempassword=new JMenuItem("Password");
         menubar.add(menuoption);
         menuoption.add(itempassword);
         menuoption.addSeparator();
         menuoption.add(itemexit); 
           setJMenuBar(menubar);
             itemexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Exit")){
                    System.exit(0);        
                }
            }
        });
             itempassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
              if(ae.getActionCommand().equals("Password")){
                        
                 }
            }
        });*/
        cardlayoutpanel=new JPanel(new CardLayout());   
      //  cardlayoutpanel.setBackground(new Color(204,153,255));
        firstscreen=new JPanel(new BorderLayout());
 
           JPanel elementpanel=new JPanel(new GridLayout(7,7,-240,7));
           JPanel centermainpanel=new JPanel(new FlowLayout());      
          // centermainpanel.setBackground(new Color(204,153,255));
           JPanel maipanel=new JPanel(new BorderLayout());
           JPanel roomnumberpanel=new JPanel(new FlowLayout());
            elementpanel.add(new JLabel("Room Number :"));
            roomnumberpanel.add(roomflor);
            roomflor.addItem("Select Floor");
            roomflor.addItem("Groundfloor  (1)");
            roomflor.addItem("First floor  (2)");
            roomflor.addItem("Second floor (3)");
            roomflor.addItem("Third floor  (4)");
            roomflor.addItem("Fourth floor (5)");
            roomnumber.addItem("Room Number");
            roomnumber.setEnabled(false);
            roomavailable.initlists();
            roomflor.addActionListener(new ActionListener() {
                /**
               * 1,2,3-> 32
               * 4-> 15
               * 5-> 13
               */
              @Override
            public void actionPerformed(ActionEvent ae) {
                int index=roomflor.getSelectedIndex();
                if(index==0){
                    roomnumber.setEnabled(false);
                    roomnumber.removeAllItems();
                    roomnumber.addItem("Room Number :");
                }
                else if(index==1){
                     roomnumber.setEnabled(true);
                     roomnumber.removeAllItems();
                         for(int i=1;i<=32;i++){
                           if(i<=9){
                               if(!roomavailable.getGroundfloorarraylist().contains(0+""+i)){
                               String x=0+""+i;
                               roomnumber.addItem(x);}
                           }
                           else{
                                if(!roomavailable.getGroundfloorarraylist().contains(i)){
                            roomnumber.addItem(Integer.toString(i));}
                           }
                       }
                }
                else if(index==2){
                 roomnumber.setEnabled(true);
                     roomnumber.removeAllItems();
                         for(int i=1;i<=32;i++){
                           if(i<=9){
                               if(!roomavailable.getFirstfloorarraylist().contains(0+""+i)){
                               String x=0+""+i;
                               roomnumber.addItem(x);}
                           }
                           else{
                                if(!roomavailable.getFirstfloorarraylist().contains(i)){
                            roomnumber.addItem(Integer.toString(i));}
                           }
                       }
                }
                else if(index==3){
                     roomnumber.setEnabled(true);
                     roomnumber.removeAllItems();
                         for(int i=1;i<=32;i++){
                           if(i<=9){
                               if(!roomavailable.getSecondfloorarraylist().contains(0+""+i)){
                               String x=0+""+i;
                               roomnumber.addItem(x);}
                           }
                           else{
                                if(!roomavailable.getSecondfloorarraylist().contains(i)){
                            roomnumber.addItem(Integer.toString(i));}
                           }
                       }
                }
                else if(index==4) {
                     roomnumber.setEnabled(true);
                     roomnumber.removeAllItems();
                     for(int i=1;i<=15;i++){
                            if(i<=9){
                                if(!roomavailable.getThirdfloorarraylist().contains(0+""+i)){
                               String x=0+""+i;
                               roomnumber.addItem(x);}
                           }
                           else{
                                   if(!roomavailable.getThirdfloorarraylist().contains(i)){
                            roomnumber.addItem(Integer.toString(i));}
                           }
                       } 
                }
                else if(index==5){
                     roomnumber.setEnabled(true);
                     roomnumber.removeAllItems();
                 for(int i=1;i<=13;i++){
                          if(i<=9){
                                 if(!roomavailable.getFirstfloorarraylist().contains(0+""+i)){
                               String x=0+""+i;
                               roomnumber.addItem(x);
                                 }
                           }
                           else{
                                 if(!roomavailable.getFourthfloorarraylist().contains(0+""+i)){
                            roomnumber.addItem(Integer.toString(i));}
                           }
                       }
                }
                
            }
        });  
            roomnumberpanel.add(roomnumber);
            elementpanel.add(roomnumberpanel);
            elementpanel.add(new JLabel("Company :"));
            companyremindckeckbox=new JCheckBox("Remember me");
            companyremindckeckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    if(!companyremindckeckbox.isSelected()){
                        company.setSelectedIndex(0);
                        ckeck=false;
                    }
                    else{
                        ckeck=true;
                    }
            }
        });
            add_delete_company=new JButton("Add/Delete");
            JPanel companypanel=new JPanel(new FlowLayout());
            companypanel.add(company);
            company.addItem("Company Name");
            fillcompanycomobox();          
            companypanel.add(companyremindckeckbox);
            companypanel.add(add_delete_company);
            elementpanel.add(companypanel);            
            elementpanel.add(new JLabel("From :"));
           JPanel frompanel=new JPanel(new FlowLayout());
           cmbfill();
           frompanel.add(fromday);
           frompanel.add(frommonth);
           frompanel.add(fromyear);
            elementpanel.add(frompanel);
            elementpanel.add(new JLabel("Till :"));
            JPanel tillpanel=new JPanel(new FlowLayout());
            tillpanel.add(tillday);
            tillpanel.add(tillmonth);
            tillpanel.add(tillyear);
            elementpanel.add(tillpanel);
          JPanel paxpanel=new JPanel(new FlowLayout());
            elementpanel.add(new JLabel("Pax :"));
          paxpanel.add(pax);
          pax.addItem("Pax");
          for(int i=1;i<=10;i++){
              if(i>9){
          pax.addItem(Integer.toString(i));
              }
              else{
                  String x=0+""+i;
                  pax.addItem(x);
              }
          }
            elementpanel.add(paxpanel);
            elementpanel.add(new JLabel("Kids :"));
            JPanel kidspanel=new JPanel(new FlowLayout());
            kidspanel.add(kids);
            kids.addItem("Kids");
            for(int i=0;i<=10;i++){
              if(i>9){
          kids.addItem(Integer.toString(i));
              }
              else{
                  String x=0+""+i;
                  kids.addItem(x);
              }
          }
            elementpanel.add(kidspanel);          
            JPanel radiopanel=new JPanel(new FlowLayout());
            radio1=new JRadioButton("All-Inclusive");
            radio1.setSelected(true);
            radio2=new JRadioButton("Half-Board");
                radiopanel.add(radio1);
                radiopanel.add(radio2);
                ButtonGroup group=new ButtonGroup();
                group.add(radio1);
                group.add(radio2);
            maipanel.add(elementpanel,BorderLayout.NORTH);
            maipanel.add(radiopanel,BorderLayout.CENTER);
            entrybutton=new JButton("   Entry   ");
            entrybutton.setEnabled(false);
          // entrybutton.setBackground(Color.GREEN);
            JPanel entrypanel=new JPanel(new FlowLayout());
            entrypanel.add(entrybutton);
            maipanel.add(entrypanel,BorderLayout.SOUTH);
            
            centermainpanel.add(maipanel);
      firstscreen.add(centermainpanel,BorderLayout.CENTER);
      back.setEnabled(false);
     //*********************************************************************
   cardlayoutpanel.add(firstscreen,fs);
        secondscreen=new JPanel(new BorderLayout());     
        JPanel centermainpanelsec=new JPanel(new BorderLayout());//*******
        
       
        leftList=new JList<String>(leftListModel);
        leftList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JPanel mainJPanel=new JPanel(new BorderLayout());
       table=new JTable(tableModel);
       tableModel.setColumnIdentifiers(new Object[]{"Room Number","From","Till","Nights","Pax","Kids"});
        model=table.getSelectionModel();
        table.setSelectionBackground(Color.RED);
         table.disable();
         table.getTableHeader().setResizingAllowed(false);
         table.getTableHeader().setReorderingAllowed(false);
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );         
table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );

       JScrollPane rightScrollPane = new JScrollPane(table);
       rightScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
       JScrollPane leftsJScrollPane=new JScrollPane(leftList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       leftsJScrollPane.setPreferredSize(new Dimension(150, 100));
     leftsJScrollPane.setMinimumSize(new Dimension(110, 150));

        mainJPanel.add(leftsJScrollPane,BorderLayout.WEST);
      mainJPanel.add(rightScrollPane,BorderLayout.CENTER);
  
   centermainpanelsec.add(mainJPanel);
   secondscreen.add(centermainpanelsec);
   cardlayoutpanel.add(secondscreen,ss);
   //*************************************************
   JPanel thirdscreen=new JPanel(new BorderLayout());
            JPanel selectdate=new JPanel(new FlowLayout());
                selectdate.add(selectday);
                selectdate.add(selectmonth);
                selectdate.add(selectyear);
                selectday.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
           listenable();
            }
        });
                selectmonth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            listenable();
            }
        });
                selectyear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                listenable();
            }
        });
             leftListdate=new JList<String>(leftListModeldate);
        leftListdate.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          JScrollPane leftsJScrollPanedate=new JScrollPane(leftListdate,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       leftsJScrollPanedate.setPreferredSize(new Dimension(120, 300));
     leftsJScrollPanedate.setMinimumSize(new Dimension(120, 300));
        JPanel mainpanel=new JPanel(new FlowLayout());
      JPanel thirdmainpanel=new JPanel(new GridLayout(5, 2, -15, 7));
      JLabel peop=new JLabel("People :");
      peop.setForeground(Color.RED);
      thirdmainpanel.add(peop);
      thirdmainpanel.add(people);
      people.setForeground(Color.RED);
      people.setHorizontalAlignment(JTextField.CENTER);
      people.setEditable(false);
      thirdmainpanel.add(new JLabel("Kids :"));
      thirdmainpanel.add(kidsdate);
      kidsdate.setHorizontalAlignment(JTextField.CENTER);
      thirdmainpanel.add(new JLabel("All-Inclisive :"));
      thirdmainpanel.add(aldate);
      aldate.setHorizontalAlignment(JTextField.CENTER);
      thirdmainpanel.add(new JLabel("Half-Board :"));
      thirdmainpanel.add(hbdate);
      hbdate.setHorizontalAlignment(JTextField.CENTER);
      thirdmainpanel.add(new JLabel("Total :"));
      thirdmainpanel.add(total);
      total.setHorizontalAlignment(JTextField.CENTER);
      kidsdate.setEditable(false);
      aldate.setEditable(false);
      hbdate.setEditable(false);
      total.setEditable(false);
      mainpanel.add(leftsJScrollPanedate);
      mainpanel.add(new JPanel(new GridLayout(1,1,-20,0)));
      mainpanel.add(thirdmainpanel);
   thirdscreen.add(selectdate,BorderLayout.NORTH);
   thirdscreen.add(mainpanel,BorderLayout.SOUTH);
   cardlayoutpanel.add(thirdscreen,tds);
   add(cardlayoutpanel,BorderLayout.CENTER);
      
     /**********Buttons panel********/
           buttonmainpanel=new JPanel(new BorderLayout());
          buttonspanel=new JPanel(new FlowLayout());
         buttonspanel.add(searchbydate);
         buttonspanel.add(back);
         buttonspanel.add(next);
         buttonmainpanel.add(buttonspanel,BorderLayout.EAST);  
         FlowLayout flowstatus=new FlowLayout();
         flowstatus.setHgap(15);
         JPanel statuspanel=new JPanel(flowstatus);
         statuspanel.add(roominfo);
         statuspanel.add(sumrooms);
         buttonmainpanel.add(statuspanel,BorderLayout.WEST);
    roominfo.setVisible(false);
    sumrooms.setVisible(false);
         add(buttonmainpanel,BorderLayout.SOUTH);
         /**********Buttons panel********/
         JPanel datetimepanel=new JPanel(new BorderLayout());
         FlowLayout flow=new FlowLayout();
         flow.setHgap(15);
         JPanel datetimepanel1=new JPanel(flow);
             datetimepanel1.add(datelabel);
            datetimepanel1.add(hourlabel);
         datetimepanel.add(datetimepanel1,BorderLayout.CENTER);
         datelabel.setText(spliddate[0]);
      //   datelabel.setForeground(Color.BLUE);
          //   datetimepanel1.setBackground(new Color(102, 255, 255));
             add(datetimepanel1,BorderLayout.NORTH);
         cardpanel=(CardLayout)(cardlayoutpanel.getLayout());
    next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              setSize(800, 500);             
                setTitle("Search By Company");
                selectday.setSelectedIndex(0);
                selectmonth.setSelectedIndex(0);
                selectyear.setSelectedIndex(1);
                leftListModeldate.clear();
                leftListModel.clear();
                cleartable();
                 row=maxroom=0;
                  roominfo.setVisible(true);
                  sumrooms.setVisible(true);
                  setLocationRelativeTo(null);
                cardpanel.next(cardlayoutpanel);
                cardpanel.show(cardlayoutpanel, ss);
                 sumrooms.setText("Total Rooms "+sumrooms()+" / 124");
                for (String companyname : companynames) {
                    leftListModel.addElement(companyname);
                }
                next.setEnabled(false);
                back.setEnabled(true);
                searchbydate.setEnabled(true);
                kidsdate.setText("");
                aldate.setText("");
                hbdate.setText("");
                people.setText("");
                
            }
        });
    back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setSize(530, 510); 
                setTitle("Information Add");
                  setLocationRelativeTo(null);
                  leftListModeldate.clear();
                  leftListModel.clear();
                  roominfo.setVisible(false);
                  sumrooms.setVisible(false);
                  cleartable();
                 row=maxroom=0;
                cardpanel.previous(cardlayoutpanel);
                cardpanel.show(cardlayoutpanel, fs);
                leftListModel.clear();
                next.setEnabled(true);
                searchbydate.setEnabled(true);
                back.setEnabled(false);
                selectday.setSelectedIndex(0);
                selectmonth.setSelectedIndex(0);
                selectyear.setSelectedIndex(1);
                kidsdate.setText("");
                aldate.setText("");
                hbdate.setText("");
                people.setText("");
            }
        });
    leftListdate.setEnabled(false);
   
    searchbydate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setTitle("Search By Date");
                  setSize(590, 480);
                leftListModel.clear();
                leftListdate.clearSelection();
                  setLocationRelativeTo(null);
                  roominfo.setVisible(true);
                  sumrooms.setVisible(true);
                  cleartable();
                  maxroom=row=0;
                  sumrooms.setText("Total Rooms "+sumrooms()+" / 124");
                cardpanel.previous(cardlayoutpanel);
                cardpanel.show(cardlayoutpanel, tds);
                kidsdate.setText("");
                total.setText("");
                aldate.setText("");
                hbdate.setText("");
                people.setText("");
                for(int i=0;i<companynames.size();i++){
                   leftListModeldate.addElement(companynames.get(i));
                }
                searchbydate.setEnabled(false);
                back.setEnabled(true);
                next.setEnabled(true);
                selectday.setSelectedIndex(0);
                selectmonth.setSelectedIndex(0);
                selectyear.setSelectedIndex(1);
            }
        });
    
    add_delete_company.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0;i<companynames.size();i++){
                   Company_settings.setLeftListModel(companynames.get(i));
                }
                companysettings.setVisible(true);
            }
        });
    company.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(company.getSelectedIndex()==0){
                    companybl=false;
                }
                else{
                companybl=true;
                }
                entryedit();
            }
        });
    roomflor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(roomflor.getSelectedIndex()==0){
                    roomflorbl =false;
                }
                else{
                roomflorbl=true;
                }
                entryedit(); 
            }
            
        });
        pax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(pax.getSelectedIndex()==0){
                    paxbl =false;
                }
                else{
                paxbl=true;
                }
                entryedit();
            }
        });
    
    kids.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(kids.getSelectedIndex()==0){
                    kidsbl =false;
                }
                else{
                kidsbl=true;
                }
                entryedit();
            }
        });
    
    fromday.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(fromday.getSelectedIndex()==0){
                    fromdaybl =false;
                }
                else{
                fromdaybl=true;
                }
                entryedit();
            }
        });
    
    frommonth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(frommonth.getSelectedIndex()==0){
                    frommonthbl =false;
                }
                else{
                frommonthbl=true;
                }
                entryedit();
            }
        });
    
    fromyear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(fromyear.getSelectedIndex()==0){
                    fromyearbl =false;
                }
                else{
                fromyearbl=true;
                }
                entryedit();
            }
        });
    tillday.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(tillday.getSelectedIndex()==0){
                    tilldaybl =false;
                }
                else{
                tilldaybl=true;
                }
                entryedit();
            }
        });
    tillmonth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(tillmonth.getSelectedIndex()==0){
                    tillmonthbl =false;
                }
                else{
                tillmonthbl=true;
                }
                entryedit();
            }
        });
    
    tillyear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(tillyear.getSelectedIndex()==0){
                    tillyearbl =false;
                }
                else{
                tillyearbl=true;
                }
                entryedit();
            }
        });
    
    entrybutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                 if(radio1.isSelected()){
                alcounter=alcounter+Integer.parseInt(pax.getSelectedItem().toString());
              }
            else{ 
                  hwcounter=hwcounter+Integer.parseInt(pax.getSelectedItem().toString());
            }
            roomavailable.fillarrylist(roomflor.getSelectedIndex(), roomnumber.getSelectedItem().toString()); 
                      new SaveToFile(getroomnumber(false), getfromdate(false), gettilldate(false), pax.getSelectedItem().toString(), kids.getSelectedItem().toString(),alcounter,hwcounter);       
              tableModel.addRow(new Object[]{getroomnumber(true),getfromdate(true),gettilldate(true),pax.getSelectedItem().toString(),kids.getSelectedItem().toString()});
              kids.setSelectedIndex(0);
               pax.setSelectedIndex(0);               
                       
             if(ckeck){
                        //do nothing
                    }
                    else{
                        company.setSelectedIndex(0);
                    }    
            }
        });
        if(next.isEnabled()){
    leftList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                  cleartable();                 
                readfromfile.read(false);
                colortable();
               row= maxroom=0;
                statuslabel(false);         
            }
        });
        }
            leftListdate.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e){
                   if(mouseinvent){
                   cleartable();
                  int index = leftListdate.locationToIndex(e.getPoint());
                        leftListdate.setSelectedIndex(index);
                        int [] sb=readfromfile.read(true);
                    statuslabel(true);
                kidsdate.setText(Integer.toString(sb[2]));
                aldate.setText(Integer.toString(sb[0]));
                hbdate.setText(Integer.toString(sb[1]));
                total.setText(Integer.toString(Integer.parseInt(kidsdate.getText())+ Integer.parseInt(aldate.getText())+Integer.parseInt(hbdate.getText())));
                  people.setText(Integer.toString(totalall()));
                   }
                    }
             });
        
        
      /*  leftListdate.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                cleartable();
                leftListdate.clearSelection();              
                System.out.println(totalall());
                            }
               
            
        });*/
  table.addMouseListener(new MouseAdapter() {@Override
 public void mouseClicked(MouseEvent e){
     int rowNumber = 0;
    if(SwingUtilities.isRightMouseButton(e)) {
        Point p = e.getPoint();
// get the row index that contains that coordinate
 rowNumber = table.rowAtPoint( p );
  int ans=  JOptionPane.showConfirmDialog(rootPane, "Are you sure  to delete  row "+rowNumber+1+" ?\nData wiil be lost !","Delete row",JOptionPane.YES_NO_OPTION);
        if(ans==JOptionPane.YES_OPTION) {
  roombackfunction(rowNumber);
        statuslabel(false);
        }
        else{
        //not delete
        }
    }         
 }});
}  //end con
private void entryedit(){
          if(roomflorbl==true && companybl==true && fromdaybl==true && frommonthbl==true && fromyearbl==true && tilldaybl==true &&tillmonthbl==true && tillyearbl==true &&paxbl==true && kidsbl==true ){
           entrybutton.setEnabled(true);   
          }
          else{
              entrybutton.setEnabled(false);
          }
      }
  private int totalall(){
        int sum=0;
     for(int i=0;i<leftListModeldate.getSize();i++){
                   leftListdate.setSelectedIndex(i);
                    int tmp[]=readfromfile.read(true);
                    sum=sum+(tmp[0]+tmp[1]+tmp[2]);
                            }
     leftListdate.clearSelection();
        return sum;
    
    }
    private void listenable(){
        if(selectday.getSelectedIndex()!=0 && selectmonth.getSelectedIndex()!=0 && selectyear.getSelectedIndex()!=0){
                leftListdate.setEnabled(true);
                mouseinvent=true;
        }
        else{
            leftListdate.setEnabled(false);
            mouseinvent=false;
        }
    }
    
    private void cmbfill(){
         fromday.addItem(" Day ");
        frommonth.addItem(" Month ");
        fromyear.addItem(" Year ");
          tillday.addItem(" Day ");
        tillmonth.addItem(" Month ");
        tillyear.addItem(" Year ");
        selectday.addItem(" Day ");
        selectmonth.addItem(" Month ");
        selectyear.addItem(" Year ");
    for(int i=1;i<=31;i++){
        if(i<=12){
            if(i<10){
                String x=0+""+i;
            fromday.addItem(x);
            frommonth.addItem(x);
            tillday.addItem(x);
            tillmonth.addItem(x);
            selectday.addItem(x);
            selectmonth.addItem(x);
            }
            else{
             fromday.addItem(Integer.toString(i));
             frommonth.addItem(Integer.toString(i));
             tillday.addItem(Integer.toString(i));
             tillmonth.addItem(Integer.toString(i));
             selectday.addItem(Integer.toString(i));
             selectmonth.addItem(Integer.toString(i));
            }
        }
        else{
        fromday.addItem(Integer.toString(i));
        tillday.addItem(Integer.toString(i));
        selectday.addItem(Integer.toString(i));
        }
    }
    fromyear.addItem( Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
    fromyear.addItem(Integer.toString( Calendar.getInstance().get(Calendar.YEAR)+1));
    fromyear.addItem(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)+2));
    fromyear.setSelectedIndex(1);
    
    tillyear.addItem( Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
    tillyear.addItem(Integer.toString( Calendar.getInstance().get(Calendar.YEAR)+1));
    tillyear.addItem(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)+2));
    tillyear.setSelectedIndex(1);
    
     selectyear.addItem( Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
    selectyear.addItem(Integer.toString( Calendar.getInstance().get(Calendar.YEAR)+1));
    selectyear.addItem(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)+2));
    selectyear.setSelectedIndex(1);
    }
             
 public static  void  addelemntCompanynames(String element) {
        companynames.add(element);
     //  Collections.sort(companynames);
   }
  public static  void  removeelemntCompanynames(String element) {
        companynames.remove(element);
        leftListModel.removeElement(element);
      //Collections.sort(companynames);
    }
  
  public static void addmaxroom(int maxroom){
        companynamesmaxroom.add(maxroom);
  
  }
  private String getfromdate(boolean bl){
        String rt= fromday.getSelectedItem().toString()+"/"+frommonth.getSelectedItem().toString() +"/"+fromyear.getSelectedItem().toString();
     if(bl){
        fromday.setSelectedIndex(0);
        frommonth.setSelectedIndex(0);
        fromyear.setSelectedIndex(1);
     }
        return rt;     
  }
  
  private String getroomnumber(boolean bl){
      String real ,fake;
      fake=roomflor.getSelectedItem().toString();
      if(fake.contains("1")){
          real="1";
      }
      else if(fake.contains("2")){
          real="2";
      }
      else if(fake.contains("3")){
          real="3";
      }
      else{
          real="5";
      }
      real=real+""+roomnumber.getSelectedItem();
      if(bl){
      roomflor.setSelectedIndex(0);
      roomnumber.setSelectedIndex(0);
      }
        return real;
  }
  private String gettilldate(boolean bl){     
      String rt=tillday.getSelectedItem().toString()+"/"+tillmonth.getSelectedItem().toString() +"/"+tillyear.getSelectedItem().toString(); 
   if(bl){
      tillday.setSelectedIndex(0);
  tillmonth.setSelectedIndex(0);
  tillyear.setSelectedIndex(1);
   }
        return rt;
  }

    public static void setCompany(String companyname) {
        company.addItem(companyname);
    }

    public static void fillcompanycomobox() {
        for(int i=0; i<companynames.size();i++){
            company.addItem(companynames.get(i));
            }  
    }

    public  static JList<String> getLeftList() {
        return leftList;
    }

    public static JList<String> getLeftListdate() {
        return leftListdate;
    }
    

    public static JTable getTable() {
        return table;
    }

    public static DefaultTableModel getTableModel() {
        return tableModel;
    }
      public static Mainframe getTakewindow() {
        return takewindow;
    }

    public static DefaultListModel<String> getLeftListModel() {
        return leftListModel;
    }

    public static JComboBox<String> getSelectday() {
        return selectday;
    }

    public static JComboBox<String> getSelectmonth() {
        return selectmonth;
    }

    public static JComboBox<String> getSelectyear() {
        return selectyear;
    }
    private void statuslabel(boolean bl){
           maxroom= CompanyNamesFile.roomcount();
          row=tableModel.getRowCount();
          if(bl){
               for (String companyname : companynames) {
                   leftListModel.addElement(companyname);
               }
            int index=leftListdate.getSelectedIndex();
            leftList.setSelectedIndex(index);
            readfromfile.read(false);
             row=tableModel.getRowCount();
          }
          roominfo.setText("Rooms "+row+"/"+maxroom);
            if(row>maxroom){
                roominfo.setForeground(Color.red);
             }
            else{
            roominfo.setForeground(Color.black);
            }
           
    }
   public static void cleartable(){
        if (Mainframe.getTableModel().getRowCount() > 0) {
    for (int i = Mainframe.getTableModel().getRowCount() - 1; i > -1; i--) {
        Mainframe.getTableModel().removeRow(i);
    }
}       
   }
    private void roombackfunction(int rowNumber){
        String rm=table.getValueAt(rowNumber, 0).toString();
     int last2= Integer.parseInt((rm))%100;
     int index=Integer.parseInt((rm))/100;
     tableModel.removeRow(rowNumber);
     String room;   
     if(last2<10){
        room =0+""+last2;
     }else{
     room=Integer.toString(last2);
     }
      roomavailable.roomback(index, room);  
      readfromfile.copy(Integer.parseInt(rm));  
   
   }
   private void colortable(){  
         Calendar c=Calendar.getInstance();
                        c.setTime(date);
                       c.add(Calendar.DATE, 1);
                       String getdate=dateFormat.format(c.getTime());    
                     String []tmpdate1=  getdate.split(" ");
                     String []newdate=tmpdate1[0].split("/");
                     String nextday=newdate[0];
                     String nextmonth=newdate[1];
                    String nextyear=newdate[2];
        for(int i=0;i<table.getRowCount();i++){
                    if(hourlabel.hour.value<12){
           if(table.getValueAt(i, 2).equals(spliddate[0])){ 
                  model.addSelectionInterval(i, i);
            }
                    }
                    else if(hourlabel.hour.value>=12 && hourlabel.min.value>=0 && hourlabel.second.value>=0){
                       
                     String nextd=nextday+"/"+nextmonth+"/"+nextyear;
                        if(table.getValueAt(i, 2).equals(nextd)){ 
                                 model.addSelectionInterval(i, i);
            }
                    String[] tablesplit= table.getValueAt(i, 2).toString().split("/");
                   if(Integer.parseInt(tablesplit[0])< Integer.parseInt(nextday)  && Integer.parseInt(tablesplit[1])<=Integer.parseInt(nextmonth) && Integer.parseInt(tablesplit[2])<= Integer.parseInt(nextyear)    ){
                                roombackfunction(i);
                        }                        
                    }
        }//end for
   }
   private void departure(){
        for(int i=0;i<table.getRowCount();i++){
                if(table.getValueAt(i, 2).equals(spliddate[0])){
                    roombackfunction(Integer.parseInt(table.getValueAt(i, 0) .toString()));
                }
        }
   }
    public void DigitalClock() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }
                frame.pack();
            }
        });
    }
    public class TestPane extends JPanel {

        private DigitPane hour;
        private DigitPane min;
        private DigitPane second;
        private JLabel[] seperator;

        private int tick = 0;
        
        public TestPane() {
            setLayout(new GridBagLayout());

            hour = new DigitPane();
            min = new DigitPane();
            second = new DigitPane();
            seperator = new JLabel[]{new JLabel(":"), new JLabel(":")};
               
            add(hour);
            add(seperator[0]);
            add(min);
            add(seperator[1]);
            add(second);

            Timer timer = new Timer(700, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
              
                    Calendar cal = Calendar.getInstance();
                    hour.setValue(cal.get(Calendar.HOUR_OF_DAY));
                    min.setValue(cal.get(Calendar.MINUTE));
                    second.setValue(cal.get(Calendar.SECOND));
                    if(hour.value==12 && min.value==0 && second.value==0){
                       departure();
                    }
                  
/*
                    if (tick % 2 == 1) {
                        seperator[0].setText(" ");
                        seperator[1].setText(" ");
                    } else {
                        seperator[0].setText(":");
                        seperator[1].setText(":");
                    }
                    tick++;*/
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }
    }
    public class DigitPane extends JPanel {

        private int value;

        @Override
        public Dimension getPreferredSize() {
            FontMetrics fm = getFontMetrics(getFont());
            return new Dimension(fm.stringWidth("00"), fm.getHeight());
        }

        public void setValue(int aValue) {
            if (value != aValue) {
                int old = value;
                value = aValue;
                firePropertyChange("value", old, value);
                repaint();
            }
        }

        public int getValue() {
            return value;
        }

        protected String pad(int value) {
            StringBuilder sb = new StringBuilder(String.valueOf(value));
            while (sb.length() < 2) {
                sb.insert(0, "0");
            }
            return sb.toString();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            g.setColor(Color.black);
            String text = pad(getValue());
          //  g.setFont(new Font("", Font.BOLD, 12));
            FontMetrics fm = getFontMetrics(g.getFont());         
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = ((getHeight()- fm.getHeight()) / 2) + fm.getAscent();
            g.drawString(text, x, y);

        }        
    }
    private int sumrooms(){
        int sum=0;
        for(int i=1;i<=5;i++){
            roomflor.setSelectedIndex(i);
            sum=sum+roomnumber.getItemCount();
        }
        roomflor.setSelectedIndex(0);
        roomnumber.setSelectedIndex(0);
        return 124-sum;
   
    }
    
}
