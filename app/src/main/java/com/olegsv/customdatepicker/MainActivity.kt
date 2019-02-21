package com.olegsv.customdatepicker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.olegsv.customdatepicker.datepicker.TimePickerPopWin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        public void onTimeClickListener() {
            if (TimeDataModel.INSTANCE.getIsDateSelect()) {
                timePickerDialog = new TimePickerDialog(getActivity());
            } else {
                toast(getActivity(), getString(R.string.first_select_date));
            }
        }*/

        val bntTextSize = 20
        val viewTextSize = 25

        val pickerDialog = TimePickerPopWin.Builder(
            this, (TimePickerPopWin.OnTimePickedListener { hour, min, timeDesc, timeFromData, timeToData ->
                Log.d("$$$","$timeFromData - $timeToData")
                textView.text = "$timeFromData - $timeToData"
            })
        )
            .textConfirm("Продолжить") //text of confirm button
            .textCancel("CANCEL") //text of cancel button
            .btnTextSize(bntTextSize) // button text size
            .viewTextSize(viewTextSize) // pick view text size
            .colorCancel(Color.parseColor("#999999")) //color of cancel button
            .colorConfirm(Color.parseColor("#A9A9A9"))//color of confirm button
            .build()

        button.setOnClickListener {
            pickerDialog.showPopWin(this)
        }

    }

}



