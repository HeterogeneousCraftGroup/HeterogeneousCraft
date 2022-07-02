package net.heterogeneous.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MagicalendTool implements ToolMaterial {

    public static final MagicalendTool INSTANCE = new MagicalendTool();

    @Override
    //材料耐久
    public int getDurability() {
        return 233;
    }
    @Override
    //挖掘速度
    public float getMiningSpeedMultiplier() {
        return 10.0F;
    }
    @Override
    //材料伤害
    public float getAttackDamage() {
        return 0.0F;
    }
    @Override
    //挖掘等级
    public int getMiningLevel() {
        return 1;
    }
    @Override
    //附魔能力(越高越好(指等级
    public int getEnchantability() {
        return 15;
    }

    @Override
    //修复原料
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.POTATO);
    }

}
