package cn.qiuye.shnn;

import cn.qiuye.shnn.api.Version;
import cn.qiuye.shnn.block.SuperLootFabBlock;
import cn.qiuye.shnn.gui.SuperLootFabContainer;
import cn.qiuye.shnn.tile.SuperLootFabTileEntity;

import dev.shadowsoffire.placebo.block_entity.TickingBlockEntityType;
import dev.shadowsoffire.placebo.menu.MenuUtil;
import dev.shadowsoffire.placebo.registry.DeferredHelper;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import com.google.common.collect.ImmutableSet;

public class SH {

    private static final DeferredHelper R = DeferredHelper.create(SHNN.MOD_ID);
    static BlockBehaviour.Properties DEFAULT_STATE = BlockBehaviour.Properties.of()
            .lightLevel((s) -> 1)
            .strength(4.0F, 3000.0F).noOcclusion();

    public SH() {}

    static void boootstrap() {
        SH.Blocks.bootstrap();
        SH.Items.bootstrap();
        SH.TileEntities.bootstrap();
        SH.Containers.bootstrap();
        SH.Tabs.bootstrap();
    }

    public static class Blocks {

        public static final RegistryObject<Block> ULTIMATE_LOOT_FABRICATOR_V1 = SH.R.block("super_loot_fabricator_v1", () -> new SuperLootFabBlock(DEFAULT_STATE, TileEntities.ULTIMATE_LOOT_FABRICATOR_V1::get, Containers.ULTIMATE_LOOT_FABRICATOR_V1::get, Version.V5));
        public static final RegistryObject<Block> ULTIMATE_LOOT_FABRICATOR_V2 = SH.R.block("super_loot_fabricator_v2", () -> new SuperLootFabBlock(DEFAULT_STATE, TileEntities.ULTIMATE_LOOT_FABRICATOR_V2::get, Containers.ULTIMATE_LOOT_FABRICATOR_V2::get, Version.V6));
        public static final RegistryObject<Block> ULTIMATE_LOOT_FABRICATOR_V3 = SH.R.block("super_loot_fabricator_v3", () -> new SuperLootFabBlock(DEFAULT_STATE, TileEntities.ULTIMATE_LOOT_FABRICATOR_V3::get, Containers.ULTIMATE_LOOT_FABRICATOR_V3::get, Version.V7));
        public static final RegistryObject<Block> ULTIMATE_LOOT_FABRICATOR_V4 = SH.R.block("super_loot_fabricator_v4", () -> new SuperLootFabBlock(DEFAULT_STATE, TileEntities.ULTIMATE_LOOT_FABRICATOR_V4::get, Containers.ULTIMATE_LOOT_FABRICATOR_V4::get, Version.VMAX));

        private static void bootstrap() {}
    }

    public static class Items {

        public static final RegistryObject<BlockItem> ULTIMATE_LOOT_FABRICATOR_V1 = SH.R.item("super_loot_fabricator_v1", () -> { return new BlockItem(Blocks.ULTIMATE_LOOT_FABRICATOR_V1.get(), new Item.Properties()); });;
        public static final RegistryObject<BlockItem> ULTIMATE_LOOT_FABRICATOR_V2 = SH.R.item("super_loot_fabricator_v2", () -> { return new BlockItem(Blocks.ULTIMATE_LOOT_FABRICATOR_V2.get(), new Item.Properties()); });;
        public static final RegistryObject<BlockItem> ULTIMATE_LOOT_FABRICATOR_V3 = SH.R.item("super_loot_fabricator_v3", () -> { return new BlockItem(Blocks.ULTIMATE_LOOT_FABRICATOR_V3.get(), new Item.Properties()); });;
        public static final RegistryObject<BlockItem> ULTIMATE_LOOT_FABRICATOR_V4 = SH.R.item("super_loot_fabricator_v4", () -> { return new BlockItem(Blocks.ULTIMATE_LOOT_FABRICATOR_V4.get(), new Item.Properties()); });;

        private static void bootstrap() {}
    }

    public static class TileEntities {

