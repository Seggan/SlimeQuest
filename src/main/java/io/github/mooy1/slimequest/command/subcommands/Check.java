package io.github.mooy1.slimequest.command.subcommands;

import io.github.mooy1.slimequest.SlimeQuest;
import io.github.mooy1.slimequest.command.QuestCommand;
import io.github.mooy1.slimequest.command.SubCommand;
import io.github.mooy1.slimequest.implementation.data.QuestData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check extends SubCommand {
    public Check(SlimeQuest plugin, QuestCommand cmd) {
        super(plugin, cmd, "check", "checks a player's quest progress", true);
    }

    @Override
    public void onExecute(@Nonnull CommandSender sender, @Nonnull String[] args) {

        if (args.length != 2) {
            sender.sendMessage(ChatColor.WHITE + "Usage: /slimequest check <player>");
            return;
        }


        Player target = Bukkit.getPlayer(args[1]);

        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Invalid player");
            return;
        }

        int[] data = QuestData.getIDs(target);

        if (data == null) {
            sender.sendMessage(new String[]{ChatColor.RED + target.getName() + " does not have any quests completed!"});
            return;
        }

        sender.sendMessage(new String[]{ChatColor.GREEN + target.getName() + "'s Quest progress: ", ChatColor.GREEN + Arrays.toString(data), ChatColor.GREEN + QuestData.getNames(target).toString()});
    }

    @Override
    public List<String> onTab(@Nonnull CommandSender sender, @Nonnull String[] args) {
        List<String> tabs = new ArrayList<>();
        if (sender.hasPermission("slimequest.admin")) {
            if (args.length == 2) {

                for (Player p : Bukkit.getOnlinePlayers()) {
                    tabs.add(p.getName());
                }

            }
        }
        return tabs;
    }
}