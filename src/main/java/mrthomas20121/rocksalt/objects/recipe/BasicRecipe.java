package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public abstract class BasicRecipe implements IRecipeEntry {

    private ResourceLocation registryName;

    public BasicRecipe(@Nonnull ResourceLocation registryName) {
        this.registryName = registryName;
    }

    @Override
    public void setRegistryName(@Nonnull ResourceLocation name) {
        this.registryName = name;
    }

    @Override
    public ResourceLocation getRegistryName() {
        return registryName;
    }
}
