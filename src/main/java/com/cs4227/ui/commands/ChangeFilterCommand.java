package com.cs4227.ui.commands;

import com.cs4227.framework.filters.Monochrome;
import com.cs4227.ui.Start;
import com.cs4227.ui.views.ImageView;
import com.cs4227.ui.views.ToolboxView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ChangeFilterCommand implements Command {

    @Override
    public void execute() {
        String filter = ToolboxView.getSelectedFilter();
        if (filter == "Monochrome"){
            BufferedImage image = ImageView.selectedImage;
            File outputfile = new File("image.jpg");
            try {
                ImageIO.write(image, "jpg", outputfile);
                Monochrome monochrome = new Monochrome();
                File convImage = monochrome.convert(outputfile);

                BufferedImage in = ImageIO.read(convImage);
                Start.refreshImage(in, in.getWidth(),in.getHeight());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void undo() {
        
    }
}
