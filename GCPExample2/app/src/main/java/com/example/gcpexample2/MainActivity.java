package com.example.gcpexample2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

//    public final static int MY_REQUEST_CODE = 1;
//
//    String requestURL =
//            "https://vision.googleapis.com/v1/images:annotate?key=" +
//                    getResources().getString(R.string.mykey);

    private static final String CLOUD_VISION_API_KEY = "a6f5386de8f80693b8e229cd52ac2193b057c78b";
    public static final String FILE_NAME = "temp.jpg";
    private static final String ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String ANDROID_PACKAGE_HEADER = "X-Android-Package";

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int GALLERY_PERMISSIONS_REQUEST = 0;
    private static final int GALLERY_IMAGE_REQUEST = 1;
    public static final int CAMERA_PERMISSIONS_REQUEST = 2;
    public static final int CAMERA_IMAGE_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void callCloudVision(final Bitmap bitmap){
        annotateImageRequest.setFeatures(new ArrayList<feature>() {{
            Feature labelDetection = new Feature();
            labelDetection.setType("LABEL_DETECTION");
            labelDetection.setMaxResults(10);
            add(labelDetection);
        }});
    }

    private String convertResponseToString(BatchAnnotateImagesResponse response){
        String message = "I found these things:\n\n";

        List<entityannotation> labels = response.getResponses().get(0).getTextAnnotations();
        if (labels != null) {
            message = labels.get(0).getDescription();
        } else {
            message  = "nothing";
        }

        return message;
    }
    }
}
