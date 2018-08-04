package com.nabinbhandari.helloworld;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(android.R.drawable.screen_background_dark_transparent)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com")
                                .withIcon(getResources().getDrawable(R.mipmap.ic_launcher)),
                        new ProfileDrawerItem().withName("Nabin").withEmail("bnabin51@gmail.com")
                                .withIcon(getResources().getDrawable(R.mipmap.ic_launcher)),
                        // don't ask but google uses 14dp for the add account icon in gmail
                        // but 20dp for the normal icons (like manage account)
                        new ProfileSettingDrawerItem().withName("Add Account").withDescription("Add new GitHub Account")
                                .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_add)
                                        .colorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN))
                                        .actionBar().paddingDp(5).colorRes(R.color.material_drawer_dark_primary_text))
                                .withIdentifier(1234),
                        new ProfileSettingDrawerItem().withName("Manage Account").withIcon(GoogleMaterial.Icon.gmd_settings)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        Toast.makeText(MainActivity.this, "Changed " + profile.getName(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .build();

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .build();
        drawer.getActionBarDrawerToggle().getDrawerArrowDrawable().setColor(Color.WHITE);


        drawer.addItem(new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_home).withName("Home"));
        drawer.addItem(new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_access_alarm).withName("Alarm"));
    }

}
