package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberValidatorTest {

    @Test
    void testNumberValidation() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));

        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));

        schema.range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }

    @Test
    void testRangeOverwriting() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        schema.range(1, 5).range(10, 20);

        assertTrue(schema.isValid(15));
        assertFalse(schema.isValid(3));
    }
}