package com.xyrodp.zelda_mod.proxy;

import item.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        System.out.println("Init du clientProxy");
        ModItems.registerRenders();
        System.out.println("fin de l'init du client Proxy");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
