package me.enander.commands;

import me.enander.ChatColor;
import me.enander.inventory.InventoryIcon;
import me.enander.inventory.InventoryMenu;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.List;


public class ChatColorCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        InventoryMenu menu = new InventoryMenu(2, Text.of("Chat Color"), "chatcolor");

        List<Text> lore = new ArrayList<>();
        lore.add(Text.of("§7Rookies can use this!"));
        lore.add(Text.of("§aClick to select color!"));
        InventoryIcon purple = new InventoryIcon(0, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.PURPLE).add(Keys.DISPLAY_NAME, Text.of("§5Purple")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon green = new InventoryIcon(1, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.GREEN).add(Keys.DISPLAY_NAME, Text.of("§2Green")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon cyan = new InventoryIcon(2, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.CYAN).add(Keys.DISPLAY_NAME, Text.of("§3Cyan")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon gold = new InventoryIcon(3, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.ORANGE).add(Keys.DISPLAY_NAME, Text.of("§6Gold")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon blue = new InventoryIcon(4, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.BLUE).add(Keys.DISPLAY_NAME, Text.of("§9Blue")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon lime = new InventoryIcon(5, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.LIME).add(Keys.DISPLAY_NAME, Text.of("§aLime")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon lightblue = new InventoryIcon(6, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.LIGHT_BLUE).add(Keys.DISPLAY_NAME, Text.of("§bLight Blue")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon pink = new InventoryIcon(7, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.PINK).add(Keys.DISPLAY_NAME, Text.of("§dPink")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon yellow = new InventoryIcon(8, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.YELLOW).add(Keys.DISPLAY_NAME, Text.of("§eYellow")).add(Keys.ITEM_LORE, lore).build());

        purple.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.purple")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§5");
                player.sendMessage(Text.of("Your chat color is now §5purple"));
            }
        });
        green.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.green")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§2");
                player.sendMessage(Text.of("Your chat color is now §2green"));
            }
        });
        cyan.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.cyan")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§3");
                player.sendMessage(Text.of("Your chat color is now §3cyan"));
            }
        });
        gold.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.gold")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§6");
                player.sendMessage(Text.of("Your chat color is now §6gold"));
            }
        });
        blue.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.blue")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§9");
                player.sendMessage(Text.of("Your chat color is now §9blue"));
            }
        });
        lime.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.lime")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§a");
                player.sendMessage(Text.of("Your chat color is now §alime"));
            }
        });
        lightblue.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.lightblue")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§b");
                player.sendMessage(Text.of("Your chat color is now §blight blue"));
            }
        });
        pink.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.pink")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§d");
                player.sendMessage(Text.of("Your chat color is now §dpink"));
            }
        });
        yellow.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.yellow")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§e");
                player.sendMessage(Text.of("Your chat color is now §eyellow"));
            }
        });

        menu.addIcon(purple);
        menu.addIcon(green);
        menu.addIcon(cyan);
        menu.addIcon(gold);
        menu.addIcon(blue);
        menu.addIcon(lightblue);
        menu.addIcon(lime);
        menu.addIcon(pink);
        menu.addIcon(yellow);

        lore.clear();
        lore.add(Text.of("§6Champions can use this!"));
        lore.add(Text.of("§aClick to select color!"));

        InventoryIcon boldpurple = new InventoryIcon(9, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.PURPLE).add(Keys.DISPLAY_NAME, Text.of("§5§lPurple")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon boldgreen = new InventoryIcon(10, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.GREEN).add(Keys.DISPLAY_NAME, Text.of("§2§lGreen")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon boldcyan = new InventoryIcon(11, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.CYAN).add(Keys.DISPLAY_NAME, Text.of("§3§lCyan")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon boldgold = new InventoryIcon(12, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.ORANGE).add(Keys.DISPLAY_NAME, Text.of("§6§lGold")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon boldblue = new InventoryIcon(13, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.BLUE).add(Keys.DISPLAY_NAME, Text.of("§9§lBlue")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon boldlime = new InventoryIcon(14, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.LIME).add(Keys.DISPLAY_NAME, Text.of("§a§lLime")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon boldlightblue = new InventoryIcon(15, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.LIGHT_BLUE).add(Keys.DISPLAY_NAME, Text.of("§b§lLight Blue")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon boldpink = new InventoryIcon(16, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.PINK).add(Keys.DISPLAY_NAME, Text.of("§d§lPink")).add(Keys.ITEM_LORE, lore).build());
        InventoryIcon boldyellow = new InventoryIcon(17, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.YELLOW).add(Keys.DISPLAY_NAME, Text.of("§e§lYellow")).add(Keys.ITEM_LORE, lore).build());

        boldpurple.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.boldpurple")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§5§l");
                player.sendMessage(Text.of("Your chat color is now §5§lpurple"));
            }
        });
        boldgreen.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.boldgreen")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§2§l");
                player.sendMessage(Text.of("Your chat color is now §2§lgreen"));
            }
        });
        boldcyan.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.boldcyan")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§3§l");
                player.sendMessage(Text.of("Your chat color is now §3§lcyan"));
            }
        });
        boldgold.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.boldgold")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§6§l");
                player.sendMessage(Text.of("Your chat color is now §6§lgold"));
            }
        });
        boldblue.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.boldblue")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§9§l");
                player.sendMessage(Text.of("Your chat color is now §9§lblue"));
            }
        });
        boldlime.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.boldlime")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§a§l");
                player.sendMessage(Text.of("Your chat color is now §a§llime"));
            }
        });
        boldlightblue.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.boldlightblue")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§b§l");
                player.sendMessage(Text.of("Your chat color is now §b§llight blue"));
            }
        });
        boldpink.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.boldpink")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§d§l");
                player.sendMessage(Text.of("Your chat color is now §d§lpink"));
            }
        });
        boldyellow.addListener(ClickInventoryEvent.Primary.class, event -> {
            if (!event.getCause().first(Player.class).isPresent()) {
                return;
            }

            Player player = event.getCause().first(Player.class).get();
            if (player.hasPermission("pscolor.boldyellow")) {
                ChatColor.instance.colors.put(player.getUniqueId(), "§e§l");
                player.sendMessage(Text.of("Your chat color is now §e§lyellow"));
            }
        });

        menu.addIcon(boldpurple);
        menu.addIcon(boldgreen);
        menu.addIcon(boldcyan);
        menu.addIcon(boldgold);
        menu.addIcon(boldblue);
        menu.addIcon(boldlightblue);
        menu.addIcon(boldlime);
        menu.addIcon(boldpink);
        menu.addIcon(boldyellow);

        if(src instanceof Player) {
            Player player = (Player) src;
            player.openInventory(menu.getInventory(), Cause.builder().named(NamedCause.simulated(player)).build());
        }

        return CommandResult.success();
    }
}
