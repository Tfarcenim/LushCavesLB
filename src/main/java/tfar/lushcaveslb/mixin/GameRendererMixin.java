package tfar.lushcaveslb.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import tfar.lushcaveslb.ReachUtil;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    //reach
    @ModifyConstant(method = "getMouseOver", constant = @Constant(doubleValue = 3))
    private double getReach(double old) {
        return ReachUtil.getReach(Minecraft.getInstance().player);
    }

    //reach squared
    @ModifyConstant(method = "getMouseOver", constant = @Constant(doubleValue = 9))
    private double getReach1(double old) {
        double reach = ReachUtil.getReach(Minecraft.getInstance().player);
        return reach * reach;
    }
}
