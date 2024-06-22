
package admin.internalpages;

import config.PanelPrinter;
import java.awt.Color;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class reportsPage extends javax.swing.JInternalFrame {

    public reportsPage() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    Color myBlue = new Color(20,120,240);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeline = new javax.swing.ButtonGroup();
        genBackground1 = new config.genBackground();
        jPanel12 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        reportpane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        res_code = new javax.swing.JLabel();
        res_code1 = new javax.swing.JLabel();
        res_code2 = new javax.swing.JLabel();
        res_code3 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        res_code4 = new javax.swing.JLabel();
        res_code5 = new javax.swing.JLabel();
        res_code6 = new javax.swing.JLabel();
        res_code7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        comonth = new javax.swing.JPanel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        month = new javax.swing.JRadioButton();
        coquarter = new javax.swing.JPanel();
        quarter = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        cosemi = new javax.swing.JPanel();
        semi = new javax.swing.JRadioButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        coannual = new javax.swing.JPanel();
        annual = new javax.swing.JRadioButton();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        report_table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 459));

        genBackground1.setPreferredSize(new java.awt.Dimension(1000, 420));
        genBackground1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(40, 120, 240));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Receipt Preview");
        jPanel12.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 160, 20));

        reportpane.setBackground(new java.awt.Color(255, 255, 255));
        reportpane.setPreferredSize(new java.awt.Dimension(306, 396));
        reportpane.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo ('80).png"))); // NOI18N
        reportpane.add(jLabel2);
        jLabel2.setBounds(80, 10, 142, 80);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(20, 120, 240));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("where money flies");
        reportpane.add(jLabel28);
        jLabel28.setBounds(130, 70, 100, 20);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Date");
        reportpane.add(jLabel31);
        jLabel31.setBounds(180, 360, 40, 10);

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Timeline:");
        reportpane.add(jLabel34);
        jLabel34.setBounds(30, 150, 50, 20);

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Transactions Made: ");
        reportpane.add(jLabel35);
        jLabel35.setBounds(30, 210, 90, 20);

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Send Transaction:");
        reportpane.add(jLabel36);
        jLabel36.setBounds(50, 230, 80, 20);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Total Money Transfered:");
        reportpane.add(jLabel38);
        jLabel38.setBounds(30, 280, 110, 20);

        jPanel10.setBackground(new java.awt.Color(20, 120, 240));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Sales Report");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(title)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        reportpane.add(jPanel10);
        jPanel10.setBounds(20, 110, 270, 20);

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Total Fees Collectef");
        reportpane.add(jLabel39);
        jLabel39.setBounds(30, 310, 100, 20);

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Number of New Customers:");
        reportpane.add(jLabel46);
        jLabel46.setBounds(30, 180, 120, 20);

        res_code.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        res_code.setText("2024-06-21");
        reportpane.add(res_code);
        res_code.setBounds(220, 360, 60, 10);

        res_code1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        res_code1.setText("5");
        reportpane.add(res_code1);
        res_code1.setBounds(130, 230, 40, 20);

        res_code2.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        res_code2.setText("Monthly - June");
        reportpane.add(res_code2);
        res_code2.setBounds(80, 150, 80, 20);

        res_code3.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        res_code3.setText("10");
        reportpane.add(res_code3);
        res_code3.setBounds(120, 210, 40, 20);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Receive Transaction:");
        reportpane.add(jLabel37);
        jLabel37.setBounds(50, 250, 90, 20);

        res_code4.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        res_code4.setText("100");
        reportpane.add(res_code4);
        res_code4.setBounds(120, 310, 40, 20);

        res_code5.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        res_code5.setText("1");
        reportpane.add(res_code5);
        res_code5.setBounds(150, 180, 40, 20);

        res_code6.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        res_code6.setText("5000");
        reportpane.add(res_code6);
        res_code6.setBounds(140, 280, 40, 20);

        res_code7.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        res_code7.setText("5");
        reportpane.add(res_code7);
        res_code7.setBounds(140, 250, 40, 20);

        jPanel12.add(reportpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 30, -1, -1));

        genBackground1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 5, 315, 430));

        jPanel11.setBackground(new java.awt.Color(20, 120, 240));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Sales Report Options:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 434, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        genBackground1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 610, 20));

        jPanel1.setBackground(new java.awt.Color(20, 120, 240));
        jPanel1.setForeground(new java.awt.Color(40, 120, 240));

        comonth.setBackground(new java.awt.Color(20, 120, 240));
        comonth.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        comonth.add(jMonthChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        timeline.add(month);
        month.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        month.setForeground(new java.awt.Color(255, 255, 255));
        month.setText("Mothly Report");
        month.setOpaque(false);
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        comonth.add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        coquarter.setBackground(new java.awt.Color(20, 120, 240));

        timeline.add(quarter);
        quarter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quarter.setForeground(new java.awt.Color(255, 255, 255));
        quarter.setText("Quarterly Report");
        quarter.setOpaque(false);
        quarter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarterActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Quarter", "2nd Quarter", "3rd Quarter", "4th Quarter" }));

        javax.swing.GroupLayout coquarterLayout = new javax.swing.GroupLayout(coquarter);
        coquarter.setLayout(coquarterLayout);
        coquarterLayout.setHorizontalGroup(
            coquarterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(quarter)
            .addGroup(coquarterLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        coquarterLayout.setVerticalGroup(
            coquarterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coquarterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(quarter)
                .addGap(7, 7, 7)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cosemi.setBackground(new java.awt.Color(20, 120, 240));
        cosemi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeline.add(semi);
        semi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        semi.setForeground(new java.awt.Color(255, 255, 255));
        semi.setText("Semi-Annual Report");
        semi.setOpaque(false);
        semi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semiActionPerformed(evt);
            }
        });
        cosemi.add(semi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Half", "2nd Half" }));
        cosemi.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 128, -1));

        coannual.setBackground(new java.awt.Color(20, 120, 240));
        coannual.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeline.add(annual);
        annual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        annual.setForeground(new java.awt.Color(255, 255, 255));
        annual.setText("Annual Report");
        annual.setOpaque(false);
        annual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annualActionPerformed(evt);
            }
        });
        coannual.add(annual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        coannual.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 94, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comonth, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(coquarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cosemi, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(coannual, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comonth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(coannual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(cosemi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coquarter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        genBackground1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 610, 90));

        report_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(report_table);

        genBackground1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 610, 240));

        jButton1.setBackground(new java.awt.Color(40, 120, 240));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Generate & Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        genBackground1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(genBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(genBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        if(month.isSelected()){
            month.setForeground(myBlue);
            quarter.setForeground(Color.WHITE);
            semi.setForeground(Color.WHITE);
            annual.setForeground(Color.WHITE);
            
            comonth.setBackground(Color.WHITE);
            coquarter.setBackground(myBlue);
            cosemi.setBackground(myBlue);
            coannual.setBackground(myBlue);
        }
    }//GEN-LAST:event_monthActionPerformed

    private void quarterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quarterActionPerformed
        if(quarter.isSelected()){
            month.setForeground(Color.WHITE);
            quarter.setForeground(myBlue);
            semi.setForeground(Color.WHITE);
            annual.setForeground(Color.WHITE);
            
            comonth.setBackground(myBlue);
            coquarter.setBackground(Color.WHITE);
            cosemi.setBackground(myBlue);
            coannual.setBackground(myBlue);
        }
    }//GEN-LAST:event_quarterActionPerformed

    private void semiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semiActionPerformed
        if(semi.isSelected()){
            month.setForeground(Color.WHITE);
            quarter.setForeground(Color.WHITE);
            semi.setForeground(myBlue);
            annual.setForeground(Color.WHITE);
            
            comonth.setBackground(myBlue);
            coquarter.setBackground(myBlue);
            cosemi.setBackground(Color.WHITE);
            coannual.setBackground(myBlue);
        }
    }//GEN-LAST:event_semiActionPerformed

    private void annualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annualActionPerformed
        if(annual.isSelected()){
            month.setForeground(Color.WHITE);
            quarter.setForeground(Color.WHITE);
            semi.setForeground(Color.WHITE);
            annual.setForeground(myBlue);
            
            comonth.setBackground(myBlue);
            coquarter.setBackground(myBlue);
            cosemi.setBackground(myBlue);
            coannual.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_annualActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PanelPrinter papri = new PanelPrinter(reportpane);
        papri.printPanel();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton annual;
    private javax.swing.JPanel coannual;
    private javax.swing.JPanel comonth;
    private javax.swing.JPanel coquarter;
    private javax.swing.JPanel cosemi;
    private config.genBackground genBackground1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel50;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JRadioButton month;
    private javax.swing.JRadioButton quarter;
    private javax.swing.JTable report_table;
    private javax.swing.JPanel reportpane;
    private javax.swing.JLabel res_code;
    private javax.swing.JLabel res_code1;
    private javax.swing.JLabel res_code2;
    private javax.swing.JLabel res_code3;
    private javax.swing.JLabel res_code4;
    private javax.swing.JLabel res_code5;
    private javax.swing.JLabel res_code6;
    private javax.swing.JLabel res_code7;
    private javax.swing.JRadioButton semi;
    private javax.swing.ButtonGroup timeline;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
