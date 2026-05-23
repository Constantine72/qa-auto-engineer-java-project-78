package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MapValidatorTest {

    @Test
    void testMapValidation() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertTrue(schema.isValid(data));

        schema.sizeof(2);

        assertFalse(schema.isValid(data));

        data.put("key2", "value2");

        assertTrue(schema.isValid(data));
    }
    @Test
    void testSizeOfOverwriting() {
        Validator v = new Validator();
        MapSchema schema = v.map().required();

        Map<String, String> data = new HashMap<>();
        data.put("k1", "v1");

        schema.sizeof(5).sizeof(1);

        assertTrue(schema.isValid(data));
    }
}
