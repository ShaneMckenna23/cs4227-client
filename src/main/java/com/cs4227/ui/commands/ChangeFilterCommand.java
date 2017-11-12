package com.cs4227.ui.commands;

public class ChangeFilterCommand implements Command {

    @Override
    public void execute() {
//        String filter = ToolboxView.getSelectedFilter();
//        if (filter == "Monochrome"){
//            BufferedImage image = ImageView.selectedImage;
//            File outputfile = new File("image.jpg");
//            try {
//                ImageIO.write(image, "jpg", outputfile);
//                Monochrome monochrome = new Monochrome();
//                File convImage = monochrome.convert(outputfile);
//
//                BufferedImage in = ImageIO.read(convImage);
//
//                Start.modifyImage(in);
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public void undo() {
        
    }
}
