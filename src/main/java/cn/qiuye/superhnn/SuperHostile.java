package cn.qiuye.superhnn;

import cn.qiuye.superhnn.api.Version;
import cn.qiuye.superhnn.block.SuperLootFabBlock;
import cn.qiuye.superhnn.gui.SuperLootFabContainer;
import cn.qiuye.superhnn.tile.SuperLootFabTileEntity;
import com.google.common.collect.ImmutableSet;
import dev.shadowsoffire.placebo.block_entity.TickingBlockEntityType;
import dev.shadowsoffire.placebo.menu.MenuUtil;
import dev.shadowsoffire.placebo.registry.DeferredHelper;
import lombok.experimental.UtilityClass;
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

@UtilityClass
public class SuperHostile {

    private final DeferredHelper R = DeferredHelper.create(SuperHostileNetworks.MOD_ID);
    BlockBehaviour.Properties DEFAULT_STATE = BlockBehaviour.Properties.of()
            .lightLevel((s) -> 1)
            .strength(4.0F, 3000.0F).noOcclusion();

    void bootstrap() {
        Blocks.bootstrap();
        Items.bootstrap();
        TileEntities.bootstrap();
        Containers.bootstrap();
        Tabs.bootstrap();
    }

    @UtilityClass
    public class Blocks {

        public final RegistryObject<Block> ULTIMATE_LOOT_FABRICATOR_V1 = SuperHostile.R.block("super_loot_fabricator_v1", () -> new SuperLootFabBlock(DEFAULT_STATE, TileEntities.ULTIMATE_LOOT_FABRICATOR_V1::get, Containers.ULTIMATE_LOOT_FABRICATOR_V1::get, Version.V5));
        public final RegistryObject<Block> ULTIMATE_LOOT_FABRICATOR_V2 = SuperHostile.R.block("super_loot_fabricator_v2", () -> new SuperLootFabBlock(DEFAULT_STATE, TileEntities.ULTIMATE_LOOT_FABRICATOR_V2::get, Containers.ULTIMATE_LOOT_FABRICATOR_V2::get, Version.V6));
        public final RegistryObject<Block> ULTIMATE_LOOT_FABRICATOR_V3 = SuperHostile.R.block("super_loot_fabricator_v3", () -> new SuperLootFabBlock(DEFAULT_STATE, TileEntities.ULTIMATE_LOOT_FABRICATOR_V3::get, Containers.ULTIMATE_LOOT_FABRICATOR_V3::get, Version.V7));
        public final RegistryObject<Block> ULTIMATE_LOOT_FABRICATOR_V4 = SuperHostile.R.block("super_loot_fabricator_v4", () -> new SuperLootFabBlock(DEFAULT_STATE, TileEntities.ULTIMATE_LOOT_FABRICATOR_V4::get, Containers.ULTIMATE_LOOT_FABRICATOR_V4::get, Version.VMAX));

        private void bootstrap() {
        }
    }

    @UtilityClass
    public class Items {

        public final RegistryObject<BlockItem> ULTIMATE_LOOT_FABRICATOR_V1 = SuperHostile.R.item("super_loot_fabricator_v1", () -> new BlockItem(Blocks.ULTIMATE_LOOT_FABRICATOR_V1.get(), new Item.Properties()));
        public final RegistryObject<BlockItem> ULTIMATE_LOOT_FABRICATOR_V2 = SuperHostile.R.item("super_loot_fabricator_v2", () -> new BlockItem(Blocks.ULTIMATE_LOOT_FABRICATOR_V2.get(), new Item.Properties()));
        public final RegistryObject<BlockItem> ULTIMATE_LOOT_FABRICATOR_V3 = SuperHostile.R.item("super_loot_fabricator_v3", () -> new BlockItem(Blocks.ULTIMATE_LOOT_FABRICATOR_V3.get(), new Item.Properties()));
        public final RegistryObject<BlockItem> ULTIMATE_LOOT_FABRICATOR_V4 = SuperHostile.R.item("super_loot_fabricator_v4", () -> new BlockItem(Blocks.ULTIMATE_LOOT_FABRICATOR_V4.get(), new Item.Properties()));

        private void bootstrap() {
        }
    }

    @UtilityClass
    public class TileEntities {

