import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAndSubStringTest {
    private final SubStringService service = new SubStringService();

    @Test
    public void subStringNotFound() {
        assertEquals(-1, service.findSubString("Chipi chipi", "chapa"));
    }

    @Test
    public void emptyStringCheck() {
        assertAll("Empty values in strings group",
                () -> assertEquals(-1, service.findSubString("", "chipi")),
                () -> assertEquals(-1, service.findSubString("chapa", ""))
        );
    }

    @Test
    public void manySubStrings() {
        assertEquals(0, service.findSubString("chipi chipi chapa chapa", "chipi"));
    }
}
