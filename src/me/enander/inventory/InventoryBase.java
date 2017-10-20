package me.enander.inventory;

import me.enander.ChatColor;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

public class InventoryBase {


    /** Builder for this kind of inventory. */
    private Inventory.Builder builder;

    /**  The resulting {@link Inventory} compiled from this class. */
    private Inventory inventory;

    /** Plugin object for building inventories **/
    private ChatColor plugin;

    public InventoryBase(int size, Text title, String pluginID)
    {
        this.plugin = ChatColor.instance;
        this.builder = Inventory.builder()
                .property(InventoryTitle.PROPERTY_NAME, InventoryTitle.of(title))
                .property(InventoryDimension.PROPERTY_NAME, InventoryDimension.of(9, size));

    }

    /**
     * Retrieves a copy of the current inventory builder.
     * Typically used before running usage of {@link #buildInventory(PluginContainer)}
     * to help apply new properties to the viewed inventory
     *
     * @return A {@link Inventory.Builder} reference to the current inventory build
     */
    public Inventory.Builder getInventoryBuilder()
    {
        return this.builder;
    }

    /**
     * Forges a Sponge Inventory, if not already created. If the inventory is an {@link InventoryMenu}
     * Starts by composing all registered item mappings to their assigned slots,
     * then proceeds to return the updated inventory.
     *
     * @return An {@link Inventory} with all icons sorted
     */
    public Inventory getInventory()
    {
        if (this.inventory == null)
        {
            this.inventory = buildInventory(Sponge.getPluginManager().getPlugin("chatcolor").orElseThrow(() ->
                    new IllegalArgumentException("Invalid plugin provided for inventory")));
        }
        return this.inventory;
    }

    /**
     * For each and every display icon, register their click events if they have any,
     * then proceed to establish the inventory. From there, we place each icon in their
     * assigned slots.
     */
    protected Inventory buildInventory(PluginContainer plugin) {
        return this.builder.build(plugin);
    }

}
