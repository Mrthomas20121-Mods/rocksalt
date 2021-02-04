package mrthomas20121.rocksalt.utils;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class Crafting {

    public static <T extends IForgeRegistryEntry<T>> void removeRecipe(IForgeRegistry<T> r, ResourceLocation location)
    {
        IForgeRegistryModifiable registry = (IForgeRegistryModifiable)r;
        registry.remove(location);
    }
    public static <T extends IForgeRegistryEntry<T>> void removeRecipe(IForgeRegistry<T> r, String location)
    {
        removeRecipe(r, new ResourceLocation(location));
    }
}
