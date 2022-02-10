package addon.brainsynder.griefprevention.config;

public class ConfigOption<T> {
    private T value;
    private final String key;
    private final String description;

    ConfigOption(String key, T value, String description) {
        this.key = key;
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getKey() {
        return key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}