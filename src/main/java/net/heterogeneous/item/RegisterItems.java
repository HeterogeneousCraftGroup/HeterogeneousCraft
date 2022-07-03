package net.heterogeneous.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.heterogeneous.Main;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

    public static final InfusionStick INFUSION_STICK = new InfusionStick(new FabricItemSettings().group(Main.HC_GROUP));
    public static final FireMagicBookPage Fire = new FireMagicBookPage(new FabricItemSettings().group(Main.HC_GROUP));
    public static final IceMagicBookPage Ice = new IceMagicBookPage(new FabricItemSettings().group(Main.HC_GROUP));
    public static final MagicBookPage BOOK_PAGE = new MagicBookPage(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Item DARKNESS_LEATHER = new Item(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Item MAGICALEND = new Item(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Template TEMPLATE = new Template(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Template SWORD_TEMPLATE = new Template(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Template DAGGER_TEMPLATE = new Template(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Template AXE_TEMPLATE = new Template(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Template SICKLE_TEMPLATE = new Template(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Template PICKAXE_TEMPLATE = new Template(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Template INGOT_TEMPLATE = new Template(new FabricItemSettings().group(Main.HC_GROUP));
    public static final Hammers FORGING_HAMMER = new Hammers(new FabricItemSettings().group(Main.HC_GROUP));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "fire"), Fire);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "ice"), Ice);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "bookpage"), BOOK_PAGE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "darkness_leather"), DARKNESS_LEATHER);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "infusion_stick"), INFUSION_STICK);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "magicalend"), MAGICALEND);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "template"), TEMPLATE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "sword_template"), SWORD_TEMPLATE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "dagger_template"), DAGGER_TEMPLATE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "axe_template"), AXE_TEMPLATE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "sickle_template"), SICKLE_TEMPLATE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "pickaxe_template"), PICKAXE_TEMPLATE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "ingot_template"), INGOT_TEMPLATE);
        Registry.register(Registry.ITEM, new Identifier("heterogeneouscraft", "forging_hammer"), FORGING_HAMMER);
    }
}
