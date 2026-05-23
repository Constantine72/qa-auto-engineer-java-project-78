package hexlet.code;

import hexlet.code.schemas.BaseSchema;
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
    @Test
    void testShapeValidationWithExtraConstraints() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        schemas.put("secretCode", v.string().required().contains("VIP"));

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        human1.put("secretCode", "MY_VIP_pass");

        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        human2.put("secretCode", "MY_VIP_pass");

        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        human3.put("secretCode", "MY_VIP_pass");

        assertFalse(schema.isValid(human3));

        Map<String, String> human4 = new HashMap<>();
        human1.put("firstName", "Anna");
        human1.put("lastName", "Smith");
        human1.put("secretCode", "MY_pass");

        assertFalse(schema.isValid(human4));

    }
}
