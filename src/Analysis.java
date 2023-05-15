
import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class Analysis extends javax.swing.JFrame {
ResultSet rs =null;
     PreparedStatement pst = null;
    /**
     * Creates new form Analysis
     */
    public Analysis() {
        initComponents();
        showPieChart();
        showBarChart();
    }
    public void showPieChart(){
    
    int os=0,other=0,projector=0,monitor = 0,cpu = 0,keyboard = 0,mouse = 0,ac = 0;
    try{
            System.out.println("Hi");
        
        String url="jdbc:mysql://localhost:3306/connecter";
        String uname="root";
        String pwd="Amantatu20!";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pwd);
        Statement st = con.createStatement();
      // Connection con = dbconnection.getconnection();
        
        ResultSet rs1=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE catagory="+'"'+"Operating System"+'"'+";");
        while(rs1.next())
        {
        System.out.println("Complaints for OS :"+rs1.getString(1));
        os=Integer.parseInt(rs1.getString(1));
        }

        ResultSet rs6=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE catagory="+'"'+"Other s/w"+'"'+";");
        while(rs6.next())
        {
        System.out.println("Complaints for Other s/w :"+rs6.getString(1));
        other=Integer.parseInt(rs6.getString(1));
        }

        ResultSet rs7=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE catagory="+'"'+"Projector"+'"'+";");
        while(rs7.next())
        {
        System.out.println("Complaints for Projector :"+rs7.getString(1));
        projector=Integer.parseInt(rs7.getString(1));
        }

        ResultSet rs4=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE catagory="+'"'+"Monitor"+'"'+";");
        while(rs4.next())
        {
        System.out.println("Complaints for Monitor :"+rs4.getString(1));
        monitor=Integer.parseInt(rs4.getString(1));
        }

       ResultSet rs3=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE catagory="+'"'+"CPU"+'"'+";");
        while(rs3.next())
        {
        System.out.println("Complaints for CPU :"+rs3.getString(1));
        cpu=Integer.parseInt(rs3.getString(1));
        }

        ResultSet rs8=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE catagory="+'"'+"Keyboard"+'"'+";");
        while(rs8.next())
        {
        System.out.println("Complaints for Keyboard :"+rs8.getString(1));
        keyboard=Integer.parseInt(rs8.getString(1));
        }

        ResultSet rs2=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE catagory="+'"'+"Mouse"+'"'+";");
        while(rs2.next())
        {
        System.out.println("Complaints for Mouse :"+rs2.getString(1));
        mouse=Integer.parseInt(rs2.getString(1));
        }

        ResultSet rs5=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE catagory="+'"'+"AC"+'"'+";");
        while(rs5.next())
        {
        System.out.println("Complaints for AC :"+rs5.getString(1));
        ac=Integer.parseInt(rs5.getString(1));
        }

        }
        catch (Exception e)
        {
            
            System.out.println(e);
        }
        double total=keyboard+mouse+cpu+monitor+ac+os+other+projector;//TOTAL COMPLAINTS
     
    //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "Keyboard "+new DecimalFormat("##.##").format(((keyboard/total)*100))+"%", keyboard );  
      barDataset.setValue( "Mouse " +new DecimalFormat("##.##").format(((mouse/total)*100))+"%", mouse );   
      barDataset.setValue( "CPU " +new DecimalFormat("##.##").format(((cpu/total)*100))+"%", cpu );    
      barDataset.setValue( "Monitor " +new DecimalFormat("##.##").format(((monitor/total)*100))+"%", monitor );
      barDataset.setValue( "AC " +new DecimalFormat("##.##").format(((ac/total)*100))+"%", ac );
      barDataset.setValue( "OS " +new DecimalFormat("##.##").format(((os/total)*100))+"%", os );
      barDataset.setValue( "Other s/w " +new DecimalFormat("##.##").format(((other/total)*100))+"%", other );
      barDataset.setValue( "Projector " +new DecimalFormat("##.##").format(((projector/total)*100))+"%", projector);

      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Category wise Complaints",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("Keyboard", new Color(255,255,102));
       piePlot.setSectionPaint("Mouse", new Color(102,255,102));
       piePlot.setSectionPaint("CPU", new Color(255,102,153));
       piePlot.setSectionPaint("Monitor", new Color(0,204,204));
       piePlot.setSectionPaint("OS", new Color(0,104,104));
       piePlot.setSectionPaint("AC", new Color(0,104,104));
       piePlot.setSectionPaint("Other s/w", new Color(0,104,104));
       piePlot.setSectionPaint("Proector", new Color(0,104,104));

      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }
    
    public void showBarChart(){
        int SYS1001=0,SYS1002=0,SYS1003=0,SYS1004=0,SYS1005=0,SYS1006=0,SYS1007=0,SYS1008=0,SYS1009=0,SYS1010=0;
        
        try{
            System.out.println("Hi");
        
        String url="jdbc:mysql://localhost:3306/connecter";
        String uname="root";
        String pwd="Amantatu20!";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pwd);
        Statement st = con.createStatement();
       
        ResultSet rs1=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1001';");
        while(rs1.next())
        {
        System.out.println("Complaints for SYS1001 :"+rs1.getString(1));
        SYS1001=Integer.parseInt(rs1.getString(1));
        }
        
        ResultSet rs2=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1002' ;");
        while(rs2.next())
        {
        System.out.println("Complaints for SYS1002 :"+rs2.getString(1));
        SYS1002=Integer.parseInt(rs2.getString(1));
        }
        
        ResultSet rs3=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1003' ;");
        while(rs3.next())
        {
        System.out.println("Complaints for SYS1003 :"+rs3.getString(1));
        SYS1003=Integer.parseInt(rs3.getString(1));
        }
        ResultSet rs4=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1004';");
        while(rs4.next())
        {
        System.out.println("Complaints for SYS1004 :"+rs4.getString(1));
        SYS1004=Integer.parseInt(rs4.getString(1));
        }
        ResultSet rs5=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1005';");
        while(rs5.next())
        {
        System.out.println("Complaints for SYS1005 :"+rs5.getString(1));
        SYS1005=Integer.parseInt(rs5.getString(1));
        }
        ResultSet rs6=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1006';");
        while(rs6.next())
        {
        System.out.println("Complaints for SYS1006 :"+rs6.getString(1));
        SYS1006=Integer.parseInt(rs6.getString(1));
        }
        ResultSet rs7=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1007';");
        while(rs7.next())
        {
        System.out.println("Complaints for SYS1001 :"+rs7.getString(1));
        SYS1007=Integer.parseInt(rs7.getString(1));
        }
        ResultSet rs8=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1008';");
        while(rs8.next())
        {
        System.out.println("Complaints for SYS1001 :"+rs8.getString(1));
        SYS1008=Integer.parseInt(rs8.getString(1));
        }
        ResultSet rs9=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1009';");
        while(rs9.next())
        {
        System.out.println("Complaints for SYS1001 :"+rs9.getString(1));
        SYS1009=Integer.parseInt(rs9.getString(1));
        }
        ResultSet rs10=st.executeQuery("SELECT COUNT(*) FROM complaintable WHERE systemid='sys1010';");
        while(rs10.next())
        {
        System.out.println("Complaints for SYS1001 :"+rs10.getString(1));
        SYS1010=Integer.parseInt(rs10.getString(1));
        }
        
        
        
        
        
        
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(SYS1001, "Each System's Complaint", "SYS1001");
        dataset.setValue(SYS1002, "Each System's Complaint", "SYS1002");
        dataset.setValue(SYS1003, "Each System's Complaint", "SYS1003");
        dataset.setValue(SYS1004, "Each System's Complaint", "SYS1004");
        dataset.setValue(SYS1005, "Each System's Complaint", "SYS1005");
        dataset.setValue(SYS1006, "Each System's Complaint", "SYS1006");
        dataset.setValue(SYS1007, "Each System's Complaint", "SYS1007");
        dataset.setValue(SYS1008, "Each System's Complaint", "SYS1008");
        dataset.setValue(SYS1009, "Each System's Complaint", "SYS1009");
        dataset.setValue(SYS1010, "Each System's Complaint", "SYS1010");
        
        
        
        
        
        
        JFreeChart chart = ChartFactory.createBarChart("Per System Complaints","System Id","Count", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(32,178,170);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        panelBarChart.removeAll();
        panelBarChart.add(barpChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
        
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelBarChart = new javax.swing.JPanel();
        panelPieChart = new javax.swing.JPanel();
        panel2 = new java.awt.Panel();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 45)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("I");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Complaint Analysis Dashboard");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1930, 70));

        jPanel3.setBackground(new java.awt.Color(204, 250, 245));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBarChart.setLayout(new java.awt.BorderLayout());
        jPanel3.add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 950, 300));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel3.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, 460, 300));

        panel2.setBackground(new java.awt.Color(0, 102, 102));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication12/home_24px.png"))); // NOI18N
        jButton3.setText("   Home");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 270, 60));

        jButton7.setBackground(new java.awt.Color(0, 102, 102));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication12/profile.png"))); // NOI18N
        jButton7.setText("   My Profile");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        panel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 270, 60));

        jButton8.setBackground(new java.awt.Color(0, 102, 102));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication12/icons8_Conference_26px.png"))); // NOI18N
        jButton8.setText("    Resolver");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 270, 60));

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication12/logout2.png"))); // NOI18N
        jButton9.setText("   Log out");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        panel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 270, 60));

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication12/icons8_Book_Shelf.png"))); // NOI18N
        jButton5.setText("   Analyzer");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 270, 60));

        jPanel3.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 860));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1680, 860));

        setSize(new java.awt.Dimension(1930, 928));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Adminhome hm=new Adminhome();
        hm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ProfileAdmin pf =new ProfileAdmin();
        pf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Resolver rsl=new Resolver();
        rsl.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        if(JOptionPane.showConfirmDialog(this , "Confirm if you want to log.out" ,
            "My Sql connecter",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
    {
        login lf =new login();
        lf.setVisible(true);
        dispose();
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        Analysis pf2 =new Analysis();
        pf2.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analysis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private java.awt.Panel panel2;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelPieChart;
    // End of variables declaration//GEN-END:variables
}
