package addon.brainsynder.griefprevention.config;

import java.util.HashMap;
import java.util.Map;

public class Options {
    private static final Map<String, ConfigOption> options;

    public static final ConfigOption<Boolean> SPAWN_UNCLAIMED;
    public static final ConfigOption<Boolean> SPAWN_ADMIN_CLAIMS;
    public static final ConfigOption<Boolean> SPAWN_PERSONAL_CLAIMS;
    public static final ConfigOption<Boolean> SPAWN_TRUSTED_CLAIMS;

    public static final ConfigOption<Boolean> MOVE_UNCLAIMED;
    public static final ConfigOption<Boolean> MOVE_ADMIN_CLAIMS;
    public static final ConfigOption<Boolean> MOVE_PERSONAL_CLAIMS;
    public static final ConfigOption<Boolean> MOVE_TRUSTED_CLAIMS;

    public static final ConfigOption<Boolean> RIDE_UNCLAIMED;
    public static final ConfigOption<Boolean> RIDE_ADMIN_CLAIMS;
    public static final ConfigOption<Boolean> RIDE_PERSONAL_CLAIMS;
    public static final ConfigOption<Boolean> RIDE_TRUSTED_CLAIMS;

    public static final ConfigOption<Boolean> MOUNT_UNCLAIMED;
    public static final ConfigOption<Boolean> MOUNT_ADMIN_CLAIMS;
    public static final ConfigOption<Boolean> MOUNT_PERSONAL_CLAIMS;
    public static final ConfigOption<Boolean> MOUNT_TRUSTED_CLAIMS;

    static {
        options = new HashMap<>();

        SPAWN_UNCLAIMED = createOption("checks.spawning.unclaimed-land", true,
                "Should pets be allowed to spawn in unclaimed lands?");
        SPAWN_ADMIN_CLAIMS = createOption("checks.spawning.admin-claims", true,
                "Should pets be allowed to spawn in admin claims?");
        SPAWN_PERSONAL_CLAIMS = createOption("checks.spawning.personal-claims", true,
                "Should players be allowed to spawn pets in their claims?");
        SPAWN_TRUSTED_CLAIMS = createOption("checks.spawning.trusted-claims", true,
                "Should players be allowed to spawn pets in claims they are trusted to?");

        MOVE_UNCLAIMED = createOption("checks.moving.unclaimed-land", true,
                "Should pets be allowed to move in unclaimed lands?");
        MOVE_ADMIN_CLAIMS = createOption("checks.moving.admin-claims", true,
                "Should pets be allowed to move in admin claims?");
        MOVE_PERSONAL_CLAIMS = createOption("checks.moving.personal-claims", true,
                "Should pets be allowed to move in their summoners claim?");
        MOVE_TRUSTED_CLAIMS = createOption("checks.moving.trusted-claims", true,
                "Should pets be allowed to move in claims their summoner is trusted on?");

        RIDE_UNCLAIMED = createOption("checks.riding.unclaimed-land", true,
                "Should players be allowed to ride their pets in unclaimed lands?");
        RIDE_ADMIN_CLAIMS = createOption("checks.riding.admin-claims", true,
                "Should players be allowed to ride their pets in admin claims?");
        RIDE_PERSONAL_CLAIMS = createOption("checks.riding.personal-claims", true,
                "Should players be allowed to ride their pets in their claims?");
        RIDE_TRUSTED_CLAIMS = createOption("checks.riding.trusted-claims", true,
                "Should players be allowed to ride their pets in claims they are trusted to?");

        MOUNT_UNCLAIMED = createOption("checks.mounting.unclaimed-land", true,
                "Should players be allowed to mount their pets in unclaimed lands?");
        MOUNT_ADMIN_CLAIMS = createOption("checks.mounting.admin-claims", true,
                "Should players be allowed to mount their pets in admin claims?");
        MOUNT_PERSONAL_CLAIMS = createOption("checks.mounting.personal-claims", true,
                "Should players be allowed to mount their pets in their claims?");
        MOUNT_TRUSTED_CLAIMS = createOption("checks.mounting.trusted-claims", true,
                "Should players be allowed to mount their pets in claims they are trusted to?");
    }






    public static <T> ConfigOption<T> createOption(String key, T value, String description) {
        ConfigOption<T> option = new ConfigOption<>(key, value, description);
        options.put(key, option);
        return (ConfigOption<T>) option;
    }

    public static Map<String, ConfigOption> getOptions() {
        return options;
    }
}
