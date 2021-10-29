package calculator.cgpa;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainGui extends JFrame {

    // Variables declaration
    //<editor-fold defaultstate="collapsed" desc=" Variable Declarations ">
    private JButton btnAdd;
    private JButton btnCalculate;
    private JButton btnClear;
    private JButton btnLoadFromFile;
    private JButton btnRemove;
    private JScrollPane jspConsole;
    private JRadioButton rdoCGPA;
    private JRadioButton rdoGPA;
    private JTextArea taConsole;
    private JTextField tfCredit;
    private JTextField tfName;
    private JTextField tfResult;
    private int category;
    // End of variables declaration
    //</editor-fold>

    public MainGui() {

        // initializing components
        initComponents();

        // window settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple CGPA Calculator");
        setResizable(false);

        // change default theme to "Nimbus"
        theme();

        // set app window to center of screen
        this.setLocationRelativeTo(null);

        // action events method reference
        btnAdd.addActionListener(this::btnAddActionPerformed);
        btnRemove.addActionListener(this::btnRemoveActionPerformed);
        btnClear.addActionListener(this::btnClearActionPerformed);
        btnCalculate.addActionListener(this::btnCalculateActionPerformed);
        btnLoadFromFile.addActionListener(this::btnLoadFromFileActionPerformed);
        rdoGPA.addActionListener(this::rdoGPAActionPerformed);
        rdoCGPA.addActionListener(this::rdoCGPAActionPerformed);
    }


    private void initComponents() {
        rdoGPA = new JRadioButton("GPA", true);
        rdoCGPA = new JRadioButton("CGPA", false);
        category = 1;

        tfName = new JTextField("Subject");
        tfResult = new JTextField();
        tfCredit = new JTextField();

        tfName.setToolTipText("Name (Optional)");
        tfResult.setToolTipText("Result (eg. 3.75)");
        tfCredit.setToolTipText("Credit (eg. 1.5)");

        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnClear = new JButton("Clear");
        btnCalculate = new JButton("Calculate");
        btnLoadFromFile = new JButton("Load From Txt File");

        taConsole = new JTextArea();
        jspConsole = new JScrollPane();

        taConsole.setColumns(20);
        taConsole.setRows(5);
        taConsole.setEnabled(false);
        jspConsole.setViewportView(taConsole);

        // Done with NetBeans
        //<editor-fold defaultstate="collapsed" desc=" initialization Codes ">
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jspConsole)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(rdoGPA, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(rdoCGPA, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tfName, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(tfResult, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(tfCredit, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnLoadFromFile, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(rdoGPA, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(rdoCGPA, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfName, GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfResult, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfCredit, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnLoadFromFile, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jspConsole, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    //</editor-fold>
        pack();
    }

    private void rdoGPAActionPerformed(ActionEvent evt) {
        if (rdoCGPA.isSelected()) {
            rdoCGPA.setSelected(false);
        }
        rdoGPA.setSelected(true);
        category = 1;
    }

    private void rdoCGPAActionPerformed(ActionEvent evt) {
        if (rdoGPA.isSelected()) {
            rdoGPA.setSelected(false);
        }
        rdoCGPA.setSelected(true);
        category = 2;
    }

    private void btnClearActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnAddActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnRemoveActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnCalculateActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnLoadFromFileActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void theme() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        // Changing Theme (Auto Generated from NetBeans)
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainGui().setVisible(true));
    }
}
