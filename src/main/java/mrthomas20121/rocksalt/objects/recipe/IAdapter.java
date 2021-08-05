package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.util.ResourceLocation;

public interface IAdapter<T> {

    T get(int index);

    boolean add(T object);

    boolean remove(ResourceLocation registryName);

    boolean remove(String registryName);
}
