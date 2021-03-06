package io.github.mooy1.slimequest.command.subcommands;

import io.github.mooy1.slimequest.SlimeQuest;
import io.github.mooy1.slimequest.command.QuestCommand;
import io.github.mooy1.slimequest.command.SubCommand;
import io.github.mooy1.slimequest.implementation.items.QuestBook;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class Book extends SubCommand {
    public Book(SlimeQuest plugin, QuestCommand cmd) {
        super(plugin, cmd, "book", "gives you a quest book", false);
    }

    @Override
    public void onExecute(@Nonnull CommandSender sender, @Nonnull String[] args) {
        if (!(sender instanceof Player)) {
            cmd.sendPlayerOnly(sender);
            return;
        }
        Player p = (Player) sender;

        Inventory inv = p.getInventory();
        if (Arrays.asList(inv.getStorageContents()).contains(null)) {

            inv.addItem(QuestBook.QUESTBOOK);

        }
    }
}