package net.heterogeneous.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static net.heterogeneous.item.RegisterItems.MAGICALEND;

public class MagicalendArmor implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {5, 8, 10, 5};

    // 四个数值依次对应脚，腿，甲，头
    // 例如，皮革使用{1, 2, 3, 1}，钻石和下界合金使用{3, 6, 8, 3}
    @Override
    //耐久值
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 50;
    }

    @Override
    //护甲值
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    //附魔能力
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    //修复材料
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(MAGICALEND);
    }

    @Override
    //材料(父材料)
    public String getName() {
        // Must be all lowercase
        return "magicalend";
    }

    @Override
    //韧性(击退抵抗)
    public float getToughness() {
        return 1.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1F;
    }
}
