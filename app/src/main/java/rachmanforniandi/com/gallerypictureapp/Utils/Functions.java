package rachmanforniandi.com.gallerypictureapp.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import rachmanforniandi.com.gallerypictureapp.R;

public class Functions {

    public static void switchMainFragment(FragmentActivity fragmentActivity, Fragment fragment){
        fragmentActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container,fragment)
                .commit();
    }

    public static void switchMainFragmentWithBack(FragmentActivity fragmentActivity, Fragment fragment){
        fragmentActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container,fragment)
                .addToBackStack(null)
                .commit();
    }
}
