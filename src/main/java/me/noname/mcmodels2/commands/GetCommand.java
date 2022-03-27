package me.noname.mcmodels2.commands;

import me.noname.mcmodels2.items.Models;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GetCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player target = Bukkit.getPlayerExact(args[2]);
        if(command.getName().equalsIgnoreCase("getModel")){
            if(args.length==2){
                if(target != null) {
                    if (args[0].equalsIgnoreCase("crown")) {
                        target.getInventory().addItem(Models.crown);
                        sender.sendMessage("§aPomyślnie dałesś model graczowi §a" + target.getDisplayName());
                        target.sendMessage("§aDostałeś model!");
                        return true;
                    } else if (args[1].equalsIgnoreCase("policeshield")) {
                        target.getInventory().addItem(Models.policeshield);
                        sender.sendMessage("§aPomyślnie dałesś model graczowi §a" + target.getDisplayName());
                        target.sendMessage("§aDostałeś model!");
                        return true;
                    } else if (args[0].equalsIgnoreCase("policebaton")) {
                        target.getInventory().addItem(Models.policebaton);
                        sender.sendMessage("§aPomyślnie dałesś model graczowi §a" + target.getDisplayName());
                        target.sendMessage("§aDostałeś model!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==1){
            List<String> modelList = new ArrayList<String>();
            modelList.add("crown");
            modelList.add("policeshield");
            modelList.add("policebaton");
            return modelList;
        }
        return null;
    }
}
