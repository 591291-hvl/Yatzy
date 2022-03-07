package main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Yatzy yatzy = new Yatzy(5,4);

		yatzy.display();

		yatzy.playGame();

	}

}