        public static final RegistryObject<BlockEntityType<SuperLootFabTileEntity>> ULTIMATE_LOOT_FABRICATOR_V1 = SH.R.blockEntity("super_loot_fabricator_v1", () -> new TickingBlockEntityType<>((pos, state) -> new SuperLootFabTileEntity(pos, state, TileEntities.ULTIMATE_LOOT_FABRICATOR_V1.get(), Version.V5), ImmutableSet.of(Blocks.ULTIMATE_LOOT_FABRICATOR_V1.get()), false, true));
        public static final RegistryObject<BlockEntityType<SuperLootFabTileEntity>> ULTIMATE_LOOT_FABRICATOR_V2 = SH.R.blockEntity("super_loot_fabricator_v2", () -> new TickingBlockEntityType<>((pos, state) -> new SuperLootFabTileEntity(pos, state, TileEntities.ULTIMATE_LOOT_FABRICATOR_V2.get(), Version.V6), ImmutableSet.of(Blocks.ULTIMATE_LOOT_FABRICATOR_V2.get()), false, true));
        public static final RegistryObject<BlockEntityType<SuperLootFabTileEntity>> ULTIMATE_LOOT_FABRICATOR_V3 = SH.R.blockEntity("super_loot_fabricator_v3", () -> new TickingBlockEntityType<>((pos, state) -> new SuperLootFabTileEntity(pos, state, TileEntities.ULTIMATE_LOOT_FABRICATOR_V3.get(), Version.V7), ImmutableSet.of(Blocks.ULTIMATE_LOOT_FABRICATOR_V3.get()), false, true));
        public static final RegistryObject<BlockEntityType<SuperLootFabTileEntity>> ULTIMATE_LOOT_FABRICATOR_V4 = SH.R.blockEntity("super_loot_fabricator_v4", () -> new TickingBlockEntityType<>((pos, state) -> new SuperLootFabTileEntity(pos, state, TileEntities.ULTIMATE_LOOT_FABRICATOR_V4.get(), Version.VMAX), ImmutableSet.of(Blocks.ULTIMATE_LOOT_FABRICATOR_V4.get()), false, true));

        private static void bootstrap() {}
    }

    public static class Containers {

        public static final RegistryObject<MenuType<SuperLootFabContainer>> ULTIMATE_LOOT_FABRICATOR_V1 = SH.R.menu("super_loot_fabricator_v1", () -> MenuUtil.posType((id, pInv, pos) -> new SuperLootFabContainer(id, pInv, pos, Containers.ULTIMATE_LOOT_FABRICATOR_V1.get(), Blocks.ULTIMATE_LOOT_FABRICATOR_V1.get())));
        public static final RegistryObject<MenuType<SuperLootFabContainer>> ULTIMATE_LOOT_FABRICATOR_V2 = SH.R.menu("super_loot_fabricator_v2", () -> MenuUtil.posType((id, pInv, pos) -> new SuperLootFabContainer(id, pInv, pos, Containers.ULTIMATE_LOOT_FABRICATOR_V2.get(), Blocks.ULTIMATE_LOOT_FABRICATOR_V2.get())));
        public static final RegistryObject<MenuType<SuperLootFabContainer>> ULTIMATE_LOOT_FABRICATOR_V3 = SH.R.menu("super_loot_fabricator_v3", () -> MenuUtil.posType((id, pInv, pos) -> new SuperLootFabContainer(id, pInv, pos, Containers.ULTIMATE_LOOT_FABRICATOR_V3.get(), Blocks.ULTIMATE_LOOT_FABRICATOR_V3.get())));
        public static final RegistryObject<MenuType<SuperLootFabContainer>> ULTIMATE_LOOT_FABRICATOR_V4 = SH.R.menu("super_loot_fabricator_v4", () -> MenuUtil.posType((id, pInv, pos) -> new SuperLootFabContainer(id, pInv, pos, Containers.ULTIMATE_LOOT_FABRICATOR_V4.get(), Blocks.ULTIMATE_LOOT_FABRICATOR_V4.get())));

        private static void bootstrap() {}
    }

    public static class Tabs {

        public static final ResourceKey<CreativeModeTab> SHNN_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, SHNN.id("tab"));
        public static final RegistryObject<CreativeModeTab> SHNN_TAB = SH.R.tab("tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.extrahnn")).icon(() -> (SH.Items.ULTIMATE_LOOT_FABRICATOR_V4.get()).getDefaultInstance()).build());

        private static void bootstrap() {}
    }
}
