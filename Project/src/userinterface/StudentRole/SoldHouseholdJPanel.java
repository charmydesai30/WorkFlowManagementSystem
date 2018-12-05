/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StudentRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.StudentOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AccomodationAssisstantManagerWorkRequest;
import Business.WorkQueue.AccomodationWorkRequest;
import Business.WorkQueue.HouseholdAssisstantManagerWorkRequest;
import Business.WorkQueue.HouseholdWorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charmy
 */
public class SoldHouseholdJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SoldHouseholdJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserAccount userAccount;
    Organization organization;
    public SoldHouseholdJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount userAccount,Organization organization) {
        initComponents();
         
        
          this.userProcessContainer=userProcessContainer;
          this.enterprise=enterprise;
          this.userAccount=userAccount;
          this.organization=(StudentOrganization)organization;
         // userNameTxt.setText("Hello  " +userAccount.getUsername() );
       populateData();
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
        workRequestJTable = new javax.swing.JTable();

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "BuyerName", "First Name", "Last Name", "Furniture Type", "Quantity", "Cost", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void populateData()
    {  DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
       
        for (HouseholdWorkRequest request : userAccount.getWorkQueue().getHouseholdWorkRequests()){
            if (request.getStatus().equalsIgnoreCase("Purchased") )
            {
            Object[] row = new Object[8];
            row[0] =request.getBuyerName();
            row[1]=request.getfName();
            row[2] = request.getlName();
            row[3] = request.getFurnitureType();
            row[4]=request.getQuantity();
            row[5]=request.getCost();
            row[6] = request.getStatus();
            String result = ((HouseholdAssisstantManagerWorkRequest) request).getTestResult();
            row[7] = result == null ? "Waiting" : result;
            model.addRow(row);
            }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}