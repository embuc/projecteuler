package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

//Right Triangles with Integer Coordinates
public class JTask91 implements Task {

	private final int input;

	public JTask91(int input) {
		this.input = input;
	}

	@NotNull
	@Override
	public Object solve() {
		int numberOfRightTriangles = 0;

		for (int x2 = 0; x2 <= input; x2++) {
			for (int y2 = 0; y2 <= input; y2++) {
//				Consider these two triangles:
//				(0,0) -> (x2, y2) -> (x3, y3)
//				(0,0) -> (x3, y3) -> (x2, y2)
//				These are the same triangle but in different order.
//				This leads to duplicate counting, note x3 and y3 start positions.
				for (int x3 = x2; x3 <= input; x3++) {
					for (int y3 = (x3 == x2) ? y2 + 1 : 0; y3 <= input; y3++) {
						if (isRightTriangle(x2, y2, x3, y3)) {
							numberOfRightTriangles++;
						}
					}
				}
			}
		}
		return numberOfRightTriangles;
	}


	private boolean isRightTriangle(int x2, int y2, int x3, int y3) {
		// Filter invalid cases:
		// Both points cannot be at the origin
		if ((x2 == 0 && y2 == 0) || (x3 == 0 && y3 == 0)) return false;
		if (x2 == x3 && y2 == y3) return false;

		// Calculate squared lengths of the triangle edges
		int a = x2 * x2 + y2 * y2;               // Distance from (0, 0) to (x2, y2)
		int b = x3 * x3 + y3 * y3;               // Distance from (0, 0) to (x3, y3)
		int c = (x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3); // Distance between (x2, y2) and (x3, y3)
		return a + b == c || a + c == b || b + c == a;
	}

	private void printRightTriangle(int x2, int y2, int x3, int y3) {
		// Determine the max width and height of the grid
		int maxX = Math.max(x2, x3);
		int maxY = Math.max(y2, y3);

		// Iterate over the grid
		for (int y = maxY; y >= 0; y--) { // From top (maxY) to bottom (0)
			for (int x = 0; x <= maxX; x++) { // From left (0) to right (maxX)
				if (isOnTriangleEdge(x, y, x2, y2, x3, y3)) {
					System.out.print("*"); // Print a star for the triangle edge
				} else {
					System.out.print(" "); // Print a blank space
				}
			}
			System.out.println(); // Move to the next line
		}
	}

	// Helper method to check if a point (x, y) is on the triangle's edge
	private boolean isOnTriangleEdge(int x, int y, int x2, int y2, int x3, int y3) {
		// Check if the point is on any of the three triangle edges:
		// Edge 1: (0, 0) -> (x2, y2)
		if (isPointOnLine(0, 0, x2, y2, x, y)) return true;

		// Edge 2: (0, 0) -> (x3, y3)
		if (isPointOnLine(0, 0, x3, y3, x, y)) return true;

		// Edge 3: (x2, y2) -> (x3, y3)
		if (isPointOnLine(x2, y2, x3, y3, x, y)) return true;

		return false;
	}

	// Helper method to check if a point (px, py) lies on the line segment between (x1, y1) and (x2, y2)
	private boolean isPointOnLine(int x1, int y1, int x2, int y2, int px, int py) {
		// Use the cross-product to check for collinearity
		int crossProduct = (py - y1) * (x2 - x1) - (px - x1) * (y2 - y1);

		// Ensure the cross-product is 0 (the point is on the infinite line)
		if (crossProduct != 0) return false;

		// Ensure the point is within the bounds of the line segment
		int dotProduct = (px - x1) * (x2 - x1) + (py - y1) * (y2 - y1);
		if (dotProduct < 0) return false;

		int squaredLength = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
		return dotProduct <= squaredLength;
	}

}
