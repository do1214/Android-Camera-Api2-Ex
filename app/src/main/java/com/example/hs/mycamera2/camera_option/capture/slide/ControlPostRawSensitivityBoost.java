package com.example.hs.mycamera2.camera_option.capture.slide;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Range;

import com.example.hs.mycamera2.camera_option.CameraOption;
import com.example.hs.mycamera2.camera_option.capture.OptionType;
import com.example.hs.mycamera2.camera_option.capture.DetailOptionInfo;

/**
 * Created by user on 2018. 4. 20..
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class ControlPostRawSensitivityBoost extends CameraOption<Integer> {

    public ControlPostRawSensitivityBoost(CameraCharacteristics characteristics) {
        super(characteristics);
    }

    @Override
    protected void initailize(CameraCharacteristics characteristics) {
        Range<Integer> range = characteristics.get(CameraCharacteristics.CONTROL_POST_RAW_SENSITIVITY_BOOST_RANGE);

        Integer lower = range.getLower();
        Integer upper = range.getUpper();

        if (lower == null || upper == null) {
            return;
        }

        items.add(new DetailOptionInfo<>(lower, "LOWER"));
        items.add(new DetailOptionInfo<>(upper, "UPPER"));
    }

    @Override
    public CaptureRequest.Key<Integer> getKey() {
        return CaptureRequest.CONTROL_POST_RAW_SENSITIVITY_BOOST;
    }

    @Override
    public String getDisplayName() {
        return "RAW 센서 데이터를 캡처 한 후 출력 이미지에 적용되는 추가 감도 증가량입니다.";
    }

    @Override
    public OptionType getOptionType() {
        return OptionType.SLIDE;
    }

    @Override
    public String getDescriptionFilePath() {
        return null;
    }
}
