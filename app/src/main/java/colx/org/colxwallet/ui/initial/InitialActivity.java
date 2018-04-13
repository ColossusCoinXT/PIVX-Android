package colx.org.colxwallet.ui.initial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import colx.org.colxwallet.ColxApplication;
import colx.org.colxwallet.ui.splash_activity.SplashActivity;
import colx.org.colxwallet.ui.wallet_activity.WalletActivity;
import colx.org.colxwallet.utils.AppConf;

/**
 * Created by furszy on 8/19/17.
 */

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColxApplication pivxApplication = ColxApplication.getInstance();
        AppConf appConf = pivxApplication.getAppConf();
        // show report dialog if something happen with the previous process
        Intent intent;
        if (!appConf.isAppInit() || appConf.isSplashSoundEnabled()){
            intent = new Intent(this, SplashActivity.class);
        }else {
            intent = new Intent(this, WalletActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
