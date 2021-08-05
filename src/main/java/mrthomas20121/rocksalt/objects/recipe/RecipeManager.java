package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeManager<K extends BasicRecipe<K>> implements IAdapter<K> {

    private final ResourceLocation registryName;
    protected final LinkedList<K> recipeList = new LinkedList<>();

    public RecipeManager(ResourceLocation registryName) {
        this.registryName = registryName;
    }

    @Nullable
    public K getRecipeByName(ResourceLocation registryName) {
        return this.recipeList.stream().filter(recipe->recipe.getRegistryName() != null &&recipe.getRegistryName().equals(registryName)).findFirst().orElse(null);
    }

    @Nullable
    public K getRecipeByName(String registryName) {
        return this.getRecipeByName(new ResourceLocation(registryName));
    }

    @Override
    public boolean remove(ResourceLocation registryName) {
        K recipe = getRecipeByName(registryName);
        return this.recipeList.remove(recipe);
    }

    @Override
    public boolean remove(String registryName) {
        K recipe = this.getRecipeByName(registryName);
        return this.recipeList.remove(recipe);
    }

    public void removeFrom(List<K> recipes) {
        if(!recipes.isEmpty()) {
            for(K recipe: recipes) {
                this.recipeList.remove(recipe);
            }
        }
    }

    public <V> void removeRecipeFor(@Nonnull V output) {
        List<K> recipes = getRecipesFor(output);
        this.removeFrom(recipes);
    }

    public <V> List<K> getRecipesFor(@Nonnull V output) {
        return this.recipeList.stream().filter(recipe->recipe.getOutput().equals(output)).collect(Collectors.toList());
    }

    public boolean add(K recipe) {
        if(recipe.getRegistryName() == null) throw new NullPointerException("Recipe name is null");
        return this.recipeList.add(recipe);
    }

    public K get(int index) {
        return this.recipeList.get(index);
    }

    public ResourceLocation getRegistryName() {
        return registryName;
    }

    public LinkedList<K> getRecipeList() {
        return recipeList;
    }
}
