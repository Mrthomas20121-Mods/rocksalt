package mrthomas20121.rocksalt.utils;

import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class OredictUtils {

    public static void add(String metal, String newName)
    {
        add(MetalUtils.getMetal(metal), newName);
    }

    public static void add(Metal metal, String newName)
    {
        for(Metal.ItemType itemType : Metal.ItemType.values())
        {
            if(itemType.equals(Metal.ItemType.DOUBLE_INGOT) || itemType.equals(Metal.ItemType.INGOT) || itemType.equals(Metal.ItemType.DOUBLE_SHEET) || itemType.equals(Metal.ItemType.SHEET) || itemType.equals(Metal.ItemType.SCRAP) || itemType.equals(Metal.ItemType.DUST))
            {
                Item itemMetal = ItemMetal.get(metal, itemType);
                OreDictionary.registerOre(fromItemType(itemType)+StringUtils.capitalize(newName.toLowerCase()), itemMetal);
            }

        }
    }

    private static String fromItemType(Metal.ItemType  itemType)
    {
        if(itemType.equals(Metal.ItemType.DOUBLE_INGOT) || itemType.equals(Metal.ItemType.DOUBLE_SHEET)) {
            String[] name = itemType.name().toLowerCase().split("_");
            return StringUtils.capitalize(name[1])+StringUtils.capitalize(name[0]);
        }
        return itemType.name().toLowerCase();
    }
}
