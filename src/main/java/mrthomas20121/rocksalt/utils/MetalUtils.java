package mrthomas20121.rocksalt.utils;

import mrthomas20121.rocksalt.RegistryHandler;
import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.IArmorMaterialTFC;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.ArmorMaterialTFC;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import javax.annotation.Nonnull;

public class MetalUtils {

    public static Metal getMetal(String name)
    {
        return TFCRegistries.METALS.getValue(TFCUtils.getLoc(name));
    }

    public static Metal registerMetal(@Nonnull String name, Metal.Tier tier, boolean usable, float specificHeat, float meltTemp, int color, Item.ToolMaterial toolMetal, IArmorMaterialTFC armorMetal)
    {
        Metal metal = new Metal(TFCUtils.getLoc(name), tier, usable, specificHeat, meltTemp, color, toolMetal, armorMetal);
        RegistryHandler.addMetal(metal);
        return metal;
    }

    public static Metal registerMetal(@Nonnull String name, int tier, boolean usable, float specificHeat, float meltTemp, int color, Item.ToolMaterial toolMetal, IArmorMaterialTFC armorMetal)
    {
        return registerMetal(name, getTier(tier), usable, specificHeat, meltTemp, color, toolMetal, armorMetal);
    }

    public static Metal registerMetal(@Nonnull String name, Metal.Tier tier, boolean usable, float specificHeat, float meltTemp, int color)
    {
        return registerMetal(name, tier, usable, specificHeat, meltTemp, color, null, null);
    }

    public static Metal registerMetal(@Nonnull String name, int tier, boolean usable, float specificHeat, float meltTemp, int color)
    {
        return registerMetal(name, tier, usable, specificHeat, meltTemp, color, null, null);
    }

    private static Metal.Tier getTier(int value)
    {
        return Metal.Tier.valueOf(value);
    }
    public static Item.ToolMaterial getToolMetal(String name, int harvestlevel, int maxUses, float efficiency, float damage, int enchantability)
    {
        return EnumHelper.addToolMaterial(name, harvestlevel, maxUses, efficiency, damage, enchantability);
    }

    public static IArmorMaterialTFC getArmorMetal(String name, String metalName, int durability, int[] reductionAmounts, int enchantability, float toughness, float piercingRes, float slashingRes, float crushingRes)
    {
        return new ArmorMaterialTFC(EnumHelper.addArmorMaterial(name, TFCUtils.combine(metalName), durability, reductionAmounts, enchantability, SoundEvents.ITEM_ARMOR_EQUIP_IRON, toughness), piercingRes, slashingRes, crushingRes);
    }
}
