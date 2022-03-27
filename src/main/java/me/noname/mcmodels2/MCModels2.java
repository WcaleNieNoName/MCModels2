package me.noname.mcmodels2;

import me.noname.mcmodels2.commands.GetCommand;
import me.noname.mcmodels2.commands.GiveCommand;
import me.noname.mcmodels2.events.CrownEffect;
import me.noname.mcmodels2.events.PoliceBatonEffect;
import me.noname.mcmodels2.events.PoliceShieldEffect;
import me.noname.mcmodels2.items.Models;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MCModels2 extends JavaPlugin implements Runnable {

    CrownEffect crownEffect;
    PoliceShieldEffect policeShieldEffect;

    @Override
    public void onEnable() {
        crownEffect = new CrownEffect();
        policeShieldEffect = new PoliceShieldEffect();
        Models.createPoliceShield();
        Models.createCrown();
        Models.createPoliceBaton();
        getServer().getPluginManager().registerEvents(new PoliceBatonEffect(), this);
        Objects.requireNonNull(getServer().getPluginCommand("giveModel")).setExecutor(new GiveCommand());
        Objects.requireNonNull(getServer().getPluginCommand("giveModel")).setTabCompleter(new GiveCommand());
        Objects.requireNonNull(getServer().getPluginCommand("getModel")).setExecutor(new GetCommand());
        Objects.requireNonNull(getServer().getPluginCommand("getModel")).setTabCompleter(new GetCommand());
        getServer().getScheduler().runTaskTimer(this, this, 20, 20);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(new PoliceBatonEffect());
    }

    @Override
    public void run() {
        for(Player onlinePlayers : Bukkit.getOnlinePlayers()){
            crownEffect.setCrownEffect(onlinePlayers);
            policeShieldEffect.setPoliceShieldEffect(onlinePlayers);
        }
    }
}
