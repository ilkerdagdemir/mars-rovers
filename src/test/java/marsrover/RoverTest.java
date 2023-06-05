package marsrover;

import org.marsrover.Rover;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoverTest {

    @Test
    public void testDirectionAndPositionInitialization() {
        Rover rover = new Rover();
        rover.setPosition(3, 4, Rover.S);

        assertEquals(3, rover.getX().intValue());
        assertEquals(4, rover.getY().intValue());
        assertEquals(Rover.S, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test
    public void testMovingRoverPositionAndLocation() {
        Rover rover = new Rover();
        rover.setPosition(1, 1, Rover.N);

        rover.move();
        assertEquals(1, rover.getX().intValue());
        assertEquals(2, rover.getY().intValue());

        rover.turnRight();
        rover.move();
        assertEquals(2, rover.getX().intValue());
        assertEquals(2, rover.getY().intValue());

        rover.turnLeft();
        rover.move();
        assertEquals(2, rover.getX().intValue());
        assertEquals(3, rover.getY().intValue());
    }

    @Test
    public void testRoverMovementScenario() {
        Rover rover = new Rover();
        rover.setPosition(1, 2, Rover.N);
        rover.process("LMLMLMLMM");

        assertEquals(1, rover.getX().intValue());
        assertEquals(3, rover.getY().intValue());
        assertEquals(Rover.N, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test
    public void testInitialPosition() {
        Rover rover = new Rover();
        assertEquals(0, rover.getX().intValue());
        assertEquals(0, rover.getY().intValue());
        assertEquals(Rover.N, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test
    public void testSetPosition() {
        Rover rover = new Rover();
        rover.setPosition(3, 5, Rover.E);
        assertEquals(3, rover.getX().intValue());
        assertEquals(5, rover.getY().intValue());
        assertEquals(Rover.E, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test
    public void testMoveNorth() {
        Rover rover = new Rover();
        rover.setPosition(2, 2, Rover.N);
        rover.move();
        assertEquals(2, rover.getX().intValue());
        assertEquals(3, rover.getY().intValue());
        assertEquals(Rover.N, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test
    public void testMoveEast() {
        Rover rover = new Rover();
        rover.setPosition(2, 2, Rover.E);
        rover.move();
        assertEquals(3, rover.getX().intValue());
        assertEquals(2, rover.getY().intValue());
        assertEquals(Rover.E, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test
    public void testMoveSouth() {
        Rover rover = new Rover();
        rover.setPosition(2, 2, Rover.S);
        rover.move();
        assertEquals(2, rover.getX().intValue());
        assertEquals(1, rover.getY().intValue());
        assertEquals(Rover.S, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test
    public void testMoveWest() {
        Rover rover = new Rover();
        rover.setPosition(2, 2, Rover.W);
        rover.move();
        assertEquals(1, rover.getX().intValue());
        assertEquals(2, rover.getY().intValue());
        assertEquals(Rover.W, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test
    public void testTurnLeft() {
        Rover rover = new Rover();
        rover.setPosition(2, 2, Rover.N);
        rover.turnLeft();
        assertEquals(2, rover.getX().intValue());
        assertEquals(2, rover.getY().intValue());
        assertEquals(Rover.W, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test
    public void testTurnRight() {
        Rover rover = new Rover();
        rover.setPosition(2, 2, Rover.N);
        rover.turnRight();
        assertEquals(2, rover.getX().intValue());
        assertEquals(2, rover.getY().intValue());
        assertEquals(Rover.E, Integer.valueOf(rover.getFacing().intValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCommand() {
        Rover rover = new Rover();
        rover.process("A"); // Should throw an IllegalArgumentException
    }
}
