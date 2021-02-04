package mrthomas20121.rocksalt;

import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.api.capability.forge.CapabilityForgeable;
import net.dries007.tfc.api.capability.forge.IForgeable;
import net.dries007.tfc.api.capability.forge.IForgeableMeasurableMetal;
import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.ItemHeatHandler;
import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemsTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import org.apache.commons.lang3.StringUtils;

import static net.dries007.tfc.api.types.Metal.ItemType.INGOT;
import static net.dries007.tfc.util.forge.ForgeRule.HIT_LAST;
import static net.dries007.tfc.util.forge.ForgeRule.HIT_SECOND_LAST;
import static net.dries007.tfc.util.forge.ForgeRule.HIT_THIRD_LAST;

public class Utils {

    public static <T extends IForgeRegistryEntry<T>> void removeRecipe(IForgeRegistry<T> r, ResourceLocation location)
    {
        IForgeRegistryModifiable registry = (IForgeRegistryModifiable)r;
        registry.remove(location);
    }
    public static <T extends IForgeRegistryEntry<T>> void removeRecipe(IForgeRegistry<T> r, String location)
    {
        removeRecipe(r, new ResourceLocation(location));
    }

    public static void addVesselHeat(ItemStack stack) {
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(stack), () -> new ItemHeatHandler(null, 1.0F, 1599.0F));
    }

    public static void addVesselHeat(String oredict) {
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(oredict), () -> new ItemHeatHandler(null, 1.0F, 1599.0F));
    }

    public static String getPath(Metal metal)
    {
        return metal.getRegistryName().getPath();
    }

    public static Metal getMetal(String name)
    {
        return TFCRegistries.METALS.getValue(get(name));
    }

    public static ResourceLocation get(String name)
    {
        return new ResourceLocation(TerraFirmaCraft.MOD_ID, name);
    }
    public static String combine(String name)
    {
        return TerraFirmaCraft.MOD_ID + ":"+name;
    }

    public static void addOredict(String metal, String newName)
    {
        addOredict(getMetal(metal), newName);
    }

    public static void addOredict(Metal metal, String newName)
    {
        for(Metal.ItemType itemType : Metal.ItemType.values())
        {
            if(itemType.equals(Metal.ItemType.DOUBLE_INGOT) || itemType.equals(Metal.ItemType.INGOT) || itemType.equals(Metal.ItemType.DOUBLE_SHEET) || itemType.equals(Metal.ItemType.SHEET) || itemType.equals(Metal.ItemType.SCRAP) || itemType.equals(Metal.ItemType.DUST))
            {
                Item itemMetal = ItemMetal.get(metal, itemType);
                OreDictionary.registerOre(fromItemType(itemType)+ StringUtils.capitalize(newName.toLowerCase()), itemMetal);
            }
        }
    }

    private static String fromItemType(Metal.ItemType itemType)
    {
        if(itemType.equals(Metal.ItemType.DOUBLE_INGOT) || itemType.equals(Metal.ItemType.DOUBLE_SHEET)) {
            String[] name = itemType.name().toLowerCase().split("_");
            return StringUtils.capitalize(name[1])+StringUtils.capitalize(name[0]);
        }
        return itemType.name().toLowerCase();
    }

    public static AnvilRecipe createBloomRecipe(Metal metal)
    {
        return new AnvilRecipe(new ResourceLocation(TerraFirmaCraft.MOD_ID, getPath(metal)+"_bloom"), x ->
        {
            if (x.getItem() == ItemsTFC.REFINED_BLOOM)
            {
                IForgeable cap = x.getCapability(CapabilityForgeable.FORGEABLE_CAPABILITY, null);
                if (cap instanceof IForgeableMeasurableMetal)
                {
                    return ((IForgeableMeasurableMetal) cap).getMetal() == metal && ((IForgeableMeasurableMetal) cap).getMetalAmount() == 100;
                }
            }
            return false;
        }, new ItemStack(ItemMetal.get(metal, INGOT)), Metal.Tier.TIER_II, null, HIT_LAST, HIT_SECOND_LAST, HIT_THIRD_LAST);
    }
    public static AnvilRecipe createBloomRecipe(String metal)
    {
        return createBloomRecipe(getMetal(metal));
    }
}
