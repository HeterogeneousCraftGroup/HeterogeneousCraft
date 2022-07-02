package net.heterogeneous.item;

import net.heterogeneous.Main;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterArmorItems {

    public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new MagicalendArmor();
    // 如果创建了新的材料，则你需要注意这里。
    public static final Item MAGICALEND_HELMET = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(Main.TUT_GROUP));
    public static final Item MAGICALEND_CHESTPLATE = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(Main.TUT_GROUP));
    public static final Item MAGICALEND_LEGGINGS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(Main.TUT_GROUP));
    public static final Item MAGICALEND_BOOTS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(Main.TUT_GROUP));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("tut", "magicalend_helmet"), MAGICALEND_HELMET);
        Registry.register(Registry.ITEM, new Identifier("tut", "magicalend_chestplate"), MAGICALEND_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("tut", "magicalend_leggings"), MAGICALEND_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("tut", "magicalend_boots"), MAGICALEND_BOOTS);
    }
}
