package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PictureBeforeSend extends JFrame {
    private JLabel picScreen;
    private JButton sendButton;
    private JButton exitButton;
    private JPanel panelButton;


    public PictureBeforeSend(ImageIcon icon){
        ImageIcon icon1 = icon;

        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        if(iconWidth > 800){
            int newWidth = 800;
            int newHeight = (int)((double)newWidth*iconHeight/iconWidth);
            iconWidth = newWidth;
            iconHeight = newHeight;
            Image img = icon1.getImage().getScaledInstance(newWidth, newHeight,Image.SCALE_SMOOTH);
            icon1 = new ImageIcon(img);
        }

        picScreen = new JLabel();
        picScreen.setBounds(0,0,iconWidth,iconHeight);
        add(picScreen);
        panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        exitButton = new JButton("Exit");
        sendButton = new JButton("send");
        panelButton.add(exitButton);
        panelButton.add(sendButton);
        add(panelButton,BorderLayout.SOUTH);



        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PictureBeforeSend.this.dispose();
            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = RequestAPI.sendPostRequest(RequestAPI.toByteArray(RequestAPI.toBufferedImage(icon)));
                if(data.equals("0")){
                    System.out.println("not found any faces ");
                }
                else{
                    PictureAfterProcess pap = null;
                    try {
                        pap = new PictureAfterProcess(icon,data);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    if(pap.icon.getIconWidth() > 800){
                        int x = 800;
                        int y = (int)((double) x / pap.icon.getIconWidth() * pap.icon.getIconHeight());
                        Image img = pap.icon.getImage().getScaledInstance(x, y,Image.SCALE_SMOOTH);
                        pap.icon = new ImageIcon(img);
                    }
                    picScreen.setIcon(pap.icon);
                    System.out.println("size :"+pap.icon.getIconWidth());
                }


            }
        });

        picScreen.setIcon(icon1);
        pack();
        setSize(new Dimension(iconWidth,iconHeight));

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
