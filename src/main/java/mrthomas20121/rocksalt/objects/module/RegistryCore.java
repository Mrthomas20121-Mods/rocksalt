package mrthomas20121.rocksalt.objects.module;

import mrthomas20121.rocksalt.utils.Crafting;
import net.dries007.tfc.api.recipes.WeldingRecipe;
import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public abstract class RegistryCore {

    private ArrayList<ResourceLocation> recipesToRemove = new ArrayList<>();
    private ArrayList<AnvilRecipe> anvilRecipes = new ArrayList<>();
    private ArrayList<HeatRecipe> heatRecipes = new ArrayList<>();
    private ArrayList<BarrelRecipe> barrelRecipes = new ArrayList<>();
    private ArrayList<KnappingRecipe> knappingRecipes = new ArrayList<>();
    private ArrayList<WeldingRecipe> weldingRecipes = new ArrayList<>();

    public RegistryCore() {

    }

    public abstract void init(FMLInitializationEvent event);

    public abstract void registerRecipes(IForgeRegistry<IRecipe> r);

    public void removeRecipes(IForgeRegistry<IRecipe> r) {
        recipesToRemove.forEach((recipe) -> Crafting.removeRecipe(r, recipe));
    }

    public void registerAnvilRecipes(IForgeRegistry<AnvilRecipe> r) {
        anvilRecipes.forEach(r::register);
    }

    public void registerHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        heatRecipes.forEach(r::register);
    }

    public void registerBarrelRecipes(IForgeRegistry<BarrelRecipe> r) {
        barrelRecipes.forEach(r::register);
    }

    public void registerKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        knappingRecipes.forEach(r::register);
    }

    public void registerWeldingRecipes(IForgeRegistry<WeldingRecipe> r) {
        weldingRecipes.forEach(r::register);
    }
}
