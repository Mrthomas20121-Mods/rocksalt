package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public interface IAdapter<T> {

    T get(int index);

    boolean add(@Nonnull T object);

    boolean remove(@Nonnull ResourceLocation registryName);

    boolean remove(@Nonnull String registryName);

    @Nonnull
    ResourceLocation getRegistryName();
}
