import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

/**
 * Created by Connor on 1/14/2017.
 */
public class MatHelper {

    /**
     * Converts a buffered image to a Mat using CV_8UC3
     * http://stackoverflow.com/questions/14958643/converting-bufferedimage-to-mat-in-opencv
     * @param bi
     * @return
     */
    public static Mat bufferedImageToMat(BufferedImage bi) {
        Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
        byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
        mat.put(0, 0, data);
        return mat;
    }

    /**
     * Converts a Mat using CV_8UC3 to a buffered image
     * http://stackoverflow.com/questions/27086120/convert-opencv-mat-object-to-bufferedimage
     * @param mat
     * @return
     */
    public static BufferedImage matToBufferedImage(Mat mat){
        BufferedImage bi = new BufferedImage(mat.width(), mat.height(), BufferedImage.TYPE_3BYTE_BGR);
        byte[] data = ((DataBufferByte)bi.getRaster().getDataBuffer()).getData();
        mat.get(0, 0, data);
        return bi;
    }
}
