package org.best.mbhvrightclick;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.RayTraceResult;

public class PlayerCommand implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("====> MBHV ADMIN GUI <====")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.hasItemMeta()) {
                String task = clickedItem.getItemMeta().getDisplayName();

                RayTraceResult rayTrace = player.getWorld().rayTraceEntities(player.getEyeLocation(), player.getEyeLocation().getDirection(), 5, 0.5, (Entity e) -> e instanceof Player && !e.equals(player));
                Player target = null;
                if (rayTrace != null && rayTrace.getHitEntity() != null) {
                    target = (Player) rayTrace.getHitEntity();
                }

                if (target != null) {
                    switch (task) {
                        case "§4 Vulcan":
                            player.performCommand("vulcan profile " + target.getName());
                            break;
                        case "§c Kick Player":
                            player.performCommand("kick " + target.getName());
                            break;
                        case "§c Ban Player":
                            player.performCommand("ban " + target.getName());
                            break;
                        case "§b Freeze Player":
                            player.performCommand("vulcan freeze " + target.getName());
                            break;
                        case "§c IP BAN (30m)":
                            player.performCommand("tempbanip " + target.getName()+ " 30m");
                            break;
                    }
                }
            }
        }
    }
}
