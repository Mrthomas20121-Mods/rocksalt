package mrthomas20121.rocksalt.objects.module;

import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class ModuleManager {

    private static ArrayList<ModuleCore> modules = new ArrayList<>();

    public ModuleManager() {

    }

    public static void addModule(ModuleCore moduleCore) {
        if(Loader.isModLoaded(moduleCore.getDependency())) {
            modules.add(moduleCore);
        }
    }

    public static void addModules(ModuleCore... modules) {
        for(ModuleCore module: modules) {
            addModule(module);
        }
    }

    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> r = event.getRegistry();
        modules.forEach(moduleCore -> {
            moduleCore.getRegistry().registerRecipes(r);
            moduleCore.getRegistry().registerAnvilRecipes(TFCRegistries.ANVIL);
            moduleCore.getRegistry().registerHeatRecipes(TFCRegistries.HEAT);
            moduleCore.getRegistry().registerBarrelRecipes(TFCRegistries.BARREL);
            moduleCore.getRegistry().registerKnappingRecipes(TFCRegistries.KNAPPING);
            moduleCore.getRegistry().registerWeldingRecipes(TFCRegistries.WELDING);
        });
    }
}
