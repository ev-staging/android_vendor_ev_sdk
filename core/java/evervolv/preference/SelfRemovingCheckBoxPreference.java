/*
 * Copyright (C) 2016 The CyanogenMod project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package evervolv.preference;

import android.content.Context;
import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceViewHolder;
import android.util.AttributeSet;

/**
 * A SwitchPreference which can automatically remove itself from the hierarchy
 * based on constraints set in XML.
 */
public class SelfRemovingCheckBoxPreference extends CheckBoxPreference {

    private final ConstraintsHelper mConstraints;

    public SelfRemovingCheckBoxPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mConstraints = new ConstraintsHelper(context, attrs, this);
    }

    public SelfRemovingCheckBoxPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        mConstraints = new ConstraintsHelper(context, attrs, this);
    }

    public SelfRemovingCheckBoxPreference(Context context) {
        super(context);
        mConstraints = new ConstraintsHelper(context, null, this);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        mConstraints.onBindViewHolder(holder);
    }

    public void setAvailable(boolean available) {
        mConstraints.setAvailable(available);
    }

    public boolean isAvailable() {
        return mConstraints.isAvailable();
    }

    /**
     * Returns whether the preference can be found in persistent storage
     */
    protected boolean isPersisted() {
        return getSharedPreferences().contains(getKey());
    }
}
