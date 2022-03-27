package me.noname.mcmodels2.commands;

import me.noname.mcmodels2.items.Models;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GiveCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("givemodel")){
            if(args.length ==1) {
                    if (args[0].equalsIgnoreCase("crown")) {
                        player.getInventory().addItem(Models.crown);
                        player.sendMessage("§aPomyślnie dodano model!");
                        return true;
                    } else if (args[0].equalsIgnoreCase("policeshield")) {
                        player.getInventory().addItem(Models.policeshield);
                        player.sendMessage("§aPomyślnie dodano model!");
                        return true;
                    } else if(args[0].equalsIgnoreCase("policebaton")){
                        player.getInventory().addItem(Models.policebaton);
                        player.sendMessage("§aPomyślnie dodano model!");
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
