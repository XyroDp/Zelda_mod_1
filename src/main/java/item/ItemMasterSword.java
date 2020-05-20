package item;

import com.xyrodp.zelda_mod.XyroZeldaMod;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.SetDamage;
import org.lwjgl.util.vector.Vector;

import javax.xml.stream.Location;
import java.util.List;

public class ItemMasterSword extends ItemSword {


    public ItemMasterSword(Item.ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(XyroZeldaMod.tabTest);
    }

    @Override
    public ActionResult<ItemStack>  onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
        if (world.isRemote) {

            //lasers
            if (player.getHealth() == 20.0F) {
                double x = player.getLookVec().xCoord;
                double z = player.getLookVec().zCoord;

                int x2 = Math.round((float) x * 10);
                int z2 = Math.round((float) z * 10);

                float x3 = (float) x;
                float z3 = (float) z;

                BlockPos blockpos = player.getPosition().add(x2, (float) (player.height / 2.0F), z2);

                EntityEnderEye entityendereye = new EntityEnderEye(world, player.posX, player.posY + (double) (player.height / 2.0F), player.posZ);

                world.spawnEntityInWorld(entityendereye);
                entityendereye.setVelocity(x3, 0, z3);
                entityendereye.moveTowards(blockpos);
                entityendereye.onUpdate();

                /**
                 * permet d'éviter que l'éclat céleste se prenne un block
                 */
                BlockPos nextBlockPos = entityendereye.getPosition().add(x * 2, 0, z * 2);
                player.addChatComponentMessage(new TextComponentString(nextBlockPos + "//" + entityendereye.getPosition()));
                if (Math.sqrt(Math.pow(entityendereye.posY - blockpos.getY(), 2)) <= 2.5 && world.getBlockState(nextBlockPos).getBlock() != Blocks.AIR) {
                    entityendereye.motionY = 1.0D;
                    entityendereye.posY += entityendereye.motionY;
                    entityendereye.onUpdate();
                    player.addChatComponentMessage(new TextComponentString(entityendereye.posY + "= posY / motionY =" + entityendereye.motionY));
                }
                else{
                    entityendereye.motionY = 0;
                    player.addChatComponentMessage(new TextComponentString("Nespresso, what else ?"));
                }

                if (Math.round(entityendereye.posZ) == blockpos.getZ() && Math.round(entityendereye.posX) == blockpos.getX()){
                    entityendereye.setDead();
                    player.addChatComponentMessage(new TextComponentString("Et boum t'es mort"));
                }

                world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ENDEREYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                world.playEvent((EntityPlayer)null, 1003, new BlockPos(player), 0);



                return new ActionResult(EnumActionResult.SUCCESS, itemStack);



            }



            //coup d'estoc

            //coup sauté

            //attaque circulaire

            //coup de grâce
        }

        return null;
    }


    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("item tooltip");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }


}

