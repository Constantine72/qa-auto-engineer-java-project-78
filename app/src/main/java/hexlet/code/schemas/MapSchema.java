package hexlet.code.schemas;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>>{
    private Integer requiredSize = null;
    private Map<String, BaseSchema<String>> shapeSchemas = null;

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }
    public MapSchema sizeof(int size) {
        this.requiredSize = size;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        this.shapeSchemas = schemas;
        return this;
    }

    @Override
    public boolean isValid(Map<?, ?> map) {

        if (isRequired && map == null) {
            return false;
        }
        if (!isRequired && map == null) {
            return true;
        }
     if (requiredSize != null && map.size() != requiredSize) {
         return false;
     }
    if (shapeSchemas != null) {
        for (Map.Entry<String, BaseSchema<String>> entry : shapeSchemas.entrySet()) {
            String key = entry.getKey();
            BaseSchema<String> fieldSchema = entry.getValue();

            Object objValue = map.get(key);
            String strValue = null;

            if (objValue instanceof String) {
                strValue = (String) objValue;
            } else if (objValue != null) {
                return false;
            }
            if (!fieldSchema.isValid(strValue)) {
                return false;
            }
        }
    }
    return true;
    }
}
