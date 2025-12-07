package cn.qiuye.shnn;

import dev.shadowsoffire.placebo.config.Configuration;
import dev.shadowsoffire.placebo.network.MessageHelper;
import dev.shadowsoffire.placebo.network.MessageProvider;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.Optional;
import java.util.function.Supplier;

public class SHNNConfig {

    public static int upgradeSpeed;
    public static int upgradeExcessive;

    public SHNNConfig() {}

    public static void load() {
        Configuration cfg = new Configuration("shnn");

        upgradeSpeed = cfg.getInt("Upgrade Speed", "upgrade", 50, 1, 1000, "Acceleration of mechanisms with a speed map");
        upgradeSpeed = cfg.getInt("Upgrade Excessive", "upgrade", 100, 100, 1000, "Acceleration of mechanisms with a Excessive map");

        if (cfg.hasChanged()) {
            cfg.save();
        }
    }

    public record ConfigMessage(int upgradeSpeed,int upgradeExcessive) {

        public static class Provider implements MessageProvider<SHNNConfig.ConfigMessage> {

            public Provider() {}

            @Override
            public Class<?> getMsgClass() {
                return ConfigMessage.class;
            }

            @Override
            public void write(ConfigMessage configMessage, FriendlyByteBuf friendlyByteBuf) {
                friendlyByteBuf.writeInt(configMessage.upgradeSpeed);
                friendlyByteBuf.writeInt(configMessage.upgradeExcessive);
            }

            public ConfigMessage read(FriendlyByteBuf buf) {
                return new ConfigMessage(buf.readInt(), buf.readInt());
            }

            public void handle(ConfigMessage configMessage, Supplier<NetworkEvent.Context> supplier) {
                MessageHelper.handlePacket(() -> {
                    SHNNConfig.upgradeSpeed = configMessage.upgradeSpeed;
                    SHNNConfig.upgradeExcessive = configMessage.upgradeExcessive;
                }, supplier);
            }

            public Optional<NetworkDirection> getNetworkDirection() {
                return Optional.of(NetworkDirection.PLAY_TO_CLIENT);
            }
        }
    }
}
