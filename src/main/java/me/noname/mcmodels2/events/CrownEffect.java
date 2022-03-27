package me.noname.mcmodels2.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CrownEffect {

    private final PotionEffect CROWN_EFFECT = new PotionEffect(PotionEffectType.SPEED, 60, 2, false, false);

    public void setCrownEffect(Player player){
        ItemStack helmet = player.getInventory().getHelmet();
        if(helmet != null && isCrown(helmet))
            player.addPotionEffect(CROWN_EFFECT);
    }

    public static boolean isCrown(ItemStack itemStack){
        ItemMeta meta = itemStack.getItemMeta();
        if(!itemStack.getType().equals(Material.DIAMOND))
            return false;
        if(!meta.hasCustomModelData())
            return false;
        return (meta.getCustomModelData() == 688150787);
    }

}
