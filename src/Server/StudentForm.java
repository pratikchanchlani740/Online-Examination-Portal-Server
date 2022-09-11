/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import db.CommonFunction;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Pratik
 */
public class StudentForm extends javax.swing.JFrame {
        int crow=0;
    int flag=0;
    String path=null;
     int id=0;
     public String nn="";
    CommonFunction cf=new CommonFunction();
    public Graphics img1;
//    public void paint(Graphics g)
//    {
//        img1=g;
//    }
//    public Graphics paint()
//    {
//        return img1;
//    }
    public void readData() throws Exception
    {
         txtid.setText(rs.getString("ID"));
        txtfname.setText(rs.getString("First_Name"));
        txtlname.setText(rs.getString("Last_Name"));
        txtphone.setText(rs.getString("Phone"));
        txtadd.setText(rs.getString("Address"));
         ImageIcon img=new ImageIcon(rs.getString("image"));
             jComboBox3.setSelectedItem(rs.getString("session"));
path=rs.getString("image");
    if(img==null)
    {
        System.out.println("No Image");
         image.setIcon(null);
    } 
    else
    {
            System.out.println("Image is There");       
    Image im= img.getImage().getScaledInstance(250, 200, java.awt.Image.SCALE_SMOOTH);
    
    img= new ImageIcon(im);
     image.setIcon(img);
    }
    
       
        String courseid= rs.getString("course");
        
        ResultSet rst= cf.getResultset(" course where cid="+courseid);
        
        rst.next();
        jComboBox1.setSelectedItem(rst.getString(2));
        
        rst.close();
       
    }
    
    
    public void enableNavigation(boolean mod)
    {
        txtfname.setEditable(!mod);
        txtlname.setEditable(!mod);
        txtphone.setEditable(!mod);
        txtadd.setEditable(!mod);
        savebtn.setEnabled(!mod);
        uploadbtn.setEnabled(!mod);
        cancelbtn.setEnabled(!mod);
        //jComboBox1.setEditable(!mod);
        //jComboBox3.setEditable(!mod);
        jComboBox1.setEnabled(!mod);
        jComboBox3.setEnabled(!mod);
        addbtn.setEnabled(mod);
        editbtn.setEnabled(mod);
        deletebtn.setEnabled(mod);
        firstbtn.setEnabled(mod);
        nextbtn.setEnabled(mod);
        lastbtn.setEnabled(mod);
        prevbtn.setEnabled(mod);
        
        
        
    }
    

