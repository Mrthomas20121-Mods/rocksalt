package mrthomas20121.rocksalt.utils;

import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.ItemHeatHandler;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.item.ItemStack;

public class Heating {

    public static void addVesselHeat(ItemStack stack) {
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(stack), () -> new ItemHeatHandler(null, 1.0F, 1599.0F));
    }

    public static void addVesselHeat(String oredict) {
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(oredict), () -> new ItemHeatHandler(null, 1.0F, 1599.0F));
    }
}
