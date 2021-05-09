package io.github.thebusybiscuit.slimefun4.api.events;

import javax.annotation.Nonnull;

import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.enchanting.AutoEnchanter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * An {@link Event} that is called whenever an {@link AutoEnchanter} is trying to enchant
 * an {@link ItemStack}.
 *
 * @author WalshyDev
 *
 * @see AutoDisenchantEvent
 */
public class AutoEnchantEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final ItemStack item;
    private final ItemStack enchantBook;
    private final AutoEnchanter enchanter;
    private boolean cancelled;

    public AutoEnchantEvent(@Nonnull ItemStack item, @Nonnull ItemStack enchantBook, @Nonnull AutoEnchanter enchanter) {
        super(true);

        this.item = item;
        this.enchantBook = enchantBook;
        this.enchanter = enchanter;
    }

    /**
     * This returns the {@link ItemStack} that is being enchanted.
     *
     * @return The {@link ItemStack} that is being enchanted
     */
    @Nonnull
    public ItemStack getItem() {
        return item;
    }

    /**
     * This returns the {@link ItemStack} that is being used enchant book
     *
     * @return The {@link ItemStack} that is being used enchant book
     */
    @Nonnull
    public ItemStack getEnchantBook() {
        return enchantBook;
    }

    /**
     * This returns the {@link AutoEnchanter} that is enchanting item.
     *
     * @return The {@link AutoEnchanter} that is enchanting item
     */
    @Nonnull
    public AutoEnchanter getEnchanter() {
        return enchanter;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Nonnull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Nonnull
    @Override
    public HandlerList getHandlers() {
        return getHandlerList();
    }

}
