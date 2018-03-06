/**
 * GridView Class
 * 		@author		Dawid Stawowy
 * 		@version	0.1 prototype
 * 		@date		06/03/2018
 * 
 * GridView class generates a textual grid where robot and destination can be placed.
 * Robot is represented as 1;
 * Destination is represented as 2;
 * If robot and destination are in the same place, it is represented as 3; 
 */

public class GridView {
	// declare size variables for the grid
	private int sizeX;
	private int sizeY;
	// size of the square (FOR FUTURE USE WITH GUI)
	static final int SQUARE_SIZE = 5;
	// declare 2d array for the grid
	private int[][] gridArray;
	// current destination location
	private int destinationX;
	private int destinationY;
	// current robot location
	private int robotX;
	private int robotY;

	public static void main(String[] args) {
		/**
		 * MAIN WORKS AS A TEST PROGRAM HERE ONCE FINISHED AND TESTED, WE CAN REMOVE THE
		 * MAIN METHOD
		 */
		GridView k = new GridView(10, 10);
		System.out.println("*Main method about to run!*\n");
		k.placeRobot(0, 0);
		k.drawGrid();
		k.placeDestination(0, 1);
		k.drawGrid();
		k.moveRobot(0, 1);
		k.drawGrid();
		k.moveRobot(0, 0);
		k.drawGrid();
		k.moveDestination(0, 0);
		k.drawGrid();
		k.moveDestination(0, 1);
		k.drawGrid();
	}

	// constructor for class GridView
	public GridView(int sizeX, int sizeY) {
		// assign variables from Simulator class to private variables here
		this.sizeX = sizeX;
		this.sizeY = sizeY;

		// initialise
		robotX = 0;
		robotY = 0;
		destinationX = 0;
		destinationY = 0;

		// create a grid
		gridArray = new int[sizeX][sizeY];

		// fill out the grid with 0's
		for (int i = 0; i < sizeX; i++) {

			for (int j = 0; j < sizeY; j++) {

				gridArray[i][j] = 0;
			}
		}

		System.out.println("*****\n1 - ROBOT\n2 - DESTINATION\n3 - ROBOT AND DESTINATION\n*****");
		System.out.println("Constructor finished!");

	}

	// get sizeY of the grid
	public int getSizeY() {
		return sizeY;
	}

	// get sizeX of the grid
	public int getSizeX() {
		return sizeX;
	}
	
	//get robot X location
	public int getRobotX() {
		return robotX;
	}
	
	//get robot Y location
	public int getRobotY() {
		return robotY;
	}
	
	//get destination X location
	public int getDestinationX() {
		return destinationX;
	}
	
	//get destination Y location
	public int getDestinationY() {
		return destinationY;
	}

	// place a robot on a grid
	// ONLY USE ONCE WHEN NO ROBOT IS ON THE GRID AS IT DOESN'T DELETE PREVIOUS
	// LOCATION
	public void placeRobot(int x, int y) {

		// checks if the place isn't taken by a robot already
		if (gridArray[x][y] == 1 || gridArray[x][y] == 3) {

			System.out.println("*Robot already there!*");
		} else {
			// updates robot position
			gridArray[x][y] = +1;
			robotX = x;
			robotY = y;
			System.out.println("*Robot placed in location x = " + robotX + ", y = " + robotY + "*");
		}
	}

	// move robot
	public void moveRobot(int x, int y) {

		// checks if the place isn't taken by a robot already
		if (gridArray[x][y] == 1 || gridArray[x][y] == 3) {

			System.out.println("*Robot already there!*");
		}

		else {
			// removes previous robot position
			/*
			 * TODO: if we fix below if statement, we can get rid of placeRobot and use only
			 * moveRobot PROBLEM: when there's no robot on the grid, below if statement
			 * checks positions 0,0 which can lead to problems in the future SOLUTION:
			 * discuss with team members
			 */
			if (gridArray[robotX][robotY] == 1 || gridArray[robotX][robotY] == 3) {

				gridArray[robotX][robotY] -= 1;
			}

			// updates robot position
			gridArray[x][y] += 1;
			robotX = x;
			robotY = y;

			System.out.println("*Robot moved to location x = " + robotX + ", y = " + robotY + "*");
		}

	}

	// places destination on the grid
	public void placeDestination(int x, int y) {

		// checks if the place isn't taken by destination already
		if (gridArray[x][y] == 2 || gridArray[x][y] == 3) {
			System.out.println("*Destination already there!*");
		}

		else {
			// updates destination position
			gridArray[x][y] = +2;
			destinationX = x;
			destinationY = y;
			System.out.println("*Destination placed in location x = " + destinationX + ", y = " + destinationY + "*");
		}

	}

	// move destination on the grid
	public void moveDestination(int x, int y) {
		// removes previous destination position
		/*
		 * TODO: if we fix below if statement, we can get rid of placeDestination and
		 * use only moveDestination PROBLEM: when there's no destination on the grid,
		 * below if statement checks positions 0,0 which can lead to problems in the
		 * future SOLUTION: discuss with team members
		 */

		if (gridArray[destinationX][destinationY] == 2 || gridArray[robotX][robotY] == 3) {
			gridArray[destinationX][destinationY] -= 2;
		}

		// updates robot position
		gridArray[x][y] += 2;
		destinationX = x;
		destinationY = y;

		System.out.println("*Destination moved to location x = " + destinationX + ", y = " + destinationY + "*");

	}

	public void drawGrid() {
		// TODO generate a grid with given parameters

		for (int i = 0; i < sizeX; i++) {

			for (int j = 0; j < sizeY; j++) {

				// gridArray[i][j] = 0;
				System.out.print(gridArray[i][j] + " ");
			}

			// new line for the grid
			System.out.print("\n");
		}

		// new line for next command
		System.out.println("\n\n");
	}

}
