import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;

    @Test
    public void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue("A male lion should have a mane", lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse("A female lion should not have a mane", lion.doesHaveMane());
    }

    @Test
    public void testInvalidSexThrowsException() {
        String invalidSex = "Без гендера";
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = assertThrows("Creating a lion with invalid sex should throw an exception",
                Exception.class,
                () -> new Lion(invalidSex, feline));
        assertEquals("Exception message should match the expected value",
                expectedMessage, exception.getMessage());
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        assertEquals("Lion should return the correct number of kittens", 1,
                lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Lion should return the correct list of food", expectedFood,
                lion.getFood());
    }
}