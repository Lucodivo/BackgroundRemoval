import org.junit.Assert;
import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.awt.image.BufferedImage;

/**
 * Created by Connor on 1/15/2017.
 */
public class BackgroundRemovalTest {

    public static String TEST_IMAGE_BAND_T_DOORWAY = "src\\main\\resources\\OpenCVTestingImages\\BandT1.jpg";
    public static String TEST_IMAGE_BAND_T_SHEET = "src\\main\\resources\\OpenCVTestingImages\\BandT2.jpg";
    public static String TEST_IMAGE_BLACK_T_DOORWAY = "src\\main\\resources\\OpenCVTestingImages\\BlackShirt1.jpg";
    public static String TEST_IMAGE_BLACK_T_SHEET = "src\\main\\resources\\OpenCVTestingImages\\BlackShirt2.jpg";
    public static String TEST_IMAGE_BLUE_YELLOW_JACKET_DOORWAY = "src\\main\\resources\\OpenCVTestingImages\\BlackYellowJacket1.jpg";
    public static String TEST_IMAGE_BLUE_YELLOW_JACKET_SHEET = "src\\main\\resources\\OpenCVTestingImages\\BlackYellowJacket2.jpg";
    public static String TEST_IMAGE_DENIM_JACKET_DOORWAY = "src\\main\\resources\\OpenCVTestingImages\\DenimJacket1.jpg";
    public static String TEST_IMAGE_DENIM_JACKET_SHEET = "src\\main\\resources\\OpenCVTestingImages\\DenimJacket2.jpg";
    public static String TEST_IMAGE_INDIAN_JACKET_DOORWAY = "src\\main\\resources\\OpenCVTestingImages\\IndianJacket1.jpg";
    public static String TEST_IMAGE_INDIAN_JACKET_SHEET = "src\\main\\resources\\OpenCVTestingImages\\IndianJacket2.jpg";
    public static String TEST_IMAGE_LUCAS1 = "src\\main\\resources\\OpenCVTestingImages\\Lucas1.jpg";
    public static String TEST_IMAGE_LUCAS2 = "src\\main\\resources\\OpenCVTestingImages\\Lucas2.jpg";
    public static String TEST_IMAGE_LUCAS3 = "src\\main\\resources\\OpenCVTestingImages\\Lucas3.jpg";

    // This will be main source of error if OpenCV isn't installed properly
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    /**
     * currently used to debug and view object image
     */
    @Test
    public void denimJacketTest1() {
        Mat photo = Imgcodecs.imread(TEST_IMAGE_DENIM_JACKET_SHEET);
        Mat foreground = ObjectExtractor.removeBackground(photo);

        BufferedImage object = MatHelper.matToBufferedImage(foreground);

        Assert.assertFalse(photo.empty());
    }
}
