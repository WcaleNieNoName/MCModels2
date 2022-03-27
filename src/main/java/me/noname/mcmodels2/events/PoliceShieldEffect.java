package me.noname.mcmodels2.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class PoliceShieldEffect {

    private static final PotionEffect POLICE_SHIELD_EFFECT = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 1, false, false);

    public static boolean isPoliceShield(ItemStack itemStack){
        ItemMeta meta = itemStack.getItemMeta();
        if(!itemStack.getType().equals(Material.SHIELD))
            return false;
        if(!itemStack.hasItemMeta())
            return false;
        return (meta.getCustomModelData() == 1825637534);
    }

    public void setPoliceShieldEffect(Player player) {
        ItemStack MainHand = player.getInventory().getItemInMainHand();
        ItemStack OffHand = player.getInventory().getItemInOffHand();
        if(MainHand != null && isPoliceShield(MainHand)){
            player.addPotionEffect(POLICE_SHIELD_EFFECT);
        }else if(OffHand != null && isPoliceShield(OffHand)){
            player.addPotionEffect(POLICE_SHIELD_EFFECT);
        }
    }

}
