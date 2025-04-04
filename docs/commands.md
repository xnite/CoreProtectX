# Commands
---
You can access the following commands by using `/cox`.
___

## Command Overview

| Command | Description |
| --- | --- |
| [/cox help](#co-help) | Display a list of commands |
| [/cox inspect](#co-inspect) | Toggle the inspector |
| [/cox lookup](#co-lookup) | Lookup block data |
| [/cox rollback](#co-rollback) | Rollback block data |
| [/cox restore](#co-restore) | Restore block data |
| [/cox purge](#co-purge) | Delete old block data |
| [/cox reload](#co-reload) | Reload the configuration file |
| [/cox status](#co-status) | View the plugin status |
| [/cox consumer](#co-consumer) | Toggle consumer processing |

### Alias Commands

| Command | Description |
| --- | --- |
| /cox near | Performs a lookup with a radius of 5 |
| /cox undo | Revert a rollback/restore via the opposite action|

---

## Command Details

*Detailed command information is listed below.*

### /cox help
Display a list of commands in-game.
___

### /cox inspect
Enable the inspector. Type the command again to disable it. You can also use just "/cox i".
___

### /cox lookup
Perform a lookup. Nearly all of the parameters are optional.

| Command | Parameters |
| --- | --- |
| /cox lookup | `u:<user> t:<time> r:<radius> a:<action> i:<include> e:<exclude>` |
| /cox l | *`/cox lookup <params>`* |

#### Parameters
| Parameter | Description |
| --- | --- |
| [`u:<user>`](#uuser) | Specify the user(s) to lookup. |
| [`t:<time>`](#ttime) | Specify the amount of time to lookup. |
| [`r:<radius>`](#rradius) | Specify a radius area to limit the lookup to. |
| [`a:<action>`](#aaction) | Restrict the lookup to a certain action. |
| [`i:<include>`](#iinclude) | Include specific blocks/entities in the lookup. |
| [`e:<exclude>`](#eexclude) | Exclude blocks/entities from the lookup. |
| [`#<hashtag>`](#hashtag) | Add a hashtag to perform additional actions. |

#### Pagination

If multiple pages are returned, use the command `/cox lookup <page>` to switch pages.  
To change the number of lines displayed on a page, use `/cox lookup <page>:<lines>`. 

> *For example, `/cox l 1:10` will return 10 lines of data, starting at the first page.*

---

### /cox rollback
Perform a rollback. Uses the same [parameters](#parameters) as /cox lookup.  
*Rollbacks can be used to revert player actions.*

| Command | Parameters |
| --- | --- |
| /cox rollback | `u:<user> t:<time> r:<radius> a:<action> i:<include> e:<exclude>` |
| /cox rb | *`/cox rollback <params>`* |

---

### /cox restore
Perform a restore. Uses the same [parameters](#parameters) as /cox lookup.  
*Restoring can be used to undo rollbacks or to restore player actions.*

| Command | Parameters |
| --- | --- |
| /cox restore | `u:<user> t:<time> r:<radius> a:<action> i:<include> e:<exclude>` |
| /cox rs | *`/cox restore <params>`* |

---

### /cox purge
Purge old block data. Useful for freeing up space on your HDD if you don't need the older data.

| Command | Parameters |
| --- | --- |
| /cox purge | `t:<time> r:<world> i:<include>` |

For example, `/cox purge t:30d` will delete all data older than one month, and only keep the last 30 days of data.

> If used in-game, only data older than 30 days can be purged.  
> If used from the console, only data older than 24 hours can be purged.

**Purging Worlds**  
You can optionally specify a world in CoreProtect v19+.  
For example, `/cox purge t:30d r:#world_nether` will delete all data older than one month in the Nether, without removing data in any other worlds.

**Purging Blocks**  
You can optionally specify block types in CoreProtect v23+.  
For example, `/cox purge t:30d i:stone,dirt` will delete all stone and dirt data older than one month, without removing other block data.

**MySQL Optimization**  
In CoreProtect v2.15+, adding "#optimize" to the end of the command (e.g. `/cox purge t:30d #optimize`) will also optimize your tables and reclaim disk space.
This option is only available when using MySQL, as SQLite purges do this by default.

*Please note adding the #optimize option will significantly slow down your purge, and is generally unnecessary.*

___

### /cox reload
Reloads the configuration file.
___

### /cox status
Displays the plugin status and version information.
___

### /cox consumer
Console command to pause or resume consumer queue processing.
___


## Parameter Details

### `u:<user>`

*You can specify a single user or multiple users.* 

* Example: `u:Notch`
* Example: `u:Notch,Intelli`
* Example: `u:#fire,#tnt,#creeper,#explosion`

---

### `t:<time>`

*You can specify weeks, days, hours, minutes, and seconds.*  
*Time amounts can be combined, and decimals may be used.*

* Example: `t:2w,5d,7h,2m,10s`
* Example: `t:5d2h`
* Example: `t:1h-2h` *(between one to two hours)*
* Example: `t:2.50h` *(two and a half hours)*

---

### `r:<radius>`

*A numeric radius targets within that many blocks of your player location.*

* Example: `r:10` *(target within 10 blocks of your location)*
* Example: `r:#world_the_end` *(target a specific world)*
* Example: `r:#global` *(target the entire server)*
* Example: `r:#worldedit` or `r:#we` *(target a WorldEdit selection)*

---

### `a:<action>`

*Restrict the command to a specific action*

* Example: `a:+block` *(only include placed blocks)*

#### Actions
| Action | Description |
| --- | --- |
| `a:block` | blocks placed/broken |
| `a:+block` | blocks placed |
| `a:-block` | blocks broken |
| `a:chat` | messages sent in chat |
| `a:click` | player interactions |
| `a:command` | commands used |
| `a:container` | items taken from or put in chests |
| `a:+container` | items put in chests |
| `a:-container` | items taken from chests |
| `a:inventory` | items added or removed from player inventories |
| `a:+inventory` | items added to player inventories |
| `a:-inventory` | items removed from player inventories |
| `a:item` | items dropped, thrown, picked up, deposited, or withdrawn by players |
| `a:+item` | items picked up or withdrawn by players |
| `a:-item` | items dropped, thrown, or deposited by players |
| `a:kill` | mobs/animals killed |
| `a:session` | player logins/logouts |
| `a:+session` | player logins |
| `a:-session` | player logouts |
| `a:sign` | messages written on signs |
| `a:username` | username changes |

---

### `i:<include>`

*Can be used to specify a block/item/entity.* 

* Example: `i:stone` *(only include stone)*
* Example: `i:stone,oak_wood,bedrock` *(specify multiple blocks)*

> You can find a list of block names at [https://coreprotect.net/wiki-blocks](https://coreprotect.net/wiki-blocks).  
> You can find a list of entity names at [https://coreprotect.net/wiki-entities](https://coreprotect.net/wiki-entities).

---

### `e:<exclude>`

*Can be used to exclude a block/item/entity/user.*

* Example: `e:tnt` *(exclude TNT)*

---

### `#<hashtag>`

Add a hashtag to the end of your command to perform additional actions.

* Example: `#preview` *(perform a rollback preview)*

#### Hashtags
| Hashtag | Effect |
| --- | --- |
| `#preview` | Preview a rollback/restore |
| `#count` | Return the number of rows found in a lookup query |
| `#verbose` | Display additional information during a rollback/restore |
| `#silent` | Display minimal information during a rollback/restore |

___

## Example Commands

### Example Rollback Commands

By default, if no radius is specified, a radius of 10 will be applied, restricting the rollback to within 10 blocks of you. Use `r:#global` to do a global rollback.

* `/cox rollback Notch t:1h`  
  *(rollback Notch 1 hour (with default radius of 10))*
* `/cox rollback u:Notch,Intelli t:1h #preview`  
  *(PREVIEW rolling back both Notch & Intelli 1 hour (with default radius of 10))*
* `/cox rollback u:Notch t:23h17m`  
  *(rollback Notch 23 hours and 17 minutes (with default radius of 10))*
* `/cox rollback u:Notch t:1h i:stone`  
  *(rollback ONLY stone placed/broken by Notch within the last hour (with default radius of 10))*
* `/cox rollback u:Notch t:1h i:stone a:-block`  
  *(rollback ONLY stone BROKEN by Notch within the last hour (with default radius of 10))*
* `/cox rollback u:Notch t:1h r:#global e:stone,dirt`  
  *(rollback EVERYTHING Notch did in the last hour EXCEPT for stone and dirt placed/broken)*
* `/cox rollback u:Notch t:1h r:20`  
  *(rollback griefing Notch did in the last hour that is within 20 blocks of you)*
* `/cox rollback u:Notch t:1h r:#nether`  
  *(rollback griefing Notch did in the last hour ONLY in the Nether)*
* `/cox rollback u:Notch t:5m a:inventory`  
  *(rollback inventory transactions by Notch in the last 5 minutes)*
* `/cox rollback t:15m r:30`  
  *(rollback everything done in the last 15 minutes by anyone within 30 blocks of you)*
* `/cox rollback t:15m r:#worldedit`  
  *(rollback everything done in the last 15 minutes in a WorldEdit selection)*

---

### Example Lookup Commands

Lookup commands are generally the same as rollback commands. The primary difference is that a default radius is not applied to lookups, meaning all lookup commands do a global search by default.

* `/cox lookup i:diamond_ore t:1h a:-block`  
  *(lookup all diamond ore mined in the last hour)*
* `/cox lookup u:Notch t:30m a:chat`  
  *(lookup chat messages sent by Notch in the last 30 minutes)*
* `/cox lookup u:Notch t:3d a:inventory`  
  *(lookup inventory transactions by Notch in the last 3 days)*
* `/cox lookup u:Notch a:login`  
  *(lookup all logins ever done by Notch)*
* `/cox lookup u:Notch a:login`  
  *(lookup all logins ever done by Notch)*
* `/cox lookup u:Notch a:username`  
  *(lookup previous usernames used by Notch)*

___
