package cn.qiuye.shnn.gui;

import cn.qiuye.shnn.tile.SuperLootFabTileEntity;

import dev.shadowsoffire.hostilenetworks.Hostile;
import dev.shadowsoffire.hostilenetworks.data.DataModel;
import dev.shadowsoffire.hostilenetworks.item.DataModelItem;
import dev.shadowsoffire.hostilenetworks.item.MobPredictionItem;
import dev.shadowsoffire.placebo.menu.BlockEntityMenu;
import dev.shadowsoffire.placebo.menu.FilteredSlot;
import dev.shadowsoffire.placebo.reload.DynamicHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SuperLootFabContainer extends BlockEntityMenu<SuperLootFabTileEntity> {

    private final Block block;

    public SuperLootFabContainer(int id, Inventory pInv, BlockPos pos, MenuType<?> type, Block block) {
        super(type, id, pInv, pos);

        this.block = block;

        SuperLootFabTileEntity.FabItemHandler inv = this.tile.getInventory();
        this.addSlot(new FilteredSlot(inv, 0, 79, 62, (s) -> s.getItem() == Hostile.Items.PREDICTION.get()));

        for (int y = 0; y < 4; ++y) {
            for (int x = 0; x < 4; ++x) {
                this.addSlot(new FilteredSlot(inv, 1 + y * 4 + x, 100 + x * 18, 7 + y * 18, (s) -> false));
            }
        }

        this.addPlayerSlots(pInv, 8, 92);
        this.mover.registerRule((stack, slot) -> slot == 0, 17, this.slots.size());
        this.mover.registerRule((stack, slot) -> stack.getItem() instanceof MobPredictionItem, 0, 1);
        this.mover.registerRule((stack, slot) -> slot < 17, 17, this.slots.size());
        this.registerInvShuffleRules();
    }

    public boolean stillValid(Player pPlayer) {
        return pPlayer.level().getBlockState(this.pos).getBlock() == block;
    }

    public boolean clickMenuButton(Player pPlayer, int pId) {
        DynamicHolder<DataModel> model = DataModelItem.getStoredModel(this.getSlot(0).getItem());
        if (model.isBound() && pId < model.get().fabDrops().size()) {
            this.tile.setSelection(model, pId);
            return true;
        } else {
            return false;
        }
    }

    public int getEnergyStored() {
        return this.tile.getEnergyStored();
    }

    public int getRuntime() {
        return this.tile.getRuntime();
    }

    public int getSelectedDrop(DataModel model) {
        return this.tile.getSelectedDrop(model);
    }
}
