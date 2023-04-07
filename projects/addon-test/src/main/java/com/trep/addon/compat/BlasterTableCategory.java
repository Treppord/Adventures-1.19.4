package com.trep.addon.compat;

import com.trep.addon.blocks.AdventureBlocks;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import java.util.ArrayList;
import java.util.List;

public class BlasterTableCategory implements DisplayCategory<BlasterTableDisplay> {
    private static final Text TITLE = Text.of(I18n.translate("gui.rei.category.blaster_table"));
    private static final EntryStack<ItemStack> ICON = EntryStacks.of(new ItemStack(AdventureBlocks.BLASTER_TABLE));

    @Override
    public CategoryIdentifier<? extends BlasterTableDisplay> getCategoryIdentifier() {
        return TestAddonPlugin.BLASTER_TABLE_DISPLAY_CATEGORY_IDENTIFIER;
    }

    @Override
    public EntryStack<ItemStack> getIcon() {
        return ICON;
    }

    @Override
    public Text getTitle() {
        return TITLE;
    }

    @Override
    public List<Widget> setupDisplay(BlasterTableDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();
        
        // create a new list of entries
        List<EntryStack<?>> entries = new ArrayList<>();

        
        
        List<EntryStack<?>> inputEntries = entries.subList(0, Math.min(entries.size(), 2));
        List<EntryStack<?>> outputEntries = entries.subList(2, Math.min(entries.size(), 3));
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createResultSlotBackground(new Point(bounds.x + 63, bounds.y + 19)));
        widgets.add(Widgets.createSlot(new Point(bounds.x + 29, bounds.y + 19)).entries(outputEntries).disableBackground().markOutput());
        widgets.add(Widgets.createArrow(new Point(bounds.x + 24, bounds.y + 19)).animationDurationTicks(50));
        if (!inputEntries.isEmpty()) {
            widgets.add(Widgets.createSlot(new Point(bounds.x + 1, bounds.y + 1)).entries(inputEntries).markInput());
        }
        if (inputEntries.size() >= 2) {
            widgets.add(Widgets.createSlot(new Point(bounds.x + 1, bounds.y + 19)).entries(inputEntries.subList(1, 2)).markInput());
        }
    
        return widgets;
    }
    
}