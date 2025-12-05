package cn.qiuye.superhnn;

import dev.shadowsoffire.placebo.config.Configuration;
import dev.shadowsoffire.placebo.network.MessageProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.Optional;
import java.util.function.Supplier;

public class SuperHostileConfig {

    public SuperHostileConfig() {
    }

    public static void load() {
        Configuration cfg = new Configuration(SuperHostileNetworks.MOD_ID);

        if (cfg.hasChanged()) {
            cfg.save();
        }
    }

    public record ConfigMessage() {

        public static class Provider implements MessageProvider<SuperHostileConfig.ConfigMessage> {

            @Override
            public Class<?> getMsgClass() {
                return ConfigMessage.class;
            }

            @Override
            public void write(ConfigMessage configMessage, FriendlyByteBuf friendlyByteBuf) {
            }

            @Override
            public ConfigMessage read(FriendlyByteBuf buf) {
                return null;
            }

            @Override
            public void handle(ConfigMessage configMessage, Supplier<NetworkEvent.Context> supplier) {
            }

            @Override
            public Optional<NetworkDirection> getNetworkDirection() {
                return Optional.of(NetworkDirection.PLAY_TO_CLIENT);
            }
        }
    }
}
