package fi.finwe.orion360.sdk.basic.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import fi.finwe.orion360.OrionVideoView;

public class MainActivity extends AppCompatActivity {

    /** Orion360 video player view. */
    private OrionVideoView mOrionVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Orion360 video view that is defined in the XML layout.
        mOrionVideoView = (OrionVideoView) findViewById(R.id.orion_video_view);

        // Listen when a video has been prepared.
        mOrionVideoView.setOnPreparedListener(new OrionVideoView.OnPreparedListener() {
            @Override
            public void onPrepared(OrionVideoView orionVideoView) {
                mOrionVideoView.start();
            }
        });

        // Notice that this call will fail if a valid Orion360 license file for the package name
        // (defined in the application's manifest file) cannot be found.
        try {
            mOrionVideoView.prepare(
                    "http://www.finwe.mobi/orion360/test/equi/Orion360_test_video_1920x960.mp4");
        } catch (OrionVideoView.LicenseVerificationException e) {
            Log.e("OrionVideoView", "Orion360 SDK license could not be verified!", e);
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        // Propagate activity lifecycle events to Orion360 video view.
        mOrionVideoView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Propagate activity lifecycle events to Orion360 video view.
        mOrionVideoView.onResume();
    }

    @Override
    public void onPause() {
        // Propagate activity lifecycle events to Orion360 video view.
        mOrionVideoView.onPause();

        super.onPause();
    }

    @Override
    public void onStop() {
        // Propagate activity lifecycle events to Orion360 video view.
        mOrionVideoView.onStop();

        super.onStop();
    }

    @Override
    public void onDestroy() {
        // Propagate activity lifecycle events to Orion360 video view.
        mOrionVideoView.onDestroy();

        super.onDestroy();
    }

}
