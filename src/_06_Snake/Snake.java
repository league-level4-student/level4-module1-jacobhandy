package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	_00_SnakeGame game = new _00_SnakeGame();
	
	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		//1. add a new SnakeSegment object to the snake
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		//2. return the location of the snake's head
		return head.getLocation();
	}

	public void update() {
		//1. use a switch statement to check on the currentDirection
		//   of the snake and calculate its next x and y position.
		switch(currentDirection) {
		case UP: head.getLocation().y--;
		case DOWN: head.getLocation().y++;
		case LEFT: head.getLocation().x--;
		case RIGHT: head.getLocation().x++;
		}

		//2. Iterate through the SnakeSegments in reverse order
		for(int a = snake.size(); a > 0; a--) {
			//2a. Update each snake segment to the location of the segment 
			//    in front of it.
			snake.get(a).setLocation(snake.get(a - 1).getLocation());
		}
		
		
		
		//3. set the location of the head to the new location calculated in step 1
		head.setLocation(getHeadLocation());

		//4. set canMove to true
		canMove = true;
	}

	public void setDirection(Direction d) {
		//1. set the current direction equal to the passed in Direction only if canMove is true.
		//   set canMove equal to false.
		//   make sure the snake cannot completely reverse directions.
		if(canMove) {
			canMove = false;
			switch(d) {
			case UP: switch(currentDirection) {
			case DOWN:
			case LEFT: currentDirection = d;
			case RIGHT: currentDirection = d;
			}
			
			case DOWN: switch(currentDirection) {
			case UP:
			case LEFT: currentDirection = d;
			case RIGHT: currentDirection = d;
			}
			
			case LEFT: switch(currentDirection) {
			case RIGHT:
			case DOWN: currentDirection = d;
			case UP: currentDirection = d;
			}
			
			case RIGHT: switch(currentDirection) {
			case LEFT:
			case DOWN: currentDirection = d;
			case UP: currentDirection = d;
			}
			}
		}
	}

	public void reset(Location loc) {
		//1. clear the snake
		snake.clear();
		//2. set the location of the head
		head.setLocation(loc);
		//3. add the head to the snake
		snake.add(head);
		
	}

	public boolean isOutOfBounds() {
		//1. complete the method so it returns true if the head of the snake is outside of the window
		//   and false otherwise
		if(head.getLocation().x > game.WIDTH || head.getLocation().x < 0 || head.getLocation().y > game.HEIGHT || head.getLocation().y < 0) {
			return true;
		}
		return false;
	}
	
	public boolean isHeadCollidingWithBody() {
		//1. complete the method so it returns true if the head is located
		//   in the same location as any other body segment
		for(int a = 0; a < snake.size(); a++) {
			if(head.getLocation() == snake.get(a).getLocation()) {
				return true;
			}
		}
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		//1. complete the method so it returns true if the passed in
		//   location is located on the snake
		for(int a = 0; a < snake.size(); a++) {
			if(snake.get(a).getLocation() == loc) {
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