    /**
     * Creates new form StudentForm
     */
   public ResultSet rs;
   PreparedStatement psmt1,psmt2,psmt3;
   Connection cnn;
    public StudentForm() {
        initComponents();
        try{
            
         Container ctx=getContentPane();
             ctx.setBackground(new Color(150,255,255));
        
        cnn=db.MyConnection.getConnection();
        
        //Statement smt=cnn.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
        psmt1=cnn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
        psmt2=cnn.prepareStatement("update student set First_Name= ?, Last_Name= ?, Course= ?, Phone= ?, Address=?, Session=?, Image=? where ID= ? ");
        psmt3=cnn.prepareStatement("delete from student where ID=?");
        //rs=smt.executeQuery("");
        
         ResultSet rs1=cf.getResultset("course");
          //rs=cf.getResultset("course");
//        if(jComboBox1.getSelectedItem().toString().equals(rs.getString("cname")))
//        {   
//       jLabel8.setText(rs.getString("cid"));
//        }
        
        while(rs1.next())
        {
            String course=rs1.getString("cname");
//        String course1=course.substring(0, 3);
//        System.out.println("Course Name"+course1);
//        String year=course.substring(4);
//         System.out.println("Year Number"+year);
            jComboBox1.addItem(course);
             if(jComboBox1.getSelectedItem().toString().equals(rs1.getString("cname")))
        {   
     
            jLabel8.setText(rs1.getString("cid"));
        }
           // jComboBox4.addItem(year);
            
        }
        
        
        rs=cf.getResultset("student");
//smt.executeQuery("select * from student");
             
             setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
         if(rs.next())
            {
                readData();
                
                enableNavigation(true);
            }
            else
            {
                
                //enableNavigation();
                JOptionPane.showMessageDialog(this,"No Record Found");
               // txtid.setText("1");
                 
                
            }
        
        
        }
        catch(Exception ee)
        {
            System.out.println("Connection Error"+ee);
        }
       //jComboBox2.setSelectedItem(ABORT);
    }
//    public ResultSet getResult()throws Exception
//    {
//        Connection cnn=db.MyConnection.getConnection();
//        
//        
//        Statement smt=cnn.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
//        
//        return smt.executeQuery("select * from student");
//    }
    
    
   
    
    //ArrayList lst=new ArrayList();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtlname = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtadd = new javax.swing.JTextArea();
        jComboBox3 = new javax.swing.JComboBox<>();
        image = new javax.swing.JLabel();
        nextbtn = new javax.swing.JButton();
        prevbtn = new javax.swing.JButton();
        firstbtn = new javax.swing.JButton();
        lastbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        uploadbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setForeground(java.awt.Color.black);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Entry Form");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Phone No");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Address");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Session");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Course");

        txtid.setEditable(false);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        txtadd.setColumns(20);
        txtadd.setRows(5);
        jScrollPane1.setViewportView(txtadd);

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019-20", "2020-21", "2021-22", "2022-23" }));

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        image.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/onlineexam.jpg"))); // NOI18N

        nextbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nextbtn.setText("NEXT");
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });

        prevbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        prevbtn.setText("PREVIOUS");
        prevbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevbtnActionPerformed(evt);
            }
        });

        firstbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        firstbtn.setText("FIRST");
        firstbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstbtnActionPerformed(evt);
            }
        });

        lastbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lastbtn.setText("LAST");
        lastbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastbtnActionPerformed(evt);
            }
        });

        addbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addbtn.setText("ADD");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        editbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        editbtn.setText("EDIT");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        deletebtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deletebtn.setText("DELETE");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        savebtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        savebtn.setText("SAVE");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        cancelbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancelbtn.setText("CANCEL");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletebtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(savebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelbtn, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(addbtn)
                .addGap(42, 42, 42)
                .addComponent(editbtn)
                .addGap(36, 36, 36)
                .addComponent(deletebtn)
                .addGap(27, 27, 27)
                .addComponent(savebtn)
                .addGap(35, 35, 35)
                .addComponent(cancelbtn)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        uploadbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        uploadbtn.setText("UPLOAD");
        uploadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtphone)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(uploadbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(firstbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(prevbtn)))))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lastbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uploadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstbtn)
                                    .addComponent(nextbtn))))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prevbtn)
                            .addComponent(lastbtn)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
try{
    //ResultSet rs=cf.getResultset("student");
    enableNavigation(false);
       flag=0;
       crow= rs.getRow();
    if( crow==0)
    {
                txtid.setText("1");
       // enableNavigation(false);
  flag=0;
  return;
    }
  
   
            rs.last();
        readData();
       
        if( rs.getString("ID")!=null)
        {
          
       
        
         System.out.println("ID is"+rs.getString("ID"));        
        id=Integer.parseInt(rs.getString("ID"))+1;
        
        System.out.println("Updated"+id);
        }
        else
        {  //System.out.println("n"+rs.getString("RollNo")); 
            
        }
            txtid.setText(""+id);
            txtfname.setText("");
            txtlname.setText("");
            txtphone.setText("");
            txtadd.setText("");
            image.setIcon(null);
//enableNavigation(false);
  flag=0;
System.out.println("add");
        }

