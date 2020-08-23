package mrthomas20121.rocksalt.utils;

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
        return new FluidWrapper(newFluid, isDefault);
    }
    public static FluidWrapper getFluid(String fluidName, ResourceLocation still, ResourceLocation flow, int color)
    {
        return registerFluid(new Fluid(fluidName, still, flow, color));
    }
    public static FluidWrapper registerLiquid(String fluidName, int color)
    {
        return getFluid(fluidName, STILL, FLOW, color);
    }
    public static FluidWrapper registerMolten(String fluidName, int color)
    {
        return getFluid(fluidName, LAVA_STILL, LAVA_FLOW, color);
    }
}
