package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class BasicIORecipe<K, V> extends BasicOutputRecipe<V> {

    private final K input;

    public BasicIORecipe(ResourceLocation registryName, V output, K input) {
        super(registryName, output);
        this.input = input;
    }

    public BasicIORecipe(String registryName, V output, K input) {
        super(registryName, output);
        this.input = input;
    }
}
