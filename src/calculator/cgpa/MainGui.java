package calculator.cgpa;

import javax.naming.InsufficientResourcesException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MainGui extends JFrame {

    // Variables declaration
    //<editor-fold defaultstate="collapsed" desc=" Variable Declarations ">
    ArrayList<GPA> info;
    DefaultTableModel model;
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
    private JTable jtblConsole;
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
        // tfResult validation
        tfResult.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || c == '.' || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        // tfCredit validation
        tfCredit.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || c == '.' || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
    }

    private void initComponents() {
        // Main components
        info = new ArrayList<>();


        // swing components initialization
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
        btnRemove = new JButton("Remove Last");
        btnClear = new JButton("Clear All");
        btnCalculate = new JButton("Calculate");
        btnLoadFromFile = new JButton("Load From Txt File");
        btnSaveToFile = new JButton("Save To Txt File");

        jtblConsole = new JTable();
        jspConsole = new JScrollPane();
        model = new DefaultTableModel();
        model.addColumn("Subject");
        model.addColumn("Result");
        model.addColumn("Credit");

        jtblConsole.setFont(new java.awt.Font("sanserif", 0, 18));
        jtblConsole.setModel(model);
        jtblConsole.setRowHeight(35);
        jtblConsole.getTableHeader().setPreferredSize( new Dimension(jtblConsole.getWidth(), 35));
        jspConsole.setViewportView(jtblConsole);

        // Done with NetBeans
        //<editor-fold defaultstate="collapsed" desc=" initialization Codes ">
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jspConsole, GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
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
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                                        .addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))))
                                .addGap(17, 17, 17))
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
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jspConsole, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
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
        category = 1;
        rdoGPA.setSelected(true);
        model.setColumnIdentifiers(new String[] {"Subject", "Result", "Credit"});
    }

    private void rdoCGPAActionPerformed(ActionEvent evt) {
        if (rdoGPA.isSelected()) {
            rdoGPA.setSelected(false);
        }
        category = 2;
        rdoCGPA.setSelected(true);
        model.setColumnIdentifiers(new String[] {"Semester", "Result", "Credit"});
    }

    private void btnClearActionPerformed(ActionEvent evt) {
        clearAll();
    }

    private void clearAll() {
        info.clear();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
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
        clearAll();
        try {
            BufferedReader br = new BufferedReader(new FileReader(Config.fileName));
            String line;
            while ((line = br.readLine()) != null) {
                // we can add comments with these
                if (line.startsWith("#") || line.startsWith("//")) continue;

                String[] d = line.split(",");
                if (d.length != 3 || d[0] == null || d[1] == null || d[2] == null)
                    throw new InputMismatchException();
                GPA tmp = new GPA(d[0], Double.parseDouble(d[1]), Double.parseDouble(d[2]));
                info.add(tmp);
                model.addRow(tmp.toArray());
            }
            br.close();
            if (info.size() == 0)
                throw new InvalidParameterException();
            else if (info.size() < 2)
                throw new InsufficientResourcesException();
            else
                new DialogGui(3, "Result", (category == 1 ? "GPA: " : "CGPA: ") + String.format("%.2f", calculate()));
        }
        catch (IOException ioe) {
            String line = "# This line is comment. You can add '#' at the beginning of line\n" +
                    "# to consider as a comment. '//' can be used for the same purpose.\n" +
                    "# Example format starts from next line.\n" +
                    "OOP, 3.67, 3\n" +
                    "OOP Lab, 4, 1\n";
            writeData(line);
            new DialogGui(3, "Warning!", Config.fileName + " not found! A " + Config.fileName + " template has been saved.");
        }
        catch (InvalidParameterException ipe) {
            ipe.printStackTrace();
            new DialogGui(3, "Error!", "Wrong input format. Please check the text file again!");
        }
        catch (InsufficientResourcesException ire) {
            ire.printStackTrace();
            String tmp = "At least 2 data needed to calculate GPA/CGPA." +
                         " Thus, calculation will not performed automatically." +
                         " Please add more data and click 'Calculate' button.";
            new DialogGui(2, "Warning!", tmp);
        }
    }

    private void writeData(String line) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Config.fileName));
            bw.write(line);
            bw.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            new DialogGui(3, "Error!", "Could not create the " + Config.fileName + " file");
        }
    }

    private double calculate() {
        double result = 0;
        double credit = 0;
        for (GPA a: info) {
            credit += a.getCredit();
            result += (a.getCredit() * a.getResult());
        }
        return result/credit;
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
