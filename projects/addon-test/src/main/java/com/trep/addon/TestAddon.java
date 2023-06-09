package com.trep.addon;


import com.parzivail.pswg.api.PswgAddon;
import com.parzivail.pswg.container.SwgItems;
import com.parzivail.util.Lumberjack;
import com.parzivail.util.registry.RegistryHelper;
import com.trep.addon.blocks.AdventureBlocks;
import com.trep.addon.blocks.entity.AdventureBlockEntities;
import com.trep.addon.entity.AdventureVillagers;
import com.trep.addon.entity.CustomSnowballEntity;
import com.trep.addon.entity.ForceDarkEntity;
import com.trep.addon.entity.ForceLightEntity;
import com.trep.addon.entity.TestEntities;
import com.trep.addon.entity.custom.BithEntity;
import com.trep.addon.entity.custom.C3POEntity;
import com.trep.addon.entity.custom.MDEntity;
import com.trep.addon.entity.custom.ZabrakEntity;
import com.trep.addon.entity.custom.RodianEntity;
import com.trep.addon.entity.custom.TrandoshanEntity;
import com.trep.addon.items.AdventureItems;
import com.trep.addon.recipe.ModRecipes;
import com.trep.addon.recipe.TestRecipeType;
import com.trep.addon.screen.ModScreenHandlers;
import com.trep.addon.trinkets.BobaCapeTrinket;
import com.trep.addon.trinkets.BobaJetpackTrinket;
import com.trep.addon.trinkets.JediMaskTrinket;
import com.trep.addon.trinkets.MandoCape2Trinket;
import com.trep.addon.trinkets.MandoCapeTrinket;
import com.trep.addon.trinkets.MandoJetpackTrinket;
import com.trep.addon.trinkets.VaderCapeTrinket;
import com.trep.addon.util.AdventureSounds;
import com.trep.addon.util.AdventureStatistics;
import com.trep.addon.util.AdventureTags;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAddon implements PswgAddon
{
	public static final String MODID = "pswg-adventures";
	public static final Lumberjack LOG = new Lumberjack(MODID);

	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final ItemGroup AdventuresTab = FabricItemGroup.builder(new Identifier (TestAddon.MODID, "items")).icon(() -> new ItemStack(AdventureItems.BESKAR_ALLOY)).build();
	public static final ItemGroup AdventuresBlocksTab = FabricItemGroup.builder(new Identifier (TestAddon.MODID, "blocks")).icon(() -> new ItemStack(AdventureItems.BRONZE_CREDIT)).build();

	public static Item TEST_TRINKET;
	public static Item TEST_TRINKET_2;
	public static Item TEST_TRINKET_3;
	public static Item TEST_TRINKET_4;
	public static Item TEST_TRINKET_5;
	public static Item TEST_TRINKET_6;
	public static Item TEST_TRINKET_7;

	public static Item PSWGADDON_TAB_ITEM = Registry.register(Registries.ITEM, TestAddon.id("alloygery_tab_item"), new Item(new Item.Settings()));
	

	public static final EntityType<CustomSnowballEntity> CustomSnowballEntityType = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(TestAddon.MODID, "thermal_detonator"),
		FabricEntityTypeBuilder.<CustomSnowballEntity>create(SpawnGroup.MISC, CustomSnowballEntity::new)
				.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
				.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
				.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
);

public static final EntityType<ForceLightEntity> ForceLightEntityType = Registry.register(
	Registries.ENTITY_TYPE,
	new Identifier(TestAddon.MODID, "force_light"),
	FabricEntityTypeBuilder.<ForceLightEntity>create(SpawnGroup.MISC, ForceLightEntity::new)
			.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
			.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
			.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
);

public static final EntityType<ForceDarkEntity> ForceDarkEntityType = Registry.register(
	Registries.ENTITY_TYPE,
	new Identifier(TestAddon.MODID, "force_dark"),
	FabricEntityTypeBuilder.<ForceDarkEntity>create(SpawnGroup.MISC, ForceDarkEntity::new)
			.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
			.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
			.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
);



	@Override
	public void onPswgReady()
	{

		TEST_TRINKET = Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, "vader_cape"), new VaderCapeTrinket(new Item.Settings().maxCount(1).maxDamage(100)));
		TEST_TRINKET_2 = Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, "mando_cape"), new MandoCapeTrinket(new Item.Settings().maxCount(1).maxDamage(100)));
		TEST_TRINKET_3 = Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, "mando_cape_2"), new MandoCape2Trinket(new Item.Settings().maxCount(1).maxDamage(100)));
		TEST_TRINKET_4 = Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, "holocron_1"), new JediMaskTrinket(new Item.Settings().maxCount(1).maxDamage(100)));
		TEST_TRINKET_5 = Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, "boba_cape"), new BobaCapeTrinket(new Item.Settings().maxCount(1).maxDamage(100)));
		TEST_TRINKET_6 = Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, "mando_jetpack"), new MandoJetpackTrinket(new Item.Settings().maxCount(1).maxDamage(100)));
		TEST_TRINKET_7 = Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, "boba_jetpack"), new BobaJetpackTrinket(new Item.Settings().maxCount(1).maxDamage(100)));

		Registry.register(Registries.SOUND_EVENT, AdventureSounds.TD_ID, AdventureSounds.THERMAL_DETONATOR_EVENT);


		AdventureItems.registerModItems();
		AdventureBlocks.registerModBlocks();



		AdventureVillagers.registerVillagers();
		AdventureVillagers.registerTrades();

		TestEntities.register();

		AdventureBlockEntities.registerAllBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();
		ModRecipes.registerRecipes();
		TestRecipeType.register();

		AdventureStatistics.register();
		AdventureTags.register();



		RegistryHelper.registerAutoId(MODID, AdventureItems.class, Object.class, SwgItems::tryRegisterItem);

		FabricDefaultAttributeRegistry.register(TestEntities.TRANDOSHAN, TrandoshanEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(TestEntities.BITH, BithEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(TestEntities.RODIAN, RodianEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(TestEntities.ZABRAK, ZabrakEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(TestEntities.C3PO, C3POEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(TestEntities.MD, MDEntity.setAttributes());

		LOG.log("PSWG Legends Enabled!");
	}
	public static Identifier id(String path)
	{
		return new Identifier(MODID, path);
	}
}
