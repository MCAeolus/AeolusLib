package me.mcaeolus.aeoluslib.GUI.ModifiedClasses;

import me.mcaeolus.aeoluslib.GUI.Button;
import me.mcaeolus.aeoluslib.GUI.GUI;
import me.mcaeolus.aeoluslib.GUI.Page;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.UUID;

public class ExampleGUI extends GUI {

    private Page[] pages = null;
    private HashMap<UUID, Integer> guiOpen = new HashMap<>();

    public ExampleGUI(Page[] pages, Plugin pl) {
        super(pages, pl);
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

}