catch(Exception ee)
{            
    System.out.println("Exception ee : "+ee.toString());// TODO add your handling code here:
    }     


      
         
    }//GEN-LAST:event_addbtnActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        try{
            //ResultSet rst=cf.getResultset("student");
           // rst.absolute(crow);
            rs.next();
         if(rs.isAfterLast())
           {
                rs.last();
               
           }
         readData();
  }
  catch(Exception ee)
  {
      System.out.println("Next Button Error"+ee);
  } 
    }//GEN-LAST:event_nextbtnActionPerformed

    private void prevbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevbtnActionPerformed
       try{
         // ResultSet rst=cf.getResultset("student");
          // rst.absolute(crow);
            rs.previous();
         if(rs.isBeforeFirst())
           {
                rs.first();
               
           }
         readData();
  }
  catch(Exception ee)
  {
      System.out.println("Previous Button Error"+ee);
      
  }   
    }//GEN-LAST:event_prevbtnActionPerformed

    private void lastbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastbtnActionPerformed
        try{
            //ResultSet rst=cf.getResultset("student");
            rs.last();
        
         readData();
  }
  catch(Exception ee)
  {
      System.out.println("Last Button Error"+ee);
      
  }        // TO
    }//GEN-LAST:event_lastbtnActionPerformed

    private void firstbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstbtnActionPerformed
       try{
           //ResultSet rs=cf.getResultset("student");
           rs.first();
           
           readData();
       }
       
       catch(Exception ee)
       {
           System.out.println("First Button Error"+ee);
       }
       
    }//GEN-LAST:event_firstbtnActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
      // enableNavigation(false);
        try{ 
           if(flag==0)
    {
           
        psmt1.setInt(1,Integer.parseInt(txtid.getText()));
         psmt1.setString(2,txtfname.getText());
         psmt1.setString(3,txtlname.getText());
        // course=jComboBox1.getSelectedItem();
       System.out.println(jComboBox1.getSelectedItem().toString());
       //ResultSet rs1=cf.getResultset("course");
       
        //psmt1.setString(4,jComboBox1.getSelectedItem().toString());
        psmt1.setString(4,jLabel8.getText());
        
        psmt1.setString(5,txtphone.getText());
        psmt1.setString(6,txtadd.getText());
        psmt1.setString(7,jComboBox3.getSelectedItem().toString());
       // psmt1.setString(8,jComboBox4.getSelectedItem().toString());
        
        //path=image.getIcon().toString();
        psmt1.setString(8,path);
        System.out.println("Hello");
        CallableStatement cstmt=cnn.prepareCall("{?= call RandString(?)}");
        cstmt.registerOutParameter(1,Types.LONGVARCHAR);
        cstmt.setInt(2,8);
       // String user=cstmt.getString(0);
        
        cstmt.execute();
        System.out.println("UserName"+cstmt.getString(1));
        psmt1.setString(9,cstmt.getString(1));
        CallableStatement cstmt1=cnn.prepareCall("{?= call RandString(?)}");
        cstmt1.registerOutParameter(1,Types.LONGVARCHAR);
        cstmt1.setInt(2,5);
        cstmt1.execute();
        psmt1.setString(10,cstmt1.getString(1));
        int count=psmt1.executeUpdate();
         enableNavigation(true);
         rs=cf.getResultset("student");
                    rs.last();
        if(count>0)
        {
        
         System.out.println("Saved");
        }
        else{
            System.out.println("Not Saved");
        }
    }
           else{
               psmt2.setString(1,txtfname.getText());
               psmt2.setString(2,txtlname.getText());
               //psmt2.setString(3,jComboBox1.getSelectedItem().toString());
          psmt2.setString(3,jLabel8.getText());
        psmt2.setString(4,txtphone.getText());
        psmt2.setString(5,txtadd.getText());
        psmt2.setString(6,jComboBox3.getSelectedItem().toString());
       // psmt2.setString(7,jComboBox4.getSelectedItem().toString());
        //path=image.getIcon().toString();
        
        System.out.println("Image Path is"+path);
        psmt2.setString(7,path);
        psmt2.setInt(8,Integer.parseInt(txtid.getText()));
               int count=psmt2.executeUpdate();
               enableNavigation(true);
               int r=rs.getRow();
               rs=cf.getResultset("student");
              rs.absolute(r);
               if(count>0)
        {
        
         System.out.println("Changed");
        }
        else{
            System.out.println("Not Changed");
        }
           }
        }
        catch(Exception ee)
        {
            System.out.println("Error is"+ee);
        }
    }//GEN-LAST:event_savebtnActionPerformed

    private void uploadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadbtnActionPerformed
        int h1=image.getHeight();
        int w1=image.getWidth();
        JFileChooser chooser=new JFileChooser();
     chooser.showOpenDialog(null);
     path=chooser.getSelectedFile().getPath();
     
    ImageIcon img=new ImageIcon(path);
    
    Image im= img.getImage().getScaledInstance(250, 200, java.awt.Image.SCALE_SMOOTH);
    
    img= new ImageIcon(im);
    
    
    // int h=img.getIconHeight();
    // int w=img.getIconWidth();
     //Graphics g=Toolkit.getDefaultToolkit().getImage(path);
     //img.paintIcon(this, img1, w, h);
    
     int h2=image.getHeight();
     int w2=image.getWidth();
     
     System.out.println("width is"+w2+"height is"+h2);
     
     
     image.setIcon(img);
     //image.setText(path);
    }//GEN-LAST:event_uploadbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
