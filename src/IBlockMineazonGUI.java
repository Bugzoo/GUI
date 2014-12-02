package com.bugzoo.Gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.bugzoo.FinancialMod.FinancialMod;



public class IBlockMineazonGUI extends GuiScreen{
	public final int xSizeBackground1 = 120;
	public final int ySizeBackground1 = 200;

	public final int guiX = (this.width - xSizeBackground1) / 2;
	public final int guiY = (this.height - xSizeBackground1) / 2;
	
	private int pageIndex = 0;
	public ResourceLocation background1 = new ResourceLocation("financialmod", "textures/gui/IBlockMineazonGUI.png");
	
	private ItemStack draggedStack;
	
	
	public void initGui(){
		//ALL BUTTONS NEED TO BE WIDTH / 2 + : HEIGHT / 2 +
		buttonList.clear();
		
	}
	
	public void actionPerformed(GuiButton guibutton){
		if(guibutton.id == 1){
			
		}
	}

	public boolean doesGuiPauseGame(){
		return false;
	}

	 private void drawItemStack(ItemStack p_146982_1_, int p_146982_2_, int p_146982_3_, String p_146982_4_)
	    {
	        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
	        this.zLevel = 200.0F;
	        itemRender.zLevel = 200.0F;
	        FontRenderer font = null;
	        if (p_146982_1_ != null) font = p_146982_1_.getItem().getFontRenderer(p_146982_1_);
	        if (font == null) font = fontRendererObj;
	        itemRender.renderItemAndEffectIntoGUI(font, this.mc.getTextureManager(), p_146982_1_, p_146982_2_, p_146982_3_);
	        itemRender.renderItemOverlayIntoGUI(font, this.mc.getTextureManager(), p_146982_1_, p_146982_2_, p_146982_3_ - (this.draggedStack == null ? 0 : 8), p_146982_4_);
	        this.zLevel = 0.0F;
	        itemRender.zLevel = 0.0F;
	    }
	
	public void drawScreen(int i, int j, float f){
		
		//Phone Texture
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(background1);
        int k1 = (this.width - this.xSizeBackground1) / 2;
        int l1 = (this.height - this.ySizeBackground1) / 2;
        this.drawTexturedModalRect(k1, l1, 0, 0, this.xSizeBackground1, this.ySizeBackground1);

        this.drawCenteredString(fontRendererObj, "Mineazon", width/2 - 26, height / 2 - 78, 0xFFCC00);
        this.drawItemStack(new ItemStack(Items.fireworks), width / 2 - 1, height / 2  - 20, "");
        
        super.drawScreen(i, j, f); 
	}
	
}
