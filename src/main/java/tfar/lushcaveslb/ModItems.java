package tfar.lushcaveslb;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ModItems {

    public static final Item VINE_WHIP = new VineWhipItem(new Item.Properties().group(ItemGroup.COMBAT));
    public static final Item SPORE_SWORD = new SwordItem(ItemTier.IRON,1,-2,new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item MOSS_HELMET = new MossArmorItem(ArmorMaterial.CHAIN, EquipmentSlotType.HEAD,new Item.Properties().group(ItemGroup.COMBAT));
    public static final Item MOSS_CHESTPLATE = new MossArmorItem(ArmorMaterial.CHAIN, EquipmentSlotType.CHEST,new Item.Properties().group(ItemGroup.COMBAT));
    public static final Item MOSS_LEGGINGS = new MossArmorItem(ArmorMaterial.CHAIN, EquipmentSlotType.LEGS,new Item.Properties().group(ItemGroup.COMBAT));
    public static final Item MOSS_BOOTS = new MossArmorItem(ArmorMaterial.CHAIN, EquipmentSlotType.FEET,new Item.Properties().group(ItemGroup.COMBAT));



    private static List<Item> MOD_ITEMS;

    public static void register(RegistryEvent.Register<Item> e) {
        for (Field field : ModItems.class.getFields()) {
            try {
                Object o = field.get(null);
                if (o instanceof Item) {
                    e.getRegistry().register(((Item) o).setRegistryName(field.getName().toLowerCase(Locale.ROOT)));
                }
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
    }

    public static List<Item> getAllItems() {
        if (MOD_ITEMS == null) {
            MOD_ITEMS = Arrays.stream(ModItems.class.getFields()).map(field -> {
                try {
                    return field.get(null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }).filter(Item.class::isInstance).map(Item.class::cast).collect(Collectors.toList());
        }
        return MOD_ITEMS;
    }
}
