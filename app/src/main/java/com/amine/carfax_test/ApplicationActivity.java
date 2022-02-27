package com.amine.carfax_test;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

public class ApplicationActivity {
    // The last activity is held here weakly, statically.
    private static WeakReference<FragmentActivity> weakActivity;

    /**
     * Return the stored Activity, WARNing if it was null.
     */
    public static @Nullable
    FragmentActivity get() {
        if (weakActivity == null || weakActivity.get() == null) {
            Log.w("APP-ACTIVITY", "get() called, had no activity (returning null) hope that's ok. If not, did you forget to call store() first?");
            return null;
        }
        return weakActivity.get();
    }

    /**
     * Deliberately overwrite any stored Activity with this one.
     * @param activity The activity to store via weak reference.
     */
    public static void overwrite(@NonNull FragmentActivity activity) {
        store(activity, false);
    }
    private static void store(@NonNull FragmentActivity activity, boolean warnOverwriting) {
        // May toss this warning, but prior implementation used a wrapper instance singleton
        // which IGNORED the equivalence of this call if there was already an activity stored, so let's
        // at least find out if this is happening ever.
        if (warnOverwriting && weakActivity != null && weakActivity.get() != null) {
            Log.wtf("APP-ACTIVITY", "store() was called but had an activity already, but maybe you should have called clear first? Had: " + weakActivity.get());
        }
        weakActivity = new WeakReference<>(activity);
    }
}

