package org.eth.week2.exercises;

import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;

public class ControllerExample {
    public static void main(String[] args) {
        Config config = ConfigUtils.createConfig();

        Controler controller = new Controler(config);

        controller.run();

    }
}
