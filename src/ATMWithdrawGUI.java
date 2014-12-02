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

import com.bugzoo.GuiButtons.ATMButton;
import com.bugzoo.GuiButtons.ATMConfirmButton;
import com.bugzoo.GuiButtons.ATMLeftButton;
import com.bugzoo.GuiButtons.ATMRedButton;
import com.bugzoo.GuiButtons.ATMRightButton;
import com.bugzoo.GuiButtons.ATMYellowButton;



public class ATMWithdrawGUI extends GuiScreen{
	public final int xSizeBackground1 = 232;
	public final int ySizeBackground1 = 250;
	
	
	public final int guiX = (this.width - xSizeBackground1) / 2;
	public final int guiY = (this.height - xSizeBackground1) / 2;
	
	public ResourceLocation background1 = new ResourceLocation("financialmod", "textures/gui/ATM.png");
	

	
	
	public void initGui(){
		//ALL BUTTONS NEED TO BE WIDTH / 2 + : HEIGHT / 2 +
		buttonList.clear();
		buttonList.add(new ATMButton(1, width / 2 + guiX + 55, height / 2 - 40 + guiY + 175, 24, 15, "1")); // 1
    	buttonList.add(new ATMButton(2, width / 2 + guiX + 87, height / 2 - 40 + guiY + 175, 24, 15, "2")); // 2
    	buttonList.add(new ATMButton(3, width / 2 + guiX + 119,height / 2 - 40 + guiY + 175, 24, 15, "3")); // 3
    	buttonList.add(new ATMRedButton(4, width / 2 + guiX + 151, height / 2 - 40 + guiY + 175, 24, 15, "")); // Cancel
    	buttonList.add(new ATMButton(5, width / 2 + guiX + 55, height / 2 - 40 + guiY + 200, 24, 15, "4")); // 4
    	buttonList.add(new ATMButton(6, width / 2 + guiX + 87, height / 2 - 40 + guiY + 200, 24, 15, "5")); // 5
    	buttonList.add(new ATMButton(7, width / 2 + guiX + 119, height / 2 - 40 + guiY + 200, 24, 15, "6")); // 6
    	buttonList.add(new ATMYellowButton(8, width / 2 + guiX + 151, height / 2 - 40 + guiY + 200, 24, 15, "")); // Clear
    	buttonList.add(new ATMButton(9, width / 2 + guiX + 55, height / 2 - 40 + guiY + 225, 24, 15, "7")); // 7
    	buttonList.add(new ATMButton(10, width / 2 + guiX + 87, height / 2 - 40 + guiY + 225, 24, 15, "8")); // 8
    	buttonList.add(new ATMButton(11, width / 2 + guiX + 119, height / 2 - 40 + guiY + 225, 24, 15, "9")); // 9
    	buttonList.add(new ATMConfirmButton(12, width / 2 + guiX + 151, height / 2 - 40 + guiY + 225, 24, 15, "")); // Confirm
    	buttonList.add(new ATMButton(13, width / 2 + guiX + 87, height / 2 - 40 + guiY + 250, 24, 15, "0")); // 0
    	buttonList.add(new ATMButton(14, width / 2 + guiX + 55, height / 2 - 40 + guiY + 250, 24, 15, "")); // Nothing Left
    	buttonList.add(new ATMButton(15, width / 2 + guiX + 119, height / 2 - 40 + guiY + 250, 24, 15, "")); // Nothing Right
    	buttonList.add(new ATMButton(16, width / 2 + guiX + 151, height / 2 - 40 + guiY + 250, 24, 15, "")); // Nothing Bottom-Right
		
    	buttonList.add(new ATMLeftButton(17, width / 2 + guiX + 11, height / 2 - 40 + guiY + 56, 24, 15, "")); //Top-Left
    	buttonList.add(new ATMLeftButton(18, width / 2 + guiX + 11, height / 2 - 40 + guiY + 86, 24, 15, "")); //Mid-Upper Left
    	buttonList.add(new ATMLeftButton(19, width / 2 + guiX + 11, height / 2 - 40 + guiY + 116, 24, 15, "")); //Mid-Lower Left
    	buttonList.add(new ATMLeftButton(20, width / 2 + guiX + 11, height / 2 - 40 + guiY + 146, 24, 15, "")); //Bottom Left
    	
    	buttonList.add(new ATMRightButton(21, width / 2 + guiX + 197, height / 2 - 40 + guiY + 56, 24, 15, "")); //Top-Right
    	buttonList.add(new ATMRightButton(22, width / 2 + guiX + 197, height / 2 - 40 + guiY + 86, 24, 15, "")); //Mid-Upper Right
    	buttonList.add(new ATMRightButton(23, width / 2 + guiX + 197, height / 2 - 40 + guiY + 116, 24, 15, "")); //Mid-Lower Right
    	buttonList.add(new ATMRightButton(24, width / 2 + guiX + 197, height / 2 - 40 + guiY + 146, 24, 15, "")); //Bottom Right
		
    	
    	
	}
	
	public void actionPerformed(GuiButton guibutton){
		
	}

	public boolean doesGuiPauseGame(){
		return false;
	}
	
	public void drawScreen(int i, int j, float f){
		
		
		
		//Background Texture
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(background1);
        int k1 = (this.width - this.xSizeBackground1) / 2;
        int l1 = (this.height - this.ySizeBackground1) / 2;
        this.drawTexturedModalRect(k1, l1, 0, 0, this.xSizeBackground1, this.ySizeBackground1);
        
        this.drawCenteredString(fontRendererObj, "Please Select The Amount", width/2, height / 2 - 95, 0xFFCC00);
        this.drawCenteredString(fontRendererObj, "You Wish To Withdraw", width/2, height / 2 - 80, 0xFFCC00);
        this.drawCenteredString(fontRendererObj, "$5", width / 2 + guiX + 45, height / 2 - 65, 0x006600);
        this.drawCenteredString(fontRendererObj, "$10", width / 2 + guiX + 182, height / 2 - 65, 0x006600);
        this.drawCenteredString(fontRendererObj, "$20", width / 2 + guiX + 48, height / 2 - 36, 0x006600);
        this.drawCenteredString(fontRendererObj, "$50", width / 2 + guiX + 182, height / 2 - 36, 0x006600);
        this.drawCenteredString(fontRendererObj, "$100", width / 2 + guiX + 52, height / 2 - 8, 0x006600);
        this.drawCenteredString(fontRendererObj, "Custom Amount", width / 2 + guiX + 155, height / 2 - 8, 0x006600);
        
        
        super.drawScreen(i, j, f); 
	}
}
