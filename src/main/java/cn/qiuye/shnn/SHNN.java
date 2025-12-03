package cn.qiuye.shnn;

import dev.shadowsoffire.placebo.loot.LootSystem;
import dev.shadowsoffire.placebo.network.MessageHelper;
import dev.shadowsoffire.placebo.tabs.TabFillingRegistry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SHNN.MOD_ID)
public class SHNN {

    public static final String MOD_ID = "shnn";
    public static final String MOD_NAME = "Super Hosyile Neural Networks";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(id("shnn"))
            .clientAcceptedVersions((s) -> true)
            .serverAcceptedVersions((s) -> true)
            .networkProtocolVersion(() -> "0.0.1").simpleChannel();
    public static final ResourceKey<CreativeModeTab> TAB;

    public static ResourceLocation id(String id) {
        return ResourceLocation.tryBuild(MOD_ID, id);
    }

    public SHNN() {
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        SHNNConfig.load();
        SH.boootstrap();
        MessageHelper.registerMessage(CHANNEL, 0, new SHNNConfig.ConfigMessage.Provider());
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            LootSystem.defaultBlockTable(SH.Blocks.ULTIMATE_LOOT_FABRICATOR_V1.get());
            LootSystem.defaultBlockTable(SH.Blocks.ULTIMATE_LOOT_FABRICATOR_V2.get());
            LootSystem.defaultBlockTable(SH.Blocks.ULTIMATE_LOOT_FABRICATOR_V3.get());
            LootSystem.defaultBlockTable(SH.Blocks.ULTIMATE_LOOT_FABRICATOR_V4.get());
            TabFillingRegistry.register(SH.Tabs.SHNN_TAB_KEY, SH.Items.ULTIMATE_LOOT_FABRICATOR_V1, SH.Items.ULTIMATE_LOOT_FABRICATOR_V2, SH.Items.ULTIMATE_LOOT_FABRICATOR_V3, SH.Items.ULTIMATE_LOOT_FABRICATOR_V4);
        });
    }

    static {
        TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, id("tab"));
    }
}
