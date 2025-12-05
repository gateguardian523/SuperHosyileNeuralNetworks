package cn.qiuye.superhnn.tile;

import cn.qiuye.superhnn.SuperHostile;
import cn.qiuye.superhnn.SuperHostileNetworks;
import cn.qiuye.superhnn.gui.SuperLootFabScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = {Dist.CLIENT},
        modid = SuperHostileNetworks.MOD_ID)
public class SuperHostileClient {

    public SuperHostileClient() {
    }

    @SubscribeEvent
    public static void init(FMLClientSetupEvent e) {
        MenuScreens.register(SuperHostile.Containers.ULTIMATE_LOOT_FABRICATOR_V1.get(), SuperLootFabScreen::new);
        MenuScreens.register(SuperHostile.Containers.ULTIMATE_LOOT_FABRICATOR_V2.get(), SuperLootFabScreen::new);
        MenuScreens.register(SuperHostile.Containers.ULTIMATE_LOOT_FABRICATOR_V3.get(), SuperLootFabScreen::new);
        MenuScreens.register(SuperHostile.Containers.ULTIMATE_LOOT_FABRICATOR_V4.get(), SuperLootFabScreen::new);
    }

    @SubscribeEvent
    public static void mrl(ModelEvent.RegisterAdditional e) {
    }
}
