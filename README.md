# Break4Reward
Simple plugin to run commands when a player breaks a block

Config:
```
Required-GameMode: SURVIVAL
Required-Tool:
  - DIAMOND_PICKAXE
  - NETHERITE_PICKAXE
  - GOLDEN_PICKAXE
  - IRON_PICKAXE
  - STONE_PICKAXE
  - WOODEN_PICKAXE
Rewards:
  STONE:
    Message: "&6You broke a stone block"
    Commands:
      - "say {player} broke a stone block"
```

```
Required-GameMode: SURVIVAL
```
This section set which gamemode the player has to be in for the commands and message to be run.

Possible GameModes
```
SURVIVAL, CREATIVE, ADVENTURE, NONE
```

If you want all gamemodes to work simply use NONE as the required gamemode option

```
Required-GameMode: NONE
```

```
Required-Tool:
  - DIAMOND_PICKAXE
  - NETHERITE_PICKAXE
  - GOLDEN_PICKAXE
  - IRON_PICKAXE
  - STONE_PICKAXE
  - WOODEN_PICKAXE
```

This section is a list of tools the player can use for the commands and message to run, if they do not use one of these tools the commands and message will not be run.

If you want them to be able to use anything simply delete this section out of the config.

```
Rewards:
  STONE:
    Message: "&6You broke a stone block"
    Commands:
      - "say {player} broke a stone block"
```

This is the section which you use to define what material will run what commands and message.

Each section starts with a key ```STONE``` in this case which is the material they have to break for it to run.

You can add your own by simply adding a new material like
```
Rewards:
  STONE:
    Message: "&6You broke a stone block"
    Commands:
      - "say {player} broke a stone block"
  GRASS_BLOCK:
    Message: "&6You broke a grass block"
    Commands: 
      - "say {player} broke a grass block"
```

You can add as many as you want, if you do not want to send them a message simply remove ```Message:```
```
Rewards:
  STONE:
    Commands:
      - "say {player} broke a stone block"
  GRASS_BLOCK:
    Commands: 
      - "say {player} broke a grass block"
```

Commands:
```
/break4reward reload
```

This command reloads the config and all the rewards.

Permissions:
```
break4reward.command.reload
```

This controls who is allowed to use /break4reward reload.
