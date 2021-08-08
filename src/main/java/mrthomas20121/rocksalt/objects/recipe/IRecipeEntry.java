package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public interface IRecipeEntry {

    void setRegistryName(@Nonnull ResourceLocation name);

    ResourceLocation getRegistryName();
}
