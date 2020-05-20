package item;

import com.xyrodp.zelda_mod.XyroZeldaMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item tutorialItem;
    public static Item masterSword;

    /**
     * le pre init, donc la ou sont chargé les item
     */
    public static void preInit() {
            tutorialItem = new item.ItemTutorialItem(EnumHelper.addToolMaterial("TUTORIAL",3, -1, 8.0F, 10.0F, 30), "tutorial_item");
            masterSword = new item.ItemMasterSword(EnumHelper.addToolMaterial("TUTORIAL",3, -1, 8.0F, 10.0F, 30), "master_sword");


            registerItems();
    }


    /**
     * la méthode SEPAREE du preInit qui permet de creer/enregistrer les dossiers de chaque items
     */
    public static void  registerItems() {
        GameRegistry.register(tutorialItem, new ResourceLocation(XyroZeldaMod.MODID, "tutorial_item"));
        GameRegistry.register(masterSword, new ResourceLocation(XyroZeldaMod.MODID, "master_sword"));
    }


    /**
     * la méthode qui sera appelée par le client proxy pour charger les rendus de TOUT les items
     */
    public static void registerRenders() {
        registerRender(tutorialItem);
        registerRender(masterSword);
    }


    /**
     * la méthode SEPAREE du registerRenders permettant d'enregistrer n'importe quel rendu, juste à lui donner le nom de l'item
     */
    public static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(XyroZeldaMod.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
    }
}
