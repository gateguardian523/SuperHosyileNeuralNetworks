package cn.qiuye.shnn.tile;

import cn.qiuye.shnn.SH;
import cn.qiuye.shnn.SHNN;
import cn.qiuye.shnn.gui.SuperLootFabScreen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
                        bus = Mod.EventBusSubscriber.Bus.MOD,
                        value = { Dist.CLIENT },
                        modid = SHNN.MOD_ID)
public class SHClient {

    public SHClient() {}

    @SubscribeEvent
    public static void init(FMLClientSetupEvent e) {
        MenuScreens.register(SH.Containers.ULTIMATE_LOOT_FABRICATOR_V1.get(), SuperLootFabScreen::new);
        MenuScreens.register(SH.Containers.ULTIMATE_LOOT_FABRICATOR_V2.get(), SuperLootFabScreen::new);
        MenuScreens.register(SH.Containers.ULTIMATE_LOOT_FABRICATOR_V3.get(), SuperLootFabScreen::new);
        MenuScreens.register(SH.Containers.ULTIMATE_LOOT_FABRICATOR_V4.get(), SuperLootFabScreen::new);
    }

    @SubscribeEvent
    public static void mrl(ModelEvent.RegisterAdditional e) {}
}
