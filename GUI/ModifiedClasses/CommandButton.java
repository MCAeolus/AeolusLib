package me.mcaeolus.aeoluslib.GUI.ModifiedClasses;

import me.mcaeolus.aeoluslib.GUI.Button;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Example inheriting {@link Button} class.
 */
public class CommandButton extends Button {

    public CommandButton(ItemStack buttonItem) {
        super(buttonItem);
    }

    public void execute(String cmd, Player p){
        p.closeInventory();
        p.performCommand(cmd);
        /*
        Super simple example of how to use execute.
         */
    }
}
