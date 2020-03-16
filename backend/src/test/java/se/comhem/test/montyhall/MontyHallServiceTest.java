package se.comhem.test.montyhall;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MontyHallServiceTest {

    @Mock
    MontyHallService mockService;

    @Test
    public void testWinSimulation() {
        Mockito.when(mockService.generateDoors()).thenAnswer(x -> new int[]{1,0,0});
        Mockito.when(mockService.runSimulation(5, false)).thenCallRealMethod();
        SimulationResult result = mockService.runSimulation(5, false);
        assertEquals(5, result.getWins());
    }

    @Test
    public void testLoseSimulation() {
        Mockito.when(mockService.generateDoors()).thenAnswer(x -> new int[]{0,0,1});
        Mockito.when(mockService.runSimulation(1, false)).thenCallRealMethod();
        SimulationResult result = mockService.runSimulation(1, false);
        assertEquals(0, result.getWins());
    }
}
