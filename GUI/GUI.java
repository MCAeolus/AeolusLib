package me.mcaeolus.aeoluslib.GUI;

import me.mcaeolus.aeoluslib.GUI.ModifiedClasses.CommandButton;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.UUID;

public class GUI implements Listener {

    private Page[] pages = null;
    private HashMap<UUID, Integer> guiOpen = new HashMap<>();

    public GUI(Page[] pages, Plugin pl){
        this.pages = pages;
        pl.getServer().getPluginManager().registerEvents(this, pl);
        pl.getLogger().info("Class events registered.");
    }

    public void open(Player p, Integer pageNum){
        if(pageNum <= pages.length-1) {
            guiOpen.put(p.getUniqueId(), pageNum);
            p.openInventory(pages[pageNum].build());
        }else{
            throw new IllegalArgumentException("Integer is too large for array size.");
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        if(guiOpen.containsKey(p.getUniqueId())){
            e.setCancelled(true);
            Button currentButton = pages[guiOpen.get(p.getUniqueId())].getButton(e.getSlot());
            if(currentButton instanceof CommandButton){
                CommandButton cmdButton = (CommandButton)currentButton;
                cmdButton.execute("say Hi!", (Player)e.getWhoClicked());
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        Player p = (Player)e.getPlayer();
        if(guiOpen.containsKey(p.getUniqueId())){
            guiOpen.remove(p.getUniqueId());
        }
        /*
        Code here.
         */
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent e){
        /*
        Code here.
         */
    }
}
