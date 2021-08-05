package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public abstract class BasicRecipe<T> implements IRecipeEntry<BasicRecipe<T>> {

    private ResourceLocation registryName;

    public BasicRecipe(ResourceLocation registryName) {
        this.registryName = registryName;
    }

    @Override
    public BasicRecipe<T> setRegistryName(ResourceLocation name) {
        this.registryName = name;
        return this;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return registryName;
    }

    public abstract T getOutput();
}
