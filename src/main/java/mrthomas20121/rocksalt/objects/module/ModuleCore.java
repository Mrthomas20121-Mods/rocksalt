package mrthomas20121.rocksalt.objects.module;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class ModuleCore {

    private final ResourceLocation name;
    private RegistryCore registry;

    public ModuleCore(ResourceLocation name) {
        this.name = name;
    }

    public ResourceLocation getName() {
        return name;
    }

    public String getDependency() {
        return name.getNamespace();
    }

    public void addRegistry(RegistryCore registry) {
        this.registry = registry;
    }

    public RegistryCore getRegistry() {
        return registry;
    }

    public abstract void preInit(FMLPreInitializationEvent event);

    public abstract void init(FMLInitializationEvent event);

    public abstract void postInit(FMLPostInitializationEvent event);


}
