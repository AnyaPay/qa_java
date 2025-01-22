import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParams {

    private final String sex;
    private final boolean expectedHasMane;
    private final String expectedExceptionMessage;

    private static final Feline FELINE = new Feline();

    public LionTestParams(String sex, boolean expectedHasMane, String expectedExceptionMessage) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedExceptionMessage = expectedExceptionMessage;
    }

    @Parameterized.Parameters(name = "Sex: {0}, Expected Has Mane: {1}, Expected Exception: {2}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, null},
                {"Самка", false, null},
                {"Без гендера", false, "Используйте допустимые значения пола животного - самец или самка"} // Invalid case
        });
    }

    @Test
    public void testDoesHaveMane() {
        try {
            Lion lion = new Lion(sex, FELINE);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals("Lion's mane status should match the expected value", expectedHasMane, actualHasMane);
        } catch (Exception e) {
            assertEquals("Exception message should match the expected value", expectedExceptionMessage, e.getMessage());
        }
    }
}