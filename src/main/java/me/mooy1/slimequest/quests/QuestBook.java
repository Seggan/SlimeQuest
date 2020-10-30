package me.mooy1.slimequest.quests;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import me.mooy1.slimequest.SlimeQuest;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class QuestBook extends SlimefunItem implements Listener {

    public static final SlimefunItemStack QUESTBOOK = new SlimefunItemStack("QUESTBOOK", Material.ENCHANTED_BOOK, "&6Quest Book", "&7Right-Click to open");
    public static final Category SLIMEQUEST = new Category(new NamespacedKey(SlimeQuest.getInstance(), "slimequest"), new CustomItem(Material.ENCHANTED_BOOK, "&aSlime&6Quest"), 0);

    public QuestBook() {
        super(SLIMEQUEST, QUESTBOOK, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] { null, null, null, null, new ItemStack(Material.DIRT), null, null, null, null });
    }

    @EventHandler
    public void onRightClick(PlayerRightClickEvent e) {
        SlimefunItem slimefunItem = SlimefunItem.getByItem(e.getItem());

        if (slimefunItem != null && slimefunItem.getItem() == QUESTBOOK) {
            //open quests
        }
    }
}