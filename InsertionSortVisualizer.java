import javax.swing.*;
import java.awt.*;

public class InsertionSortVisualizer extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BAR_WIDTH = 5;
    private static final int DELAY = 10;

    private int[] array;

    public InsertionSortVisualizer(int[] array) {
        this.array = array;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < array.length; i++) {
            int x = i * BAR_WIDTH;
            int y = HEIGHT - array[i];
            int width = BAR_WIDTH - 1;
            int height = array[i];

            g.setColor(Color.BLACK);
            g.fillRect(x, y, width, height);
        }
    }

    public void sort() {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;

            repaint();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * HEIGHT);
        }

        InsertionSortVisualizer panel = new InsertionSortVisualizer(array);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);

        panel.sort();
    }
}