package hexlet.code.schemas;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>>{
    private Integer requiredSize = null;

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }
    public MapSchema sizeof(int size) {
        this.requiredSize = size;
        return this;
    }

    @Override
    public boolean isValid(Map<?, ?> map) {
        if (isRequired) {
            if (map == null) {
                return false;
            }
        } else {
            if (map == null) {
                return true;
            }
        }
        if (requiredSize != null && map.size() != requiredSize) {
            return false;
        }
        return true;
    }
}
