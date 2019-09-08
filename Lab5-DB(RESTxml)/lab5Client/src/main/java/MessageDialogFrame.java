import javax.swing.*;
import java.awt.*;

public class MessageDialogFrame
{
    public JFrame createFrame(int width, int height, String name)
    {
        JFrame frame = new JFrame(name);
        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setLayout(new FlowLayout(50,50,50));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        return frame;
    }

    public JButton createButton(int width, int height, int xPos, int yPos, String text)
    {
        JButton button = new JButton(text);
        button.setBounds(xPos, yPos, width, height);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        return button;
    }

    public JTextArea createTextArea(int width, int height, int xPos, int yPos,String testo)
    {
        JTextArea txt = new JTextArea();
        txt.setBounds(xPos, yPos, width, height);
       
        txt.setText(testo);
        txt.setEditable(false);
        return txt;
    }
     public JTextArea createTextArea2(int width, int height, int xPos, int yPos,String testo)
    {
        JTextArea txt = new JTextArea(55,20);
        txt.setBounds(xPos, yPos, width, height);
       
        txt.setText(testo);
        txt.setEditable(true);
        return txt;
    }
}