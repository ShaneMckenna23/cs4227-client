package com.cs4227.ui.models;

import com.cs4227.ui.components.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageModel {
    private BufferedImage image;

    public ImageModel(BufferedImage image){
        this.image = image;
    }
    public BufferedImage getImage(){
        return image;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    public void readImage(FileChooser fileChooser) {
        try {
            File selectedFile = fileChooser.getSelectedFile();
            BufferedImage selectedImage = ImageIO.read(selectedFile);
            this.image = selectedImage;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveImage(String filename,String path) {
        try{
            File outputfile = new File(path);
            String fileExtension = filename.split("\\.")[1]+"";
            System.out.print(fileExtension);
            ImageIO.write(image, fileExtension, outputfile);
        }catch (Exception e){
            System.out.print("Error!");
            e.printStackTrace();
        }
    }
}
