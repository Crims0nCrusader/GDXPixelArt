package com.bhms.gdxintro;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.bhms.gdxintro.AppHandler;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1920, 1472);
		config.setForegroundFPS(60);
		config.setTitle("THEGREATESTWINDOWEVER");
		new Lwjgl3Application(new AppHandler(), config);
	}
}
