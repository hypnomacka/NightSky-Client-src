package animeware.event.impl;

import animeware.event.Cancelable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

@Cancelable
public class AttackEntityEvent extends PlayerEvent
{
    public final Entity target;
    public AttackEntityEvent(EntityPlayer player, Entity target)
    {
        super(player);
        this.target = target;
    }
}
