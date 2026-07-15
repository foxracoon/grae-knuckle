package noelle.grae.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class InventoryKeyMixin {

    @Inject(
            method = "handleInputEvents()V",
            at = @At("HEAD")
    )
    private void onHandleInputEvents(CallbackInfo ci) {
        MinecraftClient client = (MinecraftClient)(Object)this;
        GameOptions options = client.options;

        while (options.inventoryKey.wasPressed()) {
        }
    }
}
