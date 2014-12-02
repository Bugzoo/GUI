package com.bugzoo.Gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.bugzoo.GuiButtons.IBlockMineazonButton;
import com.bugzoo.GuiButtons.IBlockMinetunesButton;



public class IBlockGUI extends GuiScreen{
	public final int xSizeBackground1 = 120;
	public final int ySizeBackground1 = 200;

	public final int guiX = (this.width - xSizeBackground1) / 2;
	public final int guiY = (this.height - xSizeBackground1) / 2;
	
	public ResourceLocation background1 = new ResourceLocation("financialmod", "textures/gui/IBlock.png");
	public ResourceLocation phoneTheme1 = new ResourceLocation("financialmod", "textures/gui/IBlockTheme1.png");
	public ResourceLocation phoneTheme2 = new ResourceLocation("financialmod", "textures/gui/IBlockTheme2.png");
	

	
	
	public void initGui(){
		//ALL BUTTONS NEED TO BE WIDTH / 2 + : HEIGHT / 2 +
		buttonList.clear();
		buttonList.add(new IBlockMineazonButton(1, width / 2 + guiX + 20, height / 2 + guiY + -10, 22, 15, "")); // Mineazon Button
		buttonList.add(new IBlockMinetunesButton(2, width / 2 + guiX + 50, height / 2 + guiY + -10, 22, 15, "")); // Minetunes Button
	}
	
	public void actionPerformed(GuiButton guibutton){
		if(guibutton.id == 1){
			mc.getMinecraft().displayGuiScreen(new IBlockMineazonGUI());
		}
		if(guibutton.id == 2){
			mc.getMinecraft().displayGuiScreen(new IBlockMinetunesGUI());
		}
	}

	public boolean doesGuiPauseGame(){
		return false;
	}

	public void drawScreen(int i, int j, float f){
		
		
		
		//Phone Texture
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(background1);
        int k1 = (this.width - this.xSizeBackground1) / 2;
        int l1 = (this.height - this.ySizeBackground1) / 2;
        this.drawTexturedModalRect(k1, l1, 0, 0, this.xSizeBackground1, this.ySizeBackground1);

        //Phone Theme Texture 1
      	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(phoneTheme1);
        this.drawTexturedModalRect(width / 2 - 50, height / 2 - 80, 0, 0, 100, 155);
       
        super.drawScreen(i, j, f); 
	}
	
}
