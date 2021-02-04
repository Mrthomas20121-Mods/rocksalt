package mrthomas20121.rocksalt.objects.blocks;

import net.dries007.tfc.api.capability.size.IItemSize;
import net.dries007.tfc.api.capability.size.Size;
import net.dries007.tfc.api.capability.size.Weight;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public abstract class BlockTFC extends Block implements IItemSize {

    public BlockTFC(Material material)
    {
        super(material);
    }

    @Nonnull
    @Override
    public abstract Size getSize(@Nonnull ItemStack itemStack);

    @Nonnull
    @Override
    public abstract Weight getWeight(@Nonnull ItemStack itemStack);
}
