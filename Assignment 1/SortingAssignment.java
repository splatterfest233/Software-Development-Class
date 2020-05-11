import javax.swing.*;

import java.awt.*;

public class SortingAssignment extends JApplet {

 private static final long serialVersionUID = 1L;
 private SortPanel[] sortPanels = new SortPanel[3];
 private int size = 50;
 private int sleepTime = 20;
 

 public SortingAssignment() {
  setLayout(new  GridLayout(0, 3, 0, 0));
  int[] list = new int[size];
  for (int i = 0; i < list.length; i++) {
   list[i] = i + 1;
  }
  for (int i = 0; i < list.length; i++) {
   int index = (int) (Math.random() * list.length);
   int temp = list[i];
   list[i] = list[index];
   list[index] = temp;
  }
  sortPanels[0] = new SelectionSortPanel(" Selection Sort ", list, sleepTime);
  sortPanels[1] = new InsertionSortPanel(" Insertion Sort ", list, sleepTime);
  sortPanels[2] = new BubbleSortPanel(" Bubble Sort ", list, sleepTime);
  
  for (int i = 0; i < sortPanels.length; i++) {
   add(sortPanels[i]);    
  }

 }

 public static void main(String[] args) {
  JFrame frame = new JFrame("SortingAssignment");
  JApplet applet = new SortingAssignment();
  frame.add(applet);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
 }

}