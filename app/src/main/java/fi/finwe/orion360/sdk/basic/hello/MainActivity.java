/**
 * Copyright (c) 2016, Finwe Ltd. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation and/or
 *    other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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
