package com.amine.carfax_test;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class FragmentsUtil {
    private static final String TAG = "FragmentsUtil";

    public enum FRAGMENTS {
        CARDETAILS("CARDETAILS_FRAGMENT"),
        HOME("HOMEPAGE_FRAGMENT");
        private String fragmentTag;

        FRAGMENTS(String fragmentTag) {
            this.fragmentTag = fragmentTag;
        }

        public String getFragmentTag() {
            return fragmentTag;
        }
    }


    public static void addSubscreen(Fragment fragment, String fragmentTag) {
        Log.d(TAG, "addSubscreen with fragment: " + fragment + ", fragmentTag: " + fragmentTag);
        if (fragment == null || fragmentTag == null) return;
        FragmentActivity activity = ApplicationActivity.get();
        assert activity != null;
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Log.d(TAG, "transaction.isEmpty(): " + fragmentTransaction.isEmpty());
        backStackListener(fragmentManager);

        fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

        try {
            fragmentTransaction
                    .replace(R.id.content, fragment, fragmentTag)
                    .addToBackStack(null)  // NOTE - cannot pass fragmentTag here as we'd like as the payment stuff uses it!
                    .commit();
        } catch (Exception e) {
            Log.d("Fragment util :", e.getMessage());
            e.printStackTrace();
        }

        // We FORCE this to go synchronously at this point, to prevent death by spam-touching.
        fragmentManager.executePendingTransactions();
    }

    //Method to debug the backStack
    public static void backStackListener(FragmentManager fragmentManager) {
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Log.d(TAG, "Fragment count in back stack: " + fragmentManager.getBackStackEntryCount());
            }
        });
    }

    public static boolean isFragmentVisible(String fragmentTag) {
        Fragment myFragment = Objects.requireNonNull(ApplicationActivity.get()).getSupportFragmentManager().findFragmentByTag(fragmentTag);
        return myFragment != null && myFragment.isVisible();
    }

    /** The common case - just pop the back stack when the back button is touched. */
    public static void setBackPopStack(@NonNull Fragment fragment) {
        FragmentManager fm = fragment.getActivity().getSupportFragmentManager();
        fm.popBackStack();
    }



}