        private void bootstrap() {
        }        public final RegistryObject<BlockEntityType<SuperLootFabTileEntity>> ULTIMATE_LOOT_FABRICATOR_V1 = SuperHostile.R.blockEntity("super_loot_fabricator_v1", () -> new TickingBlockEntityType<>((pos, state) -> new SuperLootFabTileEntity(pos, state, TileEntities.ULTIMATE_LOOT_FABRICATOR_V1.get(), Version.V5), ImmutableSet.of(Blocks.ULTIMATE_LOOT_FABRICATOR_V1.get()), false, true));
        public final RegistryObject<BlockEntityType<SuperLootFabTileEntity>> ULTIMATE_LOOT_FABRICATOR_V2 = SuperHostile.R.blockEntity("super_loot_fabricator_v2", () -> new TickingBlockEntityType<>((pos, state) -> new SuperLootFabTileEntity(pos, state, TileEntities.ULTIMATE_LOOT_FABRICATOR_V2.get(), Version.V6), ImmutableSet.of(Blocks.ULTIMATE_LOOT_FABRICATOR_V2.get()), false, true));
        public final RegistryObject<BlockEntityType<SuperLootFabTileEntity>> ULTIMATE_LOOT_FABRICATOR_V3 = SuperHostile.R.blockEntity("super_loot_fabricator_v3", () -> new TickingBlockEntityType<>((pos, state) -> new SuperLootFabTileEntity(pos, state, TileEntities.ULTIMATE_LOOT_FABRICATOR_V3.get(), Version.V7), ImmutableSet.of(Blocks.ULTIMATE_LOOT_FABRICATOR_V3.get()), false, true));
        public final RegistryObject<BlockEntityType<SuperLootFabTileEntity>> ULTIMATE_LOOT_FABRICATOR_V4 = SuperHostile.R.blockEntity("super_loot_fabricator_v4", () -> new TickingBlockEntityType<>((pos, state) -> new SuperLootFabTileEntity(pos, state, TileEntities.ULTIMATE_LOOT_FABRICATOR_V4.get(), Version.VMAX), ImmutableSet.of(Blocks.ULTIMATE_LOOT_FABRICATOR_V4.get()), false, true));


    }

    @UtilityClass
    public class Containers {

        private void bootstrap() {
        }        public final RegistryObject<MenuType<SuperLootFabContainer>> ULTIMATE_LOOT_FABRICATOR_V1 = SuperHostile.R.menu("super_loot_fabricator_v1", () -> MenuUtil.posType((id, pInv, pos) -> new SuperLootFabContainer(id, pInv, pos, Containers.ULTIMATE_LOOT_FABRICATOR_V1.get(), Blocks.ULTIMATE_LOOT_FABRICATOR_V1.get())));
        public final RegistryObject<MenuType<SuperLootFabContainer>> ULTIMATE_LOOT_FABRICATOR_V2 = SuperHostile.R.menu("super_loot_fabricator_v2", () -> MenuUtil.posType((id, pInv, pos) -> new SuperLootFabContainer(id, pInv, pos, Containers.ULTIMATE_LOOT_FABRICATOR_V2.get(), Blocks.ULTIMATE_LOOT_FABRICATOR_V2.get())));
        public final RegistryObject<MenuType<SuperLootFabContainer>> ULTIMATE_LOOT_FABRICATOR_V3 = SuperHostile.R.menu("super_loot_fabricator_v3", () -> MenuUtil.posType((id, pInv, pos) -> new SuperLootFabContainer(id, pInv, pos, Containers.ULTIMATE_LOOT_FABRICATOR_V3.get(), Blocks.ULTIMATE_LOOT_FABRICATOR_V3.get())));
        public final RegistryObject<MenuType<SuperLootFabContainer>> ULTIMATE_LOOT_FABRICATOR_V4 = SuperHostile.R.menu("super_loot_fabricator_v4", () -> MenuUtil.posType((id, pInv, pos) -> new SuperLootFabContainer(id, pInv, pos, Containers.ULTIMATE_LOOT_FABRICATOR_V4.get(), Blocks.ULTIMATE_LOOT_FABRICATOR_V4.get())));


    }

    @UtilityClass
    public class Tabs {

        public final ResourceKey<CreativeModeTab> TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, SuperHostileNetworks.id("tab"));
        public final RegistryObject<CreativeModeTab> TAB = SuperHostile.R.tab("tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.extrahnn")).icon(() -> (SuperHostile.Items.ULTIMATE_LOOT_FABRICATOR_V4.get()).getDefaultInstance()).build());

        private void bootstrap() {
        }
    }
}
