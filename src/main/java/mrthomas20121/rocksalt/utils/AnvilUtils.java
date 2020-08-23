package mrthomas20121.rocksalt.utils;

import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.api.capability.forge.CapabilityForgeable;
import net.dries007.tfc.api.capability.forge.IForgeable;
import net.dries007.tfc.api.capability.forge.IForgeableMeasurableMetal;
import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemsTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.util.forge.ForgeRule;
import net.dries007.tfc.util.skills.SmithingSkill;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import javax.annotation.Nullable;

import static net.dries007.tfc.api.types.Metal.ItemType.*;
import static net.dries007.tfc.util.forge.ForgeRule.HIT_LAST;
import static net.dries007.tfc.util.forge.ForgeRule.HIT_SECOND_LAST;
import static net.dries007.tfc.util.forge.ForgeRule.HIT_THIRD_LAST;

public class AnvilUtils {

    public static void removeRecipe(IForgeRegistry<AnvilRecipe> r, ResourceLocation location)
    {
        IForgeRegistryModifiable registry = (IForgeRegistryModifiable)r;
        registry.remove(location);
    }

    public static AnvilRecipe createAnvilRecipe(ResourceLocation name, IIngredient<ItemStack> ingredient, ItemStack output, Metal.Tier minTier, @Nullable SmithingSkill.Type type, ForgeRule... rules)
    {
        return new AnvilRecipe(name, ingredient, output, minTier, type, rules);
    }
    public static AnvilRecipe createBloomRecipe(Metal metal)
    {
        return new AnvilRecipe(new ResourceLocation(TerraFirmaCraft.MOD_ID, MetalUtils.getPath(metal)+"_bloom"), x ->
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
        return createBloomRecipe(MetalUtils.getMetal(metal));
    }
}
