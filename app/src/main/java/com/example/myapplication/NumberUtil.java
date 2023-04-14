package com.example.myapplication;

import android.text.TextWatcher;
import android.widget.EditText;

/**
 * @ describe
 * @ author lzl
 * @ time 2023/4/14 4:43 PM
 */
class NumberUtil {
    public static void keep2Decimal(TextWatcher textWatcher, CharSequence s, EditText et) {
        if (s.toString().contains(".")) {
            if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                s = s.toString().subSequence(0, s.toString().indexOf(".") + 3);
                et.removeTextChangedListener(textWatcher);
                et.setText(s);
                et.setSelection(s.length());
                et.addTextChangedListener(textWatcher);
            }
        }
        if (".".equals(s.toString())) {
            s = "0" + s;
            et.removeTextChangedListener(textWatcher);
            et.setText(s);
            et.setSelection(2);
            et.addTextChangedListener(textWatcher);
        }
        if (s.toString().startsWith("0") && s.toString().trim().length() > 1 && !".".equals(s.toString().substring(1, 2))) {
            et.removeTextChangedListener(textWatcher);
            et.setText(s.toString().substring(1, s.length()));
            et.setSelection(s.length() - 1);
            et.addTextChangedListener(textWatcher);
        }
    }

}
