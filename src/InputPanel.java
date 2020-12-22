import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class InputPanel extends JPanel {

    JTextField numberTextField;
    private JButton addButton;
    private JButton deleteButton;
    private Graphics g;
    //buffer to keep the latest tree representation
    public Image image = new BufferedImage(TreeWindow.WIDTH, TreeWindow.HEIGHT, BufferedImage.TYPE_INT_RGB);
    int imageWidth, imageHeight;

    public InputPanel(){
        setLayout(new GridLayout(0,1));
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        numberTextField = new JTextField("");
        add(numberTextField);
        add(addButton);
        add(deleteButton);
        g = image.getGraphics();


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //grab the text from the numberTextField
                //add the number to the tree
                    int number = (int) (Double.parseDouble(numberTextField.getText()));
                    TreeWindow.tree.add(number);
                    numberTextField.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //grab the text from the numberTextField
                //delete the number to the tree
                int number = (int) (Double.parseDouble(numberTextField.getText()));
                TreeWindow.tree.delete(number);
                numberTextField.setText("");
            }
        });

    }

    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, imageWidth, imageHeight);
        g.drawImage(image, 0, 0, this);
    }
}
