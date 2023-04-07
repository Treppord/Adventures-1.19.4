package com.trep.addon.compat;

import com.trep.addon.recipe.BlasterTableRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public record BlasterTableDisplay(BlasterTableRecipe recipe) implements Display {


	@Override
	public List<EntryIngredient> getInputEntries() {
		return EntryIngredients.ofIngredients(recipe.getIngredients());
	}

	@Override
	public List<EntryIngredient> getOutputEntries() {
		return List.of(EntryIngredients.of(recipe.getOutput()));
	}

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return TestAddonPlugin.BLASTER_TABLE_DISPLAY_CATEGORY_IDENTIFIER;
    }
}