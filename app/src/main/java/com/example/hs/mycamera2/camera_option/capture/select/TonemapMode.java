package com.example.hs.mycamera2.camera_option.capture.select;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;

import com.example.hs.mycamera2.camera_option.CameraOption;
import com.example.hs.mycamera2.camera_option.capture.OptionType;
import com.example.hs.mycamera2.camera_option.capture.DetailOptionInfo;

/**
 * Created by user on 2018. 4. 20..
 */

public class TonemapMode extends CameraOption<Integer> {

    @Override
    public void initailize(CameraCharacteristics characteristics) {
//        Integer hardwareLevel = characteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
//        if (hardwareLevel == null || hardwareLevel != CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_FULL) {
//            return;
//        }

        int[] values = characteristics.get(CameraCharacteristics.TONEMAP_AVAILABLE_TONE_MAP_MODES);
        if (values != null && values.length > 0) {
            for (int value : values) {
                switch (value) {
                    case CameraMetadata.TONEMAP_MODE_CONTRAST_CURVE:
                        items.add(new DetailOptionInfo<>(CameraMetadata.TONEMAP_MODE_CONTRAST_CURVE, "CONTRAST CURVE"));
                        break;
                    case CameraMetadata.TONEMAP_MODE_FAST:
                        items.add(new DetailOptionInfo<>(CameraMetadata.TONEMAP_MODE_FAST, "FAST"));
                        break;
                    case CameraMetadata.TONEMAP_MODE_HIGH_QUALITY:
                        items.add(new DetailOptionInfo<>(CameraMetadata.TONEMAP_MODE_HIGH_QUALITY, "HIGH QUALITY"));
                        break;
                    case CameraMetadata.TONEMAP_MODE_GAMMA_VALUE:
                        items.add(new DetailOptionInfo<>(CameraMetadata.TONEMAP_MODE_GAMMA_VALUE, "GAMMA VALUE"));
                        break;
                    case CameraMetadata.TONEMAP_MODE_PRESET_CURVE:
                        items.add(new DetailOptionInfo<>(CameraMetadata.TONEMAP_MODE_PRESET_CURVE, "PRESET CURVE"));
                        break;
                }
            }
        }
    }

    @Override
    public CaptureRequest.Key<Integer> getKey() {
        return CaptureRequest.TONEMAP_MODE;
    }

    @Override
    public String getDisplayName() {
        return "Control High-level global contrast/gamma/tonemapping";
    }

    @Override
    public OptionType getOptionType() {
        return OptionType.INTEGER_SELECT;
    }

    @Override
    public String getDescriptionFilePath() {
        return null;
    }
}
