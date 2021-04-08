package tfar.lushcaveslb;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LushCavesLB.MODID)
public class LushCavesLB
{
    // Directly reference a log4j logger.

    public static final String MODID = "lushcaveslb";

    public LushCavesLB() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addGenericListener(Item.class, ModItems::register);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
