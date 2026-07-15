package noelle.grae.ExtraHand;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class ExtraHandsRenderer {

    private static final MinecraftClient client =
            MinecraftClient.getInstance();


    public static void render(
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light
    ) {

        PlayerEntity player = client.player;

        if (player == null)
            return;


        ExtraHandHolder holder =
                (ExtraHandHolder) player;


        ItemStack left =
                holder.getExtraHands()
                        .getLeftHand();


        ItemStack right =
                holder.getExtraHands()
                        .getRightHand();



        ItemRenderer itemRenderer =
                client.getItemRenderer();
        if (!left.isEmpty()) {

            matrices.push();


            // Position left hand item
            matrices.translate(
                    -0.45F,
                    -0.35F,
                    -0.8F
            );


            matrices.multiply(
                    RotationAxis.POSITIVE_Y.rotationDegrees(-35)
            );


            itemRenderer.renderItem(
                    left,
                    ModelTransformationMode.FIRST_PERSON_LEFT_HAND,
                    light,
                    OverlayTexture.DEFAULT_UV,
                    matrices,
                    vertexConsumers,
                    client.world,
                    0
            );


            matrices.pop();
        }
        if (!right.isEmpty()) {

            matrices.push();


            matrices.translate(
                    0.45F,
                    -0.35F,
                    -0.8F
            );


            matrices.multiply(
                    RotationAxis.POSITIVE_Y.rotationDegrees(35)
            );


            itemRenderer.renderItem(
                    right,
                    ModelTransformationMode.FIRST_PERSON_RIGHT_HAND,
                    light,
                    OverlayTexture.DEFAULT_UV,
                    matrices,
                    vertexConsumers,
                    client.world,
                    0
            );


            matrices.pop();
        }
    }
}
