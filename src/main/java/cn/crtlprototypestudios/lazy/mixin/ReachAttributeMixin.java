package cn.crtlprototypestudios.lazy.mixin;

import cn.crtlprototypestudios.lazy.Lazy;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class ReachAttributeMixin {
    @Inject(method = "getEntityInteractionRange", at = @At("RETURN"), cancellable = true)
    private void getEntityInteractionRange(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue((double) Lazy.getConfig().reachDistance);
    }

    @Inject(method = "getBlockInteractionRange", at = @At("RETURN"), cancellable = true)
    private void getBlockInteractionRange(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue((double) Lazy.getConfig().reachDistance);
    }
}
