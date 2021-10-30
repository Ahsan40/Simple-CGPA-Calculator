package calculator.cgpa;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class DialogGui extends JDialog implements Runnable {
    private String msg;
    int lineBreak;

    public DialogGui(int lineBreak, String title, String msg) {
        this.msg = msg;
        this.lineBreak = lineBreak;

        // window settings
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // start in new thread
        Thread t = new Thread(this);
        t.start();
    }

    private void initComponents() {
        JTextPane msgPane = new JTextPane();
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
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addComponent(msgPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addComponent(msgPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
        // </editor-fold>
    }

    @Override
    public void run() {
        initComponents();
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        setVisible(true);
//        System.out.println(Thread.currentThread().getId()); // debug
    }
}