package tfar.lushcaveslb;

import net.minecraft.entity.player.PlayerEntity;

public class ReachUtil {

    private static final double DEFAULT_REACH = 3;

    public static double getReach(PlayerEntity player) {
        if (player !=  null && player.getHeldItemMainhand().getItem() instanceof VineWhipItem) {
            return DEFAULT_REACH * 2;
        } else {
            return DEFAULT_REACH;
        }
    }
}
