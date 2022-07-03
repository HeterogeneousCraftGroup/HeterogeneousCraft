package net.heterogeneous.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.heterogeneous.blockentity.AnvilTableBlockEntity;
import net.heterogeneous.blockentity.Infusion;
import net.heterogeneous.blockentity.MagicTableBlockEntity;
import net.heterogeneous.item.BlockRegisterItem;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {
    public static final Block DEEPSLATE_MAGICALEND_ORE =  new OreBlock(FabricBlockSettings.of(Material.METAL).strength(2.0F).sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(3, 4));
    public static final Block ANVILTABLE = new AnvilTable(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block MAGICTABLE = new MagicTable(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block INFUSION_BLOCK = new InfusionBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static BlockEntityType<AnvilTableBlockEntity> ANVIL_TABLE_BLOCK_ENTITY;
    public static BlockEntityType<net.heterogeneous.blockentity.MagicTableBlockEntity> MAGICTABLE_BLOCK_ENTITY;
    public static BlockEntityType<Infusion> INFUSION;
    public static void register() {
        //方块物品注册
        BlockRegisterItem.registeritem(INFUSION_BLOCK,"infusion_block");
        BlockRegisterItem.registeritem(DEEPSLATE_MAGICALEND_ORE, "deepslate_magicalend_ore");
        BlockRegisterItem.registeritem(ANVILTABLE, "anvil_table");
        BlockRegisterItem.registeritem(MAGICTABLE, "magic_table");

        //方块注册
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "infusion_block"), INFUSION_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "deepslate_magicalend_ore"), DEEPSLATE_MAGICALEND_ORE);
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "anvil_table"), ANVILTABLE);
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "magic_table"), MAGICTABLE);

        //方块实体注册
        INFUSION = Registry.register(Registry.BLOCK_ENTITY_TYPE, "infusion", FabricBlockEntityTypeBuilder.create(Infusion::new, INFUSION_BLOCK).build(null));
        ANVIL_TABLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "anvil_table", FabricBlockEntityTypeBuilder.create(AnvilTableBlockEntity::new, ANVILTABLE).build(null));
        MAGICTABLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "magic_table", FabricBlockEntityTypeBuilder.create(MagicTableBlockEntity::new, MAGICTABLE).build(null));
        // Registry.register(Registry.ENTITY_TYPE, new Identifier("tut","firebullet"), FIRE_BULLET)
    }
}
