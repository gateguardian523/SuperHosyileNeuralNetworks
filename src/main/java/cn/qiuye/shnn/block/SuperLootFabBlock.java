package cn.qiuye.shnn.block;

import cn.qiuye.shnn.api.Version;
import cn.qiuye.shnn.gui.SuperLootFabContainer;
import cn.qiuye.shnn.tile.SuperLootFabTileEntity;

import dev.shadowsoffire.placebo.block_entity.TickingEntityBlock;
import dev.shadowsoffire.placebo.menu.MenuUtil;
import dev.shadowsoffire.placebo.menu.SimplerMenuProvider;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SuperLootFabBlock extends HorizontalDirectionalBlock implements TickingEntityBlock {

    Supplier<BlockEntityType<?>> blockType;
    Supplier<MenuType<?>> type;
    Version version;

    public SuperLootFabBlock(BlockBehaviour.Properties props, Supplier<BlockEntityType<?>> blockType, Supplier<MenuType<?>> type, Version version) {
        super(props);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
        this.blockType = blockType;
        this.type = type;
        this.version = version;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SuperLootFabTileEntity(pPos, pState, blockType.get(), version);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        return MenuUtil.openGui(player, pos, (id, pInv, posBlock) -> new SuperLootFabContainer(id, pInv, posBlock, type.get(), this));
    }

    public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
        return new SimplerMenuProvider<>(pLevel, pPos, (id, pInv, posBlock) -> new SuperLootFabContainer(id, pInv, posBlock, type.get(), this));
    }
}
