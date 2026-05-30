package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorTest {

    @Test
    void testRequiredValidation() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));

        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    void testContainsValidation() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));

        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    void testMinLengthValidation() {
        Validator v = new Validator();
        StringSchema schema1 = v.string();

        assertTrue(schema1.minLength(10).minLength(4).isValid("Hexlet"));

        assertFalse(schema1.minLength(10).isValid("Hexlet"));
    }

    @Test
    void testChainedRules() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("Hex");

        assertTrue(schema.isValid("Hexlet"));

        assertFalse(schema.isValid("Hex"));

        assertFalse(schema.isValid("testing"));
    }
}
