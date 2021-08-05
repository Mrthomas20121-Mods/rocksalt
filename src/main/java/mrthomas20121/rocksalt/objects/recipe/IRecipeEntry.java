package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public interface IRecipeEntry<T> {

    T setRegistryName(ResourceLocation name);

    ResourceLocation getRegistryName();
}
