package addon.brainsynder.griefprevention;

import addon.brainsynder.griefprevention.config.Options;
import com.google.common.collect.Lists;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import me.ryanhamshire.GriefPrevention.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.Plugin;
import simplepets.brainsynder.addon.AddonConfig;
import simplepets.brainsynder.addon.presets.RegionAddon;
import simplepets.brainsynder.api.Namespace;
import simplepets.brainsynder.api.plugin.SimplePets;
import simplepets.brainsynder.api.user.PetUser;
import simplepets.brainsynder.debug.DebugLevel;

import java.util.List;

@Namespace(namespace = "GriefPrevention")
public class GriefPreventionAddon extends RegionAddon {

    @Override
    public boolean shouldEnable() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("GriefPrevention");
        if (plugin == null) {
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "GriefPrevention wasn't found!");
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Please download it from: https://www.spigotmc.org/resources/1884/");
            return false;
        }
        return true;
    }

    @Override
    public double getVersion() {
        return 0.1;
    }

    @Override
    public String getAuthor() {
        return "brainsynder";
    }

    @Override
    public List<String> getDescription() {
        return Lists.newArrayList(
                "&7This addon links into",
                "&7GriefPrevention so you can",
                "&7stop specific pet events from",
                "&7occurring when on/off claims"
        );
    }

    @Override
    public void loadDefaults(AddonConfig config) {
        super.loadDefaults(config);
        Options.getOptions().forEach((key, option) -> {
            config.addDefault(key, option.getValue(), option.getDescription());
            option.setValue(config.get(key));
        });
    }

    @Override
    public boolean isSpawningAllowed(PetUser petUser, Location location) {
        PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(petUser.getOwnerUUID());
        Claim claim = GriefPrevention.instance.dataStore.getClaimAt(location, false, playerData.lastClaim);

        // TODO: There is no claim here
        if ((claim == null)) return Options.SPAWN_UNCLAIMED.getValue();

        // TODO: The claim is an admin claim
        if (claim.isAdminClaim()) return Options.SPAWN_ADMIN_CLAIMS.getValue();

        // TODO: Claim is owned by player
        if (claim.ownerID.equals(petUser.getOwnerUUID())) return Options.SPAWN_PERSONAL_CLAIMS.getValue();

        // TODO: Player is trusted in claim
        if (claim.managers.contains(petUser.getOwnerUUID().toString())) return Options.SPAWN_TRUSTED_CLAIMS.getValue();
        return true;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSpawn (CreatureSpawnEvent event) {
        // Had to add this because GriefPrevention blocked custom mobs from spawning °_°
        if (SimplePets.isPetEntity(event.getEntity()) && event.isCancelled()) event.setCancelled(false);
    }

    @Override
    public boolean isMovingAllowed(PetUser petUser, Location location) {
        PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(petUser.getOwnerUUID());
        Claim claim = GriefPrevention.instance.dataStore.getClaimAt(location, false, playerData.lastClaim);

        // TODO: There is no claim here
        if ((claim == null)) return Options.MOVE_UNCLAIMED.getValue();

        // TODO: The claim is an admin claim
        if (claim.isAdminClaim()) return Options.MOVE_ADMIN_CLAIMS.getValue();

        // TODO: Claim is owned by player
        if (claim.ownerID.equals(petUser.getOwnerUUID())) return Options.MOVE_PERSONAL_CLAIMS.getValue();

        // TODO: Player is trusted in claim
        if (claim.managers.contains(petUser.getOwnerUUID().toString())) return Options.MOVE_TRUSTED_CLAIMS.getValue();
        return true;
    }

    @Override
    public boolean isRidingAllowed(PetUser petUser, Location location) {
        PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(petUser.getOwnerUUID());
        Claim claim = GriefPrevention.instance.dataStore.getClaimAt(location, false, playerData.lastClaim);

        // TODO: There is no claim here
        if ((claim == null)) return Options.RIDE_UNCLAIMED.getValue();

        // TODO: The claim is an admin claim
        if (claim.isAdminClaim()) return Options.RIDE_ADMIN_CLAIMS.getValue();

        // TODO: Claim is owned by player
        if (claim.ownerID.equals(petUser.getOwnerUUID())) return Options.RIDE_PERSONAL_CLAIMS.getValue();

        // TODO: Player is trusted in claim
        if (claim.managers.contains(petUser.getOwnerUUID().toString())) return Options.RIDE_TRUSTED_CLAIMS.getValue();
        return true;
    }

    @Override
    public boolean isMountingAllowed(PetUser petUser, Location location) {
        PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(petUser.getOwnerUUID());
        Claim claim = GriefPrevention.instance.dataStore.getClaimAt(location, false, playerData.lastClaim);

        // TODO: There is no claim here
        if ((claim == null)) return Options.MOUNT_UNCLAIMED.getValue();

        // TODO: The claim is an admin claim
        if (claim.isAdminClaim()) return Options.MOUNT_ADMIN_CLAIMS.getValue();

        // TODO: Claim is owned by player
        if (claim.ownerID.equals(petUser.getOwnerUUID())) return Options.MOUNT_PERSONAL_CLAIMS.getValue();

        // TODO: Player is trusted in claim
        if (claim.managers.contains(petUser.getOwnerUUID().toString())) return Options.MOUNT_TRUSTED_CLAIMS.getValue();
        return true;
    }
}