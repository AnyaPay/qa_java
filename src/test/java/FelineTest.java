import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals("Feline should return the correct list of food", expectedFood, actualFood);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        Assert.assertEquals("Feline should belong to the correct family","Кошачьи",
                feline.getFamily());
    }
}
