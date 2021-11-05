package calculator.cgpa;

import javax.naming.InsufficientResourcesException;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private JTable table;
    private JScrollPane scrollPane;
    private JRadioButton rdoCGPA;
    private JRadioButton rdoGPA;
    private JTextField tfCredit;
    private JTextField tfName;
    private JTextField tfResult;
    private int category;
    private int entryCount;
    // End of variables declaration
    //</editor-fold>

    public MainGui() {

        // initializing components
        initComponents();
        entryCount = 0;

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
        btnSaveToFile.addActionListener(this::btnSaveToFileActionPerformed);
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

        // action listener for table (double click to edit)
        JFrame jf = this;
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                int col = table.columnAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    setEnabled(false);
                    new EditEntry(jf, info, model, row, col);
                } else if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    btnRemove.setText("Remove");
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

        tfName = new JTextField("Subject 1");
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

        if (entryCount == 0) {
            changeOptionState(false);
        }

        table = new JTable() {
            // making table non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane = new JScrollPane();
        model = new DefaultTableModel();
        model.addColumn("Subject");
        model.addColumn("Result");
        model.addColumn("Credit");

        table.setFont(new java.awt.Font("sanserif", Font.PLAIN, 18));
        table.setModel(model);
        table.setRowHeight(35);
        table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(), 35));
        scrollPane.setViewportView(table);

        // Done with NetBeans
        //<editor-fold defaultstate="collapsed" desc=" initialization Codes ">
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
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
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
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
        model.setColumnIdentifiers(new String[]{"Subject", "Result", "Credit"});
        if (tfName.getText().contains((category == 1 ? "Semester" : "Subject")))
            tfName.setText((category == 1 ? "Subject " : "Semester ") + (entryCount + 1));
    }

    private void rdoCGPAActionPerformed(ActionEvent evt) {
        if (rdoGPA.isSelected()) {
            rdoGPA.setSelected(false);
        }
        category = 2;
        rdoCGPA.setSelected(true);
        model.setColumnIdentifiers(new String[]{"Semester", "Result", "Credit"});
        if (tfName.getText().contains((category == 1 ? "Semester" : "Subject")))
            tfName.setText((category == 1 ? "Subject " : "Semester ") + (entryCount + 1));
    }

    private void btnClearActionPerformed(ActionEvent evt) {
        clearAll();
    }

    private void clearAll() {
        info.clear();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        entryCount = 0;
        tfName.setText((category == 1 ? "Subject " : "Semester ") + (entryCount + 1));
        changeOptionState(false);
    }

    private void btnAddActionPerformed(ActionEvent evt) {
        try {
            // getting data
            String name = tfName.getText();
            double result = Double.parseDouble(tfResult.getText());
            double credit = Double.parseDouble(tfCredit.getText());

            // checking data
            // if name is empty, it will add name automatically
            if (name.equals("") || name.equals(" "))
                name = (category == 1 ? "Subject " : "Semester ") + (entryCount + 1);
            if (credit < 1)
                throw new InvalidParameterException();
            if (result < 0)
                throw new InvalidKeyException();

            // adding data
            GPA tmp = new GPA(name, result, credit);
            info.add(tmp);
            model.addRow(tmp.toArray());
            entryCount++;

            // changing other ui states
            if (entryCount == 1) changeOptionState(true, true, false, false);
            else if (entryCount > 1) changeOptionState(true);
            if (name.equals("Subject " + entryCount) || name.equals("Semester " + entryCount))
                tfName.setText((category == 1 ? "Subject " : "Semester ") + (entryCount + 1));
        } catch (InvalidParameterException ipe) {
            ipe.printStackTrace();
            warning(3, "Warning!", "Credit can not be less than 1!");
        } catch (InvalidKeyException ike) {
            ike.printStackTrace();
            warning(3, "Warning!", "Result can not be negative!");
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            warning(3, "Warning!", "Invalid Input in Result or Credit field!");
        }
    }

    private void btnRemoveActionPerformed(ActionEvent evt) {
        // checking if any rows selected
        int size = table.getSelectedRowCount();

        if (size > 0) {
            // storing selected index in sorting them (ascending)
            int[] rows = table.getSelectedRows();
            Arrays.sort(rows);

            // reversing arrays (else removing elements from ArrayList & Table  will cause exceptions)
            int[] rowsIndex = new int[size];
            for (int i = 0; i < size; i++) rowsIndex[i] = rows[size - i - 1];

            // removing selected index'
            for (int index : rowsIndex) {
                info.remove(index);
                model.removeRow(index);
                entryCount--;
            }
        } else {
            // if no row is selected (Remove Last)
            entryCount--;
            info.remove(entryCount);
            model.removeRow(entryCount);
        }

        // Updating changes to UI
        btnRemove.setText("Remove Last");
        if (entryCount == 0) changeOptionState(false);
        else if (entryCount < 2) changeOptionState(true, true, false, false);
        tfName.setText((category == 1 ? "Subject " : "Semester ") + (entryCount + 1));
    }

    private void btnCalculateActionPerformed(ActionEvent evt) {
        warning(3, "Result", (category == 1 ? "GPA: " : "CGPA: ") + String.format("%.2f", calculate()));
    }

    private void btnLoadFromFileActionPerformed(ActionEvent evt) {
        clearAll();
        try {
            BufferedReader br = new BufferedReader(new FileReader(Config.fileName));
            String line;
            while ((line = br.readLine()) != null) {
                // ignore empty lines
                if (line.equals("")) continue;
                // we can add comments with these
                if (line.startsWith("#") || line.startsWith("//")) continue;

                String[] d = line.split(",");
                if (d.length != 3 || d[0] == null || d[1] == null || d[2] == null)
                    throw new InputMismatchException();
                GPA tmp = new GPA(d[0], Double.parseDouble(d[1]), Double.parseDouble(d[2]));
                // if name is empty, it will add name automatically
                if (tmp.getName().equals("") || tmp.getName().equals(" "))
                    tmp.setName((category == 1 ? "Subject " : "Semester ") + (entryCount + 1));
                info.add(tmp);
                model.addRow(tmp.toArray());
                entryCount++;
            }
            br.close();
            tfName.setText((category == 1 ? "Subject " : "Semester ") + (entryCount + 1));
            if (info.size() == 0)
                throw new InvalidParameterException();
            else if (info.size() < 2) {
                changeOptionState(true, true, false, false);
                throw new InsufficientResourcesException();
            } else {
                warning(3, "Result", (category == 1 ? "GPA: " : "CGPA: ") + String.format("%.2f", calculate()));
                changeOptionState(true);
            }
        } catch (IOException ioe) {
            String line = """
                    # This line is comment. You can add '#' at the beginning of line
                    # to consider as a comment. '//' can be used for the same purpose.
                    # Example format starts from next line.
                                        
                    OOP, 3.67, 3
                    OOP Lab, 4, 1
                    """;
            writeData(line);
            warning(3, "Warning!", Config.fileName + " not found! A " + Config.fileName + " template has been saved.");
        } catch (InvalidParameterException ipe) {
            ipe.printStackTrace();
            warning(3, "Error!", "Wrong input format. Please check the text file again!");
        } catch (InsufficientResourcesException ire) {
            ire.printStackTrace();
            String tmp = "At least 2 data needed to calculate GPA/CGPA." +
                    " Thus, calculation will not performed automatically." +
                    " Please add more data and click 'Calculate' button.";
            warning(2, "Warning!", tmp);
        }
    }

    private void btnSaveToFileActionPerformed(ActionEvent evt) {
        String fileName = "calculatedResult.txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (GPA a : info) {
                bw.write(a.toString() + "\n");
            }
            bw.write((category == 1 ? "GPA: " : "CGPA: ") + String.format("%.2f", calculate()));
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            warning(3, "Error!", "Could not create the " + fileName + " file");
        }
    }

    private void writeData(String line) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Config.fileName));
            bw.write(line);
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            warning(3, "Error!", "Could not create the " + Config.fileName + " file");
        }
    }

    private void changeOptionState(boolean value) {
        btnRemove.setEnabled(value);
        btnClear.setEnabled(value);
        btnCalculate.setEnabled(value);
        btnSaveToFile.setEnabled(value);
    }

    private void changeOptionState(boolean a, boolean b, boolean c, boolean d) {
        btnRemove.setEnabled(a);
        btnClear.setEnabled(b);
        btnCalculate.setEnabled(c);
        btnSaveToFile.setEnabled(d);
    }

    private void warning(int lineBreak, String title, String msg) {
        new Thread(() -> new DialogGui(lineBreak, title, msg).setVisible(true)).start();
    }

    private double calculate() {
        double result = 0;
        double credit = 0;
        for (GPA a : info) {
            credit += a.getCredit();
            result += (a.getCredit() * a.getResult());
        }
        return result / credit;
    }

    private void theme() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException exc) {
            System.err.println("Nimbus: Unsupported Look and feel!");
        }
        //</editor-fold>
    }
}
