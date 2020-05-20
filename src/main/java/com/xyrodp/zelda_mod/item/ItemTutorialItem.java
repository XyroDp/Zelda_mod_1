package item;

import com.xyrodp.zelda_mod.XyroZeldaMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.List;

public class ItemTutorialItem extends ItemSword {

    public ItemTutorialItem(Item.ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(XyroZeldaMod.tabTest);
    }

    @Override
    public ActionResult<ItemStack>  onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
        if (world.isRemote) {
            player.addChatComponentMessage(new TextComponentString("Hello World"));
            System.out.println("Right clicked motherfuckers");
        }
        return super.onItemRightClick(itemStack, world, player, hand);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.getBlockState(pos).getBlock() == Blocks.GRASS){
            world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("item tooltip");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return false;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }
}

