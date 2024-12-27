package _50to100;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class JTask96 implements Task {

	private final String input;

	@AllArgsConstructor
	static class SudokuCell {
		int value;
	}

	@NotNull
	@Override
	public Object solve() {
		String[] rows = input.split("\n");
		List<SudokuCell[][]> grids = new ArrayList<>();
		for (int i = 1; i < rows.length; i+=10 ) {
			SudokuCell[][] grid = new SudokuCell[9][9];
			for (int j = 0; j < 9; j++) {
				String[] cols = rows[i+j].split("");
				for (int k = 0; k < 9; k++) {
					grid[j][k] = new SudokuCell(Integer.parseInt(cols[k]));
				}
			}
			grids.add(grid);
		}

		int sum = 0;
		for (SudokuCell[][] grid : grids) {
			solveSudoku(grid);
			sum += grid[0][0].value * 100 + grid[0][1].value * 10 + grid[0][2].value;
		}
		return sum;
	}

	public boolean solveSudoku(SudokuCell[][] grid) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (grid[row][col].value == 0) {
					for (int num = 1; num <= 9; num++) {
						if (isValid(grid, row, col, num)) {
							grid[row][col].value = num;
							if (solveSudoku(grid)) {
								return true;
							}
							// backtrack
							grid[row][col].value = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValid(SudokuCell[][] grid, int row, int col, int num) {
		// Check the row
		for (int i = 0; i < 9; i++) {
			if (grid[row][i].value == num) return false;

		}
		// Check the column
		for (int i = 0; i < 9; i++) {
			if (grid[i][col].value == num) return false;
		}
		// Check the 3x3 subgrid
		int subgridRowStart = (row / 3) * 3;
		int subgridColStart = (col / 3) * 3;
		for (int r = subgridRowStart; r < subgridRowStart + 3; r++) {
			for (int c = subgridColStart; c < subgridColStart + 3; c++) {
				if(grid[r][c].value == num) return false;
			}
		}
		return true;
	}

}
