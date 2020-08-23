package mrthomas20121.rocksalt.utils;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class CraftingUtils {

    public static void removeRecipe(IForgeRegistry<IRecipe> r, ResourceLocation location)
    {
        IForgeRegistryModifiable registry = (IForgeRegistryModifiable)r;
        registry.remove(location);
    }
    public static void removeRecipe(IForgeRegistry<IRecipe> r, String mod_id, String path)
    {
        removeRecipe(r, new ResourceLocation(mod_id, path));
    }
}
