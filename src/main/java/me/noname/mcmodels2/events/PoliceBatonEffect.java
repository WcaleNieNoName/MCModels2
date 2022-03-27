package me.noname.mcmodels2.events;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PoliceBatonEffect implements Listener {

    public final PotionEffect POLICE_BATON_EFFECT_1 = new PotionEffect(PotionEffectType.SLOW, 200, 100, false, true);
    public final PotionEffect POLICE_BATON_EFFECT_2 = new PotionEffect(PotionEffectType.BLINDNESS, 200, 100, false, true);


    @EventHandler
    public void onEntityDamageWithPoliceBaton(EntityDamageByEntityEvent event){
        Entity damager = event.getDamager();
        LivingEntity victim = (LivingEntity) event.getEntity();
        ItemStack activeItem = ((Player)damager).getInventory().getItemInMainHand();
        if(isPoliceBaton(activeItem)) {
            if (victim != null) {
                if (damager != null){
                    if(!((Player)victim).isBlocking() && PoliceShieldEffect.isPoliceShield(activeItem)) {
                        victim.addPotionEffect(POLICE_BATON_EFFECT_1);
                        victim.addPotionEffect(POLICE_BATON_EFFECT_2);
                    }
                    return;
                }
                return;
            }
            return;
        }
        return;
    }

    public static boolean isPoliceBaton(ItemStack itemStack){
        ItemMeta meta = itemStack.getItemMeta();
        if(!itemStack.getType().equals(Material.STICK))
            return false;
        if(!meta.hasCustomModelData())
            return false;
        return (meta.getCustomModelData() == 92645181);
    }

}
