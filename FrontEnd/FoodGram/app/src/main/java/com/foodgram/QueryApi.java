package com.foodgram;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryApi {
//    private String hostname = "http://example.com/";
//
//    private SessionManager session;
//
//    private static QueryAPI mInstance = new QueryAPI();
//
//    //Create a singleton
//    public static synchronized QueryAPI getInstance() {
//        return mInstance;
//    }
//
//    //Create an object to return the server's response
//    public class ApiResult {
//        public Boolean success;
//        public String message;
//        public Object data;
//
//        //check what kind of data is returned in the json
//        public boolean dataIsArray() {
//            return (data != null && data instanceof JSONArray);
//        }
//
//        public boolean dataIsObject() {
//            return (data != null && data instanceof JSONObject);
//        }
//
//        public boolean dataIsInteger() {
//            return (data != null && data instanceof Integer);
//        }
//
//        //return the data properly casted
//        public JSONArray getDataAsArray() {
//            if (this.dataIsArray()) {
//                return (JSONArray) this.data;
//            } else {
//                return null;
//            }
//        }
//
//        public JSONObject getDataAsObject() {
//            if (this.dataIsObject()) {
//                return (JSONObject) this.data;
//            } else {
//                return null;
//            }
//        }
//
//        public Integer getDataAsInteger() {
//            if (this.dataIsInteger()) {
//                return (Integer) this.data;
//            } else {
//                return null;
//            }
//        }
//
//    }
//
//    //create an interface with a callback method
//    public interface ApiResponse<T> {
//        public void onCompletion(T result);
//    }
//
//    //Create a get request with the url to query, and a callback
//    public void RequestApi(String url, final ApiResponse<ApiResult> completion) {
//        Log.v("Performing request: ", url);
//        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, hostname + url, (JSONObject) null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        ApiResult res = new ApiResult();
//                        Log.v("RequestApi Response", response.toString());
//                        //Log.v("Data: ", response.toString());
//                        try {
//
//                            Boolean success = response.getBoolean("success");
//                            try {
//                                res.data = response.getJSONArray("data");
//                            } catch (JSONException e) {
//                                Log.v("exception catch", e.getMessage());
//                                try {
//                                    res.data = response.getJSONObject("data");
//                                } catch (JSONException x) {
//                                    Log.v("exception catch", x.getMessage());
//                                    res.data = response.getInt("data");
//                                }
//                            }
//
//                            res.success = success;
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            res.success = false;
//                        }
//                        completion.onCompletion(res);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                ApiResult res = new ApiResult();
//                res.success = false;
//                completion.onCompletion(res);
//                displayVolleyResponseError(error);
//            }
//        }
//        );

    /**
     * This needs to be added on to this query class
     */

//    public void RequestMultiPart(File file, String filename, String boundary, String url, String fileField, Map<String,String> params, final ApiResponse<String> completion ) {
//
//        final String reqUrl = hostname+url;
//        MultipartRequest imageUploadReq = new MultipartRequest(reqUrl,params,file,filename,fileField,
//                new Response.ErrorListener()
//                {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("Multipart Request Url: ", reqUrl);
//                        Log.d("Multipart ERROR", "error => " + error.toString());
//                        completion.onCompletion(error.toString());
//                        displayVolleyResponseError(error);
//                    }
//                },
//                new Response.Listener<String>()
//                {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.d("MediaSent Response", response);
//                        completion.onCompletion(response);
//
//                    }
//                }
//        ) {
//
//            /* The following method sets the cookies in the header, I needed it for my server
//             but you might want to remove it if it is not useful in your case */
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> headers = new HashMap<String, String>();
//                CookieManager manager = AppController.getInstance().getCookieManager();
//                List<HttpCookie> cookies = manager.getCookieStore().getCookies();
//                String cookie = "";
//                for (HttpCookie eachCookie : cookies) {
//                    String cookieName = eachCookie.getName().toString();
//                    String cookieValue = eachCookie.getValue().toString();
//                    cookie += cookieName + "=" + cookieValue + "; ";
//                }
//                headers.put("Cookie", cookie);
//                return headers;
//            }
//
//        };
//
//        imageUploadReq.setRetryPolicy(new DefaultRetryPolicy(1000 * 60, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        AppController.getInstance().addToRequestQueue(imageUploadReq);
//    }

    /**
     * From this website --> http://kalianey.com/sending-images-multipart-request-android-volley-library/
     */

//        //In case the server is a bit slow and we experience timeout errors﹕ error => com.android.volley.TimeoutError
//        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
//
//        AppController.getInstance().addToRequestQueue(jsonRequest);


}
