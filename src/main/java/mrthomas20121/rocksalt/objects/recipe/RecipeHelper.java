package mrthomas20121.rocksalt.objects.recipe;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeHelper {

    public static <K extends BasicRecipe> void removeFrom(RecipeManager<K> manager,  List<K> recipes) {
        if(!recipes.isEmpty()) {
            for(K recipe: recipes) {
                manager.recipeList.remove(recipe);
            }
        }
    }

    public static <V, K extends BasicOutputRecipe<V>> void removeRecipeFor(@Nonnull RecipeManager<K> manager, @Nonnull V output) {
        List<K> recipes = getRecipesFor(manager, output);
        removeFrom(manager, recipes);
    }

    public static <V, K extends BasicOutputRecipe<V>> List<K> getRecipesFor(@Nonnull RecipeManager<K> manager, @Nonnull V output) {
        return manager.recipeList.stream().filter(recipe->recipe.getOutput().equals(output)).collect(Collectors.toList());
    }
}
