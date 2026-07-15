package noelle.grae.ExtraHand;

import net.minecraft.item.ItemStack;

public class ExtraHandsInventory {

    private ItemStack leftHand = ItemStack.EMPTY;
    private ItemStack rightHand = ItemStack.EMPTY;


    public ItemStack getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(ItemStack stack) {
        this.leftHand = stack;
    }


    public ItemStack getRightHand() {
        return rightHand;
    }

    public void setRightHand(ItemStack stack) {
        this.rightHand = stack;
    }
}
