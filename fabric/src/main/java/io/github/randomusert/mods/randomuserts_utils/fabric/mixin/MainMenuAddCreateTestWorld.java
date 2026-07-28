package io.github.randomusert.mods.randomuserts_utils.fabric.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.SharedConstants;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(TitleScreen.class)
public class MainMenuAddCreateTestWorld extends Screen {
    protected MainMenuAddCreateTestWorld(Component title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "createTestWorldButton")
    private void forceCreateTestWorldButton(int topPos, int spacing, CallbackInfoReturnable<Integer> cir) {
        // Check if the env is a Dev env and Set IS_RUNNING_IN_IDE just for creating the create test button
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            SharedConstants.IS_RUNNING_IN_IDE = true;
        }
    }
}
