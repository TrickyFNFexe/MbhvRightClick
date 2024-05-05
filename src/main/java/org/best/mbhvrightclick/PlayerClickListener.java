package org.best.mbhvrightclick;

import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PlayerClickListener implements Listener {

    @EventHandler
    public void onPlayerRightClickPlayer(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Player) {
            Player player = event.getPlayer();
            Player target = (Player) event.getRightClicked();

            // Check if the player has the permission or is an operator
            if (player.hasPermission("mbhv.admin") || player.isOp()) {
                Inventory gui = Bukkit.createInventory(player, 9, "====> MBHV ADMIN GUI <====");

                // Create items for the GUI
                ItemStack[] items = new ItemStack[5];
                ItemMeta[] meta = new ItemMeta[5];

                // Task 1: Check Vulcan alerts
                items[0] = new ItemStack(Material.PAPER, 1);
                meta[0] = items[0].getItemMeta();
                meta[0].setDisplayName("§4 Vulcan");
                meta[0].setLore(Arrays.asList("§4 Click to check Vulcan alerts for " + target.getName()));
                items[0].setItemMeta(meta[0]);

                // Task 2: Kick player
                items[1] = new ItemStack(Material.DIAMOND_BOOTS, 1);
                meta[1] = items[1].getItemMeta();
                meta[1].setDisplayName("§c Kick Player");
                meta[1].setLore(Arrays.asList("§c Click to kick " + target.getName()));
                items[1].setItemMeta(meta[1]);

                // Task 3: Ban player
                items[2] = new ItemStack(Material.BARRIER, 1);
                meta[2] = items[2].getItemMeta();
                meta[2].setDisplayName("§c Ban Player");
                meta[2].setLore(Arrays.asList("§c Click to ban " + target.getName()));
                items[2].setItemMeta(meta[2]);

                // Task 4: Freeze player
                items[3] = new ItemStack(Material.ICE, 1);
                meta[3] = items[3].getItemMeta();
                meta[3].setDisplayName("§b Freeze Player");
                meta[3].setLore(Arrays.asList("§b Click to freeze/unfreeze " + target.getName()));
                items[3].setItemMeta(meta[3]);

                // Task 5: Temp Ban IP
                items[4] = new ItemStack(Material.DIRT, 1);
                meta[4] = items[4].getItemMeta();
                meta[4].setDisplayName("§c IP BAN (30m)");
                meta[4].setLore(Arrays.asList("§c Click to temp ban player: " + target.getName()));
                items[4].setItemMeta(meta[4]);

                // Add items to the GUI
                for (int i = 0; i < items.length; i++) {
                    gui.addItem(items[i]);
                }

                // Fill the rest of the GUI with Gray Stained Glass Pane
                ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
                ItemMeta fillerMeta = filler.getItemMeta();
                fillerMeta.setDisplayName(" ");
                filler.setItemMeta(fillerMeta);
                for (int i = items.length; i < 9; i++) {
                    gui.setItem(i, filler);
                }

                player.openInventory(gui);
            }
        }
    }
}