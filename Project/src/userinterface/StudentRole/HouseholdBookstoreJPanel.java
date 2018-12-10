/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StudentRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.StudentOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BookstoreAssisstantManagerWorkRequest;
import Business.WorkQueue.BookstoreWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaynee
 */
public class HouseholdBookstoreJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HouseholdBookstoreJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserAccount userAccount;
    Organization studentOrganization;
    EcoSystem system;
    public HouseholdBookstoreJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount userAccount,Organization organization,EcoSystem system) {
        initComponents();
         this.userProcessContainer=userProcessContainer;
          this.enterprise=enterprise;
          this.userAccount=userAccount;
          this.studentOrganization=(StudentOrganization)organization;
          this.system=system;
          populateData();
          
    }
    
    
    public void populateData(){
        DefaultTableModel dtm = (DefaultTableModel) buyBooksJTable.getModel();
        dtm.setRowCount(0);
        for(Network network:system.getNetworkList()){
                //Step 2.a: check against each enterprise
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
            {
              if(enterprise.getEnterpriseType()==Enterprise.EnterpriseType.Household);
              {
                  for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                     if(organization instanceof StudentOrganization)
                     {
                        for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList())
                        {
                        for (BookstoreWorkRequest request : ua.getWorkQueue().getBookstoreWorkRequestList()){
                            Object[] row = new Object[8];
                            row[0] = request.getfName();
                            row[1] = request.getBookName();
                            row[2] = request.getBookPrice();
                            row[3] = request.getBookAuthor();
                            row[4] = request.getBooktype();
                            row[5] = request.getNoOfBooks();
                            row[6] = request.getStatus();
                            row[7] = request;

                            dtm.addRow(row);
                            }
                        }
                    }
                  }
                }
       
             }
        }
        
    }   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        buyBooksJTable = new javax.swing.JTable();
        buyButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        buyBooksJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Username", "Book Name", "Book Price", "Book Author", "Book Type", "No. of Books", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(buyBooksJTable);
        if (buyBooksJTable.getColumnModel().getColumnCount() > 0) {
            buyBooksJTable.getColumnModel().getColumn(0).setResizable(false);
            buyBooksJTable.getColumnModel().getColumn(1).setResizable(false);
            buyBooksJTable.getColumnModel().getColumn(2).setResizable(false);
            buyBooksJTable.getColumnModel().getColumn(3).setResizable(false);
            buyBooksJTable.getColumnModel().getColumn(4).setResizable(false);
            buyBooksJTable.getColumnModel().getColumn(5).setResizable(false);
            buyBooksJTable.getColumnModel().getColumn(6).setResizable(false);
            buyBooksJTable.getColumnModel().getColumn(7).setResizable(false);
        }

        buyButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buyButton.setText("BUY");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("BOOKSTORE ITEM DETAILS");

        btnBack.setBackground(new java.awt.Color(102, 102, 102));
        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        int selectedRow = buyBooksJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        BookstoreAssisstantManagerWorkRequest request = (BookstoreAssisstantManagerWorkRequest)buyBooksJTable.getValueAt(selectedRow,7);
        if(request.getStatus().equalsIgnoreCase("Completed"))
         {
            request.setStatus("purchased");
            JOptionPane.showMessageDialog(null, "You purchased this household item Successfully");
            request.setBuyerName(userAccount.getUsername());
         }
        else
        {
            JOptionPane.showMessageDialog(null, "Item you want to purchase is not available to buy");                                 return;
        }
        
        request.setBuyerName(userAccount.getUsername());
        populateData();
        JOptionPane.showMessageDialog(null, "You purchased this item Successfully");

    }//GEN-LAST:event_buyButtonActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        HouseholdBuyerDetailsJPanel householdBuyerDetailsJPanel = (HouseholdBuyerDetailsJPanel) component;
        householdBuyerDetailsJPanel.populateData();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JTable buyBooksJTable;
    private javax.swing.JButton buyButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
