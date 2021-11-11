package calculator.cgpa;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.Objects;

public class DialogGui extends JDialog {
    JTextPane msgPane;
    int lineBreak;
    private String msg;

    public DialogGui(int lineBreak, String title, String msg) {
        // initialization
        this.msg = msg;
        this.lineBreak = lineBreak;
        initComponents();

        // window settings
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(Config.icon))).getImage());
    }

    private void initComponents() {
        msgPane = new JTextPane();
        while (lineBreak > 0) {
            msg = "\n" + msg;
            lineBreak--;
        }
        msgPane.setText(msg);

        // TextPane Settings
        msgPane.setEditable(false);
        msgPane.setBorder(null);
        msgPane.setFont(new java.awt.Font("sanserif", 0, 18));
        msgPane.setForeground(new java.awt.Color(223, 30, 73));
        msgPane.setOpaque(false);

        // TextPane Align to Center
        StyledDocument doc = msgPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        // Layout Setting (NetBeans)
        //<editor-fold defaultstate="collapsed" desc=" initialization Codes ">
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(msgPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(msgPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        // </editor-fold>
    }
}