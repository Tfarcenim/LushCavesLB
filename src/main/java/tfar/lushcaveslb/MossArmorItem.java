package tfar.lushcaveslb;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class MossArmorItem extends ArmorItem {
    public MossArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        //only check head
        if (!world.isRemote && slot == EquipmentSlotType.HEAD && world.getGameTime() % 20 == 0) {
            if (player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() instanceof MossArmorItem &&
                    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() instanceof MossArmorItem &&
                    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() instanceof MossArmorItem) {
                //has all items
                player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY,1,1,true,false,true));
            }
        }
    }
}
