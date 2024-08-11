package cn.crtlprototypestudios.lazy.mixin;

import cn.crtlprototypestudios.lazy.Lazy;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public class PlayerDamageAtttributeMixin {
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (Lazy.getConfig().healthLockEnabled) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}
