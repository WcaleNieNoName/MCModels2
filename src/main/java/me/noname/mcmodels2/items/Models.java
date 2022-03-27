package me.noname.mcmodels2.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Models {

    public static ItemStack crown;
    public static ItemStack policeshield;
    public static ItemStack policebaton;

    public static void createCrown(){
        ItemStack item = new ItemStack(Material.DIAMOND, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Crown");
        meta.setCustomModelData(688150787);
        item.setItemMeta(meta);
        crown = item;
    }

    public static void createPoliceShield(){
        ItemStack item = new ItemStack(Material.SHIELD);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(1825637534);
        meta.setDisplayName("§bPolice Shield");
        item.setItemMeta(meta);
        policeshield = item;
    }

    public static void createPoliceBaton(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(92645181);
        meta.setDisplayName("§bPolice Baton");
        item.setItemMeta(meta);
        policebaton = item;
    }
}
