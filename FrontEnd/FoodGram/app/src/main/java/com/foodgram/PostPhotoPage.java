package com.foodgram;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Posts a photo
 * @Alexi
 * @SKarn
 */
public class PostPhotoPage extends AppCompatActivity {

    ImageView postImage;
    private TextView mTextViewResult;

    private Button signOut, add_post;

    private EditText txt_caption, txt_foodTag, txt_costTag,txt_restaurant;

    private RequestQueue requestQueue;

    //private MultipartEntityBuilder mBuiler = MultipartEntityBuilder.create();

    //public static Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_photo_page);

        User account = new User(1, "sweaty",  "sghimire@iastate.edu", "user", "1234");
        signOut = (Button) findViewById(R.id.signOut_post);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcome_page();
            }
        });

        txt_caption = (EditText) findViewById(R.id.post_caption);
        txt_foodTag = (EditText) findViewById(R.id.post_foodTag);
        txt_costTag = (EditText) findViewById(R.id.post_costTag);
        txt_restaurant = (EditText) findViewById(R.id.post_restaurant);

        postImage = (ImageView)findViewById(R.id.post_img);

        add_post = (Button) findViewById(R.id.btn_post);
        add_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendContents();
            }
        });

        postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
//                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
//                        requestPermissions(permissions, PERMISSION_CODE);
//
//                    } else {
//                        selectImgUpload();
//                    }
//                    }
//                    else{
//                        selectImgUpload();
//                    }
                selectImgUpload();
                }
        });

        mTextViewResult = findViewById(R.id.errorView);

    }

    /**
     * Takes a user to the welcome page
     */
    public void welcome_page() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    /**
     * Grabs the posts from a user and then sends it to the backend to be posted to
     * the database.
     */
    private void sendContents() {

        requestQueue = Volley.newRequestQueue(this);
        //String url = "http://10.65.23.83:8080/post/comment/users";
        //String url = "http://10.31.4.129:8080/post/photo";
        String url = "http://10.9.213.42:8080/post/photo";
        // String url = "http://coms-309-mg-1.cs.iastate.edu:8080/photo/post";
        //String url = "http://10.31.31.154:8080/post/comment";
        //"http://10.31.24.107:8080/comment/all";

        final JSONObject obj = new JSONObject();
        final JSONObject user = new JSONObject();
        User account = new User(1, "sweaty",  "sghimire@iastate.edu", "user", "1234");
        try {
            user.put("userId", account.getUser_id());
            obj.put("pic", "url");
            obj.put("caption", (txt_caption.getText()).toString());
            obj.put("restaurant", (txt_restaurant.getText()).toString());
            obj.put("user", user);
            obj.put("foodTag", (txt_foodTag.getText()).toString());
            obj.put("costTag", (txt_costTag.getText()).toString());

            Log.d("Response", obj.toString());

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        /**
         * Receives response from controller and displays response on Logcat
         * Displays error as text view in the app page when error occurs
         */
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Log.d("Response", response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error.Response", error.toString());

                if (error instanceof TimeoutError || error instanceof NoConnectionError){
                    mTextViewResult.setText("Timeout Error or No connection error");
                }
                else if(error instanceof AuthFailureError){
                    mTextViewResult.setText("authentication failure error");
                }else if(error instanceof ServerError){
                    mTextViewResult.setText("server error");
                }else if(error instanceof NetworkError){
                    mTextViewResult.setText("network error");
                }else if(error instanceof ParseError){
                    mTextViewResult.setText("Parse Error");
                }

            }

        }) ;

//        {
//            @Override
//            public String getBodyContentType() {
//                return "application/json; charset=utf-8";
//            }
//
////            @Override
////            public byte[] getBody() throws AuthFailureError {
////                try {
////                    return obj == null ? null : obj.getBytes("utf-8");
////                } catch (UnsupportedEncodingException uee) {
////                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", obj, "utf-8");
////                    return null;
////                }
////
////            }
//        };

        requestQueue.add(objectRequest);

    }

    /**
     * Initiates image upload choice to the user after ImageView (Camera Icon) is clicked
     * The upload options are: Taking a photo and Choosing a photo form the photo Gallery to upload
     */
    private void selectImgUpload(){
        final CharSequence[] options = {"Take Photo","Choose From Gallery","Cancel"};
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(PostPhotoPage.this);
        builder.setTitle("Choose an Option");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int items) {
                if(options[items].equals("Take Photo")){
//                    if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) //Camera Permission check
//                    {
//                        requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
//                    }
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "photo.webp");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                }
                else if (options[items].equals("Choose From Gallery")){
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (options[items].equals("Cancel")){
                    dialogInterface.dismiss();
                }
            }
        });
        builder.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK) {
            //Bitmap bitmap = null;

            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for(File photos : f.listFiles()){
                    if(photos.getName().equals("photo.webp")){
                        f = photos;
                        break;
                    }
                }
//                Bitmap photo = (Bitmap) data.getExtras().get("data");
//                postImage.setImageBitmap(photo);
                try{
                    Bitmap bit;
                    BitmapFactory.Options bitOptions = new BitmapFactory.Options();
                    bit = BitmapFactory.decodeFile(f.getAbsolutePath(), bitOptions);
                    bit = getResizedBitmap(bit, 400);
                    postImage.setImageBitmap(bit);
                    File fotoDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator);
                    OutputStream outFile = null;
                    File imgFile = new File(fotoDirectory,System.currentTimeMillis() + ".webp");
                    try{
                        outFile = new FileOutputStream(imgFile);
                        bit.compress(Bitmap.CompressFormat.WEBP, 90, outFile);
                        Toast.makeText(getApplicationContext(), "Image Saved To Gallery", Toast.LENGTH_SHORT).show();
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e){
                        e.printStackTrace();
                        Log.d("File Not Found", e.toString());
                    } catch (IOException e){
                        e.printStackTrace();
                        Log.d("IO Exception", e.toString());
                    } catch (Exception e){
                        e.printStackTrace();
                        Log.d("Error", e.toString());
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    Log.d("Unable to Add Photos", e.toString());
                }

            }
            else if(requestCode == 2){
                try {
                    Uri galleryImg = data.getData();
                    String[] filePath = {MediaStore.Images.Media.DATA};
                    Cursor c = getContentResolver().query(galleryImg, filePath, null, null, null);
                    c.moveToFirst();
                    int columnIndex = c.getColumnIndex(filePath[0]);
                    String picturePath = c.getString(columnIndex);
                    c.close();
                    Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                    thumbnail = getResizedBitmap(thumbnail, 400);
                    Log.w("path of image", picturePath + "");
                    postImage.setImageBitmap(thumbnail);
                } catch (Exception e) {
                        e.printStackTrace();
                        Log.d("Gallery Error Response", e.toString());
                    }

                }
            }
        }

    /**
     * Creates a resized image to display as a thumbnail for the chosen photo from the devices image gallery
     * @param image
     * The allocated thumbnail size from the Image View on users device
     * @param maxSize
     * Max size of the thumbnail that can be made
     * @return
     * Creates a resized thumbnail with chosen image
     */
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }


}
