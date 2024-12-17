package sudoku;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;

public class Cell extends JTextField {
   private static final long serialVersionUID = 1L;

   public static final Color BG_GIVEN = new Color(240, 240, 240);
   public static final Color FG_GIVEN = Color.RED;
   public static final Color FG_NOT_GIVEN = Color.YELLOW;
   public static final Color BG_TO_GUESS  = Color.YELLOW;
   public static final Color BG_CORRECT_GUESS = new Color(0, 216, 0);
   public static final Color BG_WRONG_GUESS   = new Color(216, 216, 0);
   public static final Font FONT_NUMBERS = new Font("OCR A Extended", Font.PLAIN, 28);

   int row, col;
   int number;
   CellStatus status;

   public Cell(int row, int col) {
      super();
      this.row = row;
      this.col = col;
      super.setHorizontalAlignment(JTextField.CENTER);
      super.setFont(FONT_NUMBERS);
   }

   public void newGame(int number, boolean isGiven) {
      this.number = number;
      status = isGiven ? CellStatus.GIVEN : CellStatus.TO_GUESS;
      paint();  // Kembalikan ke nama metode asli
   }

   public void paint() {
      if (status == CellStatus.GIVEN) {
          // Preset cells (number > 0)
          super.setText(number + "");
          super.setEditable(false);
          super.setBackground(ThemeManager.getCellBackground(true));
          super.setForeground(ThemeManager.getCellForeground(true));
      } else if (status == CellStatus.TO_GUESS) {
          // User-input cells (marked with 0)
          super.setText("");
          super.setEditable(true);
          super.setBackground(ThemeManager.getCellBackground(false));
          super.setForeground(ThemeManager.getCellForeground(false));
      } else if (status == CellStatus.CORRECT_GUESS) {
          super.setBackground(BG_CORRECT_GUESS);
          super.setForeground(Color.WHITE);
      } else if (status == CellStatus.WRONG_GUESS) {
          super.setBackground(BG_WRONG_GUESS);
          super.setForeground(Color.WHITE);
      }
  }
}