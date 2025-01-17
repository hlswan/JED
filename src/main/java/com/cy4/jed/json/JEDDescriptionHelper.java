package com.cy4.jed.json;

import java.util.Map;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;

public class JEDDescriptionHelper {

	private static final Minecraft mc = Minecraft.getInstance();

	public static Component getDescriptionForItem(ItemStack item) {

		String reg = item.getItem().getRegistryName().toString();
		Map<String, String> map = JEDReloadListener.INSTANCE.getMap(mc.getLanguageManager().getSelected());

		return new TextComponent(map.getOrDefault(reg, map.getOrDefault("null", "ERROR: NULL KEY NOT PRESENT")));
	}

	public static Component getItemTitle(ItemStack item) {
		String name = item.getItem().getName(item).getString();
		return new TextComponent(name).withStyle(ChatFormatting.UNDERLINE);
	}

}
