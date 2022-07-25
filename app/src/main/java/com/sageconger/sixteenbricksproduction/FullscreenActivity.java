package com.sageconger.sixteenbricksproduction;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

//    private String mCM;
//    private ValueCallback<Uri> mUM;
//    private ValueCallback<Uri[]> mUMA;
//    Uri mCapturedImageURI;
//    File photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        WebView mWebView = (WebView) findViewById(R.id.webView);

        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.getSettings().setGeolocationEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
//        mWebView.getSettings().setAllowFileAccess(true);
//        mWebView.getSettings().setAllowContentAccess(true);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
//        mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
//        mWebView.getSettings().setGeolocationDatabasePath( this.getApplicationContext().getFilesDir().getPath() );

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // When user clicks a hyperlink, load in the existing WebView
                view.loadUrl(url);
                return true;
            }
        });

        // set setWebChromeClient
//        mWebView.setWebChromeClient(new WebChromeClient() {
//            public void onGeolocationPermissionsShowPrompt(String origin, android.webkit.GeolocationPermissions.Callback callback) {
//                callback.invoke(origin, true, false);
//            }
//
//            //For Android 3.0+
//            public void openFileChooser(ValueCallback<Uri> uploadMsg) {
//
//                mUM = uploadMsg;
//                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
//                i.addCategory(Intent.CATEGORY_OPENABLE);
//                i.setType("*/*");
//                startActivityForResult(Intent.createChooser(i, "File Chooser"), 101);
//            }
//
//            // For Android 3.0+, above method not supported in some android 3+ versions, in such case we use this
//            public void openFileChooser(ValueCallback uploadMsg, String acceptType) {
//
//                mUM = uploadMsg;
//                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
//                i.addCategory(Intent.CATEGORY_OPENABLE);
//                i.setType("*/*");
//                startActivityForResult(
//                        Intent.createChooser(i, "File Browser"),
//                        101);
//            }
//
//            //For Android 4.1+
//            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
//
//                mUM = uploadMsg;
//                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
//                i.addCategory(Intent.CATEGORY_OPENABLE);
//                i.setType("*/*");
//                startActivityForResult(Intent.createChooser(i, "File Chooser"), 101);
//            }
//
//            //For Android 5.0+
//            public boolean onShowFileChooser(
//                    WebView webView, ValueCallback<Uri[]> filePathCallback,
//                    WebChromeClient.FileChooserParams fileChooserParams) {
//
//                if (mUMA != null) {
//                    mUMA.onReceiveValue(null);
//                }
//
//                mUMA = filePathCallback;
//                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//
//                    File photoFile = null;
//
//                    try {
//                        photoFile = createImageFile();
//                        takePictureIntent.putExtra("PhotoPath", mCM);
//                    } catch (IOException ex) {
//                        System.out.println(ex.getMessage());
//                        return false;
//                    }
//                    if (photoFile != null) {
//                        mCM = "file:" + photoFile.getAbsolutePath();
//                        Uri uri = FileProvider.getUriForFile(FullscreenActivity.this, BuildConfig.APPLICATION_ID + ".provider",photoFile);
//                        takePictureIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//                    } else {
//                        takePictureIntent = null;
//                    }
//                }
//
//                startActivityForResult(takePictureIntent, 101);
//
//                return true;
//            }
//            });

        mWebView.loadUrl("https://store.sixteenbricks.com/production/mobile");

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode,
//                                    Intent intent) {
//
////        //inside onActivityResult
////        if (resultCode != RESULT_OK) {
////            mUploadMessage.onReceiveValue(null);
////            return;
////        }
////        if(requestCode==101)
////        {
////
////            if(mCapturedImageURI==null){
////                return;
////            }
////            /** fixed code **/
////            getContentResolver().notifyChange(mCapturedImageURI, null);
////            ContentResolver cr = getContentResolver();
////            try {
////                Uri uriContent= Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), photo.getAbsolutePath(), null, null));
////                photo = null;
////            }
////            catch (FileNotFoundException e) {
////                return;
////            }
////            Uri selectedImage= intent == null || resultCode != RESULT_OK ? null : intent.getData();
////            mUploadMessage.onReceiveValue(selectedImage);
////            mUploadMessage = null;
////        }
//
//        super.onActivityResult(requestCode, resultCode, intent);
//
//        if (Build.VERSION.SDK_INT >= 21) {
//            Uri[] results = null;
//
//            //Check if response is positive
//            if (resultCode == Activity.RESULT_OK) {
//                if (requestCode == 101) {
//
//                    if (null == mUMA) {
//                        return;
//                    }
//                    if (intent == null) {
//                        //Capture Photo if no image available
//                        if (mCM != null) {
//                            results = new Uri[]{Uri.parse(mCM)};
//                        }
//                    } else {
//                        String dataString = intent.getDataString();
//                        if (dataString != null) {
//                            results = new Uri[]{Uri.parse(dataString)};
//                        }
//                    }
//                }
//            }
//            mUMA.onReceiveValue(results);
//            mUMA = null;
//        } else {
//
//            if (requestCode == 101) {
//                if (null == mUM) return;
//                Uri result = intent == null || resultCode != RESULT_OK ? null : intent.getData();
//                mUM.onReceiveValue(result);
//                mUM = null;
//            }
//        }
//
//    }
//
//    // Create an image file
//    private File createImageFile() throws IOException {
//
//        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String imageFileName = "img_" + timeStamp + "_";
//        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//        return File.createTempFile(imageFileName, ".jpg", storageDir);
//    }
//
}
