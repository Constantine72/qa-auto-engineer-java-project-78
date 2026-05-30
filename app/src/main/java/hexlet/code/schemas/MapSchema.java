package hexlet.code.schemas;

import java.util.Map;


public class MapSchema extends BaseSchema<Map<?, ?>> {


    public MapSchema required() {
        addCheck("required", value -> value != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> value == null || value.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, ? extends BaseSchema> schemas) {
        addCheck("shape", value -> {
            if (value == null) {
                return true;
            }
            for (Map.Entry<String, ? extends BaseSchema> entry : schemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema rule = entry.getValue();

                Object item = value.get(key);

                if (!rule.isValid(item)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}