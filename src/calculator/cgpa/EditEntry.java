package calculator.cgpa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class EditEntry extends JFrame {

    // Variables declaration - do not modify
    private JButton btnUpdate;
    private JButton btnCancel;
    private JLabel lblName;
    private JLabel lblResult;
    private JLabel lblCredit;
    private JPanel pnlMain;
    private JTextField tfName;
    private JTextField tfResult;
    private JTextField tfCredit;
    // End of variables declaration

    public EditEntry(JFrame frame, ArrayList<GPA> data, DefaultTableModel model, int row, int col) {
        // initialization
        initComponents();

        // window settings
        setTitle("Edit");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);
                e.getWindow().dispose();
            }
        });
        this.setLocationRelativeTo(null);
        setVisible(true);

        // JComponent settings
        tfName.setText(data.get(row).getName());
        tfResult.setText(data.get(row).getResult() + "");
        tfCredit.setText(data.get(row).getCredit() + "");

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

        // event listener
        btnUpdate.addActionListener(e -> {
            try {
                // getting new data
                String name = tfName.getText();
                String result = tfResult.getText();
                String credit = tfCredit.getText();

                // credit can not be 0 or less
                if (Double.parseDouble(credit) < 1)
                    throw new InvalidParameterException();

                // result can not be less than 0
                if ((Double.parseDouble(result) < 0))
                    throw new InvalidKeyException();

                // updating data to ArrayList and Table
                if (!name.equals("")) {  // name won't be change if text field empty
                    data.get(row).setName(name);
                    model.setValueAt(name, row, 0);
                }
                data.get(row).setResult(Double.parseDouble(result));
                model.setValueAt(result, row, 1);
                data.get(row).setCredit(Double.parseDouble(credit));
                model.setValueAt(credit, row, 2);

                // enabling main windows
                frame.setEnabled(true);

                // exiting from edit window
                dispose();
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                new Thread(() -> new DialogGui(3, "Warning!", "Invalid Input in Result or Credit field!").setVisible(true)).start();
            } catch (InvalidKeyException ike) {
                ike.printStackTrace();
                new Thread(() -> new DialogGui(3, "Warning!", "Result can not be negative!").setVisible(true)).start();
            } catch (InvalidParameterException ipe) {
                ipe.printStackTrace();
                new Thread(() -> new DialogGui(3, "Warning!", "Credit can not be less than 1!").setVisible(true)).start();
            }
        });

        btnCancel.addActionListener(e -> {
            frame.setEnabled(true);
            dispose();
        });
    }

    private void initComponents() {
        pnlMain = new JPanel();
        tfName = new JTextField();
        tfResult = new JTextField();
        tfCredit = new JTextField();
        lblName = new JLabel();
        lblResult = new JLabel();
        lblCredit = new JLabel();
        btnUpdate = new JButton();
        btnCancel = new JButton();


        lblName.setText("Name");
        lblResult.setText("Result");
        lblCredit.setText("Credit");
        btnUpdate.setText("Update");
        btnCancel.setText("Cancel");

        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        GroupLayout jPanel1Layout = new GroupLayout(pnlMain);
        pnlMain.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(tfResult, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblResult, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(tfCredit, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCredit, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCredit, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                        .addComponent(lblResult, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfName)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(tfCredit, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfResult, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        // </editor-fold>
    }
}
