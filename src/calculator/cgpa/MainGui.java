package calculator.cgpa;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainGui extends JFrame {

    // Variables declaration
    //<editor-fold defaultstate="collapsed" desc=" Variable Declarations ">
    private JLabel lblName;
    private JLabel lblResult;
    private JLabel lblCredit;
    private JButton btnAdd;
    private JButton btnCalculate;
    private JButton btnClear;
    private JButton btnLoadFromFile;
    private JButton btnSaveToFile;
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

        lblName = new JLabel("Name (Optional)");
        lblResult = new JLabel("Result");
        lblCredit = new JLabel("Credit");

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
        btnSaveToFile = new JButton("Save To Txt File");

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
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnLoadFromFile, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(btnSaveToFile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(rdoGPA, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(rdoCGPA, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(tfResult, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblResult, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                                                .addGap(44, 44, 44)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblCredit, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfCredit)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jspConsole, GroupLayout.PREFERRED_SIZE, 677, GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblName)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(lblCredit)
                                                                .addComponent(lblResult)))
                                                .addGap(11, 11, 11)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfResult, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfCredit, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(rdoGPA, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(rdoCGPA, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(jspConsole, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnLoadFromFile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCalculate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSaveToFile, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
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
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
}
