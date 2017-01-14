import org.junit.Test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;

import java.util.StringTokenizer;

/**
 * Class for testing that OpenCV has installed correctly
 * After downloading the Maven specified dependencies,
 * a few additional steps are necessary
 *
 * ### Windows Instructions ###
 * 1) Download OpenCV 3.2 from the following link
 *      http://opencv.org/downloads.html
 * 2) Add the following location to your "Path" system variable
 *      \*locationOfOpenCVFolder*\opencv\build\java\x64
 */
public class OpenCVTest {

    // This will be main source of error if OpenCV isn't installed properly
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    /**
     * This test is used for viewing all the directories in your path system variable
     * Used to check if you've successfully added the location of the OpenCV dll
     */
    @Test
    public void checkJavaLibraryPath() {
        String property = System.getProperty("java.library.path");
        StringTokenizer parser = new StringTokenizer(property, ";");
        while (parser.hasMoreTokens()) {
            System.err.println(parser.nextToken());
        }
    }

    /**
     * Test that proves OpenCV is loaded and functioning properly
     */
    @Test
    public void simpleMatrixTest() {
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
        System.out.println("OpenCV Mat: " + m);
        Mat mr1 = m.row(1);
        mr1.setTo(new Scalar(1));
        Mat mc5 = m.col(5);
        mc5.setTo(new Scalar(5));
        System.out.println("OpenCV Mat data:\n" + m.dump());
    }

}