package mrthomas20121.rocksalt.utils;

import com.google.common.collect.HashBiMap;
import net.dries007.tfc.objects.fluids.FluidsTFC;
import net.dries007.tfc.objects.fluids.properties.FluidWrapper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import javax.annotation.Nonnull;

public class FluidUtils {

    private static final ResourceLocation STILL = new ResourceLocation("tfc", "blocks/fluid_still");
    private static final ResourceLocation FLOW = new ResourceLocation("tfc", "blocks/fluid_flow");
    private static final ResourceLocation LAVA_STILL = new ResourceLocation("tfc", "blocks/lava_still");
    private static final ResourceLocation LAVA_FLOW = new ResourceLocation("tfc", "blocks/lava_flow");

    private static FluidWrapper registerFluid(@Nonnull Fluid newFluid) {
        boolean isDefault = FluidRegistry.registerFluid(newFluid);
        if (!isDefault) {
            newFluid = FluidRegistry.getFluid(newFluid.getName());
        }

        FluidRegistry.addBucketForFluid(newFluid);
        FluidWrapper properties = new FluidWrapper(newFluid, isDefault);
        return properties;
    }
    public static FluidWrapper registerLiquid(String fluidName, int color)
    {
        return registerFluid(new Fluid(fluidName, STILL, FLOW, color));
    }
    public static FluidWrapper registerMolten(String fluidName, int color)
    {
        return registerFluid(new Fluid(fluidName, LAVA_STILL, LAVA_FLOW, color));
    }
}
