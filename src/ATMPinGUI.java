package com.bugzoo.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.bugzoo.FinancialMod.EconUtils;
import com.bugzoo.GuiButtons.ATMButton;
import com.bugzoo.GuiButtons.ATMConfirmButton;
import com.bugzoo.GuiButtons.ATMLeftButton;
import com.bugzoo.GuiButtons.ATMRedButton;
import com.bugzoo.GuiButtons.ATMRightButton;
import com.bugzoo.GuiButtons.ATMYellowButton;
import com.bugzoo.Items.ItemDebitCard;



public class ATMPinGUI extends GuiScreen{
	public final int xSizeBackground1 = 232;
	public final int ySizeBackground1 = 250;
	
	public static double currentBal;
	
	private String enteredPin = "";
	private String underScore = "";
	private int tick = 0;
	private int attempt = 0;
	
	
	public final int guiX = (this.width - xSizeBackground1) / 2;
	public final int guiY = (this.height - xSizeBackground1) / 2;
	
	public ResourceLocation background1 = new ResourceLocation("financialmod", "textures/gui/ATM.png");
	
	
	public void initGui(){
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
		if(guibutton.id==1){
			enteredPin = enteredPin + "1";
			System.out.println(enteredPin);
		}
		if(guibutton.id==2){
			enteredPin = enteredPin + "2";
			System.out.println(enteredPin);
		}
		if(guibutton.id==3){
			enteredPin = enteredPin + "3";
			System.out.println(enteredPin);
		}
		if(guibutton.id==4){
			
		}
		if(guibutton.id==5){
			enteredPin = enteredPin + "4";
			System.out.println(enteredPin);
		}
		if(guibutton.id==6){
			enteredPin = enteredPin + "5";
			System.out.println(enteredPin);
		}
		if(guibutton.id==7){
			enteredPin = enteredPin + "6";
			System.out.println(enteredPin);
		}
		if(guibutton.id==8){
			this.enteredPin = "";
		}
		if(guibutton.id==9){
			enteredPin = enteredPin + "7";
			System.out.println(enteredPin);
		}
		if(guibutton.id==10){
			enteredPin = enteredPin + "8";
			System.out.println(enteredPin);
		}
		if(guibutton.id==11){
			enteredPin = enteredPin + "9";
			System.out.println(enteredPin);
		}
		if(guibutton.id==12){
			if(EconUtils.parseInt(enteredPin) >= 4){
				String cutPin = enteredPin.substring(0, 4);
				authenticatePin(cutPin);
			} else {
				authenticatePin("Bugzoo");
			}
		}
		if(guibutton.id==13){
			enteredPin = enteredPin + "0";
			System.out.println(enteredPin);
		}

	}
	
	private void authenticatePin (String pinCode) {
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		
    	if (pinCode.equals(ItemDebitCard.checkCardPin(player)) && ItemDebitCard.checkCardPin(player) != null) {
    			System.out.println("Correct Pin!");
    			mc.getMinecraft().displayGuiScreen(new ATMOptionsGUI());
    		} else {
    			System.out.println("They Dont MATCH!");
    			enteredPin = "";
    			attempt++;
    		}
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
        
        String underScore = "";
    	if (tick < 60) {
    		tick++;
    	} else if (tick >= 60) {
    		tick = 0;
    	}
    	
    	if (tick < 30) {
    		underScore = "_";
    	}
    	
    	if (enteredPin.length() == 1) {
			drawString(fontRendererObj, "*" + underScore, width / 2 - 10, height / 2 - 40, 0x006600);
		} else if (enteredPin.length() == 2) {
			drawString(fontRendererObj, "**" + underScore, width / 2 - 10, height / 2 - 40, 0x006600);
		} else if (enteredPin.length() == 3) {
			drawString(fontRendererObj, "***" + underScore, width / 2 - 10, height / 2 - 40, 0x006600);
		} else if (enteredPin.length() >= 4) {
			drawString(fontRendererObj, "****" + underScore, width / 2 - 10, height / 2 - 40, 0x006600);
		}
        
        this.drawCenteredString(fontRendererObj, "Welcome!", width/2, height / 2 - 90, 0xFFCC00);
        this.drawString(fontRendererObj, "Please Enter Your PIN,", width / 2 - 55, height / 2 - 75, 0xFFCC00);
        this.drawString(fontRendererObj, "Followed By 'Confirm'", width / 2 - 51, height / 2 - 60, 0xFFCC00);
        if(this.attempt == 0){
        this.drawString(fontRendererObj, "Attempt 1 of 3", width / 2 - 36, height / 2 - 20, 0x006600);
        }
        if(this.attempt == 1){
            this.drawString(fontRendererObj, "Attempt 2 of 3", width / 2 - 36, height / 2 - 20, 0xFFCC00);
        }
        if(this.attempt == 2){
            this.drawString(fontRendererObj, "Attempt 3 of 3", width / 2 - 36, height / 2 - 20, 0xCC0000);
        }
        if(this.attempt == 3){
            mc.getMinecraft().displayGuiScreen(null);
        }
        if(enteredPin.length() == 0){
        this.drawString(fontRendererObj, underScore, width / 2 - 10, height / 2 - 40, 0x006600);
        }
        super.drawScreen(i, j, f); 
	}
}
