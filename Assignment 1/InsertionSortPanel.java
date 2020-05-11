import java.awt.*;

public class InsertionSortPanel extends SortPanel {
  private static final long serialVersionUID = 1L;
  private int redColumn = -1;
  private int blueColumn = -1;
  private int greenColumn = -1;
  
  public InsertionSortPanel(String name, int[] list, int sleepTime) {
   super(name, list, sleepTime);
  }

  @Override
  public void run() {
   try {
    for (int i = 1; i < list.length; i++) {
     greenColumn = i;
     Thread.sleep(3 * sleepTime);
     repaint();
     redColumn = greenColumn;
     blueColumn = -1;
     int k;
     for (k = i - 1; k >= 0 && list[k] > list[k + 1]; k--) {
      redColumn = k + 1;
      blueColumn = k;
      repaint();
      Thread.sleep(4 * sleepTime);
      int tmp = list[k + 1]; 
      list[k + 1] = list[k];
      list[k] = tmp;
     }
     redColumn = k + 1;
     blueColumn = k;
     repaint();
    }
    redColumn = -1;
    blueColumn = -1;
   } catch (InterruptedException e) {
   }
   repaint();
  }
  
  @Override
  protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   int columnWidth = (getWidth() - 4 * BORDER_WIDTH) / size;
   int columnHeight = (getHeight() - 4 * BORDER_WIDTH) / size;
   for (int i = (greenColumn == -1 ? 0 : greenColumn); i < list.length; i++) {
    g.setColor(Color.WHITE);
    g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
    g.setColor(Color.BLACK);
    g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);   
   }
   for (int i = 0; i <= greenColumn; i++) {
    g.setColor(Color.GREEN);
    g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
    g.setColor(Color.BLACK);
    g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);   
   }
   if(redColumn != -1) {
    g.setColor(Color.RED);
    g.fillRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
    g.setColor(Color.BLACK);
    g.drawRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
   }
   if(blueColumn != -1) {
    g.setColor(Color.BLUE);
    g.fillRect(2 * BORDER_WIDTH + columnWidth * blueColumn, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
    g.setColor(Color.BLACK);
    g.drawRect(2 * BORDER_WIDTH + columnWidth * blueColumn, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
   }
  }

 }
