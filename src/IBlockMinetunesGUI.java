package com.bugzoo.Gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.bugzoo.FinancialMod.SoundHandler;
import com.bugzoo.GuiButtons.ATMButton;



public class IBlockMinetunesGUI extends GuiScreen{
	public final int xSizeBackground1 = 120;
	public final int ySizeBackground1 = 200;

	public final int guiX = (this.width - xSizeBackground1) / 2;
	public final int guiY = (this.height - xSizeBackground1) / 2;
	
	private int pageIndex = 0;
	public ResourceLocation background1 = new ResourceLocation("financialmod", "textures/gui/IBlockMinetunesGUI.png");
	

	
	
	public void initGui(){
		//ALL BUTTONS NEED TO BE WIDTH / 2 + : HEIGHT / 2 +
		buttonList.clear();
		buttonList.add(new GuiButton(1, width / 2 + guiX + 55, height / 2 - 150 + guiY + 175, 50, 20, "Krale - Frontier")); // 1
	}
	
	public void actionPerformed(GuiButton guibutton){
		if(guibutton.id == 1){
			SoundHandler.onEntityPlay("Frontier", mc.theWorld, mc.thePlayer, 1F, 1F);
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

        this.drawCenteredString(fontRendererObj, "Minetunes", width/2 + 10, height / 2 - 78, 0xFFCC00);

        super.drawScreen(i, j, f); 
	}
	
}
