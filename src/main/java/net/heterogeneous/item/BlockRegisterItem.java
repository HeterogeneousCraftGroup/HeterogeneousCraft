package net.heterogeneous.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.heterogeneous.Main;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegisterItem {
    public static BlockItem registeritem(Block block,String path) {
        return Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", path), new BlockItem(block,new FabricItemSettings().group(Main.HC_GROUP)));
    }
}
