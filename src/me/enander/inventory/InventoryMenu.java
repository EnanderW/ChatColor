package me.enander.inventory;

import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.property.SlotIndex;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

import javax.swing.border.Border;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InventoryMenu extends InventoryBase {

    /** A mapping from slot to icons. */
    private Map<Integer, InventoryIcon> icons;

    /** The size of the Inventory */
    private int size;

    public InventoryMenu(int size, Text title, String pluginID)
    {
        super(size, title, pluginID);
        this.icons = new HashMap<>();
        this.getInventoryBuilder()
                .of(InventoryArchetypes.MENU_GRID)
                .listener(ClickInventoryEvent.class, event -> event.setCancelled(true));
    }

    /**
     * Adds a {@link InventoryIcon} display to the Mapped table of icons for the UI.
     *
     * @param icon The icon we are planning to display
     */
    public void addIcon(InventoryIcon icon)
    {
        this.icons.put(icon.getSlot(), icon);
    }

    /**
     * Attempts to locate a registered icon in the current icon registry for the inventory
     *
     * @param slot The slot index of an icon
     * @return An Optional value, either with an icon or empty when the slot has a null icon
     */
    public Optional<InventoryIcon> getIcon(int slot)
    {
        return Optional.ofNullable(this.icons.get(slot));
    }

    /**
     * Retrieves a copy of all registered icons
     *
     * @return A mapping of all icons with their assigned slot index
     */
    public Map<Integer, InventoryIcon> getAllIcons()
    {
        return this.icons;
    }

    /**
     * Draws a border around the inventory, with the top and bottom of the interface
     * being completely drawn in, and sides with only the walls drawn.
     *
     * @param rows The number of rows to draw
     */

    /**
     * Attempts to ensure an item is within the drawn border,
     * if one were drawn at all.
     *
     * @param slot The slot to check against
     * @return True if within border or no border exists, false otherwise
     */

    /**
     * Like its counterpart, this method will only update the
     * specified slot positions, allowing for quicker operation
     * and less flicker within the UI itself
     * <p>
     * Note: Due to a limitation in the Sponge API, we can't dynamically attach
     * new listeners to slots on an update. If an item is to change in a
     * slot, the listener provided by that original icon will persist.
     * Really only use this setup if you are purely doing cosmetic changes,
     * or your click listeners are setup to dynamically detect the change
     * of the icon.
     *
     * @param slots The slot indexes to modify
     */
    public void updateContents(List<Integer> slots)
    {
        GridInventory gridInventory = this.getInventory().query(GridInventory.class);
        this.icons.forEach((index, inventoryIcon) ->
        {
            for (int sl : slots)
            {
                if (sl == index)
                {
                    Slot slot = gridInventory.getSlot(
                            SlotIndex.of(index))
                            .orElseThrow(() -> new IllegalArgumentException(
                                    "Invalid index: " + index));
                    slot.set(inventoryIcon.getDisplay());
                }
            }
        });
    }

    /**
     * With the case of an open inventory, we will update all the inventory contents
     * to their updated slot icons.
     * <p>
     * Note: Due to a limitation in the Sponge API, we can't dynamically attach
     * new listeners to slots on an update. If an item is to change in a
     * slot, the listener provided by that original icon will persist.
     * Really only use this setup if you are purely doing cosmetic changes,
     * or your click listeners are setup to dynamically detect the change
     * of the icon.
     */
    public void updateContents()
    {
        GridInventory gridInventory = this.getInventory().query(GridInventory.class);
        gridInventory.clear();
        this.icons.forEach((index, inventoryIcon) ->
        {
            Slot slot = gridInventory.getSlot(SlotIndex.of(index))
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Invalid index: " + index));
            slot.set(inventoryIcon.getDisplay());
        });
    }

    /**
     * For each and every display icon, register their click events if they have any,
     * then proceed to establish the inventory. From there, we place each icon in their
     * assigned slots.
     */
    @Override
    protected Inventory buildInventory(PluginContainer plugin)
    {
        this.icons.values()
                .forEach(button ->
                        button.getListeners().forEach((clazz, listener) ->
                                this.getInventoryBuilder().listener(clazz, listener)));
        Inventory inventory = this.getInventoryBuilder().build(plugin);

        GridInventory gridInventory = inventory.query(GridInventory.class);
        this.icons.forEach((index, inventoryIcon) ->
        {
            Slot slot = gridInventory.getSlot(SlotIndex.of(index))
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Invalid index: " + index));
            slot.set(inventoryIcon.getDisplay());
        });
        return inventory;
    }

}
