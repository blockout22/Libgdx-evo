package com.blockout22.evolution.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.blockout22.evolution.Evolution;

public class DesktopLauncher {
	public static void main (String[] arg) {
//		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		config.width = 640;
//		config.height = 480;
//		new LwjglApplication(new Evolution(), config);

		//LWJGL 3
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(640, 480);
		config.enableGLDebugOutput(true, System.out);
		new Lwjgl3Application(new Evolution(), config);
	}
}
