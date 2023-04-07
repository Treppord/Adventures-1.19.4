package com.trep.addon.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.trep.addon.TestAddon;

import java.util.List;

public class NevarroItem extends Item {
    public NevarroItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ServerCommandSource source = user.getCommandSource().withLevel(4);
            try {
                String command = "cdim pswg-adventures:nevarro";
                source.getServer().getCommandManager().getDispatcher().execute(command, source);
            } catch (CommandSyntaxException e) {
                e.printStackTrace();
            }
        }
        return super.use(world, user, hand);
    }
    

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Nevarro").formatted(Formatting.YELLOW));
        } else {
            tooltip.add(Text.literal("<Press Shift for more info!>").formatted(Formatting.GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
