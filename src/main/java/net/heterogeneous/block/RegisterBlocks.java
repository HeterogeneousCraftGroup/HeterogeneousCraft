package net.heterogeneous.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.heterogeneous.blockentity.*;
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
    public static final Block DEEPSLATE_MAGICALEND_ORE =  new OreBlock(FabricBlockSettings.of(Material.METAL).strength(2.0F).requiresTool().sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(3, 4));
    public static final Block ANVILTABLE = new AnvilTable(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block MAGICTABLE = new MagicTable(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block INFUSION_BLOCK = new InfusionBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block LIQUID_CONTAINER = new LiquidContainer(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block BASE_MELTING_FURNACE = new BaseMeltingFurnace(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block LIQUID_LEAK_TAP = new LiquidLeakTap(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static BlockEntityType<AnvilTableBlockEntity> ANVIL_TABLE_BLOCK_ENTITY;
    public static BlockEntityType<net.heterogeneous.blockentity.MagicTableBlockEntity> MAGICTABLE_BLOCK_ENTITY;
    public static BlockEntityType<Infusion> INFUSION;
    public static BlockEntityType<LiquidContainerEntity> LIQUID_CONTAINER_ENTITY;
    public static BlockEntityType<BaseMeltingFurnaceEntity> BASE_MELTING_FURNACE_ENTITY;
    public static BlockEntityType<LiquidLeakTapEntity> LIQUID_LEAK_TAP_ENTITY;
    public static void register() {
        //方块物品注册
        BlockRegisterItem.registeritem(INFUSION_BLOCK,"infusion_block");
        BlockRegisterItem.registeritem(DEEPSLATE_MAGICALEND_ORE, "deepslate_magicalend_ore");
        BlockRegisterItem.registeritem(ANVILTABLE, "anvil_table");
        BlockRegisterItem.registeritem(MAGICTABLE, "magic_table");
        BlockRegisterItem.registeritem(LIQUID_CONTAINER, "liquid_container");
        BlockRegisterItem.registeritem(BASE_MELTING_FURNACE, "base_melting_furnace");
        BlockRegisterItem.registeritem(LIQUID_LEAK_TAP, "liquid_leak_tap");

        //方块注册
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "infusion_block"), INFUSION_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "deepslate_magicalend_ore"), DEEPSLATE_MAGICALEND_ORE);
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "anvil_table"), ANVILTABLE);
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "magic_table"), MAGICTABLE);
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "liquid_container"), LIQUID_CONTAINER);
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "base_melting_furnace"), BASE_MELTING_FURNACE);
        Registry.register(Registry.BLOCK, new Identifier("heterogeneouscraft", "liquid_leak_tap"), LIQUID_LEAK_TAP);

        //方块实体注册
        INFUSION = Registry.register(Registry.BLOCK_ENTITY_TYPE, "infusion", FabricBlockEntityTypeBuilder.create(Infusion::new, INFUSION_BLOCK).build(null));
        ANVIL_TABLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "anvil_table", FabricBlockEntityTypeBuilder.create(AnvilTableBlockEntity::new, ANVILTABLE).build(null));
        MAGICTABLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "magic_table", FabricBlockEntityTypeBuilder.create(MagicTableBlockEntity::new, MAGICTABLE).build(null));
        LIQUID_CONTAINER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "liquid_container", FabricBlockEntityTypeBuilder.create(LiquidContainerEntity::new, LIQUID_CONTAINER).build(null));
        BASE_MELTING_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "base_melting_furnace", FabricBlockEntityTypeBuilder.create(BaseMeltingFurnaceEntity::new, BASE_MELTING_FURNACE).build(null));
        LIQUID_LEAK_TAP_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "liquid_leak_tap", FabricBlockEntityTypeBuilder.create(LiquidLeakTapEntity::new, LIQUID_LEAK_TAP).build(null));
        // Registry.register(Registry.ENTITY_TYPE, new Identifier("tut","firebullet"), FIRE_BULLET)
    }
}
