package net.heterogeneous.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.heterogeneous.Main;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterMaterielsItems {

    public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new MagicalendArmor();
    // 如果创建了新的材料，则你需要注意这里。
    public static ToolItem MAGICAL_END_SWORD = new SwordItem(MagicalendTool.INSTANCE, 9, -2.4F, new FabricItemSettings().group(Main.HC_GROUP));
    public static ToolItem MAGICAL_END_SICKLE = new SwordItem(MagicalendTool.INSTANCE, 7, -1.8F, new FabricItemSettings().group(Main.HC_GROUP));
    public static ToolItem MAGICAL_END_SHOVEL = new ShovelItem(MagicalendTool.INSTANCE, 3, -1.5F, new FabricItemSettings().group(Main.HC_GROUP));
    public static ToolItem MAGICAL_END_AXE = new CustomAxeItem(MagicalendTool.INSTANCE, 13, -3.0F, new FabricItemSettings().group(Main.HC_GROUP));
    public static ToolItem MAGICAL_END_PICKAXE = new CustomPickaxeItem(MagicalendTool.INSTANCE, 4, -2.8F, new FabricItemSettings().group(Main.HC_GROUP));

    public static final Item MAGICALEND_HELMET = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(Main.HC_GROUP));
    public static final Item MAGICALEND_CHESTPLATE = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(Main.HC_GROUP));
    public static final Item MAGICALEND_LEGGINGS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(Main.HC_GROUP));
    public static final Item MAGICALEND_BOOTS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(Main.HC_GROUP));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend_sword"), MAGICAL_END_SWORD);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend_sickle"), MAGICAL_END_SICKLE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend_shovel"), MAGICAL_END_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend_axe"), MAGICAL_END_AXE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend_pickaxe"), MAGICAL_END_PICKAXE);

        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend_helmet"), MAGICALEND_HELMET);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend_chestplate"), MAGICALEND_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend_leggings"), MAGICALEND_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend_boots"), MAGICALEND_BOOTS);
    }
}
