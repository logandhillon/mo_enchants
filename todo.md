# To Do

|     | Legend                                 |
|-----|----------------------------------------|
| ✅   | Developed, passed tests.               |
| ❎   | Developed, failed tests, awaiting fix. |
| 🛠️ | Partially developed.                   |
| 🚩  | Developed, not tested.                 |
| 🚫  | Developed, scrapped, removed.          |
| ⛔   | Not developed, scrapped.               |
| 🔰  | Not developed, not mandatory.          |

### v1.5

1. ✅ Replace all uses of `getItemEnchantmentLevel()` with `getTagEnchantmentLevel()` `Deprecated`
2. ✅ Move event listeners to `Events.java`
3. ✅ Optimize all helper classes, make more readable
4. ✅ Go through all enchantment classes, confirm everything is correct
5. ✅ Move `TotemlikeAnimationMainhandProcedure` and `TotemlikeAnimationOffhandProcedure` into its own usages
6. ✅ Remove all `MCreator` traces (e.g. comments)
7. ✅ Optimize `init` classes
8. ✅ Put cooldown on `Panic` enchantment (8s for I, 5s, for II, maybe)
9. ✅ Remove unnecessary `@Nullable Event` parameter
10. ✅ Fix `Angel's Blessing` enchantment animation
11. ✅ Test version and make sure it is ready for distribution
12. ✅ `Panic` has a bug: if there is constant damage, game will crash (server tick loop) **Possible fixes:**
    1. ✅ Move `Panic` event call to `onEntityAttacked` from `onPlayerTick`
13. ✅ `Curse of Freezing` and `Curse of Boiling` don't properly check for biomes
14. ✅ Make `Density` increase gravity
15. 🚫 Migrate `Density`, `Growth`, `Night Vision`, `Reach`, `Swiftness` and `Weightless` UUID's to `randomUUID()` from
    hardcoded UUID
16. ✅ Migrate `✅ Density`, `✅Growth`, `✅ Reach`, `✅ Swiftness` and `✅ Weightless` UUID get to`getId()` from new UUID
    instance
17. ✅ Lower the chances of `Rock Mending` increasing the durability

### v1.6

1. `Water Protection`: Damage protection from drowning, tridents, and the Aqua Slash enchantment
2. Move `Aqua Slash` enchantment to use entity tags, instead of hardcode
3. Add more nether mobs into `Aqua Slash` damage bonus (e.g. Strider)
4. Enchantment Descriptions support

### v1.6 or v1.7

1. Add `@bcat's` `Reeling` enchantment
2. Add `@GGGamesXDlol's` `Telekinesis` enchantment
3. Add `Replenish` enchantment (see `changelog.md`)
4. Enchantment Descriptions support
