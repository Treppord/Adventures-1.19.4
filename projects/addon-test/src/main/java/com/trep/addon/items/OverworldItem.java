package com.trep.addon.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.ServerCommandSource;

import java.util.List;

public class OverworldItem extends Item {
    public OverworldItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ServerCommandSource source = user.getCommandSource().withLevel(4);
            try {
                String command = "cdim minecraft:overworld";
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
            tooltip.add(Text.literal("Overworld").formatted(Formatting.YELLOW));
        } else {
            tooltip.add(Text.literal("<Press Shift for more info!>").formatted(Formatting.GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}