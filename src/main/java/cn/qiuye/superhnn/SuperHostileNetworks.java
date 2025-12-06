package cn.qiuye.superhnn;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(SuperHostileNetworks.MOD_ID)
public class SuperHostileNetworks {

    public static final String MOD_ID = "superhnn";
    public static final String MOD_NAME = "Super Hostile Neural Networks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(id(MOD_ID))
            .clientAcceptedVersions((s) -> true)
            .serverAcceptedVersions((s) -> true)
            .networkProtocolVersion(() -> "0.0.1").simpleChannel();
    public static final ResourceKey<CreativeModeTab> TAB;

    static {
        TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, id("tab"));
    }

    public SuperHostileNetworks(FMLJavaModLoadingContext context) {
        context.getModEventBus().register(this);
        SuperHostileConfig.load();
        SuperHostile.bootstrap();
        MessageHelper.registerMessage(CHANNEL, 0, new SuperHostileConfig.ConfigMessage.Provider());
    }

    public static ResourceLocation id(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            LootSystem.defaultBlockTable(SuperHostile.Blocks.ULTIMATE_LOOT_FABRICATOR_V1.get());
            LootSystem.defaultBlockTable(SuperHostile.Blocks.ULTIMATE_LOOT_FABRICATOR_V2.get());
            LootSystem.defaultBlockTable(SuperHostile.Blocks.ULTIMATE_LOOT_FABRICATOR_V3.get());
            LootSystem.defaultBlockTable(SuperHostile.Blocks.ULTIMATE_LOOT_FABRICATOR_V4.get());
            TabFillingRegistry.register(SuperHostile.Tabs.TAB_KEY, SuperHostile.Items.ULTIMATE_LOOT_FABRICATOR_V1, SuperHostile.Items.ULTIMATE_LOOT_FABRICATOR_V2, SuperHostile.Items.ULTIMATE_LOOT_FABRICATOR_V3, SuperHostile.Items.ULTIMATE_LOOT_FABRICATOR_V4);
        });
    }
}
