package noelle.grae.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {

    @Inject(
            method = "renderFirstPersonItem",
            at = @At("HEAD"),
            cancellable = true
    )
    private void hideHand(
            AbstractClientPlayerEntity player,
            float tickProgress,
            float pitch,
            net.minecraft.util.Hand hand,
            float swingProgress,
            net.minecraft.item.ItemStack item,
            float equipProgress,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            CallbackInfo ci
    ) {
        ci.cancel();
    }
}