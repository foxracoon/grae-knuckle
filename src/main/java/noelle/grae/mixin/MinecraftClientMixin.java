package noelle.grae.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

    @Inject(
            method = "setScreen(Lnet/minecraft/client/gui/screen/Screen;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onSetScreen(Screen screen, CallbackInfo ci) {
        if (screen instanceof InventoryScreen) {
            ci.cancel();
        }
    }

    @Inject(
            method = "handleBlockBreaking",
            at = @At("HEAD"),
            cancellable = true
    )
    private void disableLeftClick(boolean breaking, CallbackInfo ci) {
        ci.cancel();
    }
}
