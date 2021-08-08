package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

/**
 * Basic Implementation of a recipe with an output
 */
public class BasicOutputRecipe<K> extends BasicRecipe {

    private final K output;

    public BasicOutputRecipe(ResourceLocation registryName, K output) {
        super(registryName);
        this.output = output;
    }

    public BasicOutputRecipe(String registryName, K output) {
        this(new ResourceLocation(registryName), output);
    }

    @Nonnull
    public K getOutput() {
        return this.output;
    }
}
