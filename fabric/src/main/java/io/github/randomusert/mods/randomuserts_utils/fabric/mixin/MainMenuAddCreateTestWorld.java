package io.github.randomusert.mods.randomuserts_utils.fabric.mixin;

import io.github.randomusert.mods.randomuserts_utils.api.LoggingHelper;
import io.github.randomusert.mods.randomuserts_utils.fabric.utils.EnvChecker;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.levelgen.presets.WorldPresets;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(TitleScreen.class)
public class MainMenuAddCreateTestWorld extends Screen {
    protected MainMenuAddCreateTestWorld(Component title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "init")
    private void addCustomButton(CallbackInfo ci) {
        boolean isDevEnv = FabricLoader.getInstance().isDevelopmentEnvironment();

        if (isDevEnv) {
            this.addRenderableWidget(
                    Button.builder(Component.literal("Create Test World"), button -> {
                                LoggingHelper.info("Hello from the button in the main menu");
                            })
                            .bounds(10, this.height - 30, 200, 20)
                            .build()
            );
        }

    }
}
