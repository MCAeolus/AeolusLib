package me.mcaeolus.aeoluslib.GUI;

import org.bukkit.inventory.ItemStack;

/**
 * This class is meant to be inherited for your own button code.
 */
public class Button {

    private ItemStack buttonItem;

    public Button(ItemStack buttonItem){
        this.buttonItem = buttonItem;
    }

    public ItemStack getItem(){
        return buttonItem;
    }

    public void execute(){
        /*
        This is where the button's execute code goes. Use this method for sub button classes.
         */
    }

}
