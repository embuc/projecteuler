package _50to100;

import se.embuc.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Monopoly odds (using Monte Carlo simulation)
public class JTask84 implements Task {
	@Override
	public Object solve() {
		String[] board = {"GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
				"JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
				"FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
				"G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2"};
		List<String> ch = new ArrayList<>(List.of("GO", "JAIL", "C1", "E3", "H2", "R1", "RN", "RN", "UN", "-3"));
		Collections.addAll(ch, "*", "*", "*", "*", "*", "*");
		List<String> cc = new ArrayList<>(List.of("GO", "JAIL"));
		Collections.addAll(cc, "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*");

		int[] visit = new int[40];
		int pos = 0;
		int dbl = 0;
		Random random = new Random();

		for (int i = 0; i < 1_000_000; i++) {
			int d1 = 1 + random.nextInt(4);
			int d2 = 1 + random.nextInt(4);
			dbl = (d1 == d2) ? dbl + 1 : 0;

			if (dbl == 3) {
				dbl = 0;
				pos = 10; // To Jail
			} else {
				pos = (pos + d1 + d2) % 40;
			}

			if (pos == 30) { // Go to Jail
				pos = 10;
				dbl = 0;
			} else if (board[pos].startsWith("CC")) {
				String card = cc.remove(0);
				cc.add(card); // Cycle the card to the bottom of the deck
				if (!card.equals("*")) pos = List.of(board).indexOf(card);
			} else if (board[pos].startsWith("CH")) {
				String card = ch.remove(0);
				ch.add(card); // Cycle the card to the bottom of the deck
				switch (card) {
					case "-3":
						pos -= 3;
						break;
					case "RN":
						pos = (pos < 5 || pos >= 35) ? 5 : (pos < 15) ? 15 : (pos < 25) ? 25 : 35;
						break;
					case "UN":
						pos = (pos < 12 || pos >= 28) ? 12 : 28;
						break;
					default:
						if (!card.equals("*")) pos = List.of(board).indexOf(card);
						break;
				}
			}
			visit[pos]++;
		}

		// Print the top 3 most visited tiles
//		System.out.println("Top 3 visited tiles:");
		List<Integer> visitList = new ArrayList<>();
		for (int count : visit) visitList.add(count);
		List<Integer> sortedIndices = new ArrayList<>();
		for (int j = 0; j < board.length; j++) sortedIndices.add(j);
		sortedIndices.sort((a, b) -> visitList.get(b) - visitList.get(a));
		String result = "";
		for (int j = 0; j < 3; j++) {
			int idx = sortedIndices.get(j);
			result += idx;
//			System.out.println("Index: " + idx + " (" + board[idx] + ") with " + visit[idx] + " visits");
		}
		return result;
	}
}
