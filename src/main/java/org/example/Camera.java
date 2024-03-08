package org.example;
import org.opencv.core.*;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Camera extends JFrame{

    private JLabel cameraScreen;

    private JButton btnCapture;

    private JButton btnOpen;

    private VideoCapture capture;

    private Mat image;
    public ImageIcon icon;

    private boolean clicked = false;
    private boolean clicked2 = false;
    public Camera(){
        //design UI
        setLayout(null);

        cameraScreen = new JLabel();
        cameraScreen.setBounds(0,0,640,480);
        add(cameraScreen);     // test

        btnCapture = new JButton("capture");
        btnCapture.setBounds(300,480, 80, 40);
        add(btnCapture);     //test

        btnOpen = new JButton("open file");
        btnOpen.setBounds(400,480, 80,40);
        add(btnOpen);

        btnCapture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked = true;
            }
        });

        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked2 = true;
            }
        });

        setSize(new Dimension(640,560));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void startCamera(){
        capture = new VideoCapture(0);
        image = new Mat();
        byte[] imageData;



        while(true){
            capture.read(image);

            final MatOfByte buf = new MatOfByte();

            Imgcodecs.imencode(".jpg", image, buf);

            imageData = buf.toArray();

            icon = new ImageIcon(imageData);
            cameraScreen.setIcon(icon);
            if(clicked){
                new PictureBeforeSend(icon);
                clicked = false;
            }
            if(clicked2){
                new PictureBeforeSend(OpenFile.openFile());
                clicked2 = false;
            }
        }
    }



}
