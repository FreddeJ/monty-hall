package se.comhem.test.montyhall;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class MontyHallService implements MontyHallServiceInterface{

    public SimulationResult runSimulation(Integer iterations, boolean switchDoors) {
        int choice = 0;
        int wins = Stream.iterate(0, n -> n + 1)
                .limit(iterations)
                .map(x -> generateDoors())
                .map(doors -> openFakeDoor(doors, choice))
                .map(doors -> chooseFinalDoorAndCollectPrice(doors, choice, switchDoors))
                .reduce(0, Integer::sum);

        return new SimulationResult(iterations, wins, switchDoors);
    }

    protected int[] generateDoors(){
        int[] doors = new int[]{0,0,0};
        Random random = new Random();
        doors[random.nextInt(3)] = 1;
        return doors;
    }

    private int[] openFakeDoor(int[] doors, int choice){
        int indexToRemove = IntStream.range(0, doors.length)
                .filter(i -> i != choice && doors[i] == 0)
                .findFirst().getAsInt();

        doors[indexToRemove] = -1;
        return doors;
    }

    private int chooseFinalDoorAndCollectPrice(int[] doors, int choice, boolean switchDoors){
        int availableChoice = IntStream.range(0, doors.length)
                .filter(i -> i != choice && doors[i] != -1)
                .findFirst().getAsInt();

        return switchDoors ? doors[availableChoice] : doors[choice];
    }
}