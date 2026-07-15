package noelle.grae.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import noelle.grae.ExtraHand.ExtraHandHolder;
import noelle.grae.ExtraHand.ExtraHandsInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class PlayerInteractionMixin {

    @Inject(
            method = "onPlayerCollision",
            at = @At("HEAD")
    )
    private void pickupItem(PlayerEntity player, CallbackInfo ci) {

        ItemEntity item = (ItemEntity)(Object)this;

        System.out.println("PICKUP ATTEMPT");

        if (player.getWorld().isClient()) {
            return;
        }

        ExtraHandsInventory hands =
                ((ExtraHandHolder) player).getExtraHands();

        ItemStack stack = item.getStack();

        if (hands.getLeftHand().isEmpty()) {
            hands.setLeftHand(stack.copy());
            item.discard();
            return;
        }

        if (hands.getRightHand().isEmpty()) {
            hands.setRightHand(stack.copy());
            item.discard();
        }
    }
}