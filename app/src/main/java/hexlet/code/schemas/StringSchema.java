package hexlet.code.schemas;

public class StringSchema {
    private boolean isRequired = false;
    private Integer minLength = null;
    private String containsStr = null;

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }
    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }
    public StringSchema contains(String substring) {
        this.containsStr = substring;
        return this;
    }
    public boolean isValid(String str) {
        if (isRequired) {
            if (str == null || str.isEmpty()) {
                return false;
            }
        } else {
            if (str == null) {
                return true;
            }
        }
        if (minLength != null && str.length() < minLength) {
            return false;
        }
        if (containsStr != null && !str.contains(containsStr)) {
            return false;
        }
        return true;
    }
 }
