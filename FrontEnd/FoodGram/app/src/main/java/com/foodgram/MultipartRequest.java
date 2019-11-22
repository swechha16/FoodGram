//package com.foodgram;
//
//
//import android.util.Log;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.AuthFailureError;
//import com.android.volley.NetworkResponse;
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyLog;
//import com.android.volley.toolbox.HttpHeaderParser;
////import org.apache.http.HttpEntity;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.HttpEntityWrapperHC4;
//import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntity;
////import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.entity.mime.content.StringBody;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//import retrofit2.http.HTTP;
//
//public class MultipartRequest extends Request<String>  {
//
//    private MultipartEntityBuilder mBuilder = MultipartEntityBuilder().create();
//
//    private final Response.Listener<String> mListener;
//    private final File mImageFile;
//    //protected Map<String, String> headers;
////    private final String mStringPart;
//    private Map<String, String> mParams;
//    private String filePartName = "file";
//    private String stringPartName = "text";
//    private String mBodyContentType;
//
////    public void setBoundary(String boundary) {
////        this.mBoundary = boundary;
////    }
//
//    public MultipartRequest(String url, final Map<String, String> params, File imageFile, ErrorListener errorListener, Response.Listener<String> listener ){
//
//        super(Method.POST, url, errorListener);
//
//        mListener = listener;
//        mImageFile = imageFile;
//        mParams = params;
////        mStringPart = stringPart; Don't need these for the backend
////        mFileName = fileName;
//
//        buildMultipartEntity();
//    }
//
//    @Override
//    public Map<String, String> getHeaders() throws AuthFailureError {
//        Map<String, String> headers = super.getHeaders();
//
//        if (headers == null || headers.equals(Collections.emptyMap())) {
//            headers = new HashMap<String, String>();
//        }
//        headers.put("file", "Multipart file");
//        return headers;
//    }
//
//    private void buildMultipartEntity(){
//        mEntity.addPart(filePartName, new FileBody(mImageFile));
//        try{
//            mEntity.addPart(stringPartName, new StringBody(mStringPart));
//        }catch (UnsupportedEncodingException e){
//            e.printStackTrace();
//            Log.d("Unsupported Encoding", e.toString());
//        }
//        for (Map.Entry<String, String> entry : mParams.entrySet()) {
//            mBuilder.addTextBody(entry.getKey(), entry.getValue());
//        }
//        mBuilder.addPart(mImageFile,ContentType.create("image/jpg"));
//        mBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//        mBuilder.addPart()
//    }
//
//    @Override
//    public String getBodyContentType(){
//        return mBodyContentType;
//    }
//
//    @Override
//    public byte[] getBody() throws AuthFailureError {
//
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        try {
//            HttpMultipartMode entity = mBuilder.build();
//            mBodyContentType = entity.getContentType().getValue();
//            mEntity.writeTo(bos);
//        } catch (IOException e) {
//            VolleyLog.e("IOException writing to ByteArrayOutputStream bos, building the multipart request.");
//        }
//        return bos.toByteArray();
//    }
//
//    @Override
//    protected void deliverResponse(String response) {
//        mListener.onResponse(response);
//    }
//
//    @Override
//    protected Response<String> parseNetworkResponse(NetworkResponse response) {
//        String parsed;
//        try {
//            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
//        } catch (UnsupportedEncodingException e) {
//            parsed = new String(response.data);
//        }
//        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
//    }
//
//}
