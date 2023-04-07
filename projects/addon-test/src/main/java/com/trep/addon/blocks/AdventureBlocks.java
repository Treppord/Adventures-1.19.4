package com.trep.addon.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import com.trep.addon.TestAddon;

import java.util.List;

public class AdventureBlocks {


    public static final Block SMITHING_ANVIL = registerBlock("fabricator",
            new FabricatorBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool().nonOpaque()), TestAddon.AdventuresBlocksTab);

    public static final Block BLASTER_TABLE = registerBlock("blaster_table",
            new BlasterTableBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool().nonOpaque()), TestAddon.AdventuresBlocksTab);

    public static final Block MARKET_STATION = registerBlock("merchant_station",
            new MarketStationBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool().nonOpaque()), TestAddon.AdventuresBlocksTab);

    public static final Block NEVARRO_STONE = registerBlock("nevarro_stone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), TestAddon.AdventuresBlocksTab);

    public static final Block C3PO_HEAD = registerBlock("c3po_head",
            new C3POBlock(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), TestAddon.AdventuresBlocksTab);
            public static final Block C3PO_BODY = registerBlock("c3po_body",
            new C3POChestBlock(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), TestAddon.AdventuresBlocksTab);
            public static final Block C3PO_LEGGINGS = registerBlock("c3po_leggings",
            new C3POLegsBlock(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), TestAddon.AdventuresBlocksTab);

    public static final Block NEVARRO_STONE_SMOOTH = registerBlock("nevarro_stone_smooth",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), TestAddon.AdventuresBlocksTab);

    public static final Block NEVARRO_STONE_BRICK = registerBlock("nevarro_stone_brick",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), TestAddon.AdventuresBlocksTab);
            
    public static final Block SCRAP_METAL = registerBlock("scrap_metal",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), TestAddon.AdventuresBlocksTab);

    public static final Block BLUE_KYBER_CRYSTAL = registerBlock("blue_kyber_crystal",
            new BlueKyberCrystal(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5), null), TestAddon.AdventuresBlocksTab);
public static final Block GREEN_KYBER_CRYSTAL = registerBlock("green_kyber_crystal",
                    new BlueKyberCrystal(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5), null), TestAddon.AdventuresBlocksTab);
public static final Block YELLOW_KYBER_CRYSTAL = registerBlock("yellow_kyber_crystal",
                            new BlueKyberCrystal(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5), null), TestAddon.AdventuresBlocksTab);
public static final Block ORANGE_KYBER_CRYSTAL = registerBlock("orange_kyber_crystal",
                                    new BlueKyberCrystal(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5), null), TestAddon.AdventuresBlocksTab);
public static final Block RED_KYBER_CRYSTAL = registerBlock("red_kyber_crystal",
                                            new BlueKyberCrystal(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5), null), TestAddon.AdventuresBlocksTab);
    public static final Block PURPLE_KYBER_CRYSTAL = registerBlock("purple_kyber_crystal",
            new BlueKyberCrystal(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5), null), TestAddon.AdventuresBlocksTab);
    public static final Block CYAN_KYBER_CRYSTAL = registerBlock("cyan_kyber_crystal",
            new BlueKyberCrystal(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5), null), TestAddon.AdventuresBlocksTab);


    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registries.BLOCK, new Identifier(TestAddon.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, name),
                new BlockItem(block, new FabricItemSettings()) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
                    }
                });
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.BLOCK, new Identifier(TestAddon.MODID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(TestAddon.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TestAddon.LOGGER.info("Registering ModBlocks for " + TestAddon.MODID);
    }

}