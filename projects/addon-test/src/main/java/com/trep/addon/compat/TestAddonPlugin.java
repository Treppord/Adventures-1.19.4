package com.trep.addon.compat;
import com.trep.addon.TestAddon;
import com.trep.addon.blocks.AdventureBlocks;
import com.trep.addon.recipe.BlasterTableRecipe;
import com.trep.addon.recipe.FabricatorRecipe;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;

public class TestAddonPlugin implements REIClientPlugin


{
    public static final CategoryIdentifier<FabricatorDisplay> FABRICATOR_DISPLAY_CATEGORY_IDENTIFIER = CategoryIdentifier.of(FabricatorRecipe.Type.ID);
    public static final CategoryIdentifier<BlasterTableDisplay> BLASTER_TABLE_DISPLAY_CATEGORY_IDENTIFIER = CategoryIdentifier.of(BlasterTableRecipe.Type.ID);


    @Override
    public void registerCategories(CategoryRegistry registry)
    {
        registry.add(new FabricatorCategory());
        registry.add(new BlasterTableCategory());

        registry.addWorkstations(FABRICATOR_DISPLAY_CATEGORY_IDENTIFIER, EntryStacks.of(AdventureBlocks.SMITHING_ANVIL));
        registry.addWorkstations(BLASTER_TABLE_DISPLAY_CATEGORY_IDENTIFIER, EntryStacks.of(AdventureBlocks.BLASTER_TABLE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry)
    {
        registry.registerFiller(FabricatorRecipe.class, FabricatorDisplay::new);
        registry.registerFiller(BlasterTableRecipe.class, BlasterTableDisplay::new);
    }

    @Override
    public void registerEntries(EntryRegistry registry)
    {
        registry.removeEntry(EntryStacks.of(new ItemStack(TestAddon.PSWGADDON_TAB_ITEM)));
    }
}