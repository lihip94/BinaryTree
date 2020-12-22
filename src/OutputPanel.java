import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        if(TreeWindow.tree.root != null) {
            drawTree(g, TreeWindow.tree);
        }
        repaint();
    }

    //draw the binary tree
    public void drawTree(Graphics g, BinaryTree tree){
        int SCREEN_WIDTH = TreeWindow.WIDTH-50;
        drawNode(g,SCREEN_WIDTH/2, tree.root, SCREEN_WIDTH/2, 0);
    }

    //get the Graphics, the sub tree width, the root of the sub Tree and his x and y coordinates
    public void drawNode(Graphics g, int subTree, Node current, int x, int y){

        g.setColor(Color.GREEN);
        g.drawOval(x, y,40,40);
        g.fillOval(x, y,40,40);
        g.setColor(Color.BLACK);
        String a = String.valueOf(current.value);
        g.drawString(a,x+10,y+25);
        if(current.right!= null){
            g.setColor(Color.DARK_GRAY);
            g.drawLine(x+20,y+40,x +20 + subTree/2,y+60);
            drawNode(g,subTree/2, current.right, x+subTree/2, y+60);
        }
        if(current.left != null){
            g.setColor(Color.DARK_GRAY);
            g.drawLine(x+20,y+40,x+20- subTree/2,y+60);
            drawNode(g,subTree/2, current.left, x-subTree/2, y+60);
        }
    }
}