flag=1;
        
enableNavigation(false);
txtid.setEditable(false);        // TODO add your handling code here:
    }//GEN-LAST:event_editbtnActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
try{
    //crow=rs.getRow();
    if(flag==0)
    {
        enableNavigation(true);
        rs.absolute(crow);
        readData();
        
    }
    else{
        enableNavigation(true);
        rs.absolute(crow);
        readData();
    }
} 
catch(Exception ee)
{
}// TODO add your handling code here:
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
try{
    System.out.println(""+txtid.getText());
    psmt3.setInt(1,Integer.parseInt(txtid.getText()));
//    System.out.println("Deleted Row"+rs.getRow());
    int r=rs.getRow();
    int count=psmt3.executeUpdate();
    
    rs=cf.getResultset("student");
    if(rs.next())
    {
        if(rs.absolute(r))
        {
            readData();
        }
        else
        {
            rs.absolute(r-1);
            readData();
        }
        
        
        
    }
    else
    {
        JOptionPane.showMessageDialog(this, "No More Records");
         txtid.setText("1");
        txtfname.setText(null);
        txtlname.setText(null);
        jComboBox1.setSelectedIndex(-1);
        txtphone.setText(null);
        txtadd.setText(null);
        jComboBox3.setSelectedIndex(-1);
         //jComboBox4.setSelectedIndex(-1);
    }
    
    
    
//    if(rs.getRow()>0)
//    {
//    if(rs.isAfterLast())
//    {
//       
//        rs.absolute(r);
//       // rs.first();
//         
//        
//    }
//    
//    else{
//        txtid.setText("1");
//        //rs.next();
//       
//    }
//    }
//    else{
//       JOptionPane.showMessageDialog(this,"Now ADD a Record");
//    }
//    readData();
}
catch(Exception ee)
{
    System.out.println("Deleting Error"+ee);
}// TODO add your handling code here:
    }//GEN-LAST:event_deletebtnActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
       try{
        String cname1=jComboBox1.getSelectedItem().toString();
        ResultSet rs1=cf.getResultset("course where cname='"+cname1+"'");
        if(rs1.next())
        {
            jLabel8.setText(rs1.getString("cid"));
        }
       }
       catch(Exception ee)
       {
           System.out.println("Item Changed Error"+ee);
       }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JButton firstbtn;
    private javax.swing.JLabel image;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lastbtn;
    private javax.swing.JButton nextbtn;
    private javax.swing.JButton prevbtn;
    private javax.swing.JButton savebtn;
    private javax.swing.JTextArea txtadd;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JButton uploadbtn;
    // End of variables declaration//GEN-END:variables
}
