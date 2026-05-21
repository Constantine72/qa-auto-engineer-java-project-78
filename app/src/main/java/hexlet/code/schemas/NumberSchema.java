package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    private boolean isPositive = false;
    private Integer minRange = null;
    private Integer maxRange = null;

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }
public NumberSchema positive() {
        this.isPositive = true;
        return this;
}
public NumberSchema range(int min, int max) {
        this.minRange = min;
        this.maxRange = max;
        return this;
}
@Override
    public boolean isValid(Integer num) {
        if (isRequired) {
            if (num == null) {
                return false;
            }
        } else {
            if (num == null) {
                return true;
            }
        }
        if (isPositive && num <= 0) {
            return false;
        }
        if (minRange != null && maxRange != null) {
            if (num < minRange || num > maxRange) {
                return false;
            }
        }
        return true;
}
}
