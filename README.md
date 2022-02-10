# GriefPrevention
This is an addon for the SimplePets v5 plugin.

### Requirements:
- [GriefPrevention](https://www.spigotmc.org/resources/1884/) Plugin `(At least v16.17.1)`

### Default configuration (Located in `plugins/SimplePets/Addons/config/GriefPrevention.yml`)
```yaml
# What should the bypass permission be set to?
bypass-permission: pet.griefprevention.bypass

checks:
  spawning:
    # Should the addon check when a pet is spawned?
    enabled: true
    # This message is only visible when you hover over the 'pet failed to spawn' message
    # You can make this blank or 'null' if you want no message
    reason: '&cYour pet is not able to be spawned in this area'
    # Should players be allowed to spawn pets in claims they are trusted to?
    trusted-claims: true
    # Should pets be allowed to spawn in admin claims?
    admin-claims: true
    # Should pets be allowed to spawn in unclaimed lands?
    unclaimed-land: true
    # Should players be allowed to spawn pets in their claims?
    personal-claims: true
    
  mounting:
    # Should the addon check when the player mounts the pet?
    enabled: true
    # Should the pet be removed or should it just be canceled?
    remove-pet: true
    # Should players be allowed to mount their pets in their claims?
    personal-claims: true
    # Should players be allowed to mount their pets in unclaimed lands?
    unclaimed-land: true
    # Should players be allowed to mount their pets in admin claims?
    admin-claims: true
    # Should players be allowed to mount their pets in claims they are trusted to?
    trusted-claims: true
    
  moving:
    # Should the addon check when a pet moves?
    enabled: true
    # Should the pet be removed or should it just be canceled?
    remove-pet: true
    # Should pets be allowed to move in unclaimed lands?
    unclaimed-land: true
    # Should pets be allowed to move in admin claims?
    admin-claims: true
    # Should pets be allowed to move in their summoners claim?
    personal-claims: true
    # Should pets be allowed to move in claims their summoner is trusted on?
    trusted-claims: true
    
  riding:
    # Should the addon check when the pets owner is riding it?
    enabled: true
    # Should the pet be removed or should it just be canceled?
    remove-pet: true
    # Should the player be dismounted (if remove-pet is set to true this is ignored)?
    dismount: true
    # Should players be allowed to ride their pets in unclaimed lands?
    unclaimed-land: true
    # Should players be allowed to ride their pets in claims they are trusted to?
    trusted-claims: true
    # Should players be allowed to ride their pets in admin claims?
    admin-claims: true
    # Should players be allowed to ride their pets in their claims?
    personal-claims: true
```