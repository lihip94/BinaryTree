import javax.swing.*;
import java.awt.*;
import javax.swing.JScrollPane;

public class TreeWindow extends JFrame {

    public static int WIDTH = 1600;
    public static int HEIGHT = 400;
    public  static BinaryTree tree = new BinaryTree();

    TreeWindow(){
        setTitle("My Binary Tree");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        //split the panels
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        split.setDividerLocation(250);
        add(split);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        //add the output panel and his scroll option
        OutputPanel outputPanel = new OutputPanel();
        outputPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT+HEIGHT));
        topPanel.add(new JScrollPane(outputPanel), BorderLayout.CENTER);

        split.setTopComponent(topPanel);

        //create the output panel
        InputPanel inputPanel = new InputPanel();
        split.setBottomComponent(inputPanel);
        setVisible(true);
    }

    public static void main(String[] args){
        new TreeWindow();
    }

}
