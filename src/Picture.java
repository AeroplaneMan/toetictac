import javax.swing.*;

public class Picture {
    JFrame frame;
    JPanel pic;
    ImageIcon pc;
    JLabel lab;
    public void OpenPicture(String image, int width, int height){
        frame = new JFrame(); //container for the JPanel and the gui's main window
        pic = new JPanel(); //container used to hold other components
        pc = new ImageIcon(image); //used to hold & store the image/image filepath being used
        lab = new JLabel(pc, SwingConstants.CENTER); //displays image specified by ImageIcon
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pic.add(lab); //JLabel is now being added to JPanel
        frame.add(pic); //JPanel is now being added to the JFrame
        frame.setSize(width, height); //Size for the gui's window is being set
        frame.setVisible(true); //window can now be seen
    }

}
