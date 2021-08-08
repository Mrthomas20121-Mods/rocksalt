package mrthomas20121.rocksalt.objects.recipe;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RecipeManager.java
 * Use this class to register recipes.
 * @author mrthomas20121
 * @param <K> recipe type
 */
public class RecipeManager<K extends BasicRecipe> implements IAdapter<K> {

    private final ResourceLocation registryName;
    protected final LinkedList<K> recipeList = new LinkedList<>();

    public RecipeManager(@Nonnull ResourceLocation registryName) {
        this.registryName = registryName;
    }

    public RecipeManager(@Nonnull String registryName) {
        this(new ResourceLocation(registryName));
    }

    @Nullable
    public K getRecipeByName(@Nonnull ResourceLocation registryName) {
        return this.recipeList.stream().filter(recipe->recipe.getRegistryName() != null &&recipe.getRegistryName().equals(registryName)).findFirst().orElse(null);
    }

    @Nullable
    public K getRecipeByName(@Nonnull String registryName) {
        return this.getRecipeByName(new ResourceLocation(registryName));
    }

    /**
     *  Get the recipe index of a recipe.
     * @param registryName Recipe registry name
     * @return the recipe index
     */
    public int getRecipeIndex(@Nonnull ResourceLocation registryName) {
        K recipe = this.getRecipeByName(registryName);
        if(recipe != null) {
            return this.getRecipeIndex(recipe);
        }
        return 0;
    }

    public int getRecipeIndex(@Nonnull K recipe) {
        return this.recipeList.indexOf(recipe);
    }

    /**
     * Edit a recipe name of a recipe.
     * @param registryName current registryName of a recipe
     * @param newRegistryName new registryName for that recipe
     */
    public void editRecipeName(@Nonnull ResourceLocation registryName, @Nonnull ResourceLocation newRegistryName) {
        this.recipeList.forEach(recipe->{
            if(recipe.getRegistryName().equals(registryName)) {
                recipe.setRegistryName(newRegistryName);
            }
        });
    }

    @Override
    public boolean remove(@Nonnull ResourceLocation registryName) {
        K recipe = getRecipeByName(registryName);
        return this.recipeList.remove(recipe);
    }

    @Override
    public boolean remove(@Nonnull String registryName) {
        K recipe = this.getRecipeByName(registryName);
        return this.recipeList.remove(recipe);
    }

    public boolean add(@Nonnull K recipe) {
        if(recipe.getRegistryName() == null) throw new NullPointerException("Recipe name is null");
        return this.recipeList.add(recipe);
    }

    public K get(int index) {
        return this.recipeList.get(index);
    }

    @Override
    @Nonnull
    public ResourceLocation getRegistryName() {
        return registryName;
    }

    public LinkedList<K> getRecipeList() {
        return recipeList;
    }
}
