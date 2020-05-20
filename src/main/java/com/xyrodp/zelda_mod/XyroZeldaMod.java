package com.xyrodp.zelda_mod;


import com.xyrodp.zelda_mod.tab.CreativeTabTest;
import item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.xyrodp.zelda_mod.proxy.CommonProxy;


@Mod(modid = XyroZeldaMod.MODID, version = XyroZeldaMod.VERSION, name = XyroZeldaMod.NAME)
public class XyroZeldaMod {
    public static final String MODID = "xyrozeldamod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Zelda's Essentials";

    public static final String PROXY = "com.xyrodp.zelda_mod.proxy.ClientProxy";

    @SidedProxy(clientSide = "com.xyrodp.zelda_mod.proxy.ClientProxy", serverSide = "com.xyrodp.zelda_mod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Instance
    public static XyroZeldaMod instance;

    public static CreativeTabTest tabTest;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tabTest = new CreativeTabTest(CreativeTabs.getNextID(), "tab_test");
        ModItems.preInit();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        proxy.postInit(event);
    }


}
