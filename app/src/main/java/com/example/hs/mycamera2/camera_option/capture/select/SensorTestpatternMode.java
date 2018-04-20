package com.example.hs.mycamera2.camera_option.capture.select;

import android.hardware.camera2.CaptureRequest;

import com.example.hs.mycamera2.camera_option.OptionType;
import com.example.hs.mycamera2.camera_option.CameraOption;
import com.example.hs.mycamera2.camera_option.detail_option.SelectDetailOption;

/**
 * Created by user on 2018. 4. 20..
 */

public class SensorTestpatternMode implements CameraOption<Integer> {
    @Override
    public CaptureRequest.Key<Integer> getKey() {
        return CaptureRequest.SENSOR_TEST_PATTERN_MODE;
    }

    @Override
    public String getDisplayName() {
        return "SENSOR TEST PATTERN MODE";
    }

    @Override
    public OptionType getOptionType() {
        return OptionType.SELECT;
    }

    @Override
    public SelectDetailOption getDetailOption() {
        return SelectDetailOption.SENSOR_TEST_PATTERN_MODE;
    }

    @Override
    public String getDescriptionFilePath() {
        return null;
    }
}
