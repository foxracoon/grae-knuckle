package noelle.grae.mixin;

import net.minecraft.entity.player.PlayerEntity;

import noelle.grae.ExtraHand.ExtraHandHolder;
import noelle.grae.ExtraHand.ExtraHandsInventory;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements ExtraHandHolder {


    private final ExtraHandsInventory extraHands =
            new ExtraHandsInventory();


    @Override
    public ExtraHandsInventory getExtraHands() {
        return extraHands;
    }

}
